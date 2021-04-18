package trythis;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// This Controller are use to get data from view and send to DAO to
		// execue quiers

		String[] color = request.getParameterValues("colors");
		String q2answer = String.join(",", color);

		String par1 = request.getParameter("name");
		String par2 = request.getParameter("player");
		String par3 = q2answer;

		DAO obje = new DAO();
		// giving parameter to insert method of DAO
		String insertflage = obje.insert(par1, par2, par3);
		System.out.println(insertflage);

		// creating Arraylist variable
		ArrayList all_details;
		// calling getAllDetails method from DAO
		all_details = obje.getAllDetails();
		// printing all details to console
		System.out.println("number of recods in the array List: " + all_details.size());

		request.setAttribute("details", all_details);
		// sending the all data to view page
		RequestDispatcher dispatch23 = request.getRequestDispatcher("view.jsp");
		dispatch23.forward(request, response);

	}
}
