package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Constants.AppConstants;
import Utils.Util;

public class GroupController extends BaseController {

	// チーム一覧ページへ飛ぶ
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_GROUP_LIST_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// チーム作成ページへ飛ぶ
	public void addAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_GROUP_ADD_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// チーム情報の編集ページへ飛ぶ
	public void editAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_GROUP_EDIT_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void detailAction(HttpServletRequest request, HttpServletResponse response){
		try {
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_GROUP_DETAIL_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
