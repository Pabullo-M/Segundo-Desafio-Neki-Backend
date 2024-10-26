package br.com.Neki_it.CartoesVirtuais.dto;

public class UsuarioLoginResponseDto {
	
	private String token;
	
	

	public UsuarioLoginResponseDto() {
		super();
	}

	public UsuarioLoginResponseDto(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
