package com.epam.autoparking.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
/**
 * This class provides utilities to main class.
 * @author Alekhya_Devisetty
 *
 */
public class Utilities {
	/**
	 * This method fills the queue.
	 * @param vehicles has the data of parking lot.
	 * @param slotQueue is the Queue.
	 * @param slot is the slot number.
	 * @return slot.
	 */
	public int queueUtility(final HashMap<String, Integer> vehicles
			                       ,final Queue<Integer> slotQueue) {
		int slotValue = 0;
		if (vehicles.size() != 0) {
			Map.Entry<String, Integer> maxEntry = null;
            for (Map.Entry<String, Integer> entry : vehicles.entrySet()) {
                if (maxEntry == null
                		|| entry.getValue() > maxEntry.getValue()) {
					maxEntry = entry;
				}
			}
			slotValue = maxEntry.getValue();

			for (int i = 1; i < slotValue - 1; i++) {
				if (vehicles.containsValue(i)) {
					continue;
				} else {
					slotQueue.add(i);
				}
			}

		}
		return slotValue;
	}
	/**
	 * This class takes data from file and adds them to hashmap.
	 * @param vehicles has the data of the parking slot.
	 * @return bufferReader object.
	 * @throws IOException deals with Input and Output.
	 */
	public void hashmapUtility (
	        final HashMap<String, Integer> vehicles)
			throws  IOException {
		BufferedReader br  = new BufferedReader(
		                     new FileReader("vehiclesData.csv"));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] str = line.split(",");

			vehicles.put(str[0], Integer.parseInt(str[1]));

		}
        br.close();
	}
}
