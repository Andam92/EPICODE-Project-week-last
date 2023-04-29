package it.epicode.gestione_incendi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class CentroControllo implements ControlloProxy{
	
	private ConcreteObserver controlloSonde;
	

	public CentroControllo(ConcreteObserver controlloSonde) {
		this.controlloSonde = controlloSonde;
		this.controlloSonde.attach(this);
	}

	@Override
	public void allertaPersonale() {
		
		if(controlloSonde.isAllerta()) {
			System.err.println("Allarme! Il livello di fumo riportato dalla sonda LAT [" + controlloSonde.getSonda().getLatitudine() + "]"
		+ ", LONG [" + controlloSonde.getSonda().getLongitudine() + "] è superiore a 5!");
		}
		
	}

}


//System.out.println("Allarme! Il livello di fumo riportato dalla sonda LAT [" + sonda.getLatitudine() + "]"
//		+ ", LONG [" + sonda.getLongitudine() + "] è superiore a 5!");
