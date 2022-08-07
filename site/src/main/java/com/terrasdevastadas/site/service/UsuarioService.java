package com.terrasdevastadas.site.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.terrasdevastadas.site.dto.UsuarioDTO;
import com.terrasdevastadas.site.model.Usuario;
import com.terrasdevastadas.site.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	 public List<Usuario> getAllUsuarios(){

	        return usuarioRepository.findAll();
	    }
	 
	 public Optional<Usuario> getById(Long id){

	        return usuarioRepository.findById(id);
	    }
	 
	 
	 public Usuario CadastrarUsuario(UsuarioDTO usuarioDTO) {
	       Optional<Usuario> usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail());

	        if (usuario.isPresent()) {
	            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Esse e-mail já está sendo utilizado");
	        } else {
	            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	            usuarioDTO.setSenha(encoder.encode(usuarioDTO.getSenha()));

	            Usuario novoUsuario = new Usuario();
	            		
	            novoUsuario.setNome(usuarioDTO.getNome());
	            novoUsuario.setEmail(usuarioDTO.getEmail());
	            novoUsuario.setSenha(usuarioDTO.getSenha());

	            return usuarioRepository.save(novoUsuario);
	        }
	    }
	 
	  
	 public Usuario update(Usuario usuario, Long id){

		 Usuario newUsuario = usuarioRepository.findById(id).get();

	        usuario.setId(newUsuario.getId());

	        return usuarioRepository.save(usuario);
		}
	  
	 
	  public void delete (Long id){

	        usuarioRepository.deleteById(id);
	   }

}
