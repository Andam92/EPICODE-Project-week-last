
package it.epicode.gestione_incendi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GestoreSonde implements Allarme{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String citta;
	@OneToMany(fetch = FetchType.EAGER)
	@Column(name = "sonde_associate")
	@Builder.Default
	@JsonIgnoreProperties
	
	private List<Sonda> listaSonde = new ArrayList<>();

	@Override
	public void inviaAllarme() {
		// TODO Auto-generated method stub
		
	}

}
