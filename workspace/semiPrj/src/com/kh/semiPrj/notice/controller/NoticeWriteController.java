package com.kh.semiPrj.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.Prj.member.MemberVo;
import com.kh.semiPrj.notice.service.NoticeService;
import com.kh.semiPrj.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/write")
public class NoticeWriteController extends HttpServlet {
	
	//화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//관리자일 때 포워딩
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		boolean isAdmin = loginMember != null && loginMember.getId().equals("admin");
		
		
		if(isAdmin) {
			req.getRequestDispatcher("/WEB-INF/views/noticeBoard/write.jsp").forward(req, resp);			
		} else {
			//관리자 아님
			req.setAttribute("msg", "글쓰기 권한이 없습니다.");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
		
		
		
		
	
	}//get
	
	//공지사항 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//세션 꺼내기
		HttpSession s = req.getSession();
		
		//로그인 멤버 가지고 오기
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		//데이터 꺼내기
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//데이터 뭉치기
		NoticeVo vo = new NoticeVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(loginMember.getNo());
		
		//디비 다녀오기
		int result = new NoticeService().write(vo);
		
		//화면 선택
		if(result == 1) {
			//공지 작성 성공
			s.setAttribute("alertMsg", "공지사항 작성 완료!");
			resp.sendRedirect("/semiPrj/notice/list");
		} else {
			//공지 작성 실패
			req.setAttribute("mag", "공지사항 작성 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}//post
	
}
