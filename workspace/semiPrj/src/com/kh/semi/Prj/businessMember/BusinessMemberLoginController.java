package com.kh.semi.Prj.businessMember;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/businessmember/login")
public class BusinessMemberLoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		//데이터 꺼내기
		String bsmemberId = req.getParameter("bsmemberId");
		String bsmemberPwd = req.getParameter("bsmemberPwd");
		
		//데이터 뭉치기
		BusinessMemberVo vo = new BusinessMemberVo();
		vo.setId(bsmemberId);
		vo.setPwd(bsmemberPwd);
		
		//디비다녀오기
		BusinessMemberVo bsloginMember = new BusinessMemberService().login(vo);
		
		//화면선택
		if(bsloginMember != null) {
			//로그인 성공
			System.out.println("로그인 성공");
			HttpSession s = req.getSession();
			s.setAttribute("bsloginMember", bsloginMember);
			resp.sendRedirect("/semiPrj");
		}else {
			//로그인 실패
			req.setAttribute("msg", "로그인 실패");
			req.getRequestDispatcher("/views/common/errorPage.jsp").forward(req, resp);
		}
	}
}
