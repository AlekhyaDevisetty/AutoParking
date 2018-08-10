package com.epam.autoparking.utilities;

import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

import com.epam.autoparking.exception.SlotEmptyException;
import com.epam.autoparking.exception.VehicleNotFoundException;
import com.epam.filedbo.FileOperations;
import com.epam.autoparking.service.UnParkingService;
/**
 * This method provides utility for parking class.
 * @author Alekhya_Devisetty
 *
 */
public class UnparkingUtility {
	public void unparkingutil(HashMap<String, Integer> vehicles,String vehicleNumber, Queue<Integer> slotQueue) {
		Scanner readObj = new Scanner(System.in);
		FileOperations foperations = new FileOperations();
	if (vehicles.size() > 0) {
		
        UnParkingService upservice = new UnParkingService();
        int slotNumber = upservice.unparking(vehicles
                         , vehicleNumber, slotQueue);
		if (slotNumber != -1) {
            System.out.printf("\nYour slotNumber: "
                                 + slotNumber);
             System.out.printf("\nUnparking sucess");
		}

		else {
			try {
               throw new VehicleNotFoundException();
	        }
           catch (VehicleNotFoundException e) {
               System.out.printf("\nVehicle is'nt parked here");
			}
		}
	} else {
		try {
          throw new SlotEmptyException();
		} catch (SlotEmptyException e) {
             System.out.printf("\nThere are no vehicles"
                               + " in the parking slot.");
		}
	}

    foperations.writeToTransactionFile(vehicles);
    foperations.writeToLog(vehicleNumber, 'u');
	}
}
