package testlogin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testr")
@SuppressWarnings("serial")
public class TestLogin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = req.getCookies();
	/*	if (cookies != null) {
			for (Cookie cookie : cookies) {
				String username = cookie.getName();
				if ("username".equals(username)) {
					username = cookie.getValue();
					System.out.println(username);
				}
			}
			
		}*/
		String username = req.getParameter("username");
		System.out.println(username);
		resp.getWriter().write("sdafsafsa");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
