package testnumber;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.Time;
import org.omg.PortableServer.ServantLocatorPackage.CookieHolder;
@WebServlet("/b/fangwen3")
@SuppressWarnings("serial")
public class TestCookieFangwen3 extends HttpServlet {
		@SuppressWarnings("deprecation")
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			Date time = new Date();
				SimpleDateFormat format = new SimpleDateFormat("h:m:s");
				System.out.println(format.format(time));
				Cookie cookie = new Cookie("time", format.format(time));
				cookie.setMaxAge(60*60);
				resp.addCookie(cookie);
				Cookie[] cookies = req.getCookies();
				for (Cookie cookie2 : cookies) {
					String name = cookie2.getName();
					if("name".equals(name)) {
						System.out.println(cookie2.getValue());
					}
				}
				
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		}
}
