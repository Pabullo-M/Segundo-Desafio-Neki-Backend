package br.com.Neki_it.CartoesVirtuais.api.model.input;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UsuarioCadastroInput {
	
	@Schema(example = "Arthur Nunes")
	@NotBlank
	private String nome;
	
	@Schema(example = "Exemplo@Neki.com.br")
	@NotBlank
	private String email;
	
	@Schema(example = "123abc@")
	@Pattern(regexp = "[^\\s]+", message = "O texto não pode conter espaços")
	@NotBlank
	private String senha;
}
