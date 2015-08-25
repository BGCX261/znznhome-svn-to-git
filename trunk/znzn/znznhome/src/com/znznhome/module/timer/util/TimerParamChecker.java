package com.znznhome.module.timer.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.znznhome.module.timer.exception.FomartException;
import com.znznhome.util.CommonUtil;

/**
 * @Description 专门检测和验证timer组件的url参数
 * 				jobCode, mode 不允许为空
 * 				其它字段，如果不为空，则检验其合法性；
 * @author xiudong.li
 * @date 2012-8-13 下午06:42:43
 * @version V1.2
 */

public class TimerParamChecker {

	public static boolean check4Start(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		if (false == UrlParamCheckUtil.checkParamExist(request, new String[] { "jobCode", "mode" })) {
			TimerUtil.outPrintln(out, "params lost! check 'jobCode、mode'");
			return false;
		}
		String mode = request.getParameter("mode");
		
		if (!mode.trim().equals("time") && !mode.trim().equals("time_period") && !mode.trim().equals("delay") && !mode.trim().equals("delay_period") && !mode.trim().equals("fixed_time_period") && !mode.trim().equals("fixed_delay_period") ) {
			TimerUtil.outPrintln(out, "params value error! check 'mode'");
			return false;
		}
		
		//处理必填参数 job编码，类似于sid，根据编码来获取恰当的job
		String jobCodeStr = request.getParameter("jobCode");
		//选填 间隔
		String periodStr = request.getParameter("period");
		//选填 延迟
		String delayStr = request.getParameter("delay");
		int jobCode;
		long period, delay;
		try{
			if(CommonUtil.isNotEmpty(jobCodeStr)){
				jobCode = Integer.parseInt(jobCodeStr);
			}
			if(CommonUtil.isNotEmpty(periodStr)){
				period = Long.parseLong(periodStr);
			}
			if(CommonUtil.isNotEmpty(delayStr)){
				delay = Long.parseLong(delayStr);
			}
			
		}catch (NumberFormatException e){
			e.printStackTrace();
			TimerUtil.outPrintln(out, "jobCode, period, delay, all shoud be a number, check it!");
			return false;
		}
		String timeStr = request.getParameter("time");
		if(CommonUtil.isNotEmpty(timeStr) && !UrlParamCheckUtil.isTimeStamp(timeStr)){
			TimerUtil.outPrintln(out, "params value error! check 'time'");
			return false;
		}
		Date time = null;
		try {
			if(CommonUtil.isNotEmpty(timeStr)){
				time = TimerUtil.parseData(timeStr);
			}
		} catch (FomartException e) {
			e.printStackTrace();
			TimerUtil.outPrintln(out, "time's format is wrong, check it!");
			return false;
		}

		return true;
	}
	
	public static boolean check4Stop(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		if (false == UrlParamCheckUtil.checkParamExist(request, new String[] { "jobName"})) {
			TimerUtil.outPrintln(out, "params lost! check 'jobName'");
			return false;
		}
		return true;
	}
}
