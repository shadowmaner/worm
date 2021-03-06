package com.app.servlet.lecture;

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
import com.app.service.LectureService;



/**
 * 查询所有专家讲堂
 *@author FFFF
 * Put
 * undefined
 * The's Not me want.
 * insert in
 * angel
 * nice
 * 2016年9月22日
 */
@WebServlet(name="FindLectureAll", urlPatterns={"/FindLectureAll"})
public class FindLectureAll extends HttpServlet {

	private static final long serialVersionUID = 4610591536953904550L;

	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application.json");
		response.setCharacterEncoding("utf-8");
		
		
		try {
			List<Map<String, Object>> kls = new LectureService().queryLectureAll();
		
			
			response.getWriter().print(new Gson().toJson(kls));//success
			
		} catch (SQLException e) {
			e.printStackTrace();
			response.getWriter().print(2);//SQL error SQL执行报错
		}
	}
	
	
	
}
