package com.onlinexam.filter;

import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class PowerFilter
 */
@WebFilter(filterName="rightsfilter",urlPatterns={"/*"})
public class RightsFilter implements Filter {
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// place your code here
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		Object o = req.getSession().getAttribute("user");
		String currentURL = req.getRequestURI(); // 取得根目录所对应的绝对路径:  
		String targetURL = currentURL.substring(currentURL.indexOf("/", 1),  
					currentURL.length()); // 截取到当前文件名用于比较 
		String partten = "(.*css.*|.*js.*|.*ttf.*|.*woff.*|.*png.*|.*jpg.* |.*mp4.*)";

		if (Pattern.matches(partten,targetURL)) {
		
		}
		
		else if(o == null && !targetURL.equals("/login.jsp")  && !targetURL.equals("/usernotfound.jsp") &&!targetURL.equals("/img/bg1.jpg")){
			if(!targetURL.equals("/loginServlet")&& !targetURL.equals("/css/mimic.css") && !targetURL.equals("/css/demo.css") &&  !targetURL.equals("/css/htmleaf-demo.css")){
				resp.sendRedirect(req.getContextPath() + "/usernotfound.jsp");
				return;
			}
		} 
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
