
package it.epicode.gestione_incendi.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data

public class ConcreteObserver implements Observer {

	private boolean allerta = false;
	private String fake = "nome";
	private Sonda sonda;
	private List<ControlloProxy> proxyObservers = new ArrayList<>();
	

	public ConcreteObserver(Sonda sonda) {
		this.sonda = sonda;
		this.sonda.attach(this);
	}


	public void attach(ControlloProxy proxy){
		proxyObservers.add(proxy);        
	 }


	@Override
	public void inviaAllarme() {
		this.setAllerta(true);
		System.out.println(this.allerta);
		for(ControlloProxy proxy : proxyObservers) {
			 if(this.isAllerta()) {			
				 System.out.println("allerta");
				 proxy.allertaPersonale();
			 } else if(!this.allerta){
				 System.out.println("Nessun problema");
			 }
		 }
		
	}

}
