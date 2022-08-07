package com.terrasdevastadas.site.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/*
 * Classes DTOS são criadas para fazer transferência de dados. Ao invés de utilizar o model que criei para o usuário, fiz um dto porque posso omitir algumas informações que 
 * não são necessárias serem mostradas no front-end, como o ID, por exemplo, o qual foi omitido daqui.
 */
public class UsuarioDTO {
	
	
	@NotNull
	private String nome;
	
	@NotNull
	@Email 
	private String email;
	
	@NotNull
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
