package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Beans.UserBean;
import Constants.AppConstants;
import DAOs.UserDAO;
import Utils.Util;


public class LoginController extends BaseController {
	
	/**
	 * ログインページへ飛ぶ
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		try {
			request.getServletContext().getRequestDispatcher(AppConstants.FOWARD_PATH.CONST_LOGIN_JSP).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ログインアクションを実行する
	 * @param request
	 * @param response
	 */
	public void mainAction(HttpServletRequest request, HttpServletResponse response){
		Util.l("アクションは呼ばれている");
		UserDAO dbObj = new UserDAO();
		UserBean userObj = dbObj.selectUserForLogin(request);
		if(userObj.getAccountName() != null){
			request.getSession().setAttribute(AppConstants.REQUEST_ATTIRIBUTE.USER_INF, userObj);
			Util.l(((UserBean)request.getSession().getAttribute("USER_INF")).getAuthFlag() + "");
			//[TODO]　ログインしたあとに同じページに戻ってくる
			goCourseIndex(request, response);
		}else{
			goError(request, response);
		}
	}
}
