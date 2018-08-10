package com.epam.autoparking.service;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.Queue;
/**
 * This class serves for unparking procedure.
 * @author Alekhya_Devisetty
 *
 */
        public class UnParkingService {
		/**
		 * @param vehicles is a HashMap.
		 * @param slotQueue is a Queue.
		 * @param vehicleNumber is a String.
		 * @return slotQueue is a Queue.
		 */

		public int unparking(final HashMap<String, Integer> vehicles
               , final String vehicleNumber
               , final Queue<Integer> slotQueue) {
			Integer slotNumber = vehicles.get(vehicleNumber);
			if (slotNumber != null) {
			vehicles.remove(vehicleNumber);
			slotQueue.add(slotNumber);
			}
			else {
				slotNumber = -1;
			}
			return slotNumber;
		}

	}


