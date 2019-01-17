package com.zyz.empSys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zyz.empSys.domain.Emp;
import com.zyz.empSys.service.IEmpSysService;
import com.zyz.empSys.service.impl.EmpSysService;

/**
 * 员工列表的Servlet
 */
@WebServlet("/EmpServlet")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取全局参数
		ServletContext context = request.getServletContext();
		String encording = context.getInitParameter("encording");
		//设置全局编码格式
		request.setCharacterEncoding(encording);
	response.setContentType("text/html;charset="+encording);
		IEmpSysService service=new EmpSysService();
		//调用IEmpSysService中的方法
		List<Emp> emp=	service.findEmpAll();
		//把emp存入域中
		request.setAttribute("emp", emp);
		//请求转发
		request.getRequestDispatcher("/empList.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
