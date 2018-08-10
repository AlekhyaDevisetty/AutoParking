package com.epam.filedbo;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 * This class performs all the file operations.
 * @author Alekhya_Devisetty
 *
 */
public class FileOperations {
   /**
    * This method removes the unparked vehicle into file.
    * @param vehicles has the data of the parking lot.
    */
   public void writeToTransactionFile(final HashMap<String, Integer> vehicles) {
    try {
            BufferedWriter bufferWriter
                           = new BufferedWriter(
                                   new FileWriter("vehiclesData.csv"));
			for (java.util.Map.Entry<String, Integer> entry : vehicles.entrySet()) {
				bufferWriter.write(entry.getKey());
				bufferWriter.write(",");
				bufferWriter.write(entry.getValue().toString());
				bufferWriter.newLine();
			}
			bufferWriter.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
    /**
     * This method adds the unparked vehicle to the file.
     * @param vehicleNumber is the number assigned to a vehicle.
     * @param slotNumber is the slot allocated for the vehicle.
     */
	public void writeToTransactionFile(final String vehicleNumber
			                          , final Integer slotNumber) {
		try {
			BufferedWriter bufferWriter = new BufferedWriter(
                                              new FileWriter("vehiclesData.csv"
                                            		         , true));
			bufferWriter.write(vehicleNumber);
			bufferWriter.write(",");
			bufferWriter.write(slotNumber.toString());
			bufferWriter.newLine();
			bufferWriter.close();
			}
		 catch (IOException e) {
			System.out.println(e);
		}
	}
    /**
     * This method writes parking and unparking data to log file.
     * @param vehicleNumber is the number assigned to a vehicle.
     * @param call specifies whether the vehicle is parked or unparked.
     */
	public void writeToLog(final String vehicleNumber, final char call) {
		try {
			BufferedWriter bufferWriter
			               = new BufferedWriter(
                                 new FileWriter("logData.csv", true));
			bufferWriter.write(vehicleNumber);
			if (call == 'p') {
				bufferWriter.write(" In time : ");
			}
			else {
				bufferWriter.write(" Out time : ");
			}
			java.util.Date date = new java.util.Date();
			String d = date.toString();
			bufferWriter.write(d);
			bufferWriter.newLine();
			bufferWriter.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
    /**
     * This method writes the number of slots to file.
     * @param numberOfSlots to be present.
     */
	public void writeToSlotFile(final Integer numberOfSlots) {
		try {
		BufferedWriter bufferWriter
		               = new BufferedWriter(
		            		   new FileWriter("SlotFile.csv"));
		System.out.println(numberOfSlots);
		bufferWriter.write(numberOfSlots.toString());
		bufferWriter.close();
	    }
		catch (IOException e) {
		System.out.println(e);
	}
	}
}
