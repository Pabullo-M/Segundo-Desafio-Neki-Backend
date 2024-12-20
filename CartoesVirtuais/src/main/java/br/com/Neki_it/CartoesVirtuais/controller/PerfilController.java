package br.com.Neki_it.CartoesVirtuais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Neki_it.CartoesVirtuais.dto.PerfilAtualizarDto;
import br.com.Neki_it.CartoesVirtuais.dto.PerfilCadastroDto;
import br.com.Neki_it.CartoesVirtuais.service.PerfilService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/perfil")
public class PerfilController {

	@Autowired
	private PerfilService perfilService;
	
	@GetMapping("/listarTodos")
	public ResponseEntity<?> listarPerfis(){
		
		return perfilService.listarPerfis(); 
	}
	
	@GetMapping("/publico/{id}")
	public ResponseEntity<?> listarPerfilPorId(@PathVariable Long id){
		
		return perfilService.listarPerfilPorId(id); 
	}

	@PostMapping
	public ResponseEntity<?> adicionarPerfil(@RequestBody @Valid PerfilCadastroDto perfilCadastroDto){
		
		return perfilService.adicionarPerfil(perfilCadastroDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarPerfil(@PathVariable Long id){
		
		return perfilService.deletarPerfil(id);
	}
	
	@PutMapping("/atualizar/{id}")
	public ResponseEntity<?> atualizarPerfil(@RequestBody @Valid PerfilAtualizarDto perfilAtualizarDto, @PathVariable Long id){
		
		return perfilService.atualizarPerfil(perfilAtualizarDto, id);
	}
	
}
	
