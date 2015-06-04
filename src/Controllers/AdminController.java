package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Constants.AppConstants;
import Utils.Util;

public class AdminController extends BaseController {
	public AdminController(){
		setAuthFlag(AppConstants.AUTH_FLAG.AUTH_ALL_USER);
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// アクションとユーザの権限の比較

		try {
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_ADMIN_INDEX_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void addcontentsAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (request.getMethod().equals("GET")) {
				request.getServletContext()
						.getRequestDispatcher(
								AppConstants.FOWARD_PATH.CONST_ADMIN_ADD_CONTENTS_JSP)
						.forward(request, response);
			} else if (request.getMethod().equals("POST")) {
				String contentsName = request.getParameter("GROUP_NAME");
				Util.l(contentsName);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
