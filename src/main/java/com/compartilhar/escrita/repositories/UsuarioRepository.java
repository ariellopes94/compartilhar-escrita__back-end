package com.compartilhar.escrita.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compartilhar.escrita.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
