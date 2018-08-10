package com.epam.filedbo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileSquile {
	public int checkFileExistance() {
		File fileObj = new File("SlotFile.csv");
		int numberOfSlots = 0;
		try {
			BufferedReader br = new BufferedReader(
					                  new FileReader("SlotFile.csv"));
		if (fileObj.exists()) {
			String text = br.readLine();
			numberOfSlots = Integer.parseInt(text);
		}
		else {
			numberOfSlots = -1;
		}
		br.close();
		}
		catch(Exception emsg) {
			System.out.println(emsg);
		}
		
		return numberOfSlots;
	}
}
