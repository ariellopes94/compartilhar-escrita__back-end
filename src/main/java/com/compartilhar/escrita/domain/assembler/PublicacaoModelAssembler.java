package com.compartilhar.escrita.domain.assembler;

import org.springframework.stereotype.Component;

import com.compartilhar.escrita.domain.Publicacao;
import com.compartilhar.escrita.domain.dto.PublicacaoDtoCurtir;

@Component
public class PublicacaoModelAssembler {

	public PublicacaoDtoCurtir modelPublicacaoToPublicacaoDtoCurtir (Publicacao obj) {
		   PublicacaoDtoCurtir publicacao = new PublicacaoDtoCurtir();
		   
		   publicacao.setId(obj.getId());
		   
		   return publicacao;
	}
}
