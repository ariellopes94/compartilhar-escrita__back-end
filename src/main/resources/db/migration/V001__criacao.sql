
CREATE table usuario (
	id bigint not null auto_increment,
    nome varchar(255), 
primary key (id)
)engine=InnoDB default charset=utf8;

CREATE table comentario (
   id bigint not null auto_increment,
   comentario varchar(455),
   publicacao_id integer,
   usuario_id integer,
primary key (id)
) engine=InnoDB default charset=utf8;

CREATE table publicacao (
	id bigint not null auto_increment,
    data_publicacao timestamp, 
    texto varchar(800), 
    titulo varchar(255), 
    upvote integer not null, 
    usuario_id integer, 
primary key (id)
) engine=InnoDB default charset=utf8;
