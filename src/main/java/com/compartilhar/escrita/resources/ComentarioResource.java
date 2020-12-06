package com.compartilhar.escrita.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compartilhar.escrita.domain.Comentario;
import com.compartilhar.escrita.domain.Publicacao;
import com.compartilhar.escrita.domain.dto.ComentarioDto;
import com.compartilhar.escrita.repositories.ComentarioRepository;
import com.compartilhar.escrita.services.ComentarioService;
import com.compartilhar.escrita.services.PublicacaoService;

@CrossOrigin //Resolvendo error de cross-origin local
@RestController
@RequestMapping(value = "comentario")
public class ComentarioResource {
	
	@Autowired
	private ComentarioService comentarioService;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@PostMapping
	public ResponseEntity<Comentario> create(@Valid @RequestBody ComentarioDto comentarioDto){
		
		Comentario obj = comentarioService.create(comentarioDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	//@PageableDefault(size = 5, sort = "dataPublicacao", direction = Direction.DESC)
	@GetMapping(value = "buscar/{id}")
	public Page<Comentario> buscarComentarioPorPublicacao(@PageableDefault(size = 2, sort = "id", direction = Direction.DESC)Pageable pageable, @PathVariable int id){
		Page<Comentario> publicacaoPage  = comentarioRepository.findByPublicacaoId(id, pageable);
		List<Comentario> comentarioModel = publicacaoPage.getContent();
		Page<Comentario> comentarioModelPage = new PageImpl<>(comentarioModel, pageable,
				publicacaoPage.getTotalElements());
		return comentarioModelPage;
	}

}
