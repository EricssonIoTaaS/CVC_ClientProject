package com.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;



/**
 * Servlet implementation class ClientServlet
 */
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = Client.create();
		WebResource webResource = client.resource("http://129.192.210.50:38080/rest/screenapi/getcars?enterpriseid=fleet_manager1");
		ClientResponse respGetCars = webResource.accept("application/json").get(ClientResponse.class);
		if (respGetCars.getStatus() == 200) {
			String output = respGetCars.getEntity(String.class);
			System.out.println(output);
		}
		
		webResource = client.resource("http://129.192.210.50:38080/rest/screenapi/getmessages?enterpriseid=fleet_manager1&id=SN123ABC1");
		ClientResponse respGetMessages = webResource.accept("application/json").get(ClientResponse.class);
		if (respGetMessages.getStatus() == 200) {
			String output = respGetMessages.getEntity(String.class);
			System.out.println(output);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client client = Client.create();
		WebResource webResource = client.resource("http://129.192.210.50:38080/rest/screenapi/sendmessage?enterpriseid=fleet_manager1&id=SN123ABC1&msgid=12&text=hello");
		ClientResponse respSendMessage = webResource.accept("application/json").get(ClientResponse.class);
		if (respSendMessage.getStatus() == 200) {
			String output = respSendMessage.getEntity(String.class);
			System.out.println(output);
		}
	}
}
