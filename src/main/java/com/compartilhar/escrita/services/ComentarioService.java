package com.compartilhar.escrita.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compartilhar.escrita.domain.Comentario;
import com.compartilhar.escrita.domain.Publicacao;
import com.compartilhar.escrita.domain.assembler.ComentarioModelAssembler;
import com.compartilhar.escrita.domain.dto.ComentarioDto;
import com.compartilhar.escrita.repositories.ComentarioRepository;
import com.compartilhar.escrita.repositories.PublicacaoRepository;

@Service
public class ComentarioService {
	
	@Autowired
	ComentarioRepository comentarioRepository;
	
	@Autowired
	PublicacaoService publicacaoService;
	
	@Autowired
	ComentarioModelAssembler comentarioModelAssembler;

	public Comentario create(ComentarioDto comentarioDto) {
		
		Comentario comentario = new Comentario();
		
		comentario = comentarioModelAssembler.modelComentarioDtoToComentario(comentarioDto);
		
		
		comentario.setId(null);
		
		
		
		
		
		//TESTE
		comentario.setPublicacao(publicacaoService.findById(comentarioDto.getIdPublicacao()));
		
		return  comentarioRepository.save(comentario);
	}
}
