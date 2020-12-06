package com.compartilhar.escrita.domain.dto;

import javax.validation.constraints.NotEmpty;

import com.compartilhar.escrita.domain.Usuario;

public class ComentarioDto {

	@NotEmpty(message = "Comentario é obrigatório")
	private String comentario;
	private int idPublicacao;

	private Usuario usuario;

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getIdPublicacao() {
		return idPublicacao;
	}

	public void setIdPublicacao(int idPublicacao) {
		this.idPublicacao = idPublicacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
