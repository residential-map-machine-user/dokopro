package Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Beans.CategoryBean;
import Beans.GroupBean;
import Beans.UserBean;
import Constants.AppConstants;
import DAOs.CourseDAO;
import DAOs.GroupDAO;
public class MypageController extends BaseController {
	/**
	 *マイページへ飛ぶ
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			GroupDAO groupObj = new GroupDAO();
			CourseDAO courseObj = new CourseDAO();
			UserBean user = (UserBean)request.getSession().getAttribute("USER_INF");
			int userId = user.getUserId();
			List<GroupBean> groupList = groupObj.selectGroupByUserId(userId);
			List<CategoryBean>categoryList = courseObj.selectCategoryByUserId(userId);
			request.setAttribute("GROUP_LIST", groupList);
			request.setAttribute("CATEGORY_LIST", categoryList);
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_MYPAGE_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * マイページ情報の編集処理へ飛ぶ
	 * @param request
	 * @param response
	 */
	public void editAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_MYPAGE_EDIT_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
