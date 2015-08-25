package com.znznhome.factory;

public class CssFactory {
	
	private static CssFactory cssFactory;
	
	private CssFactory(){};
	
	public static CssFactory getInstance() {
		if(cssFactory == null) {
			cssFactory = new CssFactory();
		}
		return cssFactory;
	}
	
	public static String[] getNaviCss(String channel) {
		String[] claz = new String[]{"", "", "", "", "", "", "", ""};
		if(channel == null || channel.trim().equalsIgnoreCase("homepage")) {
			claz[0] = " id=\"sy\" ";
		} else if (channel.trim().equalsIgnoreCase("news-posts")) {
			claz[1] = " id=\"sy\" ";
		}  else if (channel.trim().equalsIgnoreCase("self-study")) {
			claz[2] = " id=\"sy\" ";
		}  else if (channel.trim().equalsIgnoreCase("professional-gamers")) {
			claz[3] = " id=\"sy\" ";
		}  else if (channel.trim().equalsIgnoreCase("video-music")) {
			claz[4] = " id=\"sy\" ";
		}  else if (channel.trim().equalsIgnoreCase("znzn-opinions")) {
			claz[5] = " id=\"sy\" ";
		}  else if (channel.trim().equalsIgnoreCase("cool-sites")) {
			claz[6] = " id=\"sy\" ";
		}  else if (channel.trim().equalsIgnoreCase("src-download")) {
			claz[7] = " id=\"sy\" ";
		} else {
			claz[8] = " id=\"sy\" ";
		}
		return claz;
	}

}
