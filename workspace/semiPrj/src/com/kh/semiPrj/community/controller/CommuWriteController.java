package com.kh.semiPrj.community.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.semi.Prj.member.MemberVo;
import com.kh.semiPrj.community.service.CommuService;
import com.kh.semiPrj.community.vo.CategoryVo;
import com.kh.semiPrj.community.vo.CommuVo;

@WebServlet(urlPatterns = "/community/write")
public class CommuWriteController extends HttpServlet {

	private final CommuService cs = new CommuService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getSession().getAttribute("loginMember") == null) {
			
			req.setAttribute("msg", "로그인 후 이용해 주세요");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);

		}
		
		
		//디비 다녀오기
		List<CategoryVo> cateList = cs.selectCategoryList();
		
		req.setAttribute("cateList", cateList);
		
		req.getRequestDispatcher("/WEB-INF/views/communityBoard/write.jsp").forward(req, resp);
	
	}//get
	
	//게시글 작성
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//세션 불러오기
		HttpSession s = req.getSession();
		MemberVo loginMember = (MemberVo)s.getAttribute("loginMember");
		
		//인코딩
		req.setCharacterEncoding("UTF-8");
		
		//데이터 꺼내기
		String category = req.getParameter("category");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		//데이터 뭉치기
		CommuVo vo = new CommuVo();
		vo.setCategory(category);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setWriter(loginMember.getNo());
		
		//디비 다녀오기
		int result = cs.write(vo);
		
		//화면 선택
		if(result ==1) {
			//작성 성공 -> 알림이랑 리스트로
			s.setAttribute("alertMsg", "게시글 작성 성공!");
			resp.sendRedirect("/semiPrj/community/list?pno=1");
		} else {
			//작성 실패 -> 에러 페이지로
			req.setAttribute("msg", "게시글 작성 실패...");
			req.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(req, resp);
		}
	
	}//post
	
	
}
