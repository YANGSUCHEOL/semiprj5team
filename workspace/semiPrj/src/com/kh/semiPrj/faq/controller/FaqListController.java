package com.kh.semiPrj.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.faq.service.FaqService;
import com.kh.semiPrj.faq.vo.FaqVo;

@WebServlet(urlPatterns = "/faq/list")
public class FaqListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기(생략)
		//데이터 뭉치기(생략)
		
		//디비 다녀오기
		List<FaqVo> voList = new FaqService().selectFaqList();
		
		//화면 선택
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/WEB-INF/views/faq/list.jsp").forward(req, resp);
	}
}
