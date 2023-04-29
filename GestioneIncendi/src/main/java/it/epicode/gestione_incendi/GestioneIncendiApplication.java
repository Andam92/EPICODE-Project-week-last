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
		
		//Uso una factory per creare le sonde 
		SondeFactory factory = new SondeFactory();
		Sonda sonda1 = (Sonda) factory.creaDispositivo("sonda");
		Sonda sonda2 = (Sonda) factory.creaDispositivo("sonda");
		Sonda sonda3 = (Sonda) factory.creaDispositivo("sonda");
		
		//Uso una factory per creare un concrete observer (controllo sonde)
		//ConcreteObserver controllo1 = (ConcreteObserver) factory.creaDispositivo("observer");
		
		
		//controllo1.setSonda(sonda1);
		
		ConcreteObserver controllo1 = new ConcreteObserver(sonda1);
		System.out.println(sonda1.getObservers().size());
		
		
		
		//Centro di controllo
		
		CentroControllo centro = new CentroControllo(controllo1);
		sonda1.setLivelloFumo(4);
		
	}

}
