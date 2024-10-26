package br.com.Neki_it.CartoesVirtuais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Neki_it.CartoesVirtuais.dto.UsuarioLoginDto;
import br.com.Neki_it.CartoesVirtuais.service.UsuarioService;

@RestController
@RequestMapping("/login")
public class UsuarioLoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	public ResponseEntity<?> usuariologin(UsuarioLoginDto usuarioLoginDto) {
		
		return usuarioService.usuarioLogin(usuarioLoginDto);
	}
	
}
