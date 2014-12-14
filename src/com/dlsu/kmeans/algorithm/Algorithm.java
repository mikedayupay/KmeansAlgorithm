package com.dlsu.kmeans.algorithm;

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
		for(int i = 0; i < clusters[1].getClusterMembers().size(); i++)
			System.out.println(clusters[1].getClusterMembers().get(i).getMusicGenre());
		
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
		
	}
	
	
	public void outputToFile() {
		
	}
	
	
}
