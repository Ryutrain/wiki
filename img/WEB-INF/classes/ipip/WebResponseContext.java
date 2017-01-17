package ipip;

import javax.servlet.http.HttpServletResponse;

public class WebResponseContext implements ResponseContext{
	private Object result;
	private String target;
	
	private HttpServletResponse _response;
	
	public WebResponseContext(){}
	
	public void setTarget(String transferInfo){
		target="/WEB-INF/jsp/"+transferInfo+".jsp";
	}
	public String getTarger(){
		return target;
	}
	public void setResult(Object bean){
		_result=bean;
	}
	public Object getResult(){
		return _result;
	}
	public Object getResponse(){
		return _response;
	}
	public void setResponse(Object obj){
		_response=(HttpServletResponse)obj;
	}
}