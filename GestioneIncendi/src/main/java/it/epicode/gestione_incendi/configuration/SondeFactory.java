package it.epicode.gestione_incendi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.epicode.gestione_incendi.model.Allarme;
import it.epicode.gestione_incendi.model.GestoreSonde;
import it.epicode.gestione_incendi.model.Sonda;

@Configuration
public class SondeFactory {
	
	@Bean
	@Scope("prototype")
	public Allarme creaDispositivo(String tipo) {
		if(tipo == null) {
			return null;
		}
		if(tipo.equalsIgnoreCase("Sonda")) {
			return new Sonda();
			
		}else if(tipo.equalsIgnoreCase("GestoreSonde")){
			return new GestoreSonde();
		}
		return null;
	}

}
