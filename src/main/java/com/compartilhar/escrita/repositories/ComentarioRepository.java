package com.compartilhar.escrita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compartilhar.escrita.domain.Comentario;


public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

}
