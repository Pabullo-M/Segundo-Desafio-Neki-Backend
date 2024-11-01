package br.com.Neki_it.CartoesVirtuais.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "perfil")
public class PerfilModel {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(unique = true)
	private String email;
	
	@NotBlank
	private String nomeCompleto;
	
	private String nomeSocial;
	
	@NotNull
	private LocalDate dataNascimento;
	
	@NotBlank
	private String foto;
	
	private String telefone;
	
	@Embedded
	private RedesSociaisModel redesSociais;
	
	public PerfilModel() {
		super();
	}

	public PerfilModel(Long id, @NotBlank String email, @NotBlank String nomeCompleto, String nomeSocial,
			@NotBlank LocalDate dataNascimento, @NotBlank String foto, String telefone, RedesSociaisModel redesSociais) {
		super();
		this.id = id;
		this.email = email;
		this.nomeCompleto = nomeCompleto;
		this.nomeSocial = nomeSocial;
		this.dataNascimento = dataNascimento;
		this.foto = foto;
		this.telefone = telefone;
		this.redesSociais = redesSociais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
