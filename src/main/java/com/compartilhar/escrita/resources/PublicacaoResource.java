package com.compartilhar.escrita.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.compartilhar.escrita.domain.Publicacao;
import com.compartilhar.escrita.domain.assembler.PublicacaoModelAssembler;
import com.compartilhar.escrita.domain.dto.PublicacaoDtoCurtir;
import com.compartilhar.escrita.services.PublicacaoService;

@CrossOrigin //Resolvendo error de cross-origin local
@RestController
@RequestMapping(value = "publicacao")
public class PublicacaoResource {
	
	@Autowired
	private PublicacaoService publicacaoService;
	
	@Autowired
	private PublicacaoModelAssembler publicacaoModelAssembler;
	
	@PostMapping
	public ResponseEntity<Publicacao> create( @RequestBody Publicacao publicacao){
		Publicacao obj = publicacaoService.create(publicacao);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(obj.getId()).toUri();
	
		return ResponseEntity.created(uri).build();
	}
	
	
	@PostMapping(value="like")
	public PublicacaoDtoCurtir curtirComentario(@RequestBody PublicacaoDtoCurtir publicacaoDtoCurtir) {
		
		
		Publicacao publicacao = publicacaoService.curtirComentario(publicacaoDtoCurtir.getIdPublicacao());
		PublicacaoDtoCurtir publicacaoCurtir = publicacaoModelAssembler.modelPublicacaoToPublicacaoDtoCurtir(publicacao);
		
		return publicacaoCurtir;
		
	}
	
	
	@GetMapping
	public List<Publicacao> findByAll(){
		return publicacaoService.findAll();
	}

}
