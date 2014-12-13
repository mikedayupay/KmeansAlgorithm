package com.dlsu.kmeans.object;

import java.util.ArrayList;

public class Cluster {
	
	private String clusterLabel;
	private double[] clusterCentroid = new double[69];
	private ArrayList<Music> clusterMembers = new ArrayList<Music>();
	
	public Cluster(String clusterLabel, double[] clusterCentroid, Music clusterMemebers) {
		this.clusterLabel = clusterLabel;
		this.clusterCentroid = clusterCentroid;
		this.clusterMembers.add(clusterMemebers);
	}
	
	public void insertClusterMembers(Music music) {
		this.clusterMembers.add(music);
	}
	
	public void setClusterCentroid() {
		double[][] musicAttr = new double[1000][69];
		double[] total = new double[69];
		
		for(int i = 0 ; i < musicAttr.length; i++) {
			musicAttr[i] = clusterMembers.get(i).getMusicAttr();
		}
		
		for(int j = 0; j < musicAttr[0].length; j++) {
			for(int i = 0; i < musicAttr.length; i++) {
				total[j] += musicAttr[i][j];
			}
			total[j] /= clusterMembers.size();
		}
		
		this.clusterCentroid = total;
	}
	
	public String getClusterLabel() {
		return clusterLabel;
	}
	
	public ArrayList<Music> getClusterMembers() {
		return clusterMembers;
	}
	
	public double[] getClusterCentroid() {
		return clusterCentroid;
	}

}
