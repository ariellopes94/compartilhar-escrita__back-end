package com.compartilhar.escrita.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Publicacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "Título é obrigatório")
	private String titulo;
	
	@NotEmpty(message = "Texto é obrigatório")
	private String texto;
	private int upvote;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPublicacao;

	@OneToOne
	@Cascade(CascadeType.ALL)
	private Usuario usuario;

	// @OneToMany(mappedBy = "publicacao")
	// private List<Comentario> comentarios = new ArrayList<>();

	public Publicacao() {
	}

	public Publicacao(Integer id, String titulo, String texto, int upvote , Usuario usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.texto = texto;
		this.upvote = upvote;
		this.usuario = usuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getUpvote() {
		return upvote;
	}

	public void setUpvote(int upvote) {
		this.upvote = upvote;
	}

	public Date getDataPublicacao() {
		return dataPublicacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/*
	 * public List<Comentario> getComentarios() { return comentarios; }
	 * 
	 * public void setComentarios(List<Comentario> comentarios) { this.comentarios =
	 * comentarios; }
	 */
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacao other = (Publicacao) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
