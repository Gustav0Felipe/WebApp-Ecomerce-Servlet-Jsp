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

## Á fazer:

- Dinamismo com Javascript e pagina para que o admin possa fazer consultas e adição de novos produtos.

- Terminar a logica de negocio da compra, calculo de frete, botões e permitir ao entregador finalizar o pedido.

- Ajustar CSS para diferentes tamanhos de tela.


 