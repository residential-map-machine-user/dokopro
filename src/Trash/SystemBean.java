package Trash;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SystemBean {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private String idFunction;
	private String fowardPath;
	private ServletContext srvContext;
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return response;
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	public void setIdFunction(String idFunction){
		this.idFunction = idFunction;
	}
	public String getIdFunction(){
		return idFunction;
	}
	public void serFowardPath(String fowardPath){
		this.fowardPath = fowardPath; 
	}
	
	public String getFowardPath(){
		return fowardPath;
	}
	
	public void setSrvContext(ServletContext srvContext){
		this.srvContext = srvContext;
	}
	
	public ServletContext getSrvContext(){
		return srvContext;
	}
}
