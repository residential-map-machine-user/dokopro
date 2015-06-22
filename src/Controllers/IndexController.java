package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Beans.UserBean;
import Constants.AppConstants;
import DAOs.UserDAO;
import Utils.Util;

public class IndexController extends BaseController {
	
	/**
	 * インデックスページへ飛ぶ
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response){
		try {
			request.getServletContext().getRequestDispatcher(AppConstants.FOWARD_PATH.CONST_INDEX_JSP).forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
