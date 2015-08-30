package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Constants.AppConstants;
import DAOs.ProjectDAO;
import Utils.Util;

public class ProjectController extends BaseController {
	
	
	public void addAction(HttpServletRequest request, HttpServletResponse response) {
		try {
			Util.l(request.getMethod());
			if(request.getMethod().equals("GET")){
				Util.l(request.getMethod());
				request.getServletContext()
						.getRequestDispatcher(
								AppConstants.FOWARD_PATH.CONST_PROJECT_ADD_JSP)
						.forward(request, response);
			}else if(request.getMethod().equals("POST")){
				ProjectDAO daoObj = new ProjectDAO();
				String projectName = "サンプル";
				int commitLevel = 1;
				String projectSummery = "サンプルのプロジェクトです";
				int groupId = 1;
				daoObj.addProject(projectName, commitLevel, projectSummery,groupId);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void detailAction(HttpServletRequest request, HttpServletResponse response){
		try {
			List<String> uriList = (ArrayList<String>)request.getAttribute(AppConstants.REQUEST_ATTIRIBUTE.PATH);
			System.out.println(" FOR project URI " + uriList);
			request.setAttribute("PROJECT_ID", uriList.get(2));
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_PROJECT_DETAIL_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void taskAction(HttpServletRequest request, HttpServletResponse response){
		try{
			request.getServletContext().getRequestDispatcher(AppConstants.FOWARD_PATH.CONST_TASK_LIST_JSP).forward(request, response);
		} catch(ServletException | IOException e){
			e.printStackTrace();
		}
	}
}
