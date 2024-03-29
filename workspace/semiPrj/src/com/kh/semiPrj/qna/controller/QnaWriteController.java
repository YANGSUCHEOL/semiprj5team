package com.kh.semiPrj.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semiPrj.member.MemberVo;
import com.kh.semiPrj.qna.service.QnaService;
import com.kh.semiPrj.qna.vo.QuestionVo;



@WebServlet(urlPatterns = "/qna/write")
public class QnaWriteController extends HttpServlet{
	
	private final QnaService qs = new QnaService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//로그인 안 되어있으면 로그인부터
		if(req.getSession().getAttribute("loginMember") == null) {
			req.setAttribute("msg", "로그인 후 이용해주세요");
			req.getRequestDispatcher("views/common/errorPage.jsp").forward(req, resp);
			
		}else {
			req.getRequestDispatcher("/WEB-INF/views/qna/write/customer.jsp").forward(req, resp);
		}
		
		//(사업자회원이면)ㄴ
		//if() {
		//req.getRequestDispatcher("/views/qna/write/business.jsp").forward(req, resp);
		//}else if() {
		//(일반회원이면)
			
		// }
		
	}//doGet
	
	//작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//session
		HttpSession s = req.getSession();
		
		//로그인멤버 가져오기
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		System.out.println("write 로그인멤버 가져옴?");
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String title = req.getParameter("title");
		//String Date = req.getParameter("Date");
		String content = req.getParameter("content");
		
		
		//뭉치기
		QuestionVo vo = new QuestionVo();
		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setmNo(loginMember.getNo());
		
		//vo.setaNo("aNo"); //aNo 0이면 답변예정 번호 있으면 답변완료
	
		//디비
		int result = qs.write(vo);
		
		
		if(result == 1) {
			//성공
			s.setAttribute("alertMsg", "게시글 작성 성공!");
			//resp.sendRedirect("/semiPrj/WEB-INF/views/qna/list/customer.jsp");
			resp.sendRedirect("/semiPrj/qna/list");
		}else {
			System.out.println("게시글 작성 실패");
		}
		
	}
	
	

}
