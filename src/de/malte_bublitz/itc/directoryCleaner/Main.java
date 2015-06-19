package de.malte_bublitz.itc.directoryCleaner;

import de.malte_bublitz.util.ANSIConsole;

public class Main {
	public static void main(String[] args) {
		ANSIConsole c = new ANSIConsole();
		WatchThread watcher = new WatchThread("/tmp/test");
		watcher.setConsole(c);
		Thread watcherThread = new Thread(watcher);
		
		watcherThread.start();
		try {
			Thread.sleep(5*60*1000);
		} catch (InterruptedException e) {
			c.println("Got Exception!");
		} finally {
			watcher.toggleKeepRunning();
			System.exit(0);
		}
	}
}
