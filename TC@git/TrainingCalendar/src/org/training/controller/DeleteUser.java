package org.training.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.jsonParser.JSONArray;
import org.training.jsonParser.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String output;
	JSONObject jObject;

	public DeleteUser() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("key");

		try {
			/*URL url = new URL(
					"https://appserver.test.cloud.wso2.com/t/pirinthan14/webapps/trainingcalservice-1.0.0/rest/tc/user/"
							+ email);*/
			
			 URL url = new URL(
			 "http://localhost:8080/TrainingCalendar/rest/tc/user/"+email);
			 
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Accept-Type", "application/json");

			System.out.println("=====================.\n");
			// System.out.println(conn.getContent().);

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
			conn.disconnect();
			// response.sendRedirect("userDetails.jsp");

			RequestDispatcher rd = request.getRequestDispatcher("GetUsers");
			rd.forward(request, response);
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
