package it.epicode.gestione_incendi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

// Sonda è il Subject
public class Sonda implements Observer {
	
	private String latitudine;	
	private String longitudine;	
	private Integer livelloFumo = 0;
	private List<Observer> observers = new ArrayList<>();

	
	
	public void setLivelloFumo(Integer livelloFumo) {
		this.livelloFumo = livelloFumo;
		this.notifyAllObservers();
	}
	 
	 public void attach(Observer observer){
		 observers.add(observer);        
	 }
	 
	 public void notifyAllObservers() {
		 System.out.println(observers.size());
		 if(this.getLivelloFumo() > 5) {			 
			 this.getObservers().forEach(observer -> observer.inviaAllarme());	
				 		 
			} 
		 
	 }
	
	@Override
	public void inviaAllarme() {
	}

}
