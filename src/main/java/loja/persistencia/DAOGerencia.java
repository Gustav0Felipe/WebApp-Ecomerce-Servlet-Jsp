package loja.persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import loja.negocio.Pedido;
import loja.negocio.Produto;
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
				e.printStackTrace();
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
			e.printStackTrace();
		}finally {
			closeConnection(conexao);
		}
	}


	//TODO fazer
	public static void cadastrarProduto(List<Produto> produtos) {
		String cmd = EcommerceUtil.get("cadastro.produtos");
		Connection conexao = null;
		
		try {
			conexao = getConnection();
			CallableStatement cs = conexao.prepareCall(cmd);

			
			for(Produto p : produtos) {
				cs.setString(1, p.getNome());
				cs.setString(2, p.getDesc());
				cs.setDouble(3, p.getCusto());
				cs.setDouble(4, p.getValor());
				cs.setInt(5, p.getQtd_estq());
				
				cs.execute();
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(conexao);
		}
	}
	
	
	
	//TODO FAZER
	public static List<Pedido> listarPedidos() {
		Connection conexao = null;
		String cmd = EcommerceUtil.get("listar.pedido");
		List<Pedido> pedidos = new ArrayList<>();
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int numeroPedido = rs.getInt("Pedido");
				String nomeFuncionario = rs.getString("Funcionario");
				String nomeCliente = rs.getString("Cliente");
				String dataInicial = rs.getString("Data Inicial");
				String dataFinal = rs.getString("Data Final");
				Double valorTotal = rs.getDouble("Valor Total");				
				String status = rs.getString("Status");
				
				//Pedido pedido = new Pedido(numeroPedido, nomeFuncionario, nomeCliente, dataInicial, dataFinal, valorTotal, status);
				
				//pedidos.add(pedido);
			}
			
		} catch (SQLException e) {
			assert false: "Problema De Sql em ListarPedidos encomeda:" + e.getCause();
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
			assert false: ("ERRO ao validar admin: " + e.getCause());

		}finally {
			closeConnection(conexao);
			
		}
		return false;
	}
}
