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
import loja.util.LojaUtil;

public class DAOLoja {

	public static Connection getConnection() throws SQLException {
		String url = LojaUtil.get("url");
		String usuario = LojaUtil.get("usuario");
		String senha = LojaUtil.get("senha");

		Connection conexao = DriverManager.getConnection(url, usuario, senha);
		return conexao;
	}
	
	public static void closeConnection(Connection conexao) {
		if (conexao != null) {
			try {
				conexao.close();
			} catch (SQLException e) {
				assert false: ("ERRO ao fechar conexão: " + e.getCause());
			}
		}
	}
	
	
	public static List<Produto> listarProdutos() {
		Connection conexao = null;
		String cmd = LojaUtil.get("listar.produto");
		List<Produto> produtos = new ArrayList<>();
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
		
			ResultSet rs = ps.executeQuery();		
			
			while(rs.next()) {
				 int id = rs.getInt("Codigo_do_Produto");
				
				 String nome = rs.getString("Nome_do_produto");
				
				 String desc = rs.getString("Descricao");

				 int qtd_estq = rs.getInt("Estoque");
				 
				 double custo = rs.getDouble("Custo");
				
				 double valor = rs.getDouble("Valor_de_Venda");
				 
				 String categoria = rs.getString("Categoria");
				 
				 Produto produto = new Produto(id, nome, desc, custo, qtd_estq, valor, categoria);
				 
				 produtos.add(produto);
			}
		} catch (SQLException e) {
			assert false: ("ERRO ao listar produtos: " + e.getCause());
		}finally {
			closeConnection(conexao);
		}
		return produtos;
	}
	
	
	public static List<String> listarNomeProdutos() {
		Connection conexao = null;
		String cmd = LojaUtil.get("listar.produto.nomes");
		List<String> produtos = new ArrayList<>();
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
		
			ResultSet rs = ps.executeQuery();		
			
			while(rs.next()) {
				
				 String nome = rs.getString("Nome_do_produto");

				 produtos.add(nome);
			}
			
		} catch (SQLException e) {
			assert false: ("ERRO ao listar produtos pelo nome: " + e.getCause());
		}finally {
			closeConnection(conexao);
		}
		return produtos;
	}
	
	public static Produto buscarProduto(String nomeProd) {
		Connection conexao = null;
		String cmd = LojaUtil.get("buscar.produto");
		Produto produto = new Produto();
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			
			ps.setString(1, nomeProd);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				 int id = rs.getInt("Codigo_do_Produto");
					
				 String nome = rs.getString(2);
				
				 String desc = rs.getString("Descricao");

				 int qtd_estq = rs.getInt("Estoque");
				 
				 double custo = rs.getDouble("Custo");
				
				 double valor = rs.getDouble("Valor_de_Venda");
				 
				 String categoria = rs.getString("Categoria");
				 
				 produto = new Produto(id, nome, desc, custo, qtd_estq, valor, categoria);
			
				}
		} catch (SQLException e) {
			assert false: ("ERRO ao buscar produto por nome: " + e.getCause());

		}finally {
			closeConnection(conexao);
		}
		return produto;
	}
	
	


	public static void subirEncomenda(Pedido pedido) {
		Connection conexao = null;
		
		String subirEncomenda = LojaUtil.get("subir.encomenda");
		String subirEncomendaItens = LojaUtil.get("subir.encomenda.itens");
		int numeroPedido = 0;
		
		try {
			conexao = getConnection();
			CallableStatement cs = conexao.prepareCall(subirEncomenda);
			
			cs.setInt(1, pedido.getCliente());//cliente
			cs.registerOutParameter("NumPedido", java.sql.Types.INTEGER);
			
			cs.execute();
			numeroPedido = cs.getInt("NumPedido");
			
			CallableStatement csItens = conexao.prepareCall(subirEncomendaItens);
			
			for(int i=0; i< pedido.getProdutos().size(); i = i + 7) {
				csItens.setInt(1, numeroPedido);
				csItens.setInt(2, pedido.getProdutos().get(i).getId());//IdProduto
				csItens.setInt(3, pedido.getProdutos().get(i).getQuantidadePedido());//Quantidade
				csItens.execute();
			}
		} catch (SQLException e) {
			assert false: "ERRO de Sql em Subir encomenda:" + e.getCause();
		}finally {
			closeConnection(conexao);
		}
	}

	public static void finalizarEncomenda(int idPedido) {
		Connection conexao = null;
		String cmd = LojaUtil.get("finalizar.encomenda");		
		
		try {
			conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement(cmd);
			
			ps.setInt(1, idPedido);
			ps.execute();		
		} catch (SQLException e) {
			assert false: "ERRO De Sql em Finalizar encomenda:" + e.getCause();
		}
	}
}
