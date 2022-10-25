package com.kh.semiPrj.community.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.community.service.CommuService;
import com.kh.semiPrj.community.vo.CommuVo;

@WebServlet(urlPatterns = "/community/detail")
public class CommuDetailController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//데이터 꺼내기
 		String bno = req.getParameter("bno");
 		
 		//디비 다녀오기
 		CommuVo vo = new CommuService().selectOne(bno);
	
 		//화면 선택
 		req.setAttribute("vo", vo);
 		req.getRequestDispatcher("/WEB-INF/views/communityBoard/detail.jsp").forward(req, resp);
	}//get
	
	
}
