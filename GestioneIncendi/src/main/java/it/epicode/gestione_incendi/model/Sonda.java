package it.epicode.gestione_incendi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sonde")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Sonda implements Allarme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String latitudine;
	@Column(nullable = false)
	private String longitudine;
	@Builder.Default
	private Integer livelloFumo = 0;
	@ManyToOne
	private GestoreSonde gestoreSonde;
	private String tipoDispositivo;

	@Override
	public void inviaAllarme() {

	}

}
