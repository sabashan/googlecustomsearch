package org.training.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddUser() {
		super();
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		 String firstname=request.getParameter("firstname"); 
		 String lastname=request.getParameter("lastname"); 
		 String group=request.getParameter("group");
		 String email=request.getParameter("email"); 
		 String password=request.getParameter("pwd1"); 	
		 
		/*  
		 PrintWriter out=response.getWriter(); 
		 out.println(firstname);
		 out.println(lastname);
		 out.println(group);
		 out.println(email);
		 out.println(password);	*/

		try {

			 URL url = new
			 URL("https://appserver.test.cloud.wso2.com/t/pirinthan14/webapps/trainingcalservice-1.0.0/rest/tc/user");
			/*URL url = new URL(
					"http://localhost:8080/TrainingCalendar/rest/tc/user");*/
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/xml");
		
			System.out.println("===========XML==============>>>>>>>>>>>");
			String input = "<user>"
					+ "<firstName>"+firstname+"</firstName>"
							+ "<lastName>"+lastname+"</lastName>"
							+ "<group>"+group+"</group>"
							+ "<email>"+email+"</email>"
							+ "<password>"+password+"</password>"
							+ "</user>";

			 OutputStream os = conn.getOutputStream();
			 os.write(input.getBytes());
			 os.flush();		

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
			System.out.println("===========()()(==============>>>>>>>>>>>");
			System.out.println(conn.getInputStream());
			System.out.println("=========================>>>>>>>>>>>");

			conn.disconnect();
			response.sendRedirect("index.html");

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}
	}

	
	
}
