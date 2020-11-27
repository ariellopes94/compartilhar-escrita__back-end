package com.compartilhar.escrita.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compartilhar.escrita.domain.Comentario;
import com.compartilhar.escrita.domain.Publicacao;
import com.compartilhar.escrita.repositories.ComentarioRepository;
import com.compartilhar.escrita.repositories.PublicacaoRepository;

@Service
public class ComentarioService {
	
	@Autowired
	ComentarioRepository comentarioRepository;
	
	@Autowired
	PublicacaoService publicacaoService;

	public Comentario create(Comentario comentario) {
		comentario.setId(null);
		
		//TESTE
		comentario.setPublicacao(publicacaoService.findById(1));
		
		return  comentarioRepository.save(comentario);
	}
}
