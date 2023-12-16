create database ecommerce;
 
use ecommerce;

create table clientes(
	cod_cli int auto_increment,
    nome_cli varchar(255) not null,
    tel_cli varchar(20),
    email_cli varchar(100) unique not null,
    cpf_cli varchar(20),
    
    primary key(cod_cli)
);

create table cadastro_cliente_loja(
	cod_cli int,
    email_cli varchar(100) unique not null,
    pass_cli varchar(30) not null,
    
    constraint pk_cadcli_1 primary key(cod_cli),
    constraint fk_cadcli_1 foreign key(email_cli) references clientes (email_cli)
);


create table pedidos(
		num_ped int not null auto_increment,
        cod_cli int not null,
        data_inicial datetime not null,
        data_final datetime,
        status_ped varchar(30),
        valor_total decimal(10,2) default(0),
        
        constraint pk_ped primary key(num_ped),
        constraint fk_ped_2 foreign key(cod_cli) references clientes (cod_cli)
);

create table categorias(
	cod_cat int auto_increment,
    nome_cat varchar(20) unique,
    
    primary key (cod_cat)
);


create table produtos(
	id_prod int not null auto_increment,
    nome_prod varchar(75) not null unique,
    desc_prod varchar(255) not null,
    custo_prod decimal(10,2) not null,
    val_prod decimal(10,2) not null,
    qtd_estq int not null,
    cod_cat int, 
    
    constraint pk_prod primary key(id_prod),
    
    constraint fk_prod foreign key(cod_cat) references categorias(cod_cat),
    
	constraint ch_prod_1 check(val_prod>=0),

	constraint ch_prod_2 check(qtd_estq>=0)
);

create table pedidos_produtos(
	id_prod int,
    num_ped int,
    qtd_prod int, 
    val_prod decimal(10, 2),
    
    constraint pk_pedprod primary key(id_prod, num_ped),
    constraint fk_pedprod_1 foreign key(id_prod) references produtos (id_prod),
    constraint fk_pedprod_2 foreign key(num_ped) references pedidos(num_ped)
);



create table log_cad_cliente(
	id_log_cad int auto_increment,
	cod_cliente_log_cad int not null,
    data_cadastro_log_cad datetime,
	old_email_log_cad varchar(100),
    old_tel_log_cad varchar(20),
    old_cpf_log_cad varchar(20),
	new_email_log_cad varchar(100),
    new_tel_log_cad varchar(20),
    tipo_movimentacao varchar(20) not null,
    
    primary key (id_log_cad),
	foreign key (cod_cliente_log_cad) references clientes (cod_cli)
);

select * from log_cad_cliente;

create table admin_sistema_loja (
	cod_admin int auto_increment,
    user_admin varchar(50) not null unique,
    senha_admin varchar(30) not null,
    
    primary key (cod_admin)
    
);
insert admin_sistema_loja values(null, "admin@hotmail.com", "123");


create table credenciamento_email_empresa(
	email_empresa varchar(100),
    senha_empresa varchar(30),

	primary key(email_empresa, senha_empresa)
);




select * from clientes;
select * from view_pedidos;

select cod_cli "Id do Cliente", nome_cli "Nome",email_cli "Email", tel_cli "Telefone", cpf_cli "CPF" 
from clientes where cod_cli > 12 and cod_cli not in(25,26);

select * from cadastro_cliente_loja;
select * from log_cad_cliente;
select * from pedidos_produtos order by num_ped;
select num_ped "Numero do Pedido", clientes.cod_cli "Id do Cliente", nome_cli "Nome", 
		data_inicial "Data Inicial", data_final "Data Final", status_ped "Status", valor_total "Total" 
        from pedidos join clientes on clientes.cod_cli = pedidos.cod_cli;
select * from produtos order by nome_prod;
select * from admin_sistema_loja;
select * from credenciamento_email_empresa;
select * from categorias;


select * from pedidos;

select cod_cli "Id do Cliente", nome_cli "Nome",email_cli "Email", tel_cli "Telefone", cpf_cli "CPF" 
from clientes where cod_cli > 12 and cod_cli not in(25,26);

