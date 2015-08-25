package com.changda.util;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//主要用于上传图片，图片存于应用下的upload目录，根据日期等来重命名文件，文件名存于数据库，前台调用时，需指出图片的http地址；
public class FileUpload extends HttpServlet {

    private static final long   serialVersionUID = 1L;


    private static final String CONTENT_TYPE     = "text/html; charset=GB18030";


    //Process the HTTP Post request

    public void doPost(HttpServletRequest request, HttpServletResponse response)

            throws ServletException, IOException {

        String path = request.getContextPath();

        //WEB形式的表现地址，示例：http://127.0.0.1:8080/uploadtest/

        String basePath = request.getScheme() + "://" + request.getServerName()

                + ":" + request.getServerPort() + path + "/";

        //获得本地地址，示例如：c://tomcat/webapp/

        String temp = getServletContext().getRealPath("/") + "upload/temp"; //临时目录

        String loadpath = getServletContext().getRealPath("/") + "upload"; //上传文件存放目录

        response.setContentType(CONTENT_TYPE);

        PrintWriter out = response.getWriter();

        try {

            //Create a factory for disk-based file items

            DiskFileItemFactory factory = new DiskFileItemFactory();

            //Set factory constraints设置最多只允许在内存中存储的数据,单位:字节

            factory.setSizeThreshold(4096);

            //设置一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录(缓存)

            factory.setRepository(new File(temp));

            //Create a new file upload handler

            ServletFileUpload upload = new ServletFileUpload(factory);

            // Set overall request size constraint设置允许用户上传文件大小,单位:字节，这里设为5m

            upload.setSizeMax(500 * 1024 * 1024);
            
            
            //解决上传中文文件名的乱码问题
            upload.setHeaderEncoding("UTF-8");   
            response.setContentType("text/html;charset=utf-8");   

            //Parse the request

            List /* FileItem */fileItems = upload.parseRequest(request);

            //开始读取上传信息

            // 依次处理每个上传的文件

            Iterator iter = fileItems.iterator();

            while (iter.hasNext()) {

                FileItem item = (FileItem) iter.next();

                //忽略其他不是文件域的所有表单信息

                if (!item.isFormField()) {

                    String name = item.getName();

                    long size = item.getSize();

                    if ((name == null || name.equals("")) && size == 0)

                        continue;

                    name = name.substring(name.lastIndexOf("\\") + 1);//从全路径中提取文件名

                    //处理中文编码问题，前台是UTF－8，所以这里需要对应上，如果前台是gb2312的话，这里也应该是gb2312

                    name = new String(name.getBytes(), "GB18030");

                    try {

                        //保存上传的文件到指定的目录

                        //在下文中上传文件至数据库时，将对这里改写
                    	
                    	//更改文件名
                    	DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
                        String date = df.format(new Date());
//  System.out.println(name);
                        
                        name = date+Math.round(Math.random()*10000)+ name.substring(name.indexOf("."));

                    	
                        File fNew = new File(loadpath, name);

                        item.write(fNew);
                        
                        
                        PassParameter.getInstance().setS(name);
                        
                        // System.out.println(PassParameter.getS());
                        //out.print(name + " " + size + "");
                        
                        //将文件名存入session，以便表单提交的时候能够拿到
                        HttpSession session = request.getSession();
//System.out.println(name);
                        session.setAttribute("picurl", name);
                        
                        response.sendRedirect(basePath + "admin/util/uploadfile.jsp");//返回刷新页面，即返回iframe
                        
                    }

                    catch (Exception e) {

                        e.printStackTrace();

                        out.println(e);

                    }

                }

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

    }

}

