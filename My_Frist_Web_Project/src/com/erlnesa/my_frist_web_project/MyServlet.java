package com.erlnesa.my_frist_web_project;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dtools.ini.BasicIniFile;
import org.dtools.ini.IniFile;
import org.dtools.ini.IniFileReader;
import org.dtools.ini.IniSection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@WebServlet("/source_code")
public class MyServlet implements Servlet {
	//C:/Tomcat 9.0/webapps/ROOT/
	//D:/apache-tomcat-9.0.39/webapps/My_Frist_Web_Project/
	public static String Project_Add = "D:/apache-tomcat-9.0.39/webapps/My_Frist_Web_Project/";
	
	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		
	}
	
	@Override
	public ServletConfig getServletConfig() {
		return null;
	}
	
	@Override
	public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
		String code_class = servletRequest.getParameter("code_class");
		
		
		servletResponse.setContentType("text/html;charset=UTF-8");
		//添加上文
		servletResponse.getWriter().write(txt2String(new File(Project_Add+"data/above.txt")));
		//添加主目录
		File[] main_file_name_array = getFile(Project_Add+"source_code/",0);
		for(int i=0; i < main_file_name_array.length ; i++){
			if (main_file_name_array[i].isDirectory()){
	        	//如果是文件夹
	        	servletResponse.getWriter().write("<p><a href=\"source_code?code_class="+main_file_name_array[i].getName()+"\" >" + main_file_name_array[i].getName()+"</a></p>");
	        }
		}
		//添加中间段落
		servletResponse.getWriter().write(txt2String(new File(Project_Add+"data/middle.txt")));
		//添加文件目录
		if(code_class != null){
			File[] file_name_array = getFile(Project_Add+"source_code/"+code_class+"/",0);
			servletResponse.getWriter().write("<p><a href=\"#\" οnclick=\"go(-1)\"></a>……</p>");
			try{
				for(int i=0; i < file_name_array.length ; i++){
					if(file_name_array[i].isFile()){
			            //如果是文件
						servletResponse.getWriter().write("<p><a href=\"doGet"+file_name_array[i].getName()+"</p>");
			        }else if (file_name_array[i].isDirectory()){
			        	//如果是文件夹
			        	servletResponse.getWriter().write("<p>"+file_name_array[i].getName()+"</p>");
			        }
				}
			}catch (Exception e) {
				servletResponse.getWriter().write("<p>阿巴阿巴，好像没有这个路径呢</p>");
			}
			
		}else{
			servletResponse.getWriter().write("<p>My_Frist_JSP_Project</p>");
			servletResponse.getWriter().write("<p>什么，你说STM32F7！？鸽了！！！</p>");
		    
			//System.out.println("abababa");
		}
		//添加结尾段
		servletResponse.getWriter().write(txt2String(new File(Project_Add+"data/below.txt")));
	}
	
	@Override
	public String getServletInfo() {
		return null;
	}
	
	@Override
	public void destroy() {
		
	}
	
	
	
	public static File[] getFile(String path,int deep){   
        // 获得指定文件对象  
        File file = new File(path);   
        // 获得该文件夹内的所有文件   
        File[] file_name_array = file.listFiles();   
        return file_name_array;
    }
	
	public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
        	FileInputStream fis = new FileInputStream(file);
        	InputStreamReader isr = new InputStreamReader(fis,"UTF-8"); //指定以UTF-8编码读入
            BufferedReader br = new BufferedReader(isr);//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
	
	
}