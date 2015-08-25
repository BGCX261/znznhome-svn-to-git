package com.znznhome.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;

public class StrutsFilter4FCKEditor extends StrutsPrepareAndExecuteFilter {
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		if (request.getRequestURI().contains(
				"/fckeditor/editor/filemanager/connectors/")) {
			chain.doFilter(req, res);
		} else if(request.getRequestURI().contains(
		"/admin/FileUpload")){
			chain.doFilter(req, res);
		} else if(request.getRequestURI().contains(
		"/timer")){
			chain.doFilter(req, res);
		} else {
			super.doFilter(req, res, chain);
		}
	}
}
