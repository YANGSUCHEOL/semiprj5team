package com.kh.semiPrj.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/member/join")
public class MemberJoinController extends HttpServlet{
	
	//화원가입
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String joinmemberId = req.getParameter("joinmemberId");
		String joinmemberPwd = req.getParameter("joinmemberPwd");
		String joinmemberNick = req.getParameter("joinmemberNick");
		String joinmemberName = req.getParameter("joinmemberName");
		String joinphoneNum = req.getParameter("joinphoneNum");
		String joinbirth = req.getParameter("joinbirth");
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setId(joinmemberId);
		vo.setPwd(joinmemberPwd);
		vo.setNick(joinmemberNick);
		vo.setName(joinmemberName);
		vo.setPhone(joinphoneNum);
		vo.setBirth(joinbirth);

		
		// 디비 다녀오기
		int result = new MemberService().join(vo);
		
		// 화면 선택
		if(result == 1) {
			//회원가입 성공
			req.getSession().setAttribute("alertMsg", "회원가입성공!");
			resp.sendRedirect("/semiPrj");
		}else {
			//실패
			System.out.println("회원가입 실패");
		}
	}
}
