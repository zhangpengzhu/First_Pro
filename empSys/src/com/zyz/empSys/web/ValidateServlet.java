package com.zyz.empSys.web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码的Servlet
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidateServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 第一步: 首先产生字符串区
				String str = "abcdefghijkmnpqrstuvwxyABCDEFGHJKLMNPQRSTUVWXY23456789";

				// 第二步: 随机获取四个字符
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < 4; i++) {
					sb.append(str.charAt(getRandomNum(str.length())));
				}

				// 第三步: 把获取到的四个字符存入到session中
				request.getSession().setAttribute("validate", sb.toString());

				// 第四步: 在内存中创建图片对象
				int width = 120;
				int height = 40;
				int imgType = BufferedImage.TYPE_INT_RGB;
				BufferedImage img = new BufferedImage(width, height, imgType);

				// 第五步: 在图片中获取到"画笔"对象
				Graphics g = img.getGraphics();

				g.setFont(new Font("楷体", Font.BOLD, 24));

				for (int i = 0; i < 5; i++) {
					g.setColor(new Color(getRandomNum(256), getRandomNum(256), getRandomNum(256)));
					g.drawLine(getRandomNum(10), getRandomNum(40) + -5, getRandomNum(70), getRandomNum(40) + -5);
				}

				g.drawString(sb.toString(), 26, 20);

				// 设置响应头通知浏览器以图片的形式打开
				response.setContentType("image/jpeg");// 等同于response.setHeader("Content-Type", "image/jpeg");
				// 设置响应头控制浏览器不要缓存
				response.setDateHeader("expries", -1);
				response.setHeader("Cache-Control", "no-cache");
				response.setHeader("Pragma", "no-cache");

				// 第六步:将图片写给浏览器
				ImageIO.write(img, "jpg", response.getOutputStream());
	}
	/**
	 * 产生随机数的方法
	 * 
	 * @param r
	 * @return
	 */
	private int getRandomNum(int r) {
		Random random = new Random();
		return random.nextInt(r);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
