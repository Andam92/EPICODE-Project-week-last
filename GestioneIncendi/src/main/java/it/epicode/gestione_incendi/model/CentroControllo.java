package it.epicode.gestione_incendi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CentroControllo implements ControlloProxy{
	
	private ConcreteObserver controlloSonde;
	private String diffondiAllarme = null;
	

	public CentroControllo(ConcreteObserver controlloSonde) {
		this.controlloSonde = controlloSonde;
		this.controlloSonde.attach(this);
	}

	@Override
	public void allertaPersonale() {
		
		if(controlloSonde.isAllerta()) {
			this.diffondiAllarme = "Broadcasting...";
			System.err.println("http://host/alarm?=idsonda=" + controlloSonde.getSonda().getId() + "&lat=" + controlloSonde.getSonda().getLatitudine()  
		+ "&lon=" + controlloSonde.getSonda().getLongitudine() + "&smokelevel=" + controlloSonde.getSonda().getLivelloFumo());
		} 		
	}
}

