package com.epam.autoparking.utilities;

import java.util.HashMap;
import java.util.Queue;
import com.epam.filedbo.FileOperations;
import com.epam.autoparking.service.ParkingService;

/**
 * This class will be an utility class for parking.
 * @author Alekhya_Devisetty
 *
 */
public class ParkingUtility {
    /**
     * Utility method.
     * @param vehicles has the data of the vehicles.
     * @param slotQueue has the slot numbers of unparked slots.
     * @param vehicleNumber has the number assigned to a vehicle.
     * @param slot is an instance variable.
     * @return slotnumber.
     */
     public int parkingUtil(final HashMap<String, Integer> vehicles
                           , final Queue<Integer> slotQueue
                           ,final String vehicleNumber
                          ,Integer slot) {
		FileOperations foperations = new FileOperations();
		int slotNumber = -1;
		ParkingService pservice = new ParkingService();
		slotNumber = pservice.vehicleparking(vehicles, slotQueue, vehicleNumber, slot);
		foperations.writeToTransactionFile(vehicleNumber, slotNumber);
		foperations.writeToLog(vehicleNumber, 'p');
		return slotNumber;

	}
}
