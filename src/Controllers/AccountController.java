package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Beans.UserBean;
import Constants.AppConstants;
import DAOs.UserDAO;
import Utils.JavaMail;
import Utils.Util;

public class AccountController extends BaseController {
	/**
	 * GET: アカウント登録ページへ飛ぶ POST:　アカウント登録処理を実行
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 処理の切り替え
			if (request.getMethod().equals("GET")) {
				// アカウント情報登録ページへ飛ぶ
				request.getServletContext()
						.getRequestDispatcher(
								AppConstants.FOWARD_PATH.CONST_ACCOUNT_ADD_JSP)
						.forward(request, response);
			} else if (request.getMethod().equals("POST")) {
				UserDAO dbObj = new UserDAO();
				int registerCount = dbObj.addUser(request);
				if(registerCount == 1){
					JavaMail mailManager = new JavaMail();
					String userMail = request.getParameter("MAIL");
					mailManager.sendMail(AppConstants.HOST, AppConstants.FROM_ADDRRESS, userMail);
				}
				if (registerCount == 1) {
					request.getServletContext()
							.getRequestDispatcher(
									AppConstants.FOWARD_PATH.CONST_ACCOUNT_COMPLETE_JSP)
							.forward(request, response);
				} else {
					goError(request, response);
				}
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	// アカウント情報の変更ページへ飛ぶ
	public void editAction(HttpServletRequest request,
			HttpServletResponse response) {
		// アクションの権限をセット
		try {
			Util.l("リクエストの種類" + ":" + request.getMethod());
			if (request.getMethod().equals("GET")) {
				request.getServletContext()
						.getRequestDispatcher(
								AppConstants.FOWARD_PATH.CONST_ACCOUNT_EDIT_JSP)
						.forward(request, response);
			} else if (request.getMethod().equals("POST")) {
				UserDAO dbObj = new UserDAO();
				String accountName = request.getParameter("ACCOUNT_NAME");
				String mail = request.getParameter("MAIL");
				String password = request.getParameter("PASSWORD");
				String newPassword = request.getParameter("NEW_PASSWORD");
				String checkPassword = request.getParameter("CHECK_PASSWORD");
				UserBean user = new UserBean();
				user = (UserBean)request.getSession().getAttribute("USER_INF");
				int userId = user.getUserId();
				int registerCount = 0;
				if(accountName != null &&!accountName.equals("null") && !accountName.equals("")){
					registerCount = dbObj.updateAccountName(accountName, userId);
				}else if(mail != null && !mail.equals("") && !mail.equals("null")){
					registerCount = dbObj.updateUserMail(mail, userId);
				}else if(password != null && !password.equals("") && !password.equals("null")){
					Util.l("パスワード更新処理");
					registerCount = dbObj.updateUserPassword(password, newPassword, checkPassword, userId);
				}
				if (registerCount >= 1) {
					request.getServletContext()
							.getRequestDispatcher(
									AppConstants.FOWARD_PATH.CONST_ACCOUNT_COMPLETE_JSP)
							.forward(request, response);
				} else {
					goError(request, response);
				}
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
