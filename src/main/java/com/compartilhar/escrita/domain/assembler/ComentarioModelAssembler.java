package com.compartilhar.escrita.domain.assembler;

import org.springframework.stereotype.Component;

import com.compartilhar.escrita.domain.Comentario;
import com.compartilhar.escrita.domain.dto.ComentarioDto;

@Component
public class ComentarioModelAssembler {

	public Comentario modelComentarioDtoToComentario (ComentarioDto obj) {
		
		   Comentario comentario = new Comentario();
		   
		   comentario.setComentario(obj.getComentario());
		   return comentario;
	}
}
