package com.compartilhar.escrita.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.compartilhar.escrita.domain.Publicacao;
import com.compartilhar.escrita.repositories.PublicacaoRepository;
import com.compartilhar.escrita.services.exceptions.ObjectNotFoundException;

@Service
public class PublicacaoService {
	
	@Autowired
	private PublicacaoRepository publicacaoRepository;
	
	
	public Publicacao create(Publicacao publicacao) {
		publicacao.setId(null);
		return  publicacaoRepository.save(publicacao);
	}
	
	@Transactional
	public List<Publicacao> findAll(){
		 List<Publicacao> obj = publicacaoRepository.findAll();
		 if(obj == null) {
		    throw new ObjectNotFoundException("Não contem publicações");
		 }
		 return obj;
	}
	
	public Publicacao curtirComentario(int id) {
		
		Publicacao publicacao = new Publicacao();
		
		publicacao = findById(id);
		
		verificarExistencia(publicacao.getId());
		
		publicacao.setUpvote(publicacao.getUpvote() + 1);
		return publicacaoRepository.save(publicacao);
	}
	
	@Transactional
	public Publicacao findById(int id) {
		 Optional<Publicacao> obj = publicacaoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Publicação não encontrado"));
	}
	
	@Transactional
	public void verificarExistencia(int id) {
		Optional<Publicacao> obj = publicacaoRepository.findById(id);
		
		if(obj == null) {
			throw new ObjectNotFoundException("Publicação Não Existe");
		}
	}
}
