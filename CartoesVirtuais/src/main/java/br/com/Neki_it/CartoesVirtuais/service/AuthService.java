package br.com.Neki_it.CartoesVirtuais.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.Neki_it.CartoesVirtuais.repository.UserDetailsRepository;

@Service
public class AuthService implements UserDetailsService{
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	 @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        UserDetails userDetails = userDetailsRepository.findByEmail(email);
	        if (userDetails == null) {
	            throw new UsernameNotFoundException("Não foi encontrado o usuário com e-mail: " + email);
	        }
	        return userDetails;
	    }
}
