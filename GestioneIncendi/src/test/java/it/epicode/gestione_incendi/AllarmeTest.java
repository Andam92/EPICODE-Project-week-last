package it.epicode.gestione_incendi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.epicode.gestione_incendi.model.CentroControllo;
import it.epicode.gestione_incendi.model.ConcreteObserver;
import it.epicode.gestione_incendi.model.Sonda;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

import javax.management.StringValueExp;


public class AllarmeTest {
	
	@Test
	public void allarmeTest() {
		
		Sonda sonda = new Sonda();
		Sonda sonda2 = new Sonda();
		ConcreteObserver observer = new ConcreteObserver(sonda);
		ConcreteObserver observer2 = new ConcreteObserver(sonda2);
		CentroControllo centroControllo = new CentroControllo(observer);
		CentroControllo centroControllo2 = new CentroControllo(observer2);
		
		sonda.setLivelloFumo(1);
		//testa stato di allerta dell'observer in caso di assenza pericoli
		assertEquals(observer.isAllerta(), false);
		//testa stato di allerta dell'observer in caso di pericolo (fumo percepito > 5)
		sonda2.setLivelloFumo(8);
		assertEquals(observer2.isAllerta(), true);
		//testa se il messaggio di allarme è trasmesso dal centro di controllo senza motivo
		assertEquals(centroControllo.getDiffondiAllarme(), null);
		//testa se il messaggio di allarme è trasmesso dal centro di controllo in presenza di pericolo
		assertEquals(centroControllo2.getDiffondiAllarme(), "Broadcasting...");
			
	}

}
