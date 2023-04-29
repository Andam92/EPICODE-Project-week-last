package it.epicode.gestione_incendi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.epicode.gestione_incendi.model.ConcreteObserver;
import it.epicode.gestione_incendi.model.Observer;
import it.epicode.gestione_incendi.model.Sonda;

@Configuration
public class SondeFactory {
	
	public Faker faker = new Faker();
	
	@Bean
	@Scope("prototype")
	public Observer creaDispositivo(String tipo) {
		if(tipo == null) {
			return null;
		}
		if(tipo.equalsIgnoreCase("sonda")) {
			Sonda sonda = new Sonda();
			sonda.setId(faker.number().numberBetween(1, 999));
			sonda.setLatitudine(faker.address().latitude());
			sonda.setLongitudine(faker.address().longitude());			
			return sonda;
			
		}else if(tipo.equalsIgnoreCase("observer")){
			ConcreteObserver controllo = new ConcreteObserver();
			return controllo;
		}
		return null;
	}

}
