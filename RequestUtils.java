package wiki;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils{
	
	public static void setMessage(HttpServletRequest request,
									String message){
		request.setAttribute("message", message);
	}
}