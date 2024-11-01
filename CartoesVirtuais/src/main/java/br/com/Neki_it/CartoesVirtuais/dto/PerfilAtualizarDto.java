package br.com.Neki_it.CartoesVirtuais.dto;

import java.time.LocalDate;

import br.com.Neki_it.CartoesVirtuais.model.RedesSociaisModel;
import jakarta.validation.constraints.Pattern;



public class PerfilAtualizarDto {
	


	
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@(neki-it|neki)\\.com\\.br$", 
		message = "O email deve pertencer aos domínios neki-it.com.br ou neki.com.br")
	private String email;
	
	private String nomeCompleto;
	
	private String nomeSocial;
	
	private LocalDate dataNascimento;
	
	private String foto;
	
	private String telefone;
	
	private RedesSociaisModel redesSociais;
	
	public PerfilAtualizarDto() {
		super();
	}

	public PerfilAtualizarDto(String email, String nomeCompleto, String nomeSocial,
			LocalDate dataNascimento, String foto, String telefone, RedesSociaisModel redesSociais) {
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
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
