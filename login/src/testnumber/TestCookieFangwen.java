package testnumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/b/fangwen")
@SuppressWarnings("serial")
public class TestCookieFangwen extends HttpServlet {
		@SuppressWarnings("deprecation")
		
		@Override
	
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			while(req!=null) {
				int m=1;
				for(int i=m;i<10;i++) {
					Date date = new Date();
					String nowtime = date.toLocaleString();
				//	System.out.println(nowtime);
					ArrayList<Object> arrayList = new ArrayList<>();
					arrayList.add(nowtime);
					if(i==0) {
						System.out.println("你是第一次登陆，欢迎光临");
						break;
					}
					else {
						System.out.println("上次的登录时间为："+arrayList.get(i-1));
						System.out.println(i);
						break;
					}
					
				}
				m++;
				break;
			}
			
			System.out.println("aaa");
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		}
}
