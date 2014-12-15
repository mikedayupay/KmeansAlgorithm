package com.dlsu.kmeans.object;

public class Music {
	
	private String musicName;
	private String musicGenre;
	private double[] musicAttr = new double[69];
	private double distanceFromCentroid;
	
	public Music(String musicName, String musicGenre, double[] musicAttr) {
		this.musicName = musicName;
		this.musicGenre = musicGenre;
		this.musicAttr = musicAttr.clone(); 
	}

	public String getMusicName() {
		return musicName;
	}

	public String getMusicGenre() {
		return musicGenre;
	}

	public double[] getMusicAttr() {
		return musicAttr.clone();
	}
	
	public void setDistanceFromCentroid(double[] centroidAttr) {
		double[] sqrDist = new double[69];
		double total = 0;
		for(int i = 0; i < this.musicAttr.length; i++) {
			sqrDist[i] = Math.pow((this.musicAttr[i] - centroidAttr[i]), 2);
		}
		
		for(int i = 0; i < this.musicAttr.length; i++) {
			total = total + sqrDist[i];
		}
		
		this.distanceFromCentroid = Math.sqrt(total);
	}
	
	public double getDistanceFromCentroid() {
		return distanceFromCentroid;
	}
	

}
