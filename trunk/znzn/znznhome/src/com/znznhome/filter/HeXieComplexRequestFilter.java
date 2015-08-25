package com.znznhome.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.znznhome.badwords.AtomicPattern;
import com.znznhome.badwords.MutiPatternParser;
import com.znznhome.badwords.TxtReader;
import com.znznhome.util.CommonUtil;
import com.znznhome.util.ConfigUtil;

public class HeXieComplexRequestFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		//需要过滤的字段配置在配置文件中
		List fields = ConfigUtil.getFieldsList();
		for(int i=0; i<fields.size(); i++) {
			String field = (String)fields.get(i);
			String text = request.getParameter(field);
			if (CommonUtil.isNotEmpty(text)) {
				MutiPatternParser filterEngine = new MutiPatternParser();
				BufferedReader brKeyword = TxtReader
						.keywordReader("badwords2.txt");
				String keyword = null;
				Vector<Integer> levelSet = new Vector<Integer>();
				try {
					// 加载所有关键词
					while ((keyword = brKeyword.readLine()) != null) {
						filterEngine.addFilterKeyWord(keyword, 1);
					}
				} catch (IOException e) {
					System.out.println("读取文件IO异常!!!");
					e.printStackTrace();
				}
				Vector<AtomicPattern> realBadWords = filterEngine.getSingleRealKeyWords(text, levelSet);
				for (AtomicPattern ap : realBadWords) {
					System.out.println("realKeyWords -- " + ap);
					text = text.replaceAll(ap.getPattern().getStr(), MutiPatternParser.HEXIEWORD);
				}
				System.out.println("替换后的文本 -- " + text);
				//getContext().getParameters().put(field, text);
				request.setAttribute(field, text);
			}
		}
		chain.doFilter(request, response);
	}

}
