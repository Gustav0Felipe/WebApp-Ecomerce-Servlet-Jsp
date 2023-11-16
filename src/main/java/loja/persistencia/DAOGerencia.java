package loja.persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import loja.negocio.Produto;
import loja.negocioView.PedidoView;
import loja.util.EcommerceUtil;

public class DAOGerencia {
	
	public static Connection getConnection() throws SQLException {
		String url = EcommerceUtil.get("url");
	
		String usuario = EcommerceUtil.get("usuario");
		String senha = EcommerceUtil.get("senha");

		Connection conexao = DriverManager.getConnection(url, usuario, senha);

		return conexao;
	}
	
	public static void closeConnection(Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				assert false :("ERRO ao fechar conexão: " + e.getMessage());
			}
		}
	}

	/* TODO REFORMULAR ISTO. 
	public static List<Pedido> emitirRelatorio(int ano, int mes) {
		Connection conexao = null;
		String cmd = LojaUtil.get("emitir.relatorio");
		List<Pedido> pedidos = new ArrayList<>();
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			ps.setInt(1, ano);
			ps.setInt(2, mes);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int numeroPedido = rs.getInt("Pedido");
				String nomeFuncionario = rs.getString("Funcionario");
				String nomeCliente = rs.getString("Cliente");
				String dataInicial = rs.getString("Data Inicial");
				String dataFinal = rs.getString("Data Final");
				Double valorTotal = rs.getDouble("Valor Total");				
				String status = rs.getString("Status");
				
				
				Pedido pedido = new Pedido(numeroPedido, nomeFuncionario, nomeCliente, dataInicial, dataFinal, valorTotal, status);
				
				pedidos.add(pedido);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(conexao);
		}
		
		return pedidos;
	}
	*/

	public static void cadastrarUsuario(String user, String pass, String funcionario) {
		Connection conexao = null;
		String cmd = EcommerceUtil.get("cadastro.usuario.sistema");
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			ps.setString(1, funcionario);
			ps.setString(2, user);
			ps.setString(3, pass);
			ps.execute();
		} catch (SQLException e) {
			assert false :("ERRO ao cadastrar usuario: " + e.getMessage());
		}finally {
			closeConnection(conexao);
		}
	}


	//TODO fazer
	public static int cadastrarProduto(Produto produto, int categoria) {
		String cmd = EcommerceUtil.get("cadastro.produto");
		Connection conexao = null;
		int codigo_do_produto = 0;
		try {
			conexao = getConnection();
			CallableStatement cs = conexao.prepareCall(cmd);

			
		
			cs.setString(1, produto.getNome());
			cs.setString(2, produto.getDesc());
			cs.setDouble(3, produto.getCusto());
			cs.setDouble(4, produto.getValor());
			cs.setInt(5, produto.getQtd_estq());
			cs.setInt(6, categoria);
			cs.registerOutParameter("codigo_do_produto", java.sql.Types.INTEGER);
			cs.execute();
			
			codigo_do_produto = cs.getInt("codigo_do_produto");
			
			
		} catch (SQLException e) {
			assert false :("ERRO ao cadastrar produto: " + e.getMessage());
		}finally {
			closeConnection(conexao);
		}
		return codigo_do_produto;
	}
	
	/**
	 * Lista todos os pedidos, para cada pedido vai passar por todos os produtos que tem relação com ele
	 * na tabela de ligação e colocara todos esses produto na lista de produtos de seu respectivo pedido.
	 * 
	 * @return lista de todos os pedidos. 
	 */
	public static List<PedidoView> listarPedidos() {
		Connection conexao = null;
		String cmd = EcommerceUtil.get("listar.pedido");
		String listarProdutos = EcommerceUtil.get("listar.pedido.produtos");

		List<PedidoView> pedidos = new ArrayList<>();
	
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				List<Produto> produtos = new LinkedList<Produto>();
				
				int numeroPedido = rs.getInt("Pedido");
				String nomeCliente = rs.getString("Cliente");
				String dataInicial = rs.getString("Data Inicial");
				String dataFinal = rs.getString("Data Final");
				Double valorTotal = rs.getDouble("Valor Total");				
				String status = rs.getString("Status");
				
				PedidoView pedido = new PedidoView(numeroPedido, nomeCliente, dataInicial, dataFinal, valorTotal, status);
				
				PreparedStatement prods = conexao.prepareStatement(listarProdutos);
				
				prods.setInt(1, numeroPedido);
				
				ResultSet resultProdutos = prods.executeQuery();
				
				while(resultProdutos.next()) {
					Produto produto = new Produto();

					String nomeProduto = resultProdutos.getString("Produto");
					int quantidade = resultProdutos.getInt("Quantidade");
					Double valorUnitario = resultProdutos.getDouble("Valor");
					
					produto.setNome(nomeProduto);
					produto.setQuantidadePedido(quantidade);
					produto.setValor(valorUnitario);
					
					produtos.add(produto);
				}
				
				pedido.setProdutos(produtos);
				pedidos.add(pedido);
			}
			
		} catch (SQLException e) {
			assert false: "ERRO de sql ao listar pedidos:" + e.getMessage();
		}finally {
			closeConnection(conexao);
		}
		
		return pedidos;
	}
	
	
	
	/*TODO Averiguar necessidade.
	public static List<Cliente> listarClientes() {
		Connection conexao = null;
		String cmd = LojaUtil.get("listar.cliente");
		List<Cliente> clientes = new ArrayList<>();
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				
				int id = result.getInt(1);
		
				String nome = result.getString(2);
		
				String telefone = result.getString(3);
				
				String email = result.getString(4);

				String cpf = result.getString(5);
				
				
				Cliente cliente = new Cliente(id, nome, telefone, email, cpf);
			
				clientes.add(cliente);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(conexao);
		}
		return clientes;
	}
	*/
	public static Boolean validarAdmin(String usuario, String senha) {
		Connection conexao = null;
		String admin = EcommerceUtil.get("autenticar.admin");
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(admin);
				ps.setString(1, usuario);
				ps.setString(2, senha);
				
				ResultSet result = ps.executeQuery();
				if(result.next()) {
					String nome = result.getString(1);
					if(nome != null) {
						return true;
					}
				}	
		} catch (SQLException e) {
			assert false: ("ERRO ao validar admin: " + e.getMessage());

		}finally {
			closeConnection(conexao);
			
		}
		return false;
	}
}
