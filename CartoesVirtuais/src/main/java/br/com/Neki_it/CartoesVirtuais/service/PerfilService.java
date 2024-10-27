package br.com.Neki_it.CartoesVirtuais.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.Neki_it.CartoesVirtuais.exception.DatabaseException;
import br.com.Neki_it.CartoesVirtuais.exception.ResourceNotFoundException;
import br.com.Neki_it.CartoesVirtuais.model.PerfilModel;
import br.com.Neki_it.CartoesVirtuais.repository.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository perfilRepository;
	
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
}
