package com.terrasdevastadas.site.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.terrasdevastadas.site.model.Usuario;

/*
 * Repositorio é um padrão de design, ele recebe os dados do banco de dados e tem como retorno as entidades. 
 * Portanto, a anotação @Repository indica que essa classe é um repositório. 
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { // JpaRepository é basicamente uma extensão do CrudRepository e algumas coisas mais.
	// Basicamente ele faz algumas coisas de forma automática como busca e atualização, por exemplo.
	
	List<Usuario> findAll();
	
	void deleteById(Long id);
	
	Optional<Usuario> findByEmail(String email);
	
	//findById
	//findAllById

}
