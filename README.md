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


<h2>Paginas Direcionadas á usuários</h2>

Pagina Principal:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/62104592-1de2-4b8c-a17d-8480ecd29e52" width="300"></div>

Alteração de dados do usuario:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/3a296947-5a9d-4d1f-ae5e-5eadb9a06c1b" width="300"></div>

Carrinho:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/8d0cb07d-9c9a-4195-92e2-738862471bd9" width="300"></div>

Finalizar Pedido:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/ac460005-f0fe-483a-b471-2c575641a2d8" width="300"></div>

Perfil do usuario:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/8e9a3d3b-7399-465b-ac00-adf11a150298" width="300"></div>

Pagina de mensagens:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/b2afa400-5a1c-4976-bd1e-ddc8a1f094d7)" width="300"></div>

<h2>Paginas direcionadas á funcionarios</h2>

Pagina admin:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/351293a5-9282-4377-b16f-4726b5f44dfd" width="300"></div>

Cadastrar Produto:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/abcc28bf-0f7c-4884-9717-929969ebdf77" width="300"></div>

Listar Pedidos:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/640d82d2-7b40-42b5-b702-045382b6ce77" width="300"></div>

Detalhes de Pedido:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/4af63313-fac5-4eb6-b75e-0cd5ef58a13e" width="300"></div>

Detalhes de Pedido Finalizado:
<div><img src="https://github.com/Gustav0Felipe/WebApp-Ecomerce-Servlet-Jsp/assets/121760776/a26e0148-5949-40c1-bec6-05dca33b827f" width="300"></div>




