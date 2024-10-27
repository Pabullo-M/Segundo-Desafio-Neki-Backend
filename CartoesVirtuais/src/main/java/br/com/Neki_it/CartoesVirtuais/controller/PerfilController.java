package br.com.Neki_it.CartoesVirtuais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Neki_it.CartoesVirtuais.service.PerfilService;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	private PerfilService perfilService;
	
	@GetMapping("/listarTodos")
	public ResponseEntity<?> listarPerfis(){
		
		return perfilService.listarPerfis(); 
	}
}
	
