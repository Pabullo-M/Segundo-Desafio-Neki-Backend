package br.com.Neki_it.CartoesVirtuais.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Embeddable
public class RedesSociaisModel {
	
	private String linkedin;
	private String github;
	private String instagram;
	private String facebook;
	
	
}
