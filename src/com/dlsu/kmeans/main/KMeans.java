package com.dlsu.kmeans.main;

import java.util.ArrayList;
import java.util.Random;

import com.dlsu.kmeans.fileimport.Import;
import com.dlsu.kmeans.object.Music;

public class KMeans {
	
	public static void main(String[] args) {
		Import importFile = new Import();
		ArrayList<Music> list = new ArrayList<Music>();
		list.addAll(importFile.performImport());
		double[] array = new double[69];
		array = list.get(0).getMusicAttr();
		System.out.println(array[67]);
		list.get(1).setDistanceFromCentroid(list.get(2).getMusicAttr());
		System.out.println(list.get(1).getDistanceFromCentroid());
		
		double[][] musicAttr = new double[1000][69];
		double[] total = new double[69];
		double[] clusterCentroid = new double[69];
		
		for(int i = 0 ; i < musicAttr.length; i++) {
			musicAttr[i] = list.get(i).getMusicAttr();
		}
		
		for(int j = 0; j < musicAttr[0].length; j++) {
			for(int i = 0; i < musicAttr.length; i++) {
				total[j] += musicAttr[i][j];
			}
			total[j] /= list.size();
		}
		
		clusterCentroid = total;
		
		System.out.println(clusterCentroid[0]);
		
		Random rand = new Random();
		int rnd = rand.nextInt(1000);
		System.out.println(rnd);
		System.out.println(rnd);
	}

}
