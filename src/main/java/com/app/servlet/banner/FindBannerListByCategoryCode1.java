package com.app.servlet.banner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.app.service.BannerService;



/**
 * 首页广告图
 * 
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年10月29日
 */
@WebServlet(name="FindBannerListByCategoryCode1", urlPatterns={"/FindBannerListByCategoryCode1"})
public class FindBannerListByCategoryCode1 extends HttpServlet {

	private static final long serialVersionUID = 7147880293691079975L;
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			
			List<Map<String, Object>> banner = new BannerService().queryBannerListByCategory1();
			
			response.getWriter().print(new Gson().toJson(banner));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//error
		}
	}
	
	
	
}
