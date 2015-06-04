package Constants;

import java.util.HashMap;

public class AppConstants {
	//データベース
	public static class DATABASE{
		public static final String DB_URL = "jdbc:mysql://localhost/dokopro_db";
		public static final String DB_USER = "dokopro";
		public static final String DB_PASS = "dokopro";
	}
	
	//フォワードパス
	public static class FOWARD_PATH{
		public static final String CONST_INDEX_JSP = "/WEB-INF/jsp/index.jsp";
		public static final String CONST_LOGIN_JSP = "/WEB-INF/jsp/login.jsp";
		public static final String CONST_COURSE_DETAIL_JSP = "/WEB-INF/jsp/courseDetail.jsp";
		public static final String CONST_COURSE_INDEX_JSP = "/WEB-INF/jsp/courseList.jsp";
		public static final String CONST_LOGOUT_JSP = "/WEB-INF/jsp/logout.jsp";
		public static final String CONST_ACCOUNT_EDIT_JSP = "/WEB-INF/jsp/accountSetting.jsp";
		public static final String CONST_ACCOUNT_ADD_JSP = "/WEB-INF/jsp/accountAdd.jsp";
		public static final String CONST_ACCOUNT_COMPLETE_JSP = "/WEB-INF/jsp/accountComplete.jsp";
		public static final String CONST_MYPAGE_JSP = "/WEB-INF/jsp/mypage.jsp";
		public static final String CONST_MYPAGE_EDIT_JSP = "/WEB-INF/jsp/mypageEdit.jsp";
		public static final String CONST_TEAM_LIST_JSP = "/WEB-INF/jsp/teamList.jsp";
		public static final String CONST_TEAM_EDIT_JSP = "/WEB-INF/jsp/teamEdit.jsp";
		public static final String CONST_TEAM_ADD_JSP = "/WEB-INF/jsp/teamAdd.jsp";
		public static final String CONST_ERROR_JSP =  "/WBE-INF/jsp/error.jsp";
		public static final String CONST_ADMIN_INDEX_JSP =  "/WBE-INF/jsp/adminindex.jsp";
		public static final String CONST_ADMIN_ADD_CONTENTS_JSP =  "/WBE-INF/jsp/adminaddcontents.jsp";
	}
	
	//コントローラクラス権限
	public static class AUTH_FLAG{
		public static final int AUTH_ALL_USER = 1;
		public static final int AUTH_SIGNEDIN_USER = 2;
		public static final int AUTH_TEAM_LEADER = 3;
		public static final int AUTH_SYSTEM_ADMIN = 4;
	}
	
	//エラーメッセージ
	public static class ERROR_MESSAGE{
		public static final String CONST_PATH_ERROR = "そのURLは存在しません。";
	}
	
	public static class AUTH_MAP{
		public static final HashMap<String, Integer> authMap = new HashMap<String,Integer>(){
			{
				put("/account/edit", AUTH_FLAG.AUTH_ALL_USER);
			}
		};
	}
}
