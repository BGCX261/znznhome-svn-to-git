package com.znznhome.module.timer.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import org.xml.sax.SAXException;

import com.znznhome.module.timer.exception.FomartException;
import com.znznhome.module.timer.job.ITimerJob;
import com.znznhome.module.timer.manager.TimerRequestManager;
import com.znznhome.module.timer.model.TimerRequest;
import com.znznhome.module.timer.timer.TimerAdapter;
import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

public class TimerUtil {

	/**
	 * @Description Use in servlet make out print simple;
	 * @author xiudong.li
	 * @param out
	 * @param s
	 */
	public static void outPrintln(PrintWriter out, String s) {
		out.println(s);
		out.flush();
		out.close();
	}

	/**
	 * @Description Ajust TimerAdapter's state in servlet adapterMap;
	 * @author xiudong.li
	 * @param gdsTimerMap
	 * @param timerId
	 * @return
	 */
	public static int getState4Stop(Map<String, TimerAdapter> gdsTimerMap, String timerId) {
		Set keys = gdsTimerMap.keySet();
		Iterator e = keys.iterator();
		while (e.hasNext()) {
			String timerId_ = (String) e.next();
			TimerAdapter temp = (TimerAdapter) gdsTimerMap.get(timerId_);
			// ID在map中，且正在运行的才删， ID在map中，但已cancel的，可以重复启动
			if (timerId_.trim().equals(timerId) && temp.getState() == TimerAdapter.SCHEDULED) {
				return ITimerJob.RUNNING;
			} else if (timerId_.trim().equals(timerId) && temp.getState() == TimerAdapter.STOPPED) {
				return ITimerJob.STOP;
			} else if (timerId_.trim().equals(timerId) && temp.getState() == TimerAdapter.VIRGIN) {
				return ITimerJob.PREPARING;
			}
		}
		return ITimerJob.NOTEXIST;
	}

	public static Date parseData(String date) throws FomartException {
		// 2012-08-15 19:00
		if (date.matches("\\d{4}-[0-1]{1}[0-9]{1}-[0-3]{1}[0-9]{1}\\s[0-2]{1}[0-9]{1}:[0-5]{1}[0-9]{1}") == false) {
			throw new FomartException();
		}
		Date d = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			d = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return d;
	}

	public static void main(String[] args) {
		String s = "2012-04-15 19:20";
		try {
			System.out.println(parseData(s));
		} catch (FomartException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @Description 系统启动12秒后，执行未完成的TimerRequest
	 * @author xiudong.li
	 */
	public static void loadTimerRequest() {
		Timer timer = new Timer();
		TimerRequestManager manager = TimerRequestManager.getInstance();
		List<TimerRequest> list = manager.getTimerRequestList();
		if (list != null && list.size() > 0) {
			timer.schedule(getTask(list), 12000L);

		}
	}

	/**
	 * @Description 遍历未完成的TimerRequest列表，取出每一个url，发送到timer服务器，重复执行
	 * @author xiudong.li
	 * @param list
	 * @return
	 */
	public static TimerTask getTask(final List<TimerRequest> list) {
		TimerTask timerTask = new TimerTask() {
			public void run() {
				for (TimerRequest req : list) {
					String url = req.getRequesturl() + "&reqId=" + req.getId() + "&save=no";
					System.out.println(url);
					HttpUnitOptions.setScriptingEnabled(false);
					WebConversation wc = new WebConversation();
					WebRequest request = new PostMethodWebRequest(url);
					try {
						WebResponse response = wc.getResponse(request);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (SAXException e) {
						e.printStackTrace();
					}
				}
			};
		};
		return timerTask;
	}

}
