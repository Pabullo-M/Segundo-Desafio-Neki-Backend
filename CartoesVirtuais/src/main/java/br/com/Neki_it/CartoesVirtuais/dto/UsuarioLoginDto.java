package br.com.Neki_it.CartoesVirtuais.dto;

public class UsuarioLoginDto {
	
	private String email;
	
	private String senha;

	
	
	public UsuarioLoginDto() {
		super();
	}

	public UsuarioLoginDto(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email.toLowerCase();
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	

}
