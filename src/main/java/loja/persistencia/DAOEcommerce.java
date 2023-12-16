package loja.persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import loja.negocio.Cliente;
import loja.negocio.Pedido;
import loja.negocio.Produto;
import loja.util.EcommerceUtil;

public class DAOEcommerce {
	
	/**
	 * Abre uma conexão com o banco de dados, pega a url, usuario e senha do mysql através do metodo 
	 * estatico do EcommerceUtil.
	 * 
	 * @return uma conexão.
	 * @throws SQLException 
	 */
	public static Connection getConnection() throws SQLException {
		String url = EcommerceUtil.get("url");
		
		String usuario = EcommerceUtil.get("usuario");
		String senha = EcommerceUtil.get("senha");

		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		return conexao;
	}
	
	/**
	 * Fecha a conexão com o banco de dados.
	 * 
	 * @param conexao 
	 */
	public static void closeConnection(Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				assert false: "ERRO ao fechar conexao: " + e.getMessage();
			}
		}
	}
	
	/**
	 * Pega os dados do cliente no banco de dados caso ele esteja cadastrado nele.
	 * 
	 * @param usuario = email do cliente.
	 * @param senha = senha da conta do cliente.
	 * @return um objeto cliente contendo seus dados ou caso o cliente não tenha sido cadastrado retorna nulo.
	 */
	public static Cliente validarLogin(String usuario, String senha) {
		Connection conexao = null;
		String cmd = EcommerceUtil.get("autenticar.cliente");
		
		Cliente cliente = null;
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
				ps.setString(1, usuario);
				ps.setString(2, senha);
				
				ResultSet result = ps.executeQuery();
				//só tem um registro, pega todas as colunas dele.
				if(result.next()) {
					int id = result.getInt(1);
					String nome = result.getString(2);
					String tel = result.getString(3);
					String email = result.getString(4);
					String cpf = result.getString(5);
					
					cliente = new Cliente(id, nome, tel, email, cpf);
					
					return cliente;
				}	
				
				
		} catch (SQLException e) {
			assert false: "ERRO ao validar login: " + e.getMessage();
		}finally {
			closeConnection(conexao);
		}
		return null;
	}
	
	
	public static Boolean clienteAlreadyExists(String usuario, String cpf) {
		Connection conexao = null;
		String emailCheck = EcommerceUtil.get("autenticar.cliente.email");
		String cpfCheck = EcommerceUtil.get("autenticar.cliente.cpf");
		Boolean existeCliente = true;
		
		try {
			conexao = getConnection();
			PreparedStatement emailConsulta = conexao.prepareStatement(emailCheck);
			emailConsulta.setString(1, usuario);
				
			ResultSet resultEmail = emailConsulta.executeQuery();
			//só tem um registro, pega todas as colunas dele.
			if(resultEmail.next()) {
				return true;
			}else {
				existeCliente = false;
			}
		
			PreparedStatement cpfConsulta = conexao.prepareStatement(cpfCheck);
			cpfConsulta.setString(1, cpf);
			
			ResultSet resultCpf = cpfConsulta.executeQuery();
			if(resultCpf.next()) {
				return true;
			}else {
				existeCliente = false;
			}
			
		} catch (SQLException e) {
			assert false: "ERRO ao validar login: " + e.getMessage();
		}finally {
			closeConnection(conexao);
		}
		return existeCliente;
	}
	
	
	/**
	 * Ao trocar de senha o cliente fornece a senha atual dele para autenticação
	 * este metodo pega a senha fornecida e passa para uma procedure que autentica no banco de dados
	 * retornando true ou false.
	 * 
	 * @param cliente é o id do cliente. 
	 * @param senha é a senha atual que o cliente forneceu.
	 * @return true caso a senha fornecida seja a mesma que esta salva no banco de dados
	 */
	public static Boolean autenticarSenha(int cliente, String senha) {
		Connection conexao = null;
		String cmd = EcommerceUtil.get("autenticar.senha.cliente");
		Boolean autorizar = false;
		
		try {
			conexao = getConnection();
			CallableStatement cs = conexao.prepareCall(cmd);
				cs.setInt(1, cliente);
				cs.setString(2, senha);
				cs.registerOutParameter("autorizar", java.sql.Types.BOOLEAN);
				
				cs.execute();
				autorizar = cs.getBoolean("autorizar");
				
				//só tem um registro, pega todas as colunas dele.	
				return autorizar;
				
		} catch (SQLException e) {
			assert false: "ERRO ao autenticar senha: " + e.getMessage();
		}finally {
			closeConnection(conexao);
		}
		return autorizar;
	}
	
	/**
	 * Cadastra o cliente no banco de dados ultilizando as informações passadas.
	 * 
	 * 
	 * @param nome Nome do cliente
	 * @param email Email do cliente
	 * @param telefone Telefone do cliente (Opcional)
	 * @param cpf Cpf do cliente
	 * @param senha Senha do cliente que vai ser cadastrada em uma tabela de usuarios.
	 */
	public static void cadastrarCliente(String nome, String email, String telefone, String senha, String cpf) {
		Connection conexao = null;
			
		String cmd = EcommerceUtil.get("cadastro.cliente");
		String user = EcommerceUtil.get("cadastro.cliente.sistema");
		
		int idCliente = 0;
		try {
			conexao = getConnection();
			CallableStatement cs = conexao.prepareCall(cmd);
			cs.setString(1, nome);
			cs.setString(2, telefone);
			cs.setString(3, email);
			cs.setString(4, cpf);
			cs.registerOutParameter("idCliente", java.sql.Types.INTEGER);
			
			cs.execute();
			idCliente = cs.getInt("idCliente");
		
			PreparedStatement ps = conexao.prepareStatement(user);
			
			ps.setInt(1, idCliente);
			ps.setString(2, email);
			ps.setString(3, senha);
			
			ps.execute();
			
		}catch (SQLException e) {
			assert false: "ERRO ao tentar fazer o cadastro de cliente: " + e.getMessage();
		}finally {
			closeConnection(conexao);
		}
		
	}

	/**
	 * Atualiza os dados do cliente no banco de dados, só é possivel atualizar nome e telefone.
	 * 
	 * @param cliente = id do cliente.
	 * @param nome = nome do cliente.
	 * @param telefone = telefone do cliente.
	 */
	public static Boolean atualizarDadosCliente(int cliente,String nome, String telefone) {
		
		Connection conexao = null;
	
		String cmd = EcommerceUtil.get("atualizar.dados.cliente");
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			
			ps.setInt(1, cliente);
			ps.setString(2, nome);
			ps.setString(3, telefone);
			
			ps.execute();
			
			return true;
		}catch (SQLException e) {
			assert false: "ERRO ao tentar atualizar os dados de um cliente: " + e.getMessage();
			return false;
		}finally {
			closeConnection(conexao);
		}
	}
	
	/**
	 * Altera a senha do cliente. 
	 * 
	 * @param cliente = id do cliente.
	 * @param senha = nova senha fornecida pelo cliente.
	 */
	public static void atualizarSenhaCliente(int cliente, String senha) {
		
		Connection conexao = null;
	
		String cmd = EcommerceUtil.get("atualizar.senha.cliente");
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			
			ps.setInt(1, cliente);
			ps.setString(2, senha);
			
			ps.execute();
			
		}catch (SQLException e) {
			assert false: "ERRO ao tentar atualizar a senha de um cliente: " + e.getMessage();
		}finally {
			closeConnection(conexao);
		}
	}

	/**
	 * Retorna as credenciais da empresa, usadas para enviar emails aos clientes.
	 * 
	 * @return email e senha da empresa.
	 */
	public static Map<String, String> getCredenciaisEmailEmpresa() {
		
		Connection conexao = null;
		
		String cmd = EcommerceUtil.get("buscar.credenciais.email.empresa");
		String email = "";
		String senha = "";
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				email = rs.getString(1);
				senha = rs.getString(2);
				
				Map<String, String> credenciais = new LinkedHashMap<String, String>();
	
				credenciais.put("email", email);
				credenciais.put("senha", senha);
				
				return credenciais;
			}
			
			}catch (SQLException e) {
				assert false: "ERRO ao tentar obter as credenciais da empresa: " + e.getMessage();
			}finally {
				closeConnection(conexao);
			}
			return null;
		}
	
	
	
	
	
	/**
	 * Lista todos os produtos no banco de dados, porem apenas por id, possivelmente é mais leve do 
	 * que uma lista de Objetos.
	 * 
	 * @return lista de ids dos produtos.
	 */
	public static List<Integer> listarIdProdutos() {
		Connection conexao = null;
		String cmd = EcommerceUtil.get("listar.produto.codigo");
		List<Integer> produtos = new ArrayList<>();
	
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
		
			ResultSet rs = ps.executeQuery();		
			
			while(rs.next()) {
				
				 int codigo = rs.getInt("Codigo");
	
				 produtos.add(codigo);
			}
			
		} catch (SQLException e) {
			assert false: ("ERRO ao listar produtos pelo codigo: " + e.getMessage());
		}finally {
			closeConnection(conexao);
		}
		return produtos;
	}
	
	/**
	 * Busca as informações de um produto especifico.
	 * 
	 * @param idProduto = codigo do produto a ser buscado.
	 * @return um Objeto produto contendo os dados do produto no banco de dados.
	 */
	public static Produto buscarProduto(int idProduto) {
		Connection conexao = null;
		String cmd = EcommerceUtil.get("buscar.produto");
		Produto produto = new Produto();
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			
			ps.setInt(1, idProduto);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int id = rs.getInt("Codigo");
					
				String nome = rs.getString(2);
				
				String desc = rs.getString("Descricao");
	
				int qtd_estq = rs.getInt("Estoque");
				 
				double custo = rs.getDouble("Custo");
				
				double valor = rs.getDouble("Valor");
				 
				String categoria = rs.getString("Categoria");
				 
				produto = new Produto(id, nome, desc, custo, qtd_estq, valor, categoria);
				}
		} catch (SQLException e) {
			assert false: ("ERRO ao buscar produto por codigo: " + e.getMessage());
		}finally{
			closeConnection(conexao);
		}
		return produto;
	}
	


	/**
	 * Inicia um pedido no banco de dados, com o status "PENDENDE", usa 2 procedures do banco de dados,
	 * subir_encomenda inicia o pedido na tabela pedidos usando o id do cliente, e subir_encomenda_itens 
	 * vai na tabela pedidos_produtos e insere todos os produtos com suas quantidades atrelados aquele pedido,
	 * com 2 triggers, uma calculando valor total do pedido e a outra subtraindo a quantidade do 
	 * estoque de cada produto.
	 * 
	 * @param pedido = pedido contendo uma lista dos produtos, quantidade e o cliente.
	 */
	public static void subirEncomenda(Pedido pedido) {
		Connection conexao = null;
		
		String subirEncomenda = EcommerceUtil.get("subir.encomenda");
		String subirEncomendaItens = EcommerceUtil.get("subir.encomenda.itens");
		int numeroPedido = 0;
		
		try {
			conexao = getConnection();
			CallableStatement cs = conexao.prepareCall(subirEncomenda);
			
			cs.setInt(1, pedido.getCliente());
			cs.registerOutParameter("NumPedido", java.sql.Types.INTEGER);
			
			cs.execute();
			numeroPedido = cs.getInt("NumPedido");
			
			CallableStatement csItens = conexao.prepareCall(subirEncomendaItens);
			
			for(int i=0; i< pedido.getProdutos().size(); i = i + 1) {
				csItens.setInt(1, numeroPedido);
				csItens.setInt(2, pedido.getProdutos().get(i).getId());//IdProduto
				csItens.setInt(3, pedido.getProdutos().get(i).getQuantidadePedido());//Quantidade
				csItens.execute();
			}
		} catch (SQLException e) {
			assert false: "ERRO de Sql em Subir encomenda:" + e.getMessage();
		}finally {
		closeConnection(conexao);
		}
	}

	
	/**
	 * Muda o status do pedido de "PENDENTE" para "FINALIZADO".
	 * 
	 * @param idPedido = Numero do pedido.
	 */
	public static void finalizarEncomenda(int idPedido) {
		Connection conexao = null;
		String cmd = EcommerceUtil.get("finalizar.encomenda");		
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			
			ps.setInt(1, idPedido);
			ps.execute();		
		} catch (SQLException e) {
			assert false: "ERRO De Sql em Finalizar encomenda:" + e.getMessage();
		}
	}

}
