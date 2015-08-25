package com.znznhome.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.InitializingBean;

import com.znznhome.dao.impl.BaseJdbcDAO;
import com.znznhome.util.Constant;

public class ConfigMap implements InitializingBean {
	
	public static ConfigMap configMap;
	
	public static ConfigMap getInstance() {
		if(configMap == null) configMap = new ConfigMap();
		return configMap;
	}
	
	/**
	 * Description Spring创建ConfigMap（单例）时，初始化配置；
	 * @throws Exception 
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet() 
	 */ 
	public void afterPropertiesSet() throws Exception {
		System.out.println("Config initial start!");
		init();
		System.out.println("Config initial over!");
		
	}
	
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
	
	
	/** @Fields baseDAO: 用于从数据库的配置表中初始化配置*/
	private BaseJdbcDAO baseDAO = new BaseJdbcDAO();

//	@Resource(name = "baseJdbcDAO")
//	public void setBaseDAO(BaseJdbcDAO baseDAO) {
//		this.baseDAO = baseDAO;
//	}


	/**
	 * @Description: 参数初始化
	 * @author xiudong.li
	 * @date 2011-12-12 下午03:37:19
	 * @return
	 * @throws SQLException 
	 */
	public void init(){
		this.mapClear();
		String sql = "select * from znzn_meta_config order by orders,conffield desc";
		List<Config> configs = null;
		try {
			configs = baseDAO.queryForBeanList(Config.class, sql, null);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(configs != null && configs.size()>0){
			for(int i=0; i<configs.size(); i++) {
				Config config = configs.get(i);
				if(config.getItem().trim().equalsIgnoreCase(Constant.PARAMS)) {
					this.paramsMap.put(config.getConffield(), config.getConfvalue());
				} else if(config.getItem().trim().equalsIgnoreCase(Constant.PROPS)) {
					this.propsMap.put(config.getConffield(), config.getConfvalue());
				} else if(config.getItem().trim().equalsIgnoreCase(Constant.FILTERFIELD)) {
					this.fieldsList.add(config.getConffield());
				} else if(config.getItem().trim().equalsIgnoreCase(Constant.COOLSITESMODS)) {
					this.categoryNamesListCoolSites.add(config.getConffield());
				} else if(config.getItem().trim().equalsIgnoreCase(Constant.DOWNLOADMODS)) {
					this.categoryNamesListDownload.add(config.getConffield());
				} else if(config.getItem().trim().equalsIgnoreCase(Constant.HOMEPAGEMODS)) {
					this.categoryNamesListHomepage.add(config.getConffield());
				} else if(config.getItem().trim().equalsIgnoreCase(Constant.NEWSMODS)) {
					this.categoryNamesListNews.add(config.getConffield());
				} else if(config.getItem().trim().equalsIgnoreCase(Constant.OPINIONMODS)) {
					this.categoryNamesListOpinion.add(config.getConffield());
				} else if(config.getItem().trim().equalsIgnoreCase(Constant.PLAYERSMODS)) {
					this.categoryNamesListPlayers.add(config.getConffield());
				} else if(config.getItem().trim().equalsIgnoreCase(Constant.SELFSTUDYMODS)) {
					this.categoryNamesListSelfStudy.add(config.getConffield());
				} else if(config.getItem().trim().equalsIgnoreCase(Constant.VIDEOMODS)) {
					this.categoryNamesListVideo.add(config.getConffield());
				}
			}
		}
	}
	
	 
	/** 
	 * @Description 清空参数容器
	 * @author xiudong.li  
	 */
	public void mapClear() {
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

	
	 
	/** 
	 * @Description 获取频道的模块列表
	 * @author xiudong.li
	 * @param channel
	 * @return  
	 */
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

	public Map<String, Object> getParamsMap() {
		return paramsMap;
	}

	public void setParamsMap(Map<String, Object> paramsMap) {
		this.paramsMap = paramsMap;
	}

	public Map<String, Object> getPropsMap() {
		return propsMap;
	}

	public void setPropsMap(Map<String, Object> propsMap) {
		this.propsMap = propsMap;
	}

	public List<String> getFieldsList() {
		return fieldsList;
	}

	public void setFieldsList(List<String> fieldsList) {
		this.fieldsList = fieldsList;
	}

	public List<String> getCategoryNamesListHomepage() {
		return categoryNamesListHomepage;
	}

	public void setCategoryNamesListHomepage(List<String> categoryNamesListHomepage) {
		this.categoryNamesListHomepage = categoryNamesListHomepage;
	}

	public List<String> getCategoryNamesListNews() {
		return categoryNamesListNews;
	}

	public void setCategoryNamesListNews(List<String> categoryNamesListNews) {
		this.categoryNamesListNews = categoryNamesListNews;
	}

	public List<String> getCategoryNamesListFavor() {
		return categoryNamesListFavor;
	}

	public void setCategoryNamesListFavor(List<String> categoryNamesListFavor) {
		this.categoryNamesListFavor = categoryNamesListFavor;
	}

	public List<String> getCategoryNamesListPlayers() {
		return categoryNamesListPlayers;
	}

	public void setCategoryNamesListPlayers(List<String> categoryNamesListPlayers) {
		this.categoryNamesListPlayers = categoryNamesListPlayers;
	}

	public List<String> getCategoryNamesListVideo() {
		return categoryNamesListVideo;
	}

	public void setCategoryNamesListVideo(List<String> categoryNamesListVideo) {
		this.categoryNamesListVideo = categoryNamesListVideo;
	}

	public List<String> getCategoryNamesListOpinion() {
		return categoryNamesListOpinion;
	}

	public void setCategoryNamesListOpinion(List<String> categoryNamesListOpinion) {
		this.categoryNamesListOpinion = categoryNamesListOpinion;
	}

	public List<String> getCategoryNamesListCoolSites() {
		return categoryNamesListCoolSites;
	}

	public void setCategoryNamesListCoolSites(List<String> categoryNamesListCoolSites) {
		this.categoryNamesListCoolSites = categoryNamesListCoolSites;
	}

	public List<String> getCategoryNamesListDownload() {
		return categoryNamesListDownload;
	}

	public void setCategoryNamesListDownload(List<String> categoryNamesListDownload) {
		this.categoryNamesListDownload = categoryNamesListDownload;
	}

	public List<String> getCategoryNamesListSelfStudy() {
		return categoryNamesListSelfStudy;
	}

	public void setCategoryNamesListSelfStudy(List<String> categoryNamesListSelfStudy) {
		this.categoryNamesListSelfStudy = categoryNamesListSelfStudy;
	}

}
