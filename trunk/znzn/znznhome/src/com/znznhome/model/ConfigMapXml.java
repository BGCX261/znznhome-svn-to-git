package com.znznhome.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;
import org.dom4j.xpath.DefaultXPath;

public class ConfigMapXml {
	
	private static ConfigMapXml configMap;
	
	
	/** @Fields idMap: 程序中需要配置的参数 */
	private Map<String, Object> paramsMap = new HashMap<String, Object>();

	/** @Fields propsMap: 程序中需要配置的属性 */
	private Map<String, Object> propsMap = new HashMap<String, Object>();

	/** @Fields fieldsList: 敏感词过滤器中，需要过滤的字段 */
	private List<String> fieldsList = new ArrayList<String>();
	
	/** @Fields categoryNamesListHomepage: 首页所需模块的目录名 */
	private List<String> categoryNamesListHomepage = new ArrayList<String>();
	
	/** @Fields categoryNamesListNews: 新闻热帖频道的模块目录名 */
	private List<String> categoryNamesListNews = new ArrayList<String>();

	/** @Fields categoryNamesListFavor: 经典收藏频道的模块目录名*/
	private List<String> categoryNamesListFavor = new ArrayList<String>();
	
	/** @Fields categoryNamesListPlayers: 专业玩家频道的模块目录名*/
	private List<String> categoryNamesListPlayers = new ArrayList<String>();

	/** @Fields categoryNamesListVideo: 影视音乐频道的模块目录名*/
	private List<String> categoryNamesListVideo = new ArrayList<String>();
	
	/** @Fields categoryNamesListOpinion: 屌丝声音频道的模块目录名*/
	private List<String> categoryNamesListOpinion = new ArrayList<String>();
	
	/** @Fields categoryNamesListCoolSites: 未知酷站频道的模块目录名*/
	private List<String> categoryNamesListCoolSites = new ArrayList<String>();
	
	/** @Fields categoryNamesListDownload: 资源下载频道的模块目录名*/
	private List<String> categoryNamesListDownload = new ArrayList<String>();
	
	/** @Fields categoryNamesListSelfStudy: 自学天地频道的模块目录名*/
	private List<String> categoryNamesListSelfStudy = new ArrayList<String>();
	

	/** 
	 * @Description 用于节点排序
	 * @author lxd
	 * @date 2012-10-19 上午12:33:43 
	 * @version V1.3.1
	 */ 
	class NumberXPath extends DefaultXPath{
	    public NumberXPath(String text){  
	        super(text);  
	    }  
	    protected Object getCompareNumberValue(Node node) {  
	        return numberValueOf(node);  
	    } 
	}
	
	/**
	 * @Description: 将web_config.xml中配置的参数初始化
	 * @author xiudong.li
	 * @date 2011-12-12 下午03:37:19
	 * @return
	 */
	private ConfigMapXml() {
			this.init();
	}
	
	public void init() {
		this.mapClear();
		SAXReader saxReader = new SAXReader();
		try {
			String path = ConfigMapXml.class.getClassLoader().getResource("").getPath() + "web_config.xml";
			Document doc = saxReader.read(path);
			Element roote = doc.getRootElement();
			List<Element> elist = roote.elements();
			for (int i = 0; i < elist.size(); i++) {
				Element element = elist.get(i);
				if (element.getName().equals("params")) {
					List<Element> filesList = element.elements();
					for (int j = 0; j < filesList.size(); j++) {
						Element fileElement = filesList.get(j);
						paramsMap.put(fileElement.attributeValue("name"), fileElement.getText());
					}
				} else if (element.getName().equals("props")) {
					List<Element> filesList = element.elements();
					for (int j = 0; j < filesList.size(); j++) {
						Element fileElement = filesList.get(j);
						propsMap.put(fileElement.attributeValue("name"), fileElement.getText());
					}
				} else if (element.getName().equals("url-filter")) {
					List<Element> filesList = element.elements();
					for (int j = 0; j < filesList.size(); j++) {
						Element fileElement = filesList.get(j);
						fieldsList.add(fileElement.attributeValue("name"));
					}
				} else if (element.getName().equals("homepageMods")) {
					List list = doc.selectNodes("web-conf/homepageMods/module[@turn]");   
					  
					XPath xPath =new NumberXPath("@turn");   
					xPath.sort(list);   
					  
					//查看结果   
					Iterator it = list.iterator();   
					while(it.hasNext()){   
					    Element fileElement = (Element) it.next();   
					    //System.out.println(fileElement.attributeValue("turn"));   
					    categoryNamesListHomepage.add(fileElement.attributeValue("name"));
					}  
					Collections.reverse(categoryNamesListHomepage); //降序 
/*						for(String s : categoryNamesList) {
						System.out.println(s);
					}*/
				} else if (element.getName().equals("newsMods")) {
					List list = doc.selectNodes("web-conf/newsMods/module[@turn]");   
					XPath xPath =new NumberXPath("@turn");   
					xPath.sort(list);   
					//查看结果   
					Iterator it = list.iterator();   
					while(it.hasNext()){   
					    Element fileElement = (Element) it.next();   
					    categoryNamesListNews.add(fileElement.attributeValue("name"));
					}  
					Collections.reverse(categoryNamesListNews); //降序 
/*						for(String s : categoryNamesListNews) {
						System.out.println("news -- " +s);
					}*/
				}  else if (element.getName().equals("favorMods")) {
					List list = doc.selectNodes("web-conf/favorMods/module[@turn]");   
					XPath xPath =new NumberXPath("@turn");   
					xPath.sort(list);   
					//查看结果   
					Iterator it = list.iterator();   
					while(it.hasNext()){   
					    Element fileElement = (Element) it.next();   
					    categoryNamesListFavor.add(fileElement.attributeValue("name"));
					}  
					Collections.reverse(categoryNamesListFavor); //降序 
/*						for(String s : categoryNamesListFavor) {
						System.out.println("favor -- " + s);
					}*/
				} else if (element.getName().equals("playersMods")) {
					List list = doc.selectNodes("web-conf/playersMods/module[@turn]");   
					XPath xPath =new NumberXPath("@turn");   
					xPath.sort(list);   
					//查看结果   
					Iterator it = list.iterator();   
					while(it.hasNext()){   
					    Element fileElement = (Element) it.next();   
					    categoryNamesListPlayers.add(fileElement.attributeValue("name"));
					}  
					Collections.reverse(categoryNamesListPlayers); //降序 
/*						for(String s : categoryNamesListPlayers) {
						System.out.println("player -- " + s);
					}*/
				} else if (element.getName().equals("videoMods")) {
					List list = doc.selectNodes("web-conf/videoMods/module[@turn]");   
					XPath xPath =new NumberXPath("@turn");   
					xPath.sort(list);   
					//查看结果   
					Iterator it = list.iterator();   
					while(it.hasNext()){   
					    Element fileElement = (Element) it.next();   
					    categoryNamesListVideo.add(fileElement.attributeValue("name"));
					}  
					Collections.reverse(categoryNamesListVideo); //降序 
				} else if (element.getName().equals("opinionMods")) {
					List list = doc.selectNodes("web-conf/opinionMods/module[@turn]");   
					XPath xPath =new NumberXPath("@turn");   
					xPath.sort(list);   
					//查看结果   
					Iterator it = list.iterator();   
					while(it.hasNext()){   
					    Element fileElement = (Element) it.next();   
					    categoryNamesListOpinion.add(fileElement.attributeValue("name"));
					}  
					Collections.reverse(categoryNamesListOpinion); //降序 
				} else if (element.getName().equals("coolSitesMods")) {
					List list = doc.selectNodes("web-conf/coolSitesMods/module[@turn]");   
					XPath xPath =new NumberXPath("@turn");   
					xPath.sort(list);   
					//查看结果   
					Iterator it = list.iterator();   
					while(it.hasNext()){   
					    Element fileElement = (Element) it.next();   
					    categoryNamesListCoolSites.add(fileElement.attributeValue("name"));
					}  
					Collections.reverse(categoryNamesListCoolSites); //降序 
				} else if (element.getName().equals("downloadMods")) {
					List list = doc.selectNodes("web-conf/downloadMods/module[@turn]");   
					XPath xPath =new NumberXPath("@turn");   
					xPath.sort(list);   
					//查看结果   
					Iterator it = list.iterator();   
					while(it.hasNext()){   
					    Element fileElement = (Element) it.next();   
					    categoryNamesListDownload.add(fileElement.attributeValue("name"));
					}  
					Collections.reverse(categoryNamesListDownload); //降序 
				} else if (element.getName().equals("selfStudyMods")) {
					List list = doc.selectNodes("web-conf/selfStudyMods/module[@turn]");   
					XPath xPath =new NumberXPath("@turn");   
					xPath.sort(list);   
					//查看结果   
					Iterator it = list.iterator();   
					while(it.hasNext()){   
					    Element fileElement = (Element) it.next();   
					    categoryNamesListSelfStudy.add(fileElement.attributeValue("name"));
					}  
					Collections.reverse(categoryNamesListSelfStudy); //降序 
				}
			}

		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	private void mapClear() {
		paramsMap.clear();
		propsMap.clear();
		fieldsList.clear();
		categoryNamesListHomepage.clear();
		categoryNamesListNews.clear();
		categoryNamesListFavor.clear();
		categoryNamesListPlayers.clear();
		categoryNamesListVideo.clear();
		categoryNamesListOpinion.clear();
		categoryNamesListCoolSites.clear();
		categoryNamesListDownload.clear();
		categoryNamesListSelfStudy.clear();
	}

	public List<String> getChannelCategoryName(String channel) {
		List<String> list = new ArrayList<String>();
		if(channel == null || channel.trim().equalsIgnoreCase("homepage")) {
			return this.getCategoryNamesListHomepage();
		} else if (channel.trim().equalsIgnoreCase("news-posts")) {
			return this.getCategoryNamesListNews();
		}  else if (channel.trim().equalsIgnoreCase("self-study")) {
			return this.getCategoryNamesListSelfStudy();
		}  else if (channel.trim().equalsIgnoreCase("professional-gamers")) {
			return this.getCategoryNamesListPlayers();
		}  else if (channel.trim().equalsIgnoreCase("video-music")) {
			return this.getCategoryNamesListVideo();
		}  else if (channel.trim().equalsIgnoreCase("znzn-opinions")) {
			return this.getCategoryNamesListOpinion();
		}  else if (channel.trim().equalsIgnoreCase("cool-sites")) {
			return this.getCategoryNamesListCoolSites();
		}  else if (channel.trim().equalsIgnoreCase("src-download")) {
			return this.getCategoryNamesListDownload();
		} else {
			return this.getCategoryNamesListHomepage();
		}
	}
	
	public static ConfigMapXml getInstance() {
		if(configMap == null) configMap = new ConfigMapXml();
		return configMap;
	}
	
	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public Map<String, Object> getPropsMap() {
		return propsMap;
	}
	 
	

	public String getResourceAsSring(String resourceName) {
		InputStream inputStream = ConfigMapXml.class.getClassLoader().getResourceAsStream(resourceName);
		String data = "";
		try {
			data = IOUtils.toString(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}

	public List<String> getFieldsList() {
		return fieldsList;
	}
	

	public static void main(String[] args) {
		//System.out.println(ConfigUtil.getResourceAsSring("web_config.xml"));
		// Map m = getDirMap();
		// Map m = getIdMap();
		ConfigMapXml configMap = ConfigMapXml.getInstance();
/*		Map m = configMap.getParamsMap();
		Set<Map.Entry<String, Object>> set = m.entrySet();
		for (Iterator<Map.Entry<String, Object>> it = set.iterator(); it.hasNext();) {
			Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
			System.out.println(entry.getKey() + "--->" + entry.getValue());
		}
		System.out.println(configMap.getResourceAsSring("badwords.txt"));
		List<String> fieldsList = configMap.getFieldsList();
		for(String s : fieldsList) {
			System.out.println(s);
		}*/

	}

	public List<String> getCategoryNamesListHomepage() {
		return categoryNamesListHomepage;
	}


	public List<String> getCategoryNamesListNews() {
		return categoryNamesListNews;
	}

	public List<String> getCategoryNamesListFavor() {
		return categoryNamesListFavor;
	}


	public List<String> getCategoryNamesListPlayers() {
		return categoryNamesListPlayers;
	}


	public List<String> getCategoryNamesListVideo() {
		return categoryNamesListVideo;
	}


	public List<String> getCategoryNamesListOpinion() {
		return categoryNamesListOpinion;
	}


	public List<String> getCategoryNamesListCoolSites() {
		return categoryNamesListCoolSites;
	}

	public List<String> getCategoryNamesListDownload() {
		return categoryNamesListDownload;
	}
	public List<String> getCategoryNamesListSelfStudy() {
		return categoryNamesListSelfStudy;
	}

	public void setCategoryNamesListSelfStudy(List<String> categoryNamesListSelfStudy) {
		this.categoryNamesListSelfStudy = categoryNamesListSelfStudy;
	}
}
