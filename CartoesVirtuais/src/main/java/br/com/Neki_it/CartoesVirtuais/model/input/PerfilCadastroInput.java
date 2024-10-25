package br.com.Neki_it.CartoesVirtuais.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PerfilCadastroInput {

	
	@NotBlank
	private String email;
	@Schema(example = "Arthur Nunes")
	@NotBlank
	private String nomeCompleto;
	
	@Schema(example = "Zico")
	private String nomeSocial;
	
	@Schema(example = "03/03/1953")
	@NotBlank
	private String dataNascimento;
	
	@NotBlank
	private String foto;
	
	@Schema(example = "(021)912345678")
	private String telefone;
	
	private String linkedin;
	
	private String github;
	
	private String instagram;
	
	private String facebook;
	
}
