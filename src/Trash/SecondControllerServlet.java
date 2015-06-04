package Trash;
//package dokopro;
//
//import BaseClasses.BaseController;
//import BaseClasses.BaseFrontController;
//import Beans.SystemBean;
//import Constants.AppConstants;
//import Controllers.UserController;
//import Controllers.AccountController;
//import Controllers.IndexController;
//import Controllers.LoginController;
//import Controllers.LogoutController;
//import Controllers.MypageController;
//import Controllers.CourseController;
//import Controllers.TeamController;
//import Logics.AddUserLogic;
//import Logics.ChangeAccountSettingLogic;
//import Logics.IndexLogic;
//import Logics.LoginLogic;
//import Logics.LogoutLogic;
//import Logics.MypageLogic;
//import Logics.ShowCourseListLogic;
//import Logics.ShowTeamListLogic;
//
//public class SecondControllerServlet extends BaseFrontController {
//	/**
//	 * 機能に対応するコントローラーをインスタンス化
//	 * @return
//	 */
//	@Override
//	public BaseController createController(SystemBean objBeanSystem){
//		BaseController objController = null;
//		if (IndexLogic.FUNCTION_ID.equals(objBeanSystem.getIdFunction())){
//			objController = new IndexController();
//		} else if (LoginLogic.FUNCTION_ID.equals(objBeanSystem.getIdFunction())){
//			objController = new LoginController();
//		} else if (ShowCourseListLogic.FUNCTION_ID.equals(objBeanSystem.getIdFunction())){
//			objController = new CourseController();
//		} else if (ShowTeamListLogic.FUNCTION_ID.equals(objBeanSystem.getIdFunction())){
//			objController = new TeamController();
//		} else if (ChangeAccountSettingLogic.FUNCTION_ID.equals(objBeanSystem.getIdFunction())){
//			objController = new AccountController();
//		} else if (LogoutLogic.FUNCTION_ID.equals(objBeanSystem.getIdFunction())){
//			objController = new LogoutController();
//		} else if (MypageLogic.FUNCTION_ID.equals(objBeanSystem.getIdFunction())){
//			objController = new MypageController();
//		} else if (AddUserLogic.FUNCTION_ID.equals(objBeanSystem.getIdFunction())){
//			objController = new UserController();
//		}
//		return objController;
//		}
//
//	/**
//	 * 送られてきた機能IDをセット
//	 */
//	@Override
//	public void setIdFunctionData(SystemBean objBeanSystem) {
//		if (objBeanSystem.getRequest().getParameter("ID_FUNCTION") != null) {
//			objBeanSystem.setIdFunction(objBeanSystem.getRequest()
//					.getParameter("ID_FUNCTION"));
//			System.out.println("機能IDチェック:" + objBeanSystem.getIdFunction());
//		} else {
//			objBeanSystem
//					.setIdFunction(AppConstants.FUNCTION_ID.CONST_INDEX_FUNCTION);
//			System.out.println("機能IDチェック:デフォルト" + objBeanSystem.getIdFunction());
//		}
//
//	};
//
//	/**
//	 * データベースの接続に必要な情報をセット
//	 */
//	@Override
//	public void setDbAccessData(SystemBean objBeanSystem) {
//	};
//
//	/**
//	 * デフォルトのフォワード先をセット
//	 */
//	@Override
//	public void setDefaultForwardPath(SystemBean objBeanSystem) {
//		objBeanSystem.serFowardPath(AppConstants.FOWARD_PATH.CONST_INDEX_JSP);
//	}
//
//	/**
//	 * 画面のパスと機能名をセット
//	 */
//	@Override
//	public void setScreenData(SystemBean objBeanSystem) {
//		
//	};
//
//	/**
//	 * 変更されたレスポンスデータをセット
//	 */
//	@Override
//	public void setResponseData(SystemBean objBeanSystem) {
//	}
//}