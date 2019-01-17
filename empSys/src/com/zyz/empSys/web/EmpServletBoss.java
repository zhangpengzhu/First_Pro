package com.zyz.empSys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.service.IEmpSysService;
import com.zyz.empSys.service.impl.EmpSysService;

import jdk.nashorn.internal.runtime.Context;

/**
 * Emp总的Servlet
 */
@WebServlet("/EmpServletBoss")
public class EmpServletBoss extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IEmpSysService service = new EmpSysService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmpServletBoss() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("empid"));
		// 获取全局参数配置
		ServletContext context = request.getServletContext();
		String encoding = context.getInitParameter("encording");
		// 设置请求编码格式
		request.setCharacterEncoding(encoding);
		// 设置响应编码格式
		response.setContentType("text/html;charset=" + encoding);

		if (id == 1) {
			// 登录事件
			login(request, response);
		} else if (id == 2) {
			// 查看员工表
			findemp(request, response);
		} else if (id == 3) {
			// 通过ID来查找数据
			findempbyid(request, response);
		} else if (id == 4) {
			// 数据回显，并执行修改操作
			updateemp(request, response);
		} else if (id == 5) {
			// 根据id删除指定行
			deleteempbyid(request, response);
		} else if (id == 6) {
			// 员工恢复列表
			deleteempall(request, response);
		} else if (id == 7) {
			// 恢复数据
			returndelete(request, response);
		} else if (id == 8) {
			// 删除emp2表中的数据
			deleteEmp2(request, response);
		} else if (id == 9) {
			// 再次查询员工恢复列表
			findemp2all(request, response);
		} else if (id == 10) {
			// 注册
			register(request, response);
		}
		else if(id==11) {
			//安全退出
			anquanout(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
/**
 * 安全退出
 * @throws IOException 
 */
	public void anquanout(HttpServletRequest request,HttpServletResponse response) throws IOException {
				
			HttpSession session = request.getSession();
		//Emp emp =(Emp) session.getAttribute("emp");
	//	session.removeAttribute("emp");
			//销毁session
			session.invalidate();
			response.sendRedirect(request.getContextPath()+"/index.jsp");
	}
	/**
	 * 注册
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String heridate = request.getParameter("heridate");
		String salary = request.getParameter("salary");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		/*
		 * System.out.println(id); System.out.println(name);
		 * System.out.println(password); System.out.println(gender);
		 */
		Emp emp = new Emp(Integer.parseInt(id), name, password, gender, Integer.parseInt(age),
				java.sql.Date.valueOf(heridate), Double.parseDouble(salary), phone, email);
		service.insertregiter(emp);
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		;

	}

	/**
	 * 查询emp2中的数据
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void findemp2all(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Emp> emp = service.findEmpEditAll2();
		// 把emp存入域中
		request.setAttribute("emp", emp);
		// 请求转发
		request.getRequestDispatcher("/empList2.jsp").forward(request, response);
	}

	/**
	 * 删除恢复列表的数据
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void deleteEmp2(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		service.deleteemp2byid(Integer.parseInt(id));
		request.getRequestDispatcher("/EmpServletBoss?empid=9").forward(request, response);
	}

	/**
	 * 恢复删除的数据
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void returndelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		service.returnEditbyid(Integer.parseInt(id));
		request.getRequestDispatcher("/EmpServletBoss?empid=2").forward(request, response);
	}

	/**
	 * 查询所有被删除了数据
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void deleteempall(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 调用IEmpSysService中的方法
		List<Emp> emp = service.findEmpEditAll();
		// 把emp存入域中
		request.setAttribute("emp", emp);
		// 请求转发
		request.getRequestDispatcher("/empList2.jsp").forward(request, response);
	}

	/**
	 * @throws IOException
	 * @throws ServletException 通过绑定id来删除指定列
	 */
	public void deleteempbyid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Emp emp = service.deleteEmpbyid(Integer.parseInt(id));
		System.out.println(emp);
		request.getRequestDispatcher("/EmpServletBoss?empid=2").forward(request, response);
	}

	/**
	 * 数据回显，并修改
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void updateemp(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String heridate = request.getParameter("heridate");
		String salary = request.getParameter("salary");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String id = request.getParameter("id");
		Emp emp = new Emp(Integer.parseInt(id), name, password, gender, Integer.parseInt(age),
				java.sql.Date.valueOf(heridate), Double.parseDouble(salary), phone, email);
		IEmpSysService emp1 = new EmpSysService();
		// 执行更新方法
		emp1.updateEmpp(emp);
		request.getRequestDispatcher("/EmpServletBoss?empid=2").forward(request, response);
	}

	/**
	 * 通过ID查询数据
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void findempbyid(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		Emp emp = service.findempByid(Integer.parseInt(id));
		System.out.println(emp);
		request.setAttribute("emp", emp);
		request.getRequestDispatcher("/updateEmp.jsp").forward(request, response);
	}

	/**
	 * 员工列表查询
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void findemp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取session
		HttpSession session = request.getSession();
		Emp emp1 = (Emp)session.getAttribute("emp");
		if(emp1==null) {
			response.sendRedirect(request.getContextPath()+"/index.jsp");
			return;
		}
		// 调用IEmpSysService中的方法
		List<Emp> emp = service.findEmpAll();
		// 把emp存入域中
		request.setAttribute("emp", emp);
		// 请求转发
		request.getRequestDispatcher("/empList.jsp").forward(request, response);
	}

	/**
	 * 登录
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取请求参数
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		// 调用service中的方法进行登录
		IEmpSysService service = new EmpSysService();
		Emp emp = service.findEmpByNameAndPassworld(name, password);
		String validate = request.getParameter("validate");
		String val_in_session=(String)request.getSession().getAttribute("validate");
		if(!val_in_session.equalsIgnoreCase(validate)) {
			request.setAttribute("val_msg", "验证码输入错误，请重新输入");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		if (emp != null) {
			// 把登录的用户存入到session中，表示开启了一次回话
			HttpSession session = request.getSession();
			session.setAttribute("emp", emp);

			// 格式化时间日期
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			String lastTime = sdf.format(new Date());

			// 获取请求中的cookie
			Cookie[] cookies = request.getCookies();

			if (cookies != null) {

				Cookie c = null;
				for (Cookie cookie : cookies) {
					String cookieName = cookie.getName();

					if ("lastTime".equals(cookieName)) {
						c = cookie;
						break;
					}
				}

				if (c != null) {
					String value = c.getValue();
					request.setAttribute("lastTime", value);
					c.setValue(lastTime);
					response.addCookie(c);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				} else {
					c = new Cookie("lastTime", lastTime);
					// 设置cookie
					c.setPath("/");
					c.setMaxAge(60 * 60 * 24 * 365);

					request.setAttribute("lastTime", lastTime);

					response.addCookie(c);
					request.getRequestDispatcher("/index.jsp").forward(request, response);
				}
			} else {
				Cookie c = new Cookie("lastTime", lastTime);
				// 设置cookie
				c.setPath("/");
				c.setMaxAge(60 * 60 * 24 * 365);

				request.setAttribute("lastTime", lastTime);

				response.addCookie(c);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}

			response.getWriter().write("登录成功，3秒后跳转到主界面");
			response.setHeader("refresh", "3;url=" + request.getContextPath() + "/index.jsp");
			// response.sendRedirect(context.getContextPath()+"/index.html");
			return;
		} else {
			// 重定向，回到登录界面，并提示账号或密码有误
			request.setAttribute("error_msg", "账号或密码有误");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
	}
}
