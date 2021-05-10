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

import com.com.model.MyFoodDTO;
import com.com.service.FoodService;
import com.com.service.impl.FoodServiceImpl;



@WebServlet("/food/*")
public class Foodcontroller extends HttpServlet{
	
	protected FoodService fdService;
	
	public Foodcontroller() {
		fdService = new FoodServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String subPath = req.getPathInfo();
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		if(subPath.equals("/list")) {
			
			String strDate = req.getParameter("date");
			
			if(strDate == null || strDate.equals("")) {
				out.println("해당되는 날짜가 없습니다. 다시 입력해주세요");
				out.close();
					
			}else {
				List<MyFoodDTO> mfList = fdService.findByDate(strDate);
				MyFoodDTO mfDTO = new MyFoodDTO();
				ServletContext app = this.getServletContext();
				
				app.setAttribute("MYFOOD", mfDTO);
				
				RequestDispatcher disp = app.getRequestDispatcher(
						"/WEB-INF/views/list.jsp");
				disp.forward(req, resp);
						
				
			}
					
		}
		
	}
	
	

}
