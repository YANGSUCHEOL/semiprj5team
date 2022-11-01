package com.kh.semiPrj.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/member/quit")
public class MemberQuitController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession s = req.getSession();
		
		//데이터 꺼내기
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		String no = loginMember.getNo();
		
		//데이터 뭉치기
		
		//디비 다녀오기
		int result = new MemberService().quit(no);
		
		
		//화면선택
		if(result == 1) {
			//ㅇㅋ
			s.invalidate();
			resp.sendRedirect("/semiPrj");
		}else {
			//ㄴㄴ
			req.setAttribute("msg","회원탈퇴실패");
		}
	
	}
}














