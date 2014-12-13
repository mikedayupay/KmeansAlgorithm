package com.dlsu.kmeans.fileimport;

import java.util.ArrayList;

import com.dlsu.kmeans.object.Music;

public class Import {
	
	private ImportInterface importStrategy;
	
	public Import() {
		this.importStrategy = new ImportFromCSV();
	}
	
	public ArrayList<Music> performImport() {
		return importStrategy.performImport();
	}

}
