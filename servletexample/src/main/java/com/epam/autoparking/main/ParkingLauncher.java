package com.epam.autoparking.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.epam.filedbo.FileOperations;
import com.epam.autoparking.service.Validate;
import com.epam.autoparking.utilities.ParkingUtility;
import com.epam.autoparking.utilities.UnparkingUtility;

/**
 * ParkingLauncher displays all the operations to be performed.
 *
 * @author Alekhya_Devisetty
 *
 */
public class ParkingLauncher {
	public static void main(String[] args) throws IOException {

		Scanner readObj = new Scanner(System.in);
		FileOperations foperations = new FileOperations();
		Utilities utility = new Utilities();

		String userName = args[0];
		String password = args[1];
		Integer numberOfSlots = 0;

		if (userName.equals("alekhya") && password.equals("3341")) {

			HashMap<String, Integer> vehicles = new HashMap<String, Integer>();
			Queue<Integer> slotQueue = new LinkedList<Integer>();

		if (Integer.parseInt(args[2]) == 1) {
				numberOfSlots = Integer.parseInt(args[3]);
				foperations.writeToSlotFile(numberOfSlots);
			} else if (Integer.parseInt(args[2]) == 0) {
				BufferedReader br
                              = new BufferedReader(
                            		  new FileReader("SlotFile.csv"));
				String text = br.readLine();
				numberOfSlots = Integer.parseInt(text);

				br.close();
			}

			
			int slot = 0;
			if (Integer.parseInt(args[2]) == 0) {
				utility.hashmapUtility(vehicles);
			}
			///slot = utility.queueUtility(vehicles, slotQueue, slot);
			boolean flag = true;
			while (flag) {
				System.out.printf("\n 1. Parking"
			                    + "\n 2. UnParking\n "
			                    + "3. Exit");
				int choice = readObj.nextInt();
				switch (choice) {

				case 1:
					int slotNumber = 0;
                    System.out.printf("\nenter vehicles number: ");
					String vehicleNumber = readObj.next();
                    if (slot >= numberOfSlots && slotQueue.isEmpty()) {
                        System.out.printf("\nParking slot is full");
						flag = false;
						break;
					}
					Validate validate = new Validate();
                    boolean validationFlag
                                   = validate.validateNumber(vehicleNumber);
					if (validationFlag) {
					if (slotQueue.isEmpty()) {
						slot++;
					}
                     ParkingUtility pu = new ParkingUtility();
                     slotNumber = pu.parkingUtil(vehicles, slotQueue
                    		                     , vehicleNumber, slot);
					}
					if (slotNumber == -1) {
						continue;
					}
					else {
                       System.out.printf("\nYour slotNumber: " + slotNumber);
					}

					break;

				case 2:
                    System.out.printf("\nenter vehicle's number: ");
					vehicleNumber = readObj.next();
                    UnparkingUtility unpark = new UnparkingUtility();
                    unpark.unparkingutil(vehicles, vehicleNumber, slotQueue);
					break;
				case 3:
					flag = false;
					break;

				default:
					break;
				}
			}
		}
		else {
			System.out.printf("\nInvalid username or password");
		}
		readObj.close();
	}

}
