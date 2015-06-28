package Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import BaseClasses.BaseController;
import Beans.GroupBean;
import Beans.UserBean;
import Constants.AppConstants;
import DAOs.GroupDAO;
import Utils.Util;

public class GroupController extends BaseController {

	// チーム一覧ページへ飛ぶ
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			GroupDAO daoObj = new GroupDAO();
			List<GroupBean> groupList = new ArrayList<>();
			groupList = daoObj.selectAllGroup();

			request.setAttribute("GROUP_LIST", groupList);
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
		String method = request.getMethod();
		if (method.equals("POST")) {
			GroupDAO daoObj = new GroupDAO();
			String groupName = request.getParameter("GROUP_NAME");
			String description = request.getParameter("GROUP_DESCRIPTION");
			daoObj.addGroup(groupName, description);
		}
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

	public void detailAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			GroupDAO daoObj = new GroupDAO();
			Util.l("グループID"
					+ ((List<String>) request.getAttribute("PATH")).get(2));
			int groupId = Integer.parseInt(((List<String>) request
					.getAttribute("PATH")).get(2));
			GroupBean group = new GroupBean();
			group = daoObj.selectGroupByGroupId(groupId);
			request.setAttribute("GROUP", group);
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_GROUP_DETAIL_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addgroupmemberAction(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			GroupDAO daoObj = new GroupDAO();
			//[TODO]グループに重複してメンバーの登録を行わないように確認する
			int groupId = Integer.parseInt(((List<String>) request
					.getAttribute("PATH")).get(2));
			GroupBean group = daoObj.selectGroupByGroupId(groupId);
			int userId = ((UserBean) request.getSession().getAttribute(
					"USER_INF")).getUserId();
			request.setAttribute("GROUP", group);
			daoObj.addGroupMember(groupId, userId);
			request.getServletContext()
					.getRequestDispatcher(
							AppConstants.FOWARD_PATH.CONST_GROUP_DETAIL_JSP)
					.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
