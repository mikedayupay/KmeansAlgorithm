package com.dlsu.kmeans.algorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import com.dlsu.kmeans.fileimport.Import;
import com.dlsu.kmeans.object.Cluster;
import com.dlsu.kmeans.object.Music;

public class Algorithm {
	
	private int euclideanCompCount = 0;
	private int pass = 0;
	private int k = 10;
	private ArrayList<Music> musicSample = new ArrayList<Music>();
	private Cluster[] clusters = new Cluster[k];
	private String filename1 = "initialClusters.csv";
	private String filename2 = "finalClusters.csv";
	
	public Algorithm() {
		
		int flag = 0;
		
		Import importFile = new Import();
		musicSample.addAll(importFile.performImport());
		
		initializeClusters();
		
		do {
			
			for(int a = 0; a < clusters.length; a++) {
				clusters[a].setClusterCentroid();//adjust centroids to current clusters
			}
			
			
			for(int i = 0 ; i < musicSample.size(); i++) {
				Double minValue = null;
				
				for(int j = 0; j < clusters.length; j++) {
					musicSample.get(i).setDistanceFromCentroid(clusters[j].getClusterCentroid());//compute for euclidean distance from centroid

					// remove all from clusters 
					for(int k = 0; k < clusters.length; k++) {
						if(clusters[k].getClusterMembers().contains(musicSample.get(i))) {
							clusters[k].getClusterMembers().remove(musicSample.get(i));
						}
					}
					
					//getting the minimum euclidean distance
					if(minValue == null || musicSample.get(i).getDistanceFromCentroid() < minValue) {
						minValue = musicSample.get(i).getDistanceFromCentroid();
						flag = j;
					}
				}
				clusters[flag].insertClusterMembers(musicSample.get(i)); //insert music sample to nearest cluster centroid
			}	
			
			pass++;
		}while (pass != 100);
		
		System.out.println("----------------------------------------------------------");
		for(int i = 0; i < clusters[0].getClusterMembers().size(); i++)
			System.out.println(clusters[0].getClusterMembers().get(i).getMusicGenre());
		
		outputToFile(filename2);
	}
	
	/*initializes all the clusters*/
	public void initializeClusters() {
		Random rand = new Random();
		int flag = 0;
		
		
		for(int i = 0; i < k; i++) {
			int rnd = rand.nextInt(1000);
			clusters[i] = new Cluster(i+"", musicSample.get(rnd).getMusicAttr(), musicSample.get(rnd));// initializing cluster centroid with 10 random music samples
		}
		
		for(int a = 0 ; a < musicSample.size(); a++) {
			Double min = null;
			for(int b = 0; b < clusters.length; b++) {
				musicSample.get(a).setDistanceFromCentroid(clusters[b].getClusterCentroid());
			
				// getting the minimum euclidean distance
				if(min == null || musicSample.get(a).getDistanceFromCentroid() < min) {
					min = musicSample.get(a).getDistanceFromCentroid();
					flag = b;
					//System.out.println(flag);
				}
			}
			clusters[flag].insertClusterMembers(musicSample.get(a)); //insert music sample to nearest cluster centroid
		}
		
		outputToFile(filename1);
	}
	
	
	public void outputToFile(String filename) {
		String outputFile = filename;
		boolean alreadyExists = new File(outputFile).exists();
		
		try {
			
			File file = new File(outputFile);
			if(!alreadyExists){
				file.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			
			
			fw.append(clusters[0].getClusterLabel());
			for(int i = 0; i < clusters[0].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[0].getClusterMembers().get(i).getMusicName());
			}
			fw.append("\n");
			
			fw.append(clusters[0].getClusterLabel());
			for(int i = 0; i < clusters[0].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[0].getClusterMembers().get(i).getMusicGenre());
			}
			fw.append("\n\n");
			
			fw.append(clusters[1].getClusterLabel());
			for(int i = 0; i < clusters[1].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[1].getClusterMembers().get(i).getMusicName());
			}
			fw.append("\n");
			
			fw.append(clusters[1].getClusterLabel());
			for(int i = 0; i < clusters[1].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[1].getClusterMembers().get(i).getMusicGenre());
			}
			fw.append("\n\n");
			
			fw.append(clusters[2].getClusterLabel());
			for(int i = 0; i < clusters[2].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[2].getClusterMembers().get(i).getMusicName());
			}
			fw.append("\n");
			
			fw.append(clusters[2].getClusterLabel());
			for(int i = 0; i < clusters[2].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[2].getClusterMembers().get(i).getMusicGenre());
			}
			fw.append("\n\n");
			
			fw.append(clusters[3].getClusterLabel());
			for(int i = 0; i < clusters[3].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[3].getClusterMembers().get(i).getMusicName());
			}
			fw.append("\n");
			
			fw.append(clusters[3].getClusterLabel());
			for(int i = 0; i < clusters[3].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[3].getClusterMembers().get(i).getMusicGenre());
			}
			fw.append("\n\n");
			
			fw.append(clusters[4].getClusterLabel());
			for(int i = 0; i < clusters[4].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[4].getClusterMembers().get(i).getMusicName());
			}
			fw.append("\n");
			
			fw.append(clusters[4].getClusterLabel());
			for(int i = 0; i < clusters[4].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[4].getClusterMembers().get(i).getMusicGenre());
			}
			fw.append("\n\n");
			
			fw.append(clusters[5].getClusterLabel());
			for(int i = 0; i < clusters[5].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[5].getClusterMembers().get(i).getMusicName());
			}
			fw.append("\n");
			
			fw.append(clusters[5].getClusterLabel());
			for(int i = 0; i < clusters[5].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[5].getClusterMembers().get(i).getMusicGenre());
			}
			fw.append("\n\n");
			
			fw.append(clusters[6].getClusterLabel());
			for(int i = 0; i < clusters[6].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[6].getClusterMembers().get(i).getMusicName());
			}
			fw.append("\n");
			
			fw.append(clusters[6].getClusterLabel());
			for(int i = 0; i < clusters[6].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[6].getClusterMembers().get(i).getMusicGenre());
			}
			fw.append("\n\n");
			
			fw.append(clusters[7].getClusterLabel());
			for(int i = 0; i < clusters[7].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[7].getClusterMembers().get(i).getMusicName());
			}
			fw.append("\n");
			
			fw.append(clusters[7].getClusterLabel());
			for(int i = 0; i < clusters[7].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[7].getClusterMembers().get(i).getMusicGenre());
			}
			fw.append("\n\n");
			
			fw.append(clusters[8].getClusterLabel());
			for(int i = 0; i < clusters[8].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[8].getClusterMembers().get(i).getMusicName());
			}
			fw.append("\n");
			
			fw.append(clusters[8].getClusterLabel());
			for(int i = 0; i < clusters[8].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[8].getClusterMembers().get(i).getMusicGenre());
			}
			fw.append("\n\n");
			
			fw.append(clusters[9].getClusterLabel());
			for(int i = 0; i < clusters[9].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[9].getClusterMembers().get(i).getMusicName());
			}
			fw.append("\n");
			
			fw.append(clusters[9].getClusterLabel());
			for(int i = 0; i < clusters[9].getClusterMembers().size(); i++) {
				fw.append(",");
				fw.append(clusters[9].getClusterMembers().get(i).getMusicGenre());
			}
			fw.append("\n\n");
			
			fw.flush();
			fw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
