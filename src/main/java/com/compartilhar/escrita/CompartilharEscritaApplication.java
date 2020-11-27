package com.compartilhar.escrita;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.compartilhar.escrita.domain.Comentario;
import com.compartilhar.escrita.domain.Publicacao;
import com.compartilhar.escrita.domain.Usuario;
import com.compartilhar.escrita.repositories.ComentarioRepository;
import com.compartilhar.escrita.repositories.PublicacaoRepository;
import com.compartilhar.escrita.repositories.UsuarioRepository;

@SpringBootApplication
public class CompartilharEscritaApplication implements CommandLineRunner  {

	public static void main(String[] args) {
		SpringApplication.run(CompartilharEscritaApplication.class, args);
	}
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PublicacaoRepository publicacaoReposiory;
	
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
     /*
		//Criar Usuario
		Usuario usuario = new Usuario();
		
		//Usuario 01
		usuario.setNome("Ariel");
		//Salvar Usuario
		usuarioRepository.save(usuario);
		
		
		

		//Criar Comentario
		Comentario comentario = new Comentario();
		comentario.setComentario("OTIMO ADOREI");
		
		Comentario comentario2 = new Comentario();
		comentario.setComentario("OTIMO ADOREI");
		
		
		
		
		
		//Criar Publicação
		Publicacao publicacao = new Publicacao();
		
		//Publicacao 01
		publicacao.setTitulo("São Paulo");
		publicacao.setTexto("Um time que joga por AMOR e na raça, time muito bom");
		publicacao.setDataPublicacao(new Date());
		publicacao.setUsuarios(usuario);
		
		publicacao.getComentarios().add(comentario);
		//Salvar Publicaçao
		publicacaoReposiory.save(publicacao);
		
		//Criar Publicação
		Publicacao publicacao2 = new Publicacao();
		
		//Publicacao 01
		publicacao2.setTitulo("São Paulo");
		publicacao2.setTexto("Um time que joga por AMOR e na raça, time muito bom");
		publicacao2.setDataPublicacao(new Date());
		publicacao2.setUsuarios(usuario);
		//Salvar Publicacao
		publicacaoReposiory.save(publicacao);	
		
		*/
	}

	
	

}
