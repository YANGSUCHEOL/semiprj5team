package com.kh.semiPrj.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.member.MemberVo;
import com.kh.semiPrj.community.service.CommuService;
import com.kh.semiPrj.community.vo.CategoryVo;
import com.kh.semiPrj.community.vo.CommuVo;

@WebServlet(urlPatterns = "/community/edit")
public class CommuEditController extends HttpServlet {
	
	private final CommuService cs = new CommuService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//현재 게시글 번호만 조회(꺼내오기)
		String bno = req.getParameter("bno");
		
		//디비 다녀오기
		CommuVo vo = cs.selectOne(bno);
		List<CategoryVo> cateList = cs.selectCategoryList();
		

		
		//화면 선택
		req.setAttribute("cateList", cateList);
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/communityBoard/edit.jsp").forward(req, resp);

	
	}//get
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//세션 불러오기
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		// 데이터 꺼내기
		String bno = req.getParameter("bno");
		String category = req.getParameter("category");
		System.out.println(category);
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		CommuVo vo = new CommuVo();
		vo.setNo(bno);
		vo.setCategory(category);
		System.out.println(vo.getCategory());
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(loginMember.getNo());
		
		// 디비 다녀오기
		int result = cs.edit(vo);
		
		// 화면선택
		if(result == 1) {
			//성공
			req.getSession().setAttribute("alertMsg", "게시글 수정 성공!");
			resp.sendRedirect("/semiPrj/community/detail?bno=" + bno);
		}else {
			//실패
			req.setAttribute("msg", "게시글 수정 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}//post

}
