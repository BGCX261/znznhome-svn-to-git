package com.znznhome.module.timer.timertask;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import org.xml.sax.SAXException;

import com.meterware.httpunit.HttpUnitOptions;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
@Deprecated
public class GdsTimerTask extends TimerTask{
	
	int i = 0;
	
	private GdsTimerTask(){};
	private static GdsTimerTask _gdsTimerTask = null;
	public static synchronized GdsTimerTask getInstance() {
		if (_gdsTimerTask == null)
			_gdsTimerTask = new GdsTimerTask();
		return _gdsTimerTask;
	}

	
	@Override
	public void run() {
		String urlString = "http://10.2.8.40:15001";
		HttpUnitOptions.setScriptingEnabled(false);
		WebConversation wc = new WebConversation();
		WebRequest request = new PostMethodWebRequest(urlString);
		try {
			WebResponse response = wc.getResponse(request);
			String resultText = response.getText();
			//System.out.println(resultText);
			System.out.println(i++);
/*			if(i > 5) {
				this.cancel();
			}*/
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
        Timer timer = new Timer();
        GdsTimerTask task = GdsTimerTask.getInstance();
        timer.schedule(task, 500L, 1000L);
	}

}
