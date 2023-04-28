package it.epicode.gestione_incendi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.epicode.gestione_incendi.model.GestoreSonde;

@Repository
public interface GestoreSondeRepository extends CrudRepository<GestoreSonde, Long> {

}
