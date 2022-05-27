package com.omi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.omi.dto.UserDto;

/**
 * Servlet implementation class LogoutAction
 */
@WebServlet({ "/LogoutAction", "/logoutAction" })
public class LogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect("/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDto userDto = new UserDto();
		
		userDto.setId(request.getParameter("id"));
		userDto.setPw(request.getParameter("pw"));
		
		
		
		// HTTP 요청 -> Java Servlet -> jsp페이지
		ServletContext app = this.getServletContext();
		RequestDispatcher dispatcher =  app.getRequestDispatcher("/login.jsp");
		
		if(!"test".equals(userDto.getId())) {
			request.setAttribute("errMsg", "id/pw를 확인해주세요.");
			
			// forward 방식은 request영역과 response영역을 공유!
			dispatcher.forward(request, response);
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", userDto);
		response.sendRedirect("/loginOk.jsp");
		
	}

}
