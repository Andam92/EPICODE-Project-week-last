package it.epicode.gestione_incendi.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;

import it.epicode.gestione_incendi.model.Allarme;
import it.epicode.gestione_incendi.model.GestoreSonde;
import it.epicode.gestione_incendi.model.Sonda;
import it.epicode.gestione_incendi.repository.GestoreSondeRepository;
import it.epicode.gestione_incendi.repository.SondaRepository;



@Service
public class AllarmeService {
	
	@Autowired SondaRepository sondaRepo;
	@Autowired GestoreSondeRepository gestoreRepo;
	
	public void creaDispositivo(Allarme disp) {
		Faker fake = Faker.instance(new Locale("it-IT"));
		if (disp instanceof Sonda) {
			Sonda sonda = (Sonda) disp;
			sonda.setLongitudine(fake.address().longitude());
			sonda.setLatitudine(fake.address().latitude());
			sondaRepo.save(sonda);
			System.out.println(sonda + "salvata nel db");
		} else if (disp instanceof GestoreSonde) {
			GestoreSonde gestore = (GestoreSonde) disp;
			gestore.setCitta(fake.address().city());
			gestoreRepo.save(gestore);
			System.out.println(gestore + "salvato nel db");
		}
	}
	
	public Sonda trovaSondaById(Long id) {
		return sondaRepo.findById(id).get();
	}
	
	public GestoreSonde trovaGestoreById(Long id) {
		return gestoreRepo.findById(id).get();
	}
	
	public void updateSonda(Sonda sonda) {
		sondaRepo.save(sonda);
		System.out.println("Sonda aggiornata");
	}
	
	public void updateGestore(GestoreSonde gestore) {
		gestoreRepo.save(gestore);
		System.out.println("Gestore sonde aggiornato");
	}
}
