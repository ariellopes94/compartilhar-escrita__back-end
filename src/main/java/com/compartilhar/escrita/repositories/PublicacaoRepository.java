package com.compartilhar.escrita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compartilhar.escrita.domain.Publicacao;

public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer>{

}
