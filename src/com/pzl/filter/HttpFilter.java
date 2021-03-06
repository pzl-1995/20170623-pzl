package com.pzl.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class HttpFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		
		doFilter(request, response, arg2);

	}
	
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain chain)throws IOException, ServletException;
	private FilterConfig filterConfig;
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.filterConfig = arg0;
		init();
	}

	protected void init() {
	}
	
	public FilterConfig getFilterConfig(){
		return filterConfig;
	}

}
