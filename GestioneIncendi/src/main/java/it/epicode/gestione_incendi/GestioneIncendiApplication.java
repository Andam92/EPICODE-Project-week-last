package it.epicode.gestione_incendi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.epicode.gestione_incendi.configuration.SondeFactory;
import it.epicode.gestione_incendi.model.CentroControllo;
import it.epicode.gestione_incendi.model.ConcreteObserver;
import it.epicode.gestione_incendi.model.Sonda;

@SpringBootApplication
public class GestioneIncendiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneIncendiApplication.class, args);
		
		//FACTORY
		//Uso una factory per creare le sonde 
		SondeFactory factory = new SondeFactory();
		Sonda sonda1 = (Sonda) factory.creaDispositivo("sonda");
		Sonda sonda2 = (Sonda) factory.creaDispositivo("sonda");
		Sonda sonda3 = (Sonda) factory.creaDispositivo("sonda");
		
		//Uso una factory per creare un concrete observer (controllo sonde)
		//ConcreteObserver controllo1 = (ConcreteObserver) factory.creaDispositivo("observer");
		
		
		//Costruttore di ConcreteObserver (controllo sonde) con sonda
		ConcreteObserver controllo1 = new ConcreteObserver(sonda1);
		//System.out.println(sonda1.getObservers().size());
		

		//Centro di controllo con controllo sonde		
		CentroControllo centro = new CentroControllo(controllo1);
		
		
		//OBSERVER
		//Check nessun allarme
		sonda1.setLivelloFumo(3);
		//Check allarme livello di fumo
		//sonda1.setLivelloFumo(6);
		
	}

}
