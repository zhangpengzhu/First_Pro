package testnumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
@WebServlet("/b/fangwen2")
@SuppressWarnings("serial")
public class TestCookieFangwen2 extends HttpServlet {
	int i=1;
		@SuppressWarnings("deprecation")
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ServletContext context = req.getServletContext();
			while(req!=null) {
					context.setAttribute("name", ""+i++);
			
					break;
				}
			Date date = new Date();
			String time = date.toLocaleString();
			ArrayList<Object> list = new ArrayList<>();
			list.add(time);
			for (Object object : list) {
				System.out.println(object);
			}
			System.out.println("访问量："+context.getAttribute("name"));
		//	System.out.println("欢迎回来，上次登录时间为："+list.get(i-2));
			if(i==2) {
				System.out.println("第一次登陆");
			}else {
			//	System.out.println("欢迎回来，上次登录时间为："+list.get(i-1));
			}
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		}
}
