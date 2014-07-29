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
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@WebServlet("/GetUsers")
public class GetUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String output;
	private JSONObject jObject;	

	public GetUsers() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			
			 URL url = new
			 URL("https://appserver.test.cloud.wso2.com/t/pirinthan14/webapps/trainingcalservice-1.0.0/rest/tc/user");
			/*URL url = new URL(
					"http://localhost:8080/TrainingCalendar/rest/tc/user");*/
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept-Type", "application/json");

			System.out.println("in side get user servlet\n");
		

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));		

			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				
				jObject = new JSONObject(output);
				
			}
			conn.disconnect();
		
			JSONArray am = jObject.getJSONArray("user");
			request.setAttribute("msg", am);

			
			
			RequestDispatcher rd = request.getRequestDispatcher("userDetails.jsp");
			rd.forward(request, response);
			
			System.out.println("After JSP display");
			
		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}
}
