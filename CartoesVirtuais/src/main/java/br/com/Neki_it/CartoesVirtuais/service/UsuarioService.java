package br.com.Neki_it.CartoesVirtuais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.Neki_it.CartoesVirtuais.dto.UsuarioCadastroDto;
import br.com.Neki_it.CartoesVirtuais.dto.UsuarioLoginDto;
import br.com.Neki_it.CartoesVirtuais.exception.DatabaseException;
import br.com.Neki_it.CartoesVirtuais.exception.ResourceNotFoundException;
import br.com.Neki_it.CartoesVirtuais.mapper.UsuarioMapper;
import br.com.Neki_it.CartoesVirtuais.model.UsuarioModel;
import br.com.Neki_it.CartoesVirtuais.repository.UsuarioRepository;
import jakarta.validation.Valid;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	public ResponseEntity<?> adicionar (@Valid UsuarioCadastroDto usuarioCadastroInput) {
		
		String senhaEncryp = new BCryptPasswordEncoder().encode(usuarioCadastroInput.getSenha());
		usuarioCadastroInput.setSenha(senhaEncryp);
		try {
			UsuarioModel usuario = usuarioMapper.UsuarioCadastroInputToUsuarioModel(usuarioCadastroInput);
			usuarioRepository.save(usuario);
			return ResponseEntity.ok(usuario);
			
		}catch(ResourceNotFoundException e) {
		
			return ResponseEntity.badRequest().body(e.getMessage());
		
		} catch (DataIntegrityViolationException e) {
			if (e.getMessage().contains("Chave (email)=")) {
				 throw new DatabaseException("O e-mail informado já está em uso. Por favor, escolha outro.", e);
			}
	        throw new DatabaseException("Erro de integridade no banco de dados: " + e.getMessage(), e);
		}	
	}

	public ResponseEntity<?> usuarioLogin(UsuarioLoginDto usuarioLoginDto) {
		// TODO Auto-generated method stub
		return null;
	}
}
