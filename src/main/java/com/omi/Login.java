package com.omi;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class Login
 */
@WebServlet({ "/Login", "/login" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserDto user = (UserDto)session.getAttribute("user");
		
		if(user != null) {
			response.sendRedirect("/loginOk.jsp");
		} else {
			response.sendRedirect("/login.jsp");			
		}
		
		
//		// TODO Auto-generated method stub
//		response.setContentType("text/html");
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		
//		PrintWriter out = response.getWriter();
//		out.println("<html><head></head><body>");
//		out.println("환영합니다.<br>");
//		out.println("id : <input type='text' name='id'><br>");
//		out.println("pw : <input type='text' name='pw'><br>");
//		out.println("<button type=\"submit\">로그인</button>");
//		out.println("<body></html>");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDto userDto = new UserDto();
		
		userDto.setId(request.getParameter("id"));
		userDto.setPw(request.getParameter("pw"));
		
		ServletContext app = this.getServletContext();
		RequestDispatcher dispatcher =  app.getRequestDispatcher("/login.jsp");
		
		if(!"test".equals(userDto.getId())) {
			request.setAttribute("errMsg", "id/pw를 확인해주세요.");
			dispatcher.forward(request, response);
		}
		HttpSession session = request.getSession();
		session.setAttribute("user", userDto);
		response.sendRedirect("/loginOk.jsp");
	}

}
