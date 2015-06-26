package net.eprojex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class MyFilter
 */
public class MyFilter implements Filter {
	//private static final long serialVersionUID = 1L;
	
	FilterConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest rq, ServletResponse rs,
			FilterChain chain) throws IOException, ServletException {

		PrintWriter pw = rs.getWriter();
		
		String s = config.getInitParameter("construction");
		
		if(s.equals("yes")) {
			
			pw.print("This page is under construction");
			
		}
		else {
			chain.doFilter(rq, rs);//sends the request to the next resource
		}
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		
	}

}
