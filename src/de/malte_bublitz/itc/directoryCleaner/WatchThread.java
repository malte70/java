package de.malte_bublitz.itc.directoryCleaner;

import de.malte_bublitz.util.ANSIConsole;
import java.io.File;
import java.util.ArrayList;

public class WatchThread implements Runnable {
	private String directoryName = "";
	private boolean keepRunning = false;
	private ANSIConsole console = null;
	
	public void toggleKeepRunning() {
		this.keepRunning = !this.keepRunning;
	}
	
	public void setConsole(ANSIConsole console) {
		this.console = console;
	}
	
	public ArrayList<File> listDirectoryContents(String directoryName) {
		File dir = new File(directoryName);
		ArrayList<File> listing = new ArrayList<File>();
		
		File[] fList = dir.listFiles();
		for (File f : fList) {
			if (f.isDirectory()) {
				listing.addAll(this.listDirectoryContents(f.getAbsolutePath()));
			} else {
				listing.add(f);
			}
		}
		
		return listing;
	}
	
	public void run() {
		this.toggleKeepRunning();
		ArrayList<File> listing;
		while (this.keepRunning) {
			listing = this.listDirectoryContents(this.directoryName);
			this.console.clear();
			this.console.println("Listing for: "+this.directoryName);
			this.console.println("");
			for (File f : listing) {
				this.console.println(f.getAbsolutePath());
			}
			try {
				Thread.sleep(30*1000);
			} catch (InterruptedException e) {
				this.console.println("EXCEPTION!!!!");
			}
		}
	}
	
	public WatchThread(String directoryName) {
		this.directoryName = directoryName;
	}
}
