package com.changda.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class FreeMarkerTemplateUtil {
	
    private final Log logger = LogFactory.getLog(getClass()); 
    private Configuration freemarker_cfg = null; 
    
    public static void main(String[] args) { 
        String dir = FreeMarkerTemplateUtil.class.getClassLoader().getResource("").getPath(); 
        String htmlDir = dir.substring(1, dir.lastIndexOf("WEB-INF")) + "html/";
        FreeMarkerTemplateUtil freeMarkerTemplateUtil = new FreeMarkerTemplateUtil(); 
        Map map = new HashMap(); 
        String fileName = "test_view.htm"; 
        boolean bOK = freeMarkerTemplateUtil.createHtmlFile("news.ftl", map, "", fileName); 
    } 

    /** 
     * 获取freemarker的配置. freemarker本身支持classpath,目录和从ServletContext获取. 
     */ 
    protected Configuration getFreeMarkerCFG() 
    { 
        if (null == freemarker_cfg) { 
            freemarker_cfg = new Configuration(); 
            // - FreeMarker支持多种模板装载方式,可以查看API文档,都很简单:路径,根据Servlet上下文,classpath等等 
            //htmlskin是放在classpath下的一个目录 
            freemarker_cfg.setDefaultEncoding("UTF-8");
            freemarker_cfg.setOutputEncoding("UTF-8"); 
            freemarker_cfg.setClassForTemplateLoading(this.getClass(), "/template"); 
        } 
        
        return freemarker_cfg; 
    } 

    /** 
     * 生成静态文件. 
     * 
     * @param templateFileName 模板文件名,相对htmlskin路径,例如"/tpxw/view.ftl" 
     * @param propMap 用于处理模板的属性Object映射 
     * @param htmlFilePath 要生成的静态文件的路径,相对设置中的根路径,例如 "/tpxw/1/2005/4/" 
     * @param htmlFileName 要生成的文件名,例如 "1.htm" 
     */ 
    public boolean createHtmlFile(String templateFileName, Map map, String htmlFilePath, String htmlFileName ) { 
        //@todo 从配置中取得要静态文件存放的根路径:需要改为自己的属性类调用 
      /*String propsfilename = "freemarker.properties"; 
        InputStream is = getClass().getClassLoader().getResourceAsStream(propsfilename); 
        Properties p = new Properties(); 
        try {
			p.load(is);
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		String filename = p.getProperty("templatefile");*/
		
    	//File dir = new File(path+"/"+dstr); 
    	//改成
    	//File dir = new File(path+File.separator+dstr); 
    	
        String dir = this.getClass().getClassLoader().getResource("").getPath(); 
        String sRootDir = dir.substring(1, dir.lastIndexOf("WEB-INF")) + "/";
//System.out.println("dir: " + dir);
//System.out.println("sRootDir: " + sRootDir);
        try {
        	//注意，如果模板中有错误，下列代码之后，会直接跳转到TemplateException；
            Template t = getFreeMarkerCFG().getTemplate(templateFileName, "UTF-8"); 
//System.out.println("debug");
            //如果根路径存在,则递归创建子目录 
            boolean b =creatDirs(sRootDir,htmlFilePath); 
            File file = new File(sRootDir +"/" +htmlFilePath + "/" + htmlFileName); 
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8")); 
            t.process(map, out); 
//System.out.println("b: " + b);
//System.out.println("htmlFilePath: " + htmlFilePath);
//System.out.println("htmlFileName: " + htmlFileName);
        } 
        catch (TemplateException e) { 
            logger.error("Error while processing FreeMarker template " + templateFileName,e); 
            return false; 
        } 
        catch (IOException e) { 
            logger.error("Error while generate Static Html File " + htmlFileName,e); 
            return false; 
        } 

        return true; 
    } 
    
    /** 
     * 创建多级目录 
     * @param parentDir String 
     * @param subDir  以 / 开头 
     * @return boolean 是否成功 
     */ 
    public static boolean creatDirs(String parentDir, String subDir) {
		File file = new File(parentDir);
		if (file.exists()) {
			File subFile = new File(parentDir + subDir);
			if (!subFile.exists()) {
				return subFile.mkdirs();
			} else {
				return true;
			}
		} else {
			return false;
		}
	}  
 
}
