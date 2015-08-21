package Controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import BaseClasses.BaseController;
import Beans.ProgressBean;
import Beans.UserBean;
import Constants.AppConstants;
import DAOs.CourseDAO;
import DAOs.ProgressDAO;
import Utils.Util;

public class ProgressController extends BaseController {
	public void getProgress() {
		
	}

	/**
	 * @throws IOException 
	 * 
	 */
	public void getsubcategoryprogressAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int userId = ((UserBean)request.getSession().getAttribute("USER_INF")).getUserId();
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		request.setAttribute(AppConstants.REQUEST_ATTIRIBUTE.CATEGORY_ID, categoryId);
		response.setContentType("application/json; charset=UTF-8");  
        response.setHeader("Cache-Control", "private");
		ProgressDAO daoObj = new ProgressDAO();
		Map<Integer,ProgressBean> progressCountMap = daoObj.selectContentsProgress(userId,categoryId);
		Map<Integer,Integer> questionCountMap =daoObj.selectQuestionCount(categoryId);
		List<ProgressBean> result = new ArrayList<>();
		for(int key: progressCountMap.keySet()){
			Util.l("きーの値" + key);
			ProgressBean progress = progressCountMap.get(key);
			int questionCount  = questionCountMap.get(key);
			progress.setQuestionCount(questionCount);
			progress.progresCalc();
			result.add(progress);
		}
		JSONArray jsonArray = JSONArray.fromObject(result);
		Util.l(jsonArray.toString());	 
		response.getOutputStream().write(jsonArray.toString().getBytes("UTF-8"));  
	}

	/**
	 * 
	 */
	public void getCategoryProgress() {

	}

	/**
	 * 
	 */
	public void getContentsProgress() {

	}
	
	public void getcompleteitemidlistAction(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, IOException{
		int userId = ((UserBean)request.getSession().getAttribute("USER_INF")).getUserId();
		CourseDAO daoObj = new CourseDAO();
		List<Integer> itemIdList = null;
		int contentsId  = Integer.parseInt(request.getParameter("CONTENTS_ID"));
		itemIdList = daoObj.selectItemByUserId(userId, contentsId);
		JSONArray jsonArray = JSONArray.fromObject(itemIdList);
		Util.l(jsonArray.toString());
		response.getOutputStream().write(jsonArray.toString().getBytes("UTF-8"));
	}
}
