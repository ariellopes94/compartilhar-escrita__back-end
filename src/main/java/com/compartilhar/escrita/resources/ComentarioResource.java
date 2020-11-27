package com.compartilhar.escrita.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compartilhar.escrita.domain.Comentario;
import com.compartilhar.escrita.domain.Publicacao;
import com.compartilhar.escrita.domain.dto.ComentarioDto;
import com.compartilhar.escrita.services.ComentarioService;
import com.compartilhar.escrita.services.PublicacaoService;

@CrossOrigin //Resolvendo error de cross-origin local
@RestController
@RequestMapping(value = "comentario")
public class ComentarioResource {
	
	@Autowired
	private ComentarioService comentarioService;
	
	
	@PostMapping
	public ResponseEntity<Comentario> create( @RequestBody ComentarioDto comentarioDto){
		
		
		Comentario obj = comentarioService.create(comentarioDto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	

}
