package br.com.Neki_it.CartoesVirtuais.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.Neki_it.CartoesVirtuais.model.UsuarioModel;

public interface UserDetailsRepository extends JpaRepository<UsuarioModel, Long>{

	UserDetails findByEmail(String email);
	
}
