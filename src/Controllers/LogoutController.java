package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Constants.AppConstants;
import Utils.Util;

public class LogoutController extends BaseController {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		try {
			request.getServletContext().getRequestDispatcher(AppConstants.FOWARD_PATH.CONST_INDEX_JSP).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
