package org.training.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateEvent")
public class UpdateEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public UpdateEvent() {
        super();
      
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String id = request.getParameter("key");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String topic = request.getParameter("topic");
		String group = request.getParameter("group");
		String location = request.getParameter("location");
		
		
		 PrintWriter out=response.getWriter(); 
		 out.println(date);
		 out.println(time);
		 out.println(topic);
		 out.println(location);
		 out.println(id);
		
	try {

			 URL url = new
			 URL("https://appserver.test.cloud.wso2.com/t/pirinthan14/webapps/trainingcalservice-1.0.0/rest/tc/event");
		/*	URL url = new URL(
					"http://localhost:8080/TrainingCalendar/rest/tc/event");*/
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/xml");
			
			System.out.println("===========XML==============>>>>>>>>>>>");
			String input = "<event>" + "<date>" + date + "</date>" + "<time>"
					+ time + "</time>" + "<topic>" + topic + "</topic>"
					+ "<group>" + group + "</group>" + "<location>" + location
					+ "</location>" +"<id>" + id
					+ "</id>"+ "</event>";


			 OutputStream os = conn.getOutputStream();
			 os.write(input.getBytes());
			 os.flush();		

			 //response.sendRedirect("GetUsers");
			 RequestDispatcher rd = request.getRequestDispatcher("GetEvent");
			rd.forward(request, response);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				
			}			
			conn.disconnect();
			

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	
	}

}
