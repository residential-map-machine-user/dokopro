package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Beans.CategoryBean;
import Beans.ContentsBean;
import Beans.SubCategoryBean;
import Constants.AppConstants;
import DAOs.ContentsDAO;
import DAOs.CourseDAO;
import DAOs.ItemDAO;
import DAOs.SubCategoryDAO;
import Utils.Util;

public class AdminController extends BaseController {
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

	public void addcontentAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (request.getMethod().equals("GET")) {
				request.getServletContext()
						.getRequestDispatcher(
								AppConstants.FOWARD_PATH.CONST_ADMIN_ADD_CONTENT_JSP)
						.forward(request, response);
			} else if (request.getMethod().equals("POST")) {
				String contentsName = request.getParameter("GROUP_NAME");
				Util.l(contentsName);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void addcontentsAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (request.getMethod().equals("GET")) {
				SubCategoryDAO daoObj = new SubCategoryDAO();
				CourseDAO courseObj = new CourseDAO();
				List<SubCategoryBean> subcategoryList = daoObj.selectAllSubCategory();
				request.setAttribute("SUB_CATEGORY_LIST", subcategoryList);
				request.getServletContext()
						.getRequestDispatcher(
								AppConstants.FOWARD_PATH.CONST_ADMIN_ADD_CONTENTS_JSP)
						.forward(request, response);
			} else if (request.getMethod().equals("POST")) {
				ContentsDAO daoObj = new ContentsDAO();
				int subCategoryId = Integer.parseInt(request.getParameter("SUB_CATEGORY_ID"));
				String title = request.getParameter("TITLE");
				Util.l("カテゴリーのタイトル" + title);
				Util.l("成功件数" + daoObj.addContents(subCategoryId, title));
				execute(request, response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void addcategoryAction(HttpServletRequest request,
			HttpServletResponse response) {

		try {
			if (request.getMethod().equals("GET")) {
				request.getServletContext()
						.getRequestDispatcher(
								AppConstants.FOWARD_PATH.CONST_ADMIN_ADD_CATEGORY_JSP)
						.forward(request, response);
			} else if (request.getMethod().equals("POST")) {
				CourseDAO daoObj = new CourseDAO();
				String categoryName = request.getParameter("CATEGORY_NAME");
				daoObj.addCategory(categoryName);
				execute(request,response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void addsubcategoryAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (request.getMethod().equals("GET")) {
				CourseDAO daoObj = new CourseDAO();
				List<CategoryBean> categoryList = new ArrayList<>();
				categoryList = daoObj.selectAllCategory();
				for (CategoryBean item : categoryList) {
					Util.l(item.getCategoryName());
					Util.l(item.getCategoryId() + "");
					Util.l(item.getBelongTo());
					Util.l(item.getCreatedAt().toString());
				}
				request.setAttribute("CATEGORY_LIST", categoryList);
				request.getServletContext()
						.getRequestDispatcher(
								AppConstants.FOWARD_PATH.CONST_ADMIN_ADD_SUB_CATEGORY_JSP)
						.forward(request, response);
			} else if (request.getMethod().equals("POST")) {
				int categoryId = Integer.parseInt(request.getParameter("CATEGORY_ID"));
				String title = request.getParameter("TITLE");
				SubCategoryDAO daoObj = new SubCategoryDAO();
				daoObj.addSubCategory(categoryId, title);
				execute(request, response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	public void additemAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (request.getMethod().equals("GET")) {
				ContentsDAO daoObj = new ContentsDAO();
				List<ContentsBean> contentsList = new ArrayList<>();
				contentsList = daoObj.selectAllContents();
				request.setAttribute("CONTENTS_LIST", contentsList);
				request.getServletContext()
						.getRequestDispatcher(
								AppConstants.FOWARD_PATH.CONST_ADMIN_ADD_ITEM_JSP)
						.forward(request, response);
			} else if (request.getMethod().equals("POST")) {
				ItemDAO daoObj = new ItemDAO();
				int contentsId = Integer.parseInt(request.getParameter("CONTENTS_ID"));
				String itemTitle = request.getParameter("ITEM_TITLE");
				String itemText = request.getParameter("ITEM_TEXT");
				daoObj.addItem(contentsId, itemTitle, itemText);
				execute(request,response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void editAction(HttpServletRequest request,
			HttpServletResponse response){
		try {
			if (request.getMethod().equals("GET")) {
				ContentsDAO daoObj = new ContentsDAO();
				List<ContentsBean> contentsList = new ArrayList<>();
				contentsList = daoObj.selectAllContents();
				request.setAttribute("CONTENTS_LIST", contentsList);
				request.getServletContext()
						.getRequestDispatcher(
								AppConstants.FOWARD_PATH.CONST_ADMIN_ADD_ITEM_JSP)
						.forward(request, response);
			} else if (request.getMethod().equals("POST")) {
				ItemDAO daoObj = new ItemDAO();
				int contentsId = Integer.parseInt(request.getParameter("CONTENTS_ID"));
				String itemTitle = request.getParameter("ITEM_TITLE");
				String itemText = request.getParameter("ITEM_TEXT");
				daoObj.addItem(contentsId, itemTitle, itemText);
				execute(request,response);
			}
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
