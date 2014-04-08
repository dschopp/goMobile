package com.gomobile;

import com.gomobile.data.controller.BikeDataController;
import com.gomobile.scanner.model.Component;

public class ScannerController {
	
	private History history = new History();
	private final BikeDataController bikeDataController = new BikeDataController();

	public Component getComponentInUse(){
		return history.getComponentInUse();
	}
	
	public boolean setComponentInUse(Component comp){
		history.add(comp);
		if(history.isSameType(comp)){
			//TODO
			return true;
		}else{
	        return false;
		}
	}
	
	public Component getComponentBefore() {
		return history.getComponentBefore();
	}
	
	
	//singleton
	private static ScannerController instance = null;
	
	private ScannerController(){}
	
	public static synchronized ScannerController getInstance(){
		if (instance == null){
			instance = new ScannerController();
		}
		return instance;
	}
	//singleton end

	/**
	 * @return the bikeDataController
	 */
	public BikeDataController getBikeDataController() {
		return bikeDataController;
	}

}