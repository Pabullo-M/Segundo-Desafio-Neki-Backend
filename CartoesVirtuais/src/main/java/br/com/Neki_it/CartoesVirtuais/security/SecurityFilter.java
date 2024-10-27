package br.com.Neki_it.CartoesVirtuais.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.Neki_it.CartoesVirtuais.repository.UserDetailsRepository;
import br.com.Neki_it.CartoesVirtuais.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserDetailsRepository repository;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	        throws ServletException, IOException {
		System.out.println(request.getHeader("Authorization"));
	    String token = recuperarToken(request);
	    
	    if (token != null) {
	        try {
	            String email = tokenService.validacaoToken(token); 
	            UserDetails usuario = repository.findByEmail(email);
	            if (usuario != null) {
	                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
	                SecurityContextHolder.getContext().setAuthentication(authentication);
	                System.out.println("Usuário autenticado: " + usuario.getUsername()); 
	            } else {
	                System.out.println("Usuário não encontrado com o token."); 
	            }
	        } catch (Exception e) {
	            System.out.println("Erro na validação do token: " + e.getMessage()); 
	        }
	    } else {
	        System.out.println("Token não encontrado.");
	    }
	    
	    filterChain.doFilter(request, response);
	}
	private String recuperarToken(HttpServletRequest request) {
	    String authHeader = request.getHeader("Authorization");
	    System.out.println("aqui " + authHeader + request.toString());
	    if (authHeader != null && authHeader.startsWith("Bearer ")) {
	        return authHeader.replace("Bearer ", "");
	    }
	    return null;
	}

}

