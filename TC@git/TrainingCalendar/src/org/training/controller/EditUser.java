package org.training.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.jsonParser.JSONArray;
import org.training.jsonParser.JSONObject;

@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JSONObject jObject;
	private String output;

	public EditUser() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("key");

		try {

			 URL url = new
			 URL("https://appserver.test.cloud.wso2.com/t/pirinthan14/webapps/trainingcalservice-1.0.0/rest/tc/user/searche/"+email);
			/*URL url = new URL(
					"http://localhost:8080/TrainingCalendar/rest/tc/user/searche/"
							+ email);*/
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept-Type", "application/json");

			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));			
			
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {				
				jObject = new JSONObject(output);
			}
			conn.disconnect();
			System.out.println(jObject);		
			request.setAttribute("msg", jObject);
			RequestDispatcher rd = request
					.getRequestDispatcher("editUser.jsp");
			rd.forward(request, response);

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
