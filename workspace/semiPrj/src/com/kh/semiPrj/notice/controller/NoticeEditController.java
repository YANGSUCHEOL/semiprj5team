package com.kh.semiPrj.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semiPrj.notice.service.NoticeService;
import com.kh.semiPrj.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/edit")
public class NoticeEditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//현재 게시글 번호만 조회(꺼내오기)
		String no = req.getParameter("no");
		
		//디비 다녀오기 (공지 조회 서비스 이용)
		NoticeVo vo = new NoticeService().selectNoticeDetail(no);
		
		//화면 선택
		req.setAttribute("vo", vo);
		req.getRequestDispatcher("/WEB-INF/views/noticeBoard/edit.jsp").forward(req, resp);
	
	}//get
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		// 데이터 꺼내기
		String no = req.getParameter("no");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
	
		//데이터 뭉치기
		NoticeVo vo = new NoticeVo();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		
		// 디비 다녀오기
		int result = new NoticeService().edit(vo);
	
		// 화면선택
		if(result == 1) {
			//성공
			req.getSession().setAttribute("alertMsg", "공지사항 수정 성공!");
			resp.sendRedirect("/semiPrj/notice/detail?no=" + no);
		}else {
			//실패
			req.setAttribute("msg", "공지사항 수정 실패 ...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}//post
	
	
}
