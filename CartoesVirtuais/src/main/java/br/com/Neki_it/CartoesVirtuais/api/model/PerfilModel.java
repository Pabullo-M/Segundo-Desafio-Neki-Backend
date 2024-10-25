package br.com.Neki_it.CartoesVirtuais.api.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class PerfilModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String nomeCompleto;
	
	private String nomeSocial;
	
	@NotBlank
	private String dataNascimento;
	
	@NotBlank
	private String foto;
	
	private String telefone;
	
	@Embedded
	private RedesSociais redesSociais;
}
