package com.com.food;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.model.MyFoodDTO;
import com.com.service.FoodService;
import com.com.service.impl.FoodServiceImpl;

@WebServlet("/")
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 598031852800474880L;
	protected FoodService fService;

	public HomeController() {
		fService = new FoodServiceImpl();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	List<MyFoodDTO> mfList = fService.selectAll();
	
	req.setAttribute("MYFOOD", mfList );
	req.getRequestDispatcher("/WEB-INF/views/home.jsp")
	.forward(req, resp);
		
	}

}
