package com.epam.autoparking.service;
import java.util.HashMap;
import java.util.Queue;
/**
 * This class serves for parking procedures.
 * @author Alekhya_Device
 *
 */
public class ParkingService {
/**
 * @param vehicles is a HashMap.
 * @param slotQueue is a Queue.
 * @param vehicleNumber is a String.
 * @param slot is a Integer.
 * @return vehicle is a HashMap.
 */
     public int vehicleparking(final HashMap<String, Integer> vehicles
            , final Queue<Integer> slotQueue
           , final String vehicleNumber
           , final Integer slot) {
         int slotNumber;
		if (slotQueue.isEmpty()) {
		vehicles.put(vehicleNumber, slot);
		slotNumber = slot;
		}
		else {
			vehicles.put(vehicleNumber, (Integer) slotQueue.peek());
			slotNumber = (Integer) slotQueue.peek();
			slotQueue.remove();
		}
		return slotNumber;
	}

}


