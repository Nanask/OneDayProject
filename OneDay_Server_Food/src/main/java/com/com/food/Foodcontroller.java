package com.com.food;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.model.FoodDTO;
import com.com.model.MyFoodDTO;
import com.com.service.FoodService;
import com.com.service.MyFoodService;
import com.com.service.impl.FoodServiceImpl;
import com.com.service.impl.MyFoodServiceImpl;

@WebServlet("/food/*")
public class Foodcontroller extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4321331129212825174L;
	protected FoodService fdService;
	protected MyFoodService mfService;

	public Foodcontroller() {
		fdService = new FoodServiceImpl();
		mfService = new MyFoodServiceImpl();

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		if (subPath.equals("/list")) {

			String strDate = req.getParameter("date");

			if (strDate == null || strDate.equals("")) {
				out.println("해당되는 날짜가 없습니다. 다시 입력해주세요");
				out.close();

			} else {
				List<MyFoodDTO> mfList = fdService.findByDate(strDate);
				ServletContext app = this.getServletContext();

				app.setAttribute("MYFOOD", mfList);

				RequestDispatcher disp = app.getRequestDispatcher("/WEB-INF/views/list.jsp");
				disp.forward(req, resp);

			}
		} else if (subPath.equals("/insert/search")) {

			String fd_fname = req.getParameter("fd_fname");
			if (fd_fname == null || fd_fname.equals("")) {
				out.println("식품 이름을 반드시 입력해야 합니다");
				out.close();
			} else {
				List<FoodDTO> fList = mfService.findByName(fd_fname);

				System.out.println("=".repeat(50));
				for (FoodDTO f : fList) {
					System.out.println(f.toString());
				}
				System.out.println("=".repeat(50));

				req.setAttribute("FOODLIST", fList);

				RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/views/search.jsp");
				disp.forward(req, resp);

			}
		} else if (subPath.equals("/insert")) {

			req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);

		}

	}

}
