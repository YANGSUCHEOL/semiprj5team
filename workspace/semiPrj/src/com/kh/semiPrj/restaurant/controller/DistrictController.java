package com.kh.semiPrj.restaurant.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.restaurant.service.RestaurantService;
import com.kh.semiPrj.restaurant.vo.RestaurantVo;

import com.google.gson.Gson;

@WebServlet(urlPatterns = "/district")
public class DistrictController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
		String district = req.getParameter("d");
		
		List<RestaurantVo> voList = new RestaurantService().searchDistrictList(district);
		
		Gson gson = new Gson();
		String str = gson.toJson(voList);
		
		out.write(str);
		
	}
	
}
