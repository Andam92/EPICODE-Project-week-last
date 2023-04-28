package it.epicode.gestione_incendi.runner;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.epicode.gestione_incendi.configuration.SondeFactory;
import it.epicode.gestione_incendi.model.Allarme;
import it.epicode.gestione_incendi.model.GestoreSonde;
import it.epicode.gestione_incendi.model.Sonda;
import it.epicode.gestione_incendi.service.AllarmeService;


@Component
public class SondeRunner implements ApplicationRunner {
	
	@Autowired ObjectProvider<SondeFactory> allarmeProvider;
	@Autowired AllarmeService allarmeServ;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Run...");		
		
		Allarme sonda = allarmeProvider.getObject().creaDispositivo("sonda");
		Allarme sonda2 = allarmeProvider.getObject().creaDispositivo("sonda");
		Allarme sonda3 = allarmeProvider.getObject().creaDispositivo("sonda");
		//Allarme gestore = allarmeProvider.getObject().creaDispositivo("GestoreSonde");
		Sonda sondaLetta = allarmeServ.trovaSondaById(1l);
		Sonda sondaLetta2 = allarmeServ.trovaSondaById(2l);
		Sonda sondaLetta3 = allarmeServ.trovaSondaById(3l);
		//GestoreSonde gestoreLetto = allarmeServ.trovaGestoreById(1l);
		//sondaLetta.setGestoreSonde(gestoreLetto);
		//gestoreLetto.getListaSonde().add(sondaLetta);
		//allarmeServ.updateSonda(sondaLetta);
		//allarmeServ.creaDispositivo(gestore);
		//System.out.println(sondaLetta);
		
		//allarmeServ.updateGestore(gestoreLetto);
	}

}
