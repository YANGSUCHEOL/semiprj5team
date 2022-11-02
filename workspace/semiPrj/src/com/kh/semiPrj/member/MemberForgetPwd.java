package com.kh.semiPrj.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/member/forgetPwd")
public class MemberForgetPwd extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String forgetName = req.getParameter("forgetName");
		String forgetId = req.getParameter("forgetId");
		
		MemberVo vo = new MemberVo();
		vo.setName(forgetName);
		vo.setId(forgetId);
		
		MemberVo forget = new MemberService().forget(vo);
		
		if(forget != null) {
			System.out.println("비밀번호찾기 성공");
			req.getSession().setAttribute("alertMsg", "비밀번호 : "+forget.getPwd());
			resp.sendRedirect("/semiPrj");
		}else {
			System.out.println("비밀번호찾기 실패");
			req.getRequestDispatcher("/semiPrj/errorPage.jsp").forward(req, resp);
		}
		
		
	}

}
