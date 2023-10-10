package loja.persistencia;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import loja.negocio.Cliente;
import loja.util.LojaUtil;

public class DAOEcommerce {
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
				// s� um alerta no console se n�o conseguir fechar a conex�o.
				e.printStackTrace();
			}
		}
	}
	
	
	
	public static Cliente validarLogin(String usuario, String senha) {
		Connection conexao = null;
		//pega o funcionario passando usuario e senha.
		String cmd = LojaUtil.get("autenticar.cliente");
		
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
			e.printStackTrace();
		}finally {
			closeConnection(conexao);
		}
		return null;
	}
	
	
	/**
	 * Cadastra o cliente no banco de dados ultilizando as informações passadas.
	 * 
	 * 
	 * @param nome Nome do cliente
	 * @param email Email do cliente
	 * @param telefone Telefone do cliente (Opcional)
	 * @param endereco Cpf do cliente
	 * @param senha Senha do cliente que vai ser cadastrada em uma tabela de usuarios.
	 */
	public static void cadastrarCliente(String nome, String email, String telefone, String senha, String cpf) {
		Connection conexao = null;
			
		String cmd = LojaUtil.get("cadastro.cliente");
		String user = LojaUtil.get("cadastro.cliente.sistema");
		
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
			e.printStackTrace();
		}finally {
			closeConnection(conexao);
		}
		
	}
}
