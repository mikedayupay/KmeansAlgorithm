package com.dlsu.kmeans.fileimport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.dlsu.kmeans.object.Music;

public class ImportFromCSV implements ImportInterface{

	@Override
	public ArrayList<Music> performImport() {
		ArrayList<Music> list = new ArrayList<Music>();
		String csvFile = "MusicData.csv";
		BufferedReader br = null;
		String line = "";
		String token = ",";
		
		try {
			br = new BufferedReader(new FileReader(csvFile));
			while((line = br.readLine()) != null) {
				String[] details = line.split(token);
				double[] attr = new double[69];
				
				for(int i = 0;i < attr.length;i++) {
					attr[i] = Double.parseDouble(details[i+2]);
				}
				
				list.add(new Music(details[0], details[1], attr));
			}
			
		}
		
		catch(FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return list;
	}
	
	

}
