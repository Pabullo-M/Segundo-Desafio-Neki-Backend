package br.com.Neki_it.CartoesVirtuais.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UsuarioCadastroDto {

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
	
	
	

	public UsuarioCadastroDto() {
		super();
	}

	public UsuarioCadastroDto(@NotBlank String nome, @NotBlank String email,
			@Pattern(regexp = "[^\\s]+", message = "O texto não pode conter espaços") @NotBlank String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}	
	
	
	
} ;
	
	

