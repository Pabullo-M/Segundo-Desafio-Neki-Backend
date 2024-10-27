package br.com.Neki_it.CartoesVirtuais.dto;

import br.com.Neki_it.CartoesVirtuais.model.RedesSociaisModel;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;



public class PerfilCadastroDto {
	


	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(neki-it|neki)\\.com\\.br$", 
		message = "O email deve pertencer aos domínios neki-it.com.br ou neki.com.br")
	private String email;
	
	@NotBlank
	private String nomeCompleto;
	
	private String nomeSocial;
	
	@NotBlank
	private String dataNascimento;
	
	@NotBlank
	private String foto;
	
	private String telefone;
	
	private RedesSociaisModel redesSociais;
	
	public PerfilCadastroDto() {
		super();
	}

	public PerfilCadastroDto( @NotBlank String email, @NotBlank String nomeCompleto, String nomeSocial,
			@NotBlank String dataNascimento, @NotBlank String foto, String telefone, RedesSociaisModel redesSociais) {
		super();
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.nomeSocial = nomeSocial;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.telefone = telefone;
		this.redesSociais = redesSociais;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email.toLowerCase();
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}

	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public RedesSociaisModel getRedesSociais() {
		return redesSociais;
	}

	public void setRedesSociais(RedesSociaisModel redesSociais) {
		this.redesSociais = redesSociais;
	}
	
	
}
