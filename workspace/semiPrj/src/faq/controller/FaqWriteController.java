package faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import faq.service.FaqService;
import faq.vo.FaqVo;

@WebServlet(urlPatterns = "/faq/write")
public class FaqWriteController extends HttpServlet {

	//FAQ 작성 (화면)
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession s = req.getSession();
		//MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		//boolean isAdmin = loginMember != null && loginMember.getId().equals("admin");
		
//		if(isAdmin) {
//			req.getRequestDispatcher("/views/faq/write.jsp").forward(req, resp);
//		}else {
//			req.setAttribute("msg", "접근 권한이 없습니다.");
//			//에러페이지로 보내기
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		HttpSession s = req.getSession();
		
		//MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		FaqVo vo = new FaqVo();
		vo.setTitle(title);
		vo.setContent(content);
		
		int result = new FaqService().write(vo);
		
		if(result == 1) {
			s.setAttribute("alertMsg", "글 작성이 완료되었습니다:)");
			resp.sendRedirect("/views/faq/list.jsp");
		}else {
			req.setAttribute("msg", "글 작성에 실패했습니다ㅠ");
			//에러페이지로 보내기
		}
		
		
	}
}
