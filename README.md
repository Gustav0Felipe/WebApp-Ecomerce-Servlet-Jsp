# WebApp-Ecomerce-Servlet-Jsp
Projeto Java - Fazendo um Ecommerce com Servlets e JSP's


## O que foi feito até agora:

- Pagina inicial funcionando.

- Pagina dinamica de compra funcionando, ao clicar na imagem de um produto uma pagina com as informações daquele produto e a opção de adicionar ao carrinho é criada.

- Carrinho funcionando, persistencia de produtos usando o id da sessão esta funcionando.

- Pagina de cadastro e login adicionadas e funcionando.

- Estilização concluida.

- Comecei a usar include nas JSP's.

- Agora ao pegar os produtos no banco de dados armazenar apenas os ids para carregar dinamicamente as imagens ao invés de um objeto Produto, ao clicar em um produto que o Objeto sera criado.

- Subi no github os scripts do banco de dados que fiz.

- Ao finalizar a compra na pagina carrinho o pedido é subido no banco de dados, com calculo de estoque restante de cada produto e valor total do pedido feitos por trigger.

- O cliente ao logar e ir no perfil pode alterar seus dados, apenas é permitido alterar nome, telefone e senha.

- Ao querer alterar senha necessario fornecer a senha atual, que sera validada para checar se corresponde a que foi cadastrada no banco de dados.

- Após isto o sistema pega as credenciais da empresa e as usa para mandar ao cliente um email com o link para alteração de senha para confirmar que ele que solicitou.

- Ao clicar no link o sistema checa se o token de autenticação esta certo e então o cliente tem acesso a pagina de alteração de senha, onde ele passa o novo valor que sera atualizado no banco de dados.

- Mensagens colocadas em algumas JSP's para notificar o usuario, como uma mensagem caso a senha passada na troca de senha seja invalida.

- Agora é possivel fazer login como admin, feita a validação libera a opção de cadastrar um produto, passando uma imagem que vai ser associada a este produto e guardada na pasta imagens dentro de metadata, que sera mostrada na pagina principal.

- Possivel listar pedidos em /admin/pedidos, caso não tenha logado como admin sera redirecionado a pagina de login.

- Na lista de pedidos agora é possivel abrir os detalhes de pedidos especificos.

- Ao abrir os detalhes do pedido existe a opção de finaliza-lo, a data final sera colocada como a data atual, e o status mudara para finalizado.

## Á fazer:

- Dinamismo com Javascript.

- Terminar a logica de negocio da compra, calculo de frete, botões 

- Ajustar CSS para diferentes tamanhos de tela.

<h2>Caso de uso efetuar compra:</h2>

[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/G7SVrrwB88s/0.jpg)](https://www.youtube.com/watch?v=G7SVrrwB88s)


<h2>Caso de uso Cliente ao se cadastrar:</h2>

[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/wle2WkDqmH0/0.jpg)](https://www.youtube.com/watch?v=wle2WkDqmH0)
