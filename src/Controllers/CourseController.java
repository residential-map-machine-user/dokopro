package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Constants.AppConstants;
import Utils.Util;

public class CourseController extends BaseController {
	public CourseController() {
		setAuthFlag(AppConstants.AUTH_FLAG.AUTH_ALL_USER);
	}
	
	/**
	 * コース一覧ページへ飛ぶ
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		setAuthFlag(AppConstants.AUTH_FLAG.AUTH_SIGNEDIN_USER);
		try {
			request.getServletContext().getRequestDispatcher(AppConstants.FOWARD_PATH.CONST_COURSE_INDEX_JSP).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * コースの詳細(一番大きな)へ飛ぶ
	 * @param request
	 * @param response
	 */
	public void detailAction(HttpServletRequest request, HttpServletResponse response){
		setAuthFlag(AppConstants.AUTH_FLAG.AUTH_SIGNEDIN_USER);
		try {
			request.getServletContext().getRequestDispatcher(AppConstants.FOWARD_PATH.CONST_COURSE_DETAIL_JSP).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}