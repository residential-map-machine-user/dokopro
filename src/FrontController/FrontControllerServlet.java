package FrontController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Beans.RequestURIBean;
import Beans.UserBean;
import Constants.AppConstants;
import Utils.Util;

public class FrontControllerServlet extends HttpServlet {
	// [TODO] 認証に必要なデータは基本的に暗号化しておく.(暗号化してデータベースに保存)暗号化して戻せないアルゴリズムにしておく
	// [TODO] Auth認証の実装(google.facebook.twitter)
	// [TODO] ユーザのパスワード再発行用のメールを送る
	// [TODO] メール用のサーバーを作る。
	// [TODO] アクセストークンをサーバに接続
	// [TODO] レッドマインの導入
	// []
	/**
	 * 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<String> splitedURI = spliteURIToList(request);
		// リクエストされたコントロラーを取得
		Class controllerClass = getClass(splitedURI.get(0));
		if (controllerClass != null) {
			try {
				BaseController controller = null;
				// 取得したコントローラーをインスタンス化
				controller = (BaseController) controllerClass.newInstance();
				// 権限チェック
				Util.l(request.getRequestURI());
				UserBean user = (UserBean) request.getSession().getAttribute(
						"USER_INF");
				String authKey = splitedURI.get(0) + "/" + splitedURI.get(1);
				Util.l("権限チェックのkey>>>>>" + authKey);
				if (AppConstants.AUTH_MAP.authMap.containsKey(authKey)) {
					if (AppConstants.AUTH_MAP.authMap.get(authKey) == AppConstants.AUTH_FLAG.AUTH_ALL_USER) {
						Util.l("すべてのユーザに対する処理");
						request.setAttribute("PATH", splitedURI);
						doAction(controllerClass, controller, request,
								response, splitedURI.get(1));
					} else {
						if (request.getSession().getAttribute("USER_INF") != null) {
							if ((Integer) AppConstants.AUTH_MAP.authMap
									.get(authKey) <= user.getAuthFlag()) {
								request.setAttribute("PATH", splitedURI);
								doAction(controllerClass, controller, request,
										response, splitedURI.get(1));
							}
						} else {
							controller.goLogin(request, response);
							Util.l("<<<権限エラー>>>");
						}
					}
				} else {
					// [TODO]エラーページへ飛ばす メッセージは要求されたペーズは存在しません
					Util.l("********リクエストされたページは存在しません");
					Util.l("********定数のhashマップの確認をする");
				}
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 
	 * @param controllerClass
	 * @param controller
	 * @param request
	 * @param response
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private void doAction(Class<?> controllerClass, BaseController controller,
			HttpServletRequest request, HttpServletResponse response,
			String actionPath) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		// 実行するメソッドの型指定
		Util.l("アクション名>>>>>" + actionPath);
		Method actionMethod = controllerClass.getMethod(
				convertToActionName(actionPath), HttpServletRequest.class,
				HttpServletResponse.class);
		// メソッドの実行
		actionMethod.invoke(controller, request, response);
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	private Class getClass(String controllerPath) {
		String className = convertToControllerName(controllerPath);
		try {
			// クラスを取得して返す
			return Class.forName("Controllers." + className);
		} catch (ClassNotFoundException notFoundException) {
			notFoundException.printStackTrace();
		}
		return null;
	}

	/**
	 * コントローラーネームのチェックメソッド
	 * 
	 * @param request
	 * @param uri
	 * @return
	 */
	private String convertToControllerName(String controllerPath) {
		if (controllerPath == null || controllerPath.equals("*")) {
			controllerPath = "IndexController";
			Util.l("コントローラーの名前>>>>>" + controllerPath);
			return controllerPath;
		}
		controllerPath = controllerPath.substring(0, 1).toUpperCase()
				+ controllerPath.substring(1);
		controllerPath += "Controller";
		Util.l("コントローラーの名前>>>>>" + controllerPath);
		return controllerPath;
	}

	/**
	 * アクションネームのチェックメソッド
	 * 
	 * @param request
	 * @param uri
	 * @return
	 */
	private String convertToActionName(String actionPath) {
		if (actionPath.equals("execute")) {
			return actionPath;
		}
		actionPath.toLowerCase();
		actionPath += "Action";
		Util.l("アクションの名前>>>>>" + actionPath);
		return actionPath;
	}

	/**
	 * リクエストされたURIをコマンド名にして返すメソッド 一番目にはコントローラの名前 二番目にはアクション名 三番目以降には任意で必要な値
	 * 
	 * @param request
	 * @return RequestURIBean パスの入ったインスタンス
	 */
	private List<String> spliteURIToList(HttpServletRequest request) {
		// リクエストURI
		String uriPath = request.getRequestURI();
		Util.l("URIパス>>>>>" + uriPath);
		// 現在のプロジェクトのルートパス
		String contextPath = request.getContextPath();
		Util.l("コンテキストパス>>>>>" + contextPath);
		// パスを分解
		String[] splitedPath = uriPath.replace(contextPath + "/front/", "")
				.split("/");
		List<String> splitedURI = new ArrayList<>();
		// デバッグ
		for (int i = 0; i < splitedPath.length; i++) {
			splitedURI.add(splitedPath[i]);
			Util.l("スプライト後の結果>>>>" + "[" + i + "]" + splitedPath[i]);
		}
		if (splitedURI.get(0).equals("*")) {
			splitedURI.set(0, "index");
		}
		if (splitedURI.size() < 2) {
			splitedURI.add("execute");
		}
		return splitedURI;
	}
}
