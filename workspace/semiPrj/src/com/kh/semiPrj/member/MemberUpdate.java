package com.kh.semiPrj.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/member/change")
public class MemberUpdate extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		
		//데이터 꺼내기
		String updatenmemberId = req.getParameter("updatenmemberId");
		String updatememberPwd = req.getParameter("updatememberPwd");
		String updatememberNick = req.getParameter("updatememberNick");
		String updatememberName = req.getParameter("updatememberName");
		String updatephoneNum = req.getParameter("updatephoneNum");
		String updatebirth = req.getParameter("updatebirth");
		
		MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
		String no = loginMember.getNo();
		
		//데이터 뭉치기
		MemberVo vo = new MemberVo();
		vo.setId(updatenmemberId);
		vo.setPwd(updatememberPwd);
		vo.setNick(updatememberNick);
		vo.setName(updatememberName);
		vo.setPhone(updatephoneNum);
		vo.setBirth(updatebirth);
		vo.setNo(no);
		
		//디비 다녀오기
		MemberVo updatedMember = new MemberService().edit(vo);
		
		//화면선택
		if(updatedMember !=null) {
			//ㅇㅋ
			req.getSession().setAttribute("alertMsg", "회원 정보 수정 성공!");
			req.getSession().setAttribute("loginMember", updatedMember);
			resp.sendRedirect("/semiPrj");
		}else {
			//ㄴㄴ
		}
	
	}

}
