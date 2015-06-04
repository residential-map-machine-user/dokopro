package BaseClasses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controllers.CourseController;
import Controllers.ErrorController;
import Controllers.IndexController;
import Controllers.LoginController;
public abstract class BaseController{
	protected int authFlag = 0;
	protected int actionAuthFlag = 0;
	public void execute(HttpServletRequest request, HttpServletResponse response){
	}
	
	public int getAuthFlag() {
		return authFlag;
	}
	
	public void setAuthFlag(int authFlag) {
		this.authFlag = authFlag;
	};
	
	//ログインページへ飛ぶ
	public void goLogin(HttpServletRequest request, HttpServletResponse response){
		BaseController controller = new LoginController();
		controller.execute(request, response);
	}
	
	//インデックスページへ飛ぶ
	public void goIndex(HttpServletRequest request, HttpServletResponse response){
		BaseController controller = new IndexController();
		controller.execute(request, response);
	}
	
	//コース一覧ページへ飛ぶ
	public void goCourseIndex(HttpServletRequest request, HttpServletResponse response){
		BaseController controller = new CourseController();
		controller.execute(request,response);
	}
	
	//エラーページへ飛ぶ
	public void goError(HttpServletRequest request, HttpServletResponse response){
		BaseController controller = new ErrorController();
		controller.execute(request, response);
	}
	
	public boolean checkActionAuth(HttpServletRequest request, HttpServletResponse response){
		int userAuth = (int)request.getAttribute("USER_AUTH_FLAG");
		if(userAuth < actionAuthFlag){
			return false;
		}
		return true;
	}
	
	public void setActionAuthFlag(int actionAuthFlag){
		this.actionAuthFlag  = actionAuthFlag;
	}
}
