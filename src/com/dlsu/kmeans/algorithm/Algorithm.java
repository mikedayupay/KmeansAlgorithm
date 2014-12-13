package com.dlsu.kmeans.algorithm;

import java.util.ArrayList;
import java.util.Random;

import com.dlsu.kmeans.fileimport.Import;
import com.dlsu.kmeans.object.Cluster;
import com.dlsu.kmeans.object.Music;

public class Algorithm {
	
	private int euclideanCompCount;
	private int pass = 100;
	private int k = 10;
	private ArrayList<Music> musicSample = new ArrayList<Music>();
	private Cluster[] clusters = new Cluster[k];
	
	public Algorithm() {
		Import importFile = new Import();
		musicSample.addAll(importFile.performImport());
		
		
	}
	
	public void initializeClusters() {
		Random rand = new Random();
		int rnd = rand.nextInt(1000);
		for(int i = 0; i <= k; i++) {
			clusters[i] = new Cluster("A", musicSample.get(rnd).getMusicAttr(), musicSample.get(rnd));
		}
	}
	
	
	
}
