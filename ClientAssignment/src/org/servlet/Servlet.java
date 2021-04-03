package org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ejb.Customer;
import org.ejb.Workout;
import org.facade.FacadeLocal;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	FacadeLocal facade;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html><html><head>");
		out.println("<title>Assignment: Backend </title>");
		out.println("<meta charset=\"ISO-8859-1\">");
		out.println("</head><body>");

		out.println("<h2>Customers</h2>");
		

		// Test FindAll Customers
		out.println("<h3>***FindAll Customers***</h3>");
		List<Customer> allCustomers = facade.findAllCustomers();
		for (Customer c : allCustomers) {
			out.println("<h4>Hittade: " + c.getClass().getSimpleName());
			out.println(" Id: " + c.getPnrId());
			out.println(" -" + c.getName());
			out.println(" -" + c.getAddress());
			out.println(" -" + c.getPhoneNo() + "</h4>");
		}
		
		//Test of relationship (WorkoutBooking table in database)
		out.println("<br>" + "***Show a Customers Bookings***");
		Customer customer = facade.findCustomerByPnr("9012124444");
		if (customer != null) {
			out.println("<br>");
			out.println("For Customer: " + customer.getName());
			out.println("<br>");
			for (Workout tmp : customer.getBookings()) {
				out.println(tmp.getCode());
				out.println("<br>");
			}
		}

		out.println("<h2>Workouts</h2>");
		
		//Test FindAll Workouts
		out.println("<h3>***FindAll Workouts***</h3>");
		List<Workout> allWorkout = facade.findAllWorkout();
		for (Workout w : allWorkout) {
			out.println("<h4>Hittade: " + w.getClass().getSimpleName());
			out.println(" Id: " + w.getCode());
			out.println(" -" + w.getLocation());
			out.println(" -" + w.getDate() + "</h4>");
		}
		
		
		//Test of relationship (WorkoutBooking table in database)
		out.println("<br>" + "***Show a Workouts Particiants***");
		Workout workout = facade.findWorkoutByCode("A05");
		if (workout != null) {
			out.println("<br>");
			out.println("For workout: " + workout.getCode());
			out.println("<br>");
			for (Customer tmp : workout.getParticiapants()) {
				out.println(tmp.getName());
				out.println("<br>");
			}
		}

		out.println("</body></html>");
		out.close();
	}

}
