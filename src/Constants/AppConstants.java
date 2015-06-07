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
		public static final String CONST_GROUP_LIST_JSP = "/WEB-INF/jsp/groupList.jsp";
		public static final String CONST_GROUP_EDIT_JSP = "/WEB-INF/jsp/groupEdit.jsp";
		public static final String CONST_GROUP_ADD_JSP = "/WEB-INF/jsp/groupAdd.jsp";
		public static final String CONST_ERROR_JSP =  "/WEB-INF/jsp/error.jsp";
		public static final String CONST_ADMIN_INDEX_JSP =  "/WEB-INF/jsp/adminindex.jsp";
		public static final String CONST_ADMIN_ADD_CONTENTS_JSP =  "/WEB-INF/jsp/adminaddcontents.jsp";
	}
	
	//コントローラクラス権限
	public static class AUTH_FLAG{
		public static final int AUTH_ALL_USER = 1;
		public static final int AUTH_SIGNEDIN_USER = 2;
		public static final int AUTH_GROUP_LEADER = 3;
		public static final int AUTH_SYSTEM_ADMIN = 4;
	}
	
	//エラーメッセージ
	public static class ERROR_MESSAGE{
		public static final String CONST_PATH_ERROR = "そのURLは存在しません。";
	}
	
	public static class AUTH_MAP{
		public static final HashMap<String, Integer> authMap = new HashMap<String,Integer>(){
			{
				put("/dokopro/front/account", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/account/edit", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/admin/addcontents",AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/admin", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/course", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/course/detail", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/error", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/mypage", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/mypage/edit", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/group", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/group/edit", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/logout", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/login", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/login/main", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/", AUTH_FLAG.AUTH_ALL_USER);
				put("/dokopro/front/*", AUTH_FLAG.AUTH_ALL_USER);
			}
		};
	}
}
