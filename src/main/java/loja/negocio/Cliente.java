package loja.negocio;

public class Cliente {
	
	public int id;
	
	public String nome;
	
	public String telefone;
	
	public String email;

	public String senha;

	public String cpf;
	

	

	public Cliente(int id, String nome, String telefone, String email, String senha, String cpf) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
		this.cpf = cpf;
	}

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Cliente(int id, String nome, String telefone, String email, String cpf) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	
	
}
