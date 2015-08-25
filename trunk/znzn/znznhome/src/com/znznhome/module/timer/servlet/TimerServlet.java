package com.znznhome.module.timer.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.znznhome.module.timer.exception.FomartException;
import com.znznhome.module.timer.manager.TimerRequestManager;
import com.znznhome.module.timer.util.TimerParamChecker;
import com.znznhome.module.timer.util.TimerUtil;
import com.znznhome.util.CommonUtil;

public class TimerServlet extends HttpServlet {

	/** @Fields serialVersionUID: */
	private static final long serialVersionUID = 5960052148177222763L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//必填 启动还是停止，默认是start
		String method = request.getParameter("method");
		if(CommonUtil.isEmpty(method)) {
			TimerUtil.outPrintln(out, "params lost! check 'method'");
		}
		
		/*
		 *  1. 处理参数
		 */

		//参数不合法则返回
		if(method.trim().equalsIgnoreCase("start") && (TimerParamChecker.check4Start(request, response) == false)) {
			return;
		}else if(method.trim().equalsIgnoreCase("stop") && (TimerParamChecker.check4Stop(request, response) == false)) {
			return;
		}
		
		TimerRequestManager timerRequestManager = TimerRequestManager.getInstance();
		
		/*
		 *  2. 启动或停止
		 */
		
		if(method.trim().equalsIgnoreCase("start")) {
			//必填  job编码，类似于sid，根据编码来获取恰当的job
			String jobCodeStr = request.getParameter("jobCode");
			int jobCode = Integer.parseInt(jobCodeStr);
			//选填 供存储、删除任务使用
			String jobName = request.getParameter("jobName").trim();
			if(CommonUtil.isEmpty(jobName)) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
				jobName = "Job" + format.format(new Date(System.currentTimeMillis()));
			}
			
			//选填 间隔 默认60s
			String periodStr = request.getParameter("period");
			Long period = null;
			if(CommonUtil.isNotEmpty(periodStr)){
				period = Long.valueOf(periodStr);
			}
			//选填 延迟默认60s
			String delayStr = request.getParameter("delay");
			Long delay = null;
			if(CommonUtil.isNotEmpty(delayStr)) {
				delay = Long.valueOf(delayStr);
			}
			//选填 格式：2012-08-15 19:00 job运行日期或起始日期，默认当前时间开始
			String timeStr = request.getParameter("time");
			Date time = null;
			try {
				if(CommonUtil.isNotEmpty(timeStr)) {
					time = TimerUtil.parseData(timeStr);
				}
			} catch (FomartException e) {
				e.printStackTrace();
				TimerUtil.outPrintln(out, "Param time fomart is wrong, error!");
				return;
			}
			//获取计划任务的方式，取值为 time、time_period、delay、delay_period、fixed_time_period、fixed_delay_period六种
			String mode = request.getParameter("mode");
			
			//load 未完成的任务时使用
			String save = request.getParameter("save");
			
			//获取Job的参数列表
			String param_Str = request.getParameter("params");
			String params[] = null;
			if(CommonUtil.isNotEmpty(param_Str)) {
				params = param_Str.split(",");
			}
			
			String reqId = request.getParameter("reqId");
			
			//用户任务请求的url
			String requestUrl = request.getRequestURL() + "?" + request.getQueryString();
			
			String result = timerRequestManager.start(jobName, save, requestUrl, mode, 
					params, reqId, jobCode, time, period, delay);
			TimerUtil.outPrintln(out, result);
		} else {
			String jobName = request.getParameter("jobName").trim();
			String result = timerRequestManager.stop(jobName);
			TimerUtil.outPrintln(out, result);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
