package loja.negocio;

import java.util.Collection;

public class Pedido {
	
	
		private int id;
		private String funcionario;
		private String cliente;
		private String dataInicial;
		private String dataFinal;		
		private double valorTotal;
		private String status;
		private Collection<Produto> produtos;
		private int quantidade = 1;
		
		public int getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(int quantidade) {
			this.quantidade = quantidade;
		}
		public Collection<Produto> getProdutos() {
			return produtos;
		}
		public void setProdutos(Collection<Produto> produtos) {
			this.produtos = produtos;
		}
		public Pedido(int id, String funcionario, String cliente, String dataInicial, String dataFinal,
				double valorTotal, String status) {
			super();
			this.id = id;
			this.funcionario = funcionario;
			this.cliente = cliente;
			this.dataInicial = dataInicial;
			this.dataFinal = dataFinal;
			this.valorTotal = valorTotal;
			this.status = status;
		}
		public Pedido(String cliente, String dataInicial, String dataFinal,
				double valorTotal, String status) {
			super();
			this.cliente = cliente;
			this.dataInicial = dataInicial;
			this.dataFinal = dataFinal;
			this.valorTotal = valorTotal;
			this.status = status;
		}
		public Pedido() {
			// TODO Auto-generated constructor stub
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFuncionario() {
			return funcionario;
		}
		public void setFuncionario(String funcionario) {
			this.funcionario = funcionario;
		}
		public String getCliente() {
			return cliente;
		}
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}
		public String getDataInicial() {
			return dataInicial;
		}
		public void setDataInicial(String dataInicial) {
			this.dataInicial = dataInicial;
		}
		public String getDataFinal() {
			return dataFinal;
		}
		public void setDataFinal(String dataFinal) {
			this.dataFinal = dataFinal;
		}
		public double getValorTotal() {
			return valorTotal;
		}
		public void setValorTotal(double valorTotal) {
			this.valorTotal = valorTotal;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
	

		
		
}
