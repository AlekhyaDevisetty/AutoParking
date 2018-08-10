package com.epam.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.autoparking.main.Utilities;
import com.epam.autoparking.service.ParkingService;
import com.epam.autoparking.service.Validate;
import com.epam.autoparking.utilities.ParkingUtility;
import com.epam.filedbo.FileSquile;

@WebServlet(urlPatterns = "/MainServlet")
public class MainServlet extends HttpServlet {
	int slot = 0;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<String, Integer> vehicles = new HashMap<String, Integer>();
		Queue<Integer> slotQueue = new LinkedList<Integer>();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String requirement = request.getParameter("requirement");
		String vehicleNumber = request.getParameter("vehicleNumber");
		FileSquile fileObj = new FileSquile();
		int totalSlots = fileObj.checkFileExistance();
		if (totalSlots == -1) {
			totalSlots = 10;
		} else {
			Utilities utilityObj = new Utilities();
			utilityObj.hashmapUtility(vehicles);
			int slotValue = utilityObj.queueUtility(vehicles, slotQueue);
			slot = slotValue;
		}
		Validate verify = new Validate();
		boolean valid = verify.validateNumber(vehicleNumber);
		if (valid) {
			if (requirement.equals("parking")) {
				if (slot >= totalSlots && slotQueue.isEmpty()) {
					System.out.printf("\nParking slot is full");
				}
				if (slotQueue.isEmpty()) {
					slot++;
				}
				ParkingUtility util = new ParkingUtility();
				
				int allotedSlot = util.parkingUtil(vehicles, slotQueue, vehicleNumber, slot);
				out.print(allotedSlot);
			} else if (requirement.equals("unparking")) {
				out.print("unparking");
			}

		}
	}

}
