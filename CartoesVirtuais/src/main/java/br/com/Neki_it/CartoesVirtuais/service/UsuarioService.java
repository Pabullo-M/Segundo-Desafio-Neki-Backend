package br.com.Neki_it.CartoesVirtuais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.Neki_it.CartoesVirtuais.dto.UsuarioCadastroDto;
import br.com.Neki_it.CartoesVirtuais.mapper.UsuarioMapper;
import br.com.Neki_it.CartoesVirtuais.model.UsuarioModel;
import br.com.Neki_it.CartoesVirtuais.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public ResponseEntity<?> adicionar (UsuarioCadastroDto usuarioCadastroInput) {
		
		try {
			UsuarioModel usuario = usuarioMapper.UsuarioCadastroInputToUsuarioModel(usuarioCadastroInput);
			usuarioRepository.save(usuario);
			return ResponseEntity.ok(usuario);
			
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
	}
}
