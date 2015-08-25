package com.znznhome.module.timer.job;

import java.io.IOException;
import java.util.List;

import org.xml.sax.SAXException;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


 
/**
 * @Description 任务示例
 * @author xiudong.li
 * @date 2012-7-19 下午03:54:30
 * @version V1.2
 */
public class TimerJobExample implements ITimerJob{

	int _i = 0;
	
	public boolean isOver() {
		if(_i > 5) {
			System.out.println("a GdsTask isOver.");
			return true;
		} else { 
			return false;
		}
		
	}

	public void work(String[] params) {
		String urlString = "http://10.2.8.40:15001";
		HttpUnitOptions.setScriptingEnabled(false);
		WebConversation wc = new WebConversation();
		WebRequest request = new PostMethodWebRequest(urlString);
		try {
			WebResponse response = wc.getResponse(request);
			String resultText = response.getText();
			//System.out.println(resultText);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
		System.out.println("a GdsTask running , print i = " + _i);
		_i ++;
	}

}
