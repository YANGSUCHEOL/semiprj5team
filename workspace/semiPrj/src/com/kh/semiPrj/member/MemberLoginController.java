package com.kh.semiPrj.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/member/login")
public class MemberLoginController extends HttpServlet{
	
	//로그인 (화면)
	
	//로그인
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//데이터 꺼내기
		String memberId = req.getParameter("memberId");
		String memberPwd = req.getParameter("memberPwd");
		String uri = req.getParameter("requestURI");
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setId(memberId);
		vo.setPwd(memberPwd);
		
		//디비다녀오기
		MemberVo loginMember = new MemberService().login(vo);
		
		//화면선택
		if(loginMember != null) {
			//로그인 성공
			System.out.println("로그인 성공");
			HttpSession s = req.getSession();
			s.setAttribute("loginMember", loginMember);
			resp.sendRedirect(uri);
		}else {
			//로그인 실패
			req.setAttribute("msg", "로그인 실패");
			req.getRequestDispatcher("/views/errorPage.jsp").forward(req, resp);
		}
		
	}
}