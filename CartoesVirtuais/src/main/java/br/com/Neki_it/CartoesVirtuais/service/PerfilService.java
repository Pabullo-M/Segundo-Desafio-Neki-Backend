package br.com.Neki_it.CartoesVirtuais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.Neki_it.CartoesVirtuais.dto.PerfilAtualizarDto;
import br.com.Neki_it.CartoesVirtuais.dto.PerfilCadastroDto;
import br.com.Neki_it.CartoesVirtuais.exception.DatabaseException;
import br.com.Neki_it.CartoesVirtuais.exception.ResourceNotFoundException;
import br.com.Neki_it.CartoesVirtuais.mapper.PerfilMapper;
import br.com.Neki_it.CartoesVirtuais.model.PerfilModel;
import br.com.Neki_it.CartoesVirtuais.repository.PerfilRepository;
import jakarta.validation.Valid;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private PerfilMapper perfilMapper;
	
	public ResponseEntity<?> listarPerfis(){
		
		try{
			List<PerfilModel> listaPerfis = perfilRepository.findAll();
			if(listaPerfis.isEmpty()) {
				throw new  ResourceNotFoundException("Não existem Perfis cadastrados.");
			}
			
			return ResponseEntity.ok(listaPerfis);
			
		}catch(DataIntegrityViolationException e) {
			
			throw new DatabaseException("Erro de integridade no banco de dados: " + e.getMessage(), e);
		}
		
	}

	public ResponseEntity<?> adicionarPerfil(@Valid PerfilCadastroDto perfilCadastroDto) {
		try {
			PerfilModel perfil = perfilMapper.PerfilCadastroDtoToPerfilModel(perfilCadastroDto);
			perfilRepository.save(perfil);
		}catch(ResourceNotFoundException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		
		} catch (DataIntegrityViolationException e) {
			if (e.getMessage().contains("Chave (email)=")) {
				 throw new DatabaseException("O e-mail informado já está em uso. Por favor, escolha outro.", e);
			}
	        throw new DatabaseException("Erro de integridade no banco de dados: " + e.getMessage(), e);
		}	
		
		
		return null;
	}

	public ResponseEntity<?> listarPerfilPorId(Long id) {
		try {
			Optional<PerfilModel> perfil = perfilRepository.findById(id);
			if(perfil.isEmpty()) {
				throw new  ResourceNotFoundException("Não existe Perfil cadastrado com id: " + id);
			}
			return ResponseEntity.ok(perfil);
		}catch(DataIntegrityViolationException e) {
			
			throw new DatabaseException("Erro de integridade no banco de dados: " + e.getMessage(), e);
		}
	}

	public ResponseEntity<?> deletarPerfil(Long id) {
		try {
			if(!perfilRepository.existsById(id)) {
				 throw new ResourceNotFoundException("Perfil com id " + id + " não encontrado.");
			}
			perfilRepository.deleteById(id);
			return ResponseEntity.ok("Perfil de id: " + id + " deletado com sucesso!!" );
		}catch(ResourceNotFoundException e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		
		}catch(DataIntegrityViolationException e) {
			
			throw new DatabaseException("Erro de integridade no banco de dados: " + e.getMessage(), e);
		}
	}

	public ResponseEntity<?> atualizarPerfil(PerfilAtualizarDto perfilAtualizarDto, Long id) {
		try {
			 return perfilRepository.findById(id)
					.map(perfil -> {	
						
						perfilMapper.AtualizaPerfil(perfilAtualizarDto, perfil);
						perfilRepository.save(perfil);
						
						return ResponseEntity.ok("Perfil atualizado com sucesso.");
					}).orElseGet(()-> ResponseEntity.status(HttpStatus.NOT_FOUND)
							.body("Perfil com ID " + id + " não encontrado."));
		} catch (DataIntegrityViolationException e) {
			if (e.getMessage().contains("Chave (email)=")) {
				 throw new DatabaseException("O e-mail informado já está em uso. Por favor, escolha outro.", e);
			}
	        throw new DatabaseException("Erro de integridade no banco de dados: " + e.getMessage(), e);
		}	
	}
}
