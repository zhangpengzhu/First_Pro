package com.zyz.empSys.web;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 防止表单重复提交的Servlet
 */
@WebServlet("/SubmitServlet")
public class SubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String token_in_session=(String)session.getAttribute("TOKEN_IN_SESSION");
		String hidden = request.getParameter("hidden");
		System.out.println(hidden);
		System.out.println(token_in_session);
		if(!hidden.equals(token_in_session)||hidden==null) {
			System.out.println("操作中，请求失败");
			return;
		}
		String text = request.getParameter("text");
			System.out.println(text);
			//执行完一次之后，用覆盖的方式改变值
			request.getSession().setAttribute("TOKEN_IN_SESSION", UUID.randomUUID().toString());
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
