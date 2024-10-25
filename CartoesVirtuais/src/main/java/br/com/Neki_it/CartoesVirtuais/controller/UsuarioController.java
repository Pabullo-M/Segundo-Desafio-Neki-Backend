package br.com.Neki_it.CartoesVirtuais.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Neki_it.CartoesVirtuais.dto.UsuarioCadastroDto;
import br.com.Neki_it.CartoesVirtuais.mapper.UsuarioMapper;
import br.com.Neki_it.CartoesVirtuais.model.UsuarioModel;
import br.com.Neki_it.CartoesVirtuais.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController  {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@PostMapping
	public UsuarioModel adicionar (@RequestBody @Valid UsuarioCadastroDto usuarioCadastroInput) {
		
		UsuarioModel usuario = usuarioMapper.UsuarioCadastroInputToUsuarioModel(usuarioCadastroInput);
		usuarioRepository.save(usuario);
		return usuario;
	}
}
