package com.kh.semi.Prj.businessMember;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/businessmember/join")
public class BusinessMemberJoinController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//인코딩
				req.setCharacterEncoding("UTF-8");
				
				//데이터 꺼내기
				String bsrestaurantname = req.getParameter("bsrestaurantname");
				String bsjoinmemberId = req.getParameter("bsjoinmemberId");
				String bsjoinmemberPwd = req.getParameter("bsjoinmemberPwd");
				String bsjoinmemberNick = req.getParameter("bsjoinmemberNick");
				String bsjoinmemberName = req.getParameter("bsjoinmemberName");
				String bsjoinphoneNum = req.getParameter("bsjoinphoneNum");
				String bsnumber = req.getParameter("bsnumber");
				
				//데이터 뭉치기
				BusinessMemberVo vo = new BusinessMemberVo();
				
				vo.setrNo(bsrestaurantname);
				vo.setId(bsjoinmemberId);
				vo.setPwd(bsjoinmemberPwd);
				vo.setNick(bsjoinmemberNick);
				vo.setName(bsjoinmemberName);
				vo.setPhone(bsjoinphoneNum);
				vo.setbNum(bsnumber);
				

				
				// 디비 다녀오기
				int result = new BusinessMemberService().join(vo);
				
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
