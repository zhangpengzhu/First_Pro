package testnumber;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/a/number")
@SuppressWarnings("serial")
public class Testnumber extends HttpServlet {
	
	int i  = 1;
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");
			
//			String x=null;
//			Cookie cookie = new Cookie("number", x);
//			resp.addCookie(cookie);
//			
//			int n=0;
//			if(req!=null) {
//				n++;
//			}
//			resp.getWriter().write("访问量"+n);
			//上次登录时间
			//商品浏览记录
			ServletContext context = this.getServletContext();
			
			while(req != null) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				context.setAttribute("total", ""+i++);
				
				break;
			}
			System.out.println("访问总量:"+context.getAttribute("total"));
			
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
			
		}
}
