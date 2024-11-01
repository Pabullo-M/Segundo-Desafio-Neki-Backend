package br.com.Neki_it.CartoesVirtuais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Neki_it.CartoesVirtuais.dto.UsuarioLoginDto;
import br.com.Neki_it.CartoesVirtuais.service.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class UsuarioLoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@CrossOrigin(origins = "http://localhost:5173")
	@PostMapping
	public ResponseEntity<?> usuariologin(@RequestBody @Valid UsuarioLoginDto usuarioLoginDto) {
		
		System.out.println(usuarioLoginDto.getEmail() + usuarioLoginDto.getSenha());
		return usuarioService.usuarioLogin(usuarioLoginDto);
	}
	
}
