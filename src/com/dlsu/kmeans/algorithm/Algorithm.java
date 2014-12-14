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
	private double minValue = Double.MAX_VALUE;
	private ArrayList<Music> musicSample = new ArrayList<Music>();
	private Cluster[] clusters = new Cluster[k];
	
	public Algorithm() {
		Import importFile = new Import();
		musicSample.addAll(importFile.performImport());
		
		initializeClusters();
		for(int i = 0; i < clusters[1].getClusterMembers().size(); i++)
			System.out.println(clusters[1].getClusterMembers().get(i).getMusicName());
		do {
			
			for(int a = 0; a < clusters.length; a++) {
				clusters[a].setClusterCentroid();
			}
			
			
			for(int i = 0 ; i < musicSample.size(); i++) {
				for(int j = 0; j < clusters.length; j++) {
					musicSample.get(i).setDistanceFromCentroid(clusters[j].getClusterCentroid());
					
					if(musicSample.get(i).getDistanceFromCentroid() < minValue) {
						minValue = musicSample.get(i).getDistanceFromCentroid();
							
						for(int k = 0; k < clusters.length; k ++) {
							if(clusters[k].getClusterMembers().contains(musicSample.get(i))) {
								clusters[k].getClusterMembers().remove(musicSample.get(i));
							}
						}
						clusters[j].insertClusterMembers(musicSample.get(i));
					}
				}
			}	
			
			pass++;
			
		}while (pass < 100);
		
		
		
		
	}
	
	public void initializeClusters() {
		Random rand = new Random();
		int flag = 0;
		
		
		for(int i = 0; i < k; i++) {
			int rnd = rand.nextInt(1000);
			clusters[i] = new Cluster(i+"", musicSample.get(rnd).getMusicAttr(), musicSample.get(rnd));
		}
		
		for(int a = 0 ; a < musicSample.size(); a++) {
			Double min = null;
			for(int b = 0; b < clusters.length; b++) {
				musicSample.get(a).setDistanceFromCentroid(clusters[b].getClusterCentroid());
			
				if(min == null || musicSample.get(a).getDistanceFromCentroid() < min) {
					min = musicSample.get(a).getDistanceFromCentroid();
					flag = b;
					System.out.println(flag);
				}
			}
			clusters[flag].insertClusterMembers(musicSample.get(a));
		}
		
	}
	
	
	
}
