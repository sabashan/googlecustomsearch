package org.training.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateUser
 */
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateUser() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
		String firstname=request.getParameter("firstname"); 
		 String lastname=request.getParameter("lastname"); 
		 String group=request.getParameter("group");
		 String email=request.getParameter("email"); 		 
		  
		/* PrintWriter out=response.getWriter(); 
		 out.println(firstname);
		 out.println(lastname);
		 out.println(group);
		 out.println(email);		
*/
		try {

			URL url = new
			URL("https://appserver.test.cloud.wso2.com/t/pirinthan14/webapps/trainingcalservice-1.0.0/rest/tc/user");
			/*URL url = new URL(
					"http://localhost:8080/TrainingCalendar/rest/tc/user");*/
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-Type", "application/xml");
			// conn.set

			
			System.out.println("===========XML==============>>>>>>>>>>>");
			String input = "<user>"
					+ "<firstName>"+firstname+"</firstName>"
							+ "<lastName>"+lastname+"</lastName>"
							+ "<group>"+group+"</group>"
							+ "<email>"+email+"</email>"							
							+ "</user>";

			 OutputStream os = conn.getOutputStream();
			 os.write(input.getBytes());
			 os.flush();		

			 //response.sendRedirect("GetUsers");
			 System.out.println("\nUpdate user ok==================>");
			 
			 RequestDispatcher rd = request.getRequestDispatcher("GetUsers");
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
