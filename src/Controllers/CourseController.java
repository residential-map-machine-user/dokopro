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
import DAOs.SubCategoryDAO;
import Utils.Util;

public class CourseController extends BaseController {
	/**
	 * コース一覧ページへ飛ぶ
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			CourseDAO daoObj = new CourseDAO();
			List<CategoryBean> categoryList = new ArrayList<>();
			categoryList = daoObj.selectAllCategory();
			for (CategoryBean item : categoryList) {
				Util.l(item.getCategoryName());
				Util.l(item.getCategoryId() + "");
				Util.l(item.getBelongTo());
				Util.l(item.getCreatedAt().toString());
			}
			request.setAttribute("CATEGORY", categoryList);
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_COURSE_INDEX_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * コースの詳細(一番大きな)へ飛ぶ
	 * 
	 * @param request
	 * @param response
	 */
	public void detailAction(HttpServletRequest request,
			HttpServletResponse response) {
		SubCategoryDAO daoObj = new SubCategoryDAO();
		int categoryId = Integer.parseInt((String) request
				.getAttribute("THIRD"));
		List<SubCategoryBean> subcategoryList = daoObj
				.selectSubCategoryByCategoryId(categoryId);
		// [TODO]ここるべきなのはsubcategoryのIDに対応した
		for (int i = 0; i < subcategoryList.size(); i++) {
			ContentsDAO contentsDAO = new ContentsDAO();
			List<ContentsBean> contentsList = contentsDAO
					.selectContentsBySubCategoryId(subcategoryList.get(i)
							.getSubCategoryId());
			Util.l("カテゴリーID********************"
					+ subcategoryList.get(i).getSubCategoryId());
			for (ContentsBean contents : contentsList) {
				Util.l("コンテンツタイトル*****" + contents.getContentsTitle());
				Util.l("コンテンツID*****" + contents.getContentsId());
			}
			subcategoryList.get(i).setContentsList(
					contentsDAO.selectContentsBySubCategoryId(subcategoryList
							.get(i).getSubCategoryId()));
		}
		request.setAttribute("SUB_CATEGORY", subcategoryList);
		try {
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_COURSE_DETAIL_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void contentAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_COURSE_CONTENT_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
