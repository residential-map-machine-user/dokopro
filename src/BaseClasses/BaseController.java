package BaseClasses;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controllers.CourseController;
import Controllers.ErrorController;
import Controllers.IndexController;
import Controllers.LoginController;
public abstract class BaseController{
	public void execute(HttpServletRequest request, HttpServletResponse response){
	}	
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
}
