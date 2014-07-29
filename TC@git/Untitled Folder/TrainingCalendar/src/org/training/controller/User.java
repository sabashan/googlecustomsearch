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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.training.jsonParser.JSONArray;
import org.training.jsonParser.JSONObject;

@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String output;
	private JSONObject jObject;

	public User() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String userName = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("user"))
					userName = cookie.getValue();
			}
		}

		try {

			 URL url = new
			 URL("https://appserver.test.cloud.wso2.com/t/pirinthan14/webapps/trainingcalservice-1.0.0/rest/tc/event/searche/"+userName);
			/*URL url = new URL(
					"http://localhost:8080/TrainingCalendar/rest/tc/event/searche/"
							+ userName);*/
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
			/*
			 * System.out.print(jObject.getJSONArray("event").getJSONObject(0)
			 * .getString("firstName"));
			 */

			// am=jObject.getJSONArray("user").getJSONObject(0).getString("firstName");
			JSONArray am = jObject.getJSONArray("event");
			request.setAttribute("msg", am);

			

			RequestDispatcher rd = request.getRequestDispatcher("userHome.jsp");
			rd.forward(request, response);
		
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

}
