package com.compartilhar.escrita.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.compartilhar.escrita.domain.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	// List<Comentario> findByPublicacaoId(int id);

	Page<Comentario> findByPublicacaoId(int id, Pageable pageable);
}
