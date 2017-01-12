package fw;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

public  class  EncodingFilter implements Filter{
	public void init(FilterConfig filterConfig) throws ServletException{}
	
	public void doFilter(javax.servlet.ServletRequest req,javax.servlet.ServletResponse res
							,FilterChain chain) throws IOException,ServletException{
	
		System.out.println("calls EncodingFilter#doFilter()");
		
		req.setCharacterEncoding("Windows-31J");
		
		chain.doFilter(req,res);
	}
	public void destroy(){
	}
}

		