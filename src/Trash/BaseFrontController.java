package Trash;
//package BaseClasses;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import Beans.SystemBean;
//
//public class BaseFrontController extends HttpServlet {
//	public SystemBean objBeanSystem = null;
//	/**
//	 * doPostで処理を実行する
//	 */
//	public void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws IOException {
//		System.out.println(request.getRequestURI());
//		doPost(request, response);
//	}
//	
//	/**
//	 *サーブレットの実行メソッド 
//	 */
//	public void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws IOException {
//		//エンコードの設定
//		request.setCharacterEncoding("utf-8");
//		//アプリ内で共有する情報を持たせる
//		objBeanSystem = new SystemBean();
//		//サーブレットコンテキストの保持
//		objBeanSystem.setSrvContext(this.getServletContext());
//		//リクエストの保持
//		objBeanSystem.setRequest(request);
//		//共通インスタンスにレスポンスの保持
//		objBeanSystem.setResponse(response);
//		//画面から送られてくる機能IDの確認
//		System.out.println("画面から送られてくる機能ID>>>>>" + request.getParameter("ID_FUNCTION"));
//		//TODO データベースアクセスの情報を保持
//		this.setDbAccessData(objBeanSystem);
//		//機能IDを共通インスタンスに保持
//		this.setIdFunctionData(objBeanSystem);
//		//コントローラーを作成
//		BaseController objController = this.createController(objBeanSystem);
//		//コントローラで機能を実行
//		if (objController != null) {
//			objController.execute(objBeanSystem);
//		}
//		//共通インスタンスにレスポンスを保持
//		this.setResponseData(objBeanSystem);
//		//フォワードさせる
//		try {
//			objBeanSystem.getRequest().getRequestDispatcher(objBeanSystem.getFowardPath()).forward(objBeanSystem.getRequest(),objBeanSystem.getResponse());
//		} catch (ServletException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	/**
//	 * 機能IDに対応するコントローラーをインスタンス化
//	 * @return
//	 */
//	public BaseController createController(SystemBean objBeanSystem) {
//		return null;
//	}
//	
//	/**
//	 * 送られてきた機能IDをセット 
//	 */
//	public void setIdFunctionData(SystemBean objBeanSystem) {
//	};
//	
//	/**
//	 *データベースの接続に必要な情報をセット 
//	 */
//	public void setDbAccessData(SystemBean objBeanSystem) {
//	};
//	
//	/**
//	 *デフォルトのフォワード先をセット
//	 */
//	public void setDefaultForwardPath(SystemBean objBeanSystem) {
//	}
//	
//	/**
//	 * 画面のパスと機能名をセット
//	 */
//	public void setScreenData(SystemBean objBeanSystem) {
//		
//	};
//	
//	/**
//	 *変更されたレスポンスデータをセット
//	 */
//	public void setResponseData(SystemBean objBeanSystem) {
//	}
//}
