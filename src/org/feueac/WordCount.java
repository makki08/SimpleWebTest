package org.feueac;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class WordCount
 */
@WebServlet(description = "Get list of words", urlPatterns = { "/WordCountPath" })
public class WordCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String input = request.getParameter("input");
		String[] words = input.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("[ ]+");
		//PrintWriter out = response.getWriter();

		for(String s : words) {
			System.out.println(s);
		}
	}

}
