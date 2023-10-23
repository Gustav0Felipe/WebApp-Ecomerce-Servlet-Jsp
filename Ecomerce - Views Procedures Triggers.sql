create or replace view view_produtos as
select id_prod "Codigo do Produto", nome_prod as "Nome do produto", desc_prod as "Descricao", custo_prod "Custo", val_prod as "Valor de Venda", qtd_estq as "Estoque",
cod_cat as 'Categoria' from produtos
;

create view view_clientes as
select cod_cli as "Id", nome_cli as "Nome", tel_cli "Telefone", email_cli "Email", cpf_cli "Cpf" from clientes;


create or replace view view_pedidos as
select 
num_ped as "Pedido", nome_cli as "Cliente", data_inicial as "Data Inicial", 
data_final as "Data Final", valor_total as "Valor Total", status_ped as "Status" 
from pedidos 
join clientes on pedidos.cod_cli = clientes.cod_cli
;

insert into categorias values(null, "Comida");
insert produtos values (1, "Biscoito", "É um biscoito de chocolate", 1.00, 1.50, 20, 1);
insert produtos values (2, "Bolacha", "É uma bolacha de agua e sal", 3.00, 4.50, 50, 1);



create procedure pd_cadastro_produto(in nome varchar(75), in descricao varchar(255), in custo decimal(10,2), in valor decimal(10,2), in estoque int) 
insert into produtos values (null, nome, descricao, custo, valor, estoque)
;

delimiter $$
create procedure pd_subir_encomenda(in cliente int, in funcionario int, out NumPedido int)
begin
	insert into pedidos values (null, funcionario, cliente, now(), null, "pendente");
        select last_insert_id() into NumPedido;
end $$
delimiter ;

delimiter $$
create procedure pd_subir_encomenda_itens(in pedido int, in codproduto int,  in quantidade int)
begin
	declare valor decimal(10, 2);
    set valor = (select val_prod from produtos where id_prod = codproduto);
	insert into pedidos_produtos values (codproduto, pedido, quantidade, valor);
end $$
delimiter ;

create procedure pd_finalizar_encomenda(in pedido int)
	update pedidos set data_final = now() where num_ped = pedido;

create procedure pd_user_admin(in usuario varchar(50), in senha varchar(30))
select user_admin as "Nome"
from admin_sistema_loja 
where user_admin = usuario and senha_admin = senha;

create procedure pd_emitir_relatorio(in Ano int, in mes int)
select 
num_ped as "Pedido", nome_cli as "Cliente", data_inicial as "Data Inicial", 
data_final as "Data Final", valor_total as "Valor Total", status_ped as "Status" 
from pedidos 
join clientes on pedidos.cod_cli = clientes.cod_cli
where year(data_final) = ano and month(data_final) = mes
;



delimiter $$
create trigger tr_cadastro_cliente after insert on clientes
for each row
begin
insert into log_cad_cliente 
(cod_cliente_log_cad, data_cadastro_log_cad, new_email_log_cad, new_tel_log_cad, old_cpf_log_cad, tipo_movimentacao)
values(new.cod_cli, now(), new.email_cli, new.tel_cli, new.cpf_cli, "insert");
end
$$
delimiter ;



create procedure pd_user_cliente(in usuario varchar(50), in senha varchar(30))
select clientes.cod_cli, nome_cli, tel_cli, clientes.email_cli, cpf_cli 
from clientes 
join cadastro_cliente_loja cad_cli on clientes.cod_cli = cad_cli.cod_cli 
where cad_cli.email_cli = usuario and pass_cli = senha
;

delimiter $$
create trigger tr_atualiza_estoque before insert on pedidos_produtos
for each row
begin
	select qtd_estq into @qtd_estq from produtos where id_prod = new.id_prod;
	if(new.qtd_prod <= @qtd_estq)then
		select val_prod into @val_prod from produtos where id_prod = new.id_prod; 
		set new.val_prod = @val_prod; -- O valor do produto vai ser sempre o da tabela produtos, não permito alterar o valor na tabela pedidos_produtos.
		update produtos set qtd_estq = qtd_estq - new.qtd_prod where id_prod = new.id_prod;
    else 
		signal sqlstate '45200' set message_text = 'Quantidade Indisponivel em Estoque';
    end if;
end
$$
delimiter ;


delimiter $$
create trigger tr_total_pedido after insert on pedidos_produtos
for each row
begin
	update pedidos set valor_total = valor_total + (new.val_prod * new.qtd_prod) where num_ped = new.num_ped;
end
$$
delimiter ;

delimiter $$
create procedure pd_cadastro_cliente(in nome varchar(255),in tel varchar(20), in email varchar(100), in cpf varchar(255), out idCliente int)
begin
insert into clientes values(null, nome, tel ,email, cpf);
	select last_insert_id() into idCliente;
end $$
delimiter ;



delimiter $$ 
create procedure pd_cadastro_cliente_sistema(in cliente int, in usuario varchar(50), in senha varchar(30))
begin
insert into cadastro_cliente_loja values(cliente, usuario, senha);
end $$
delimiter ;

select * from clientes;
select * from cadastro_cliente_loja;