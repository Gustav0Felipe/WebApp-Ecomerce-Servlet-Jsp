package loja.negocio;

import java.util.List;

public class Pedido {
	
	
		private int id;
		private int cliente;
		private String dataInicial;
		private String dataFinal;		
		private String status;
		private List<Produto> produtos;
		
		public Pedido() {
		}

		public Pedido(int cliente, String dataInicial, String dataFinal,
				String status) {
			this.cliente = cliente;
			this.dataInicial = dataInicial;
			this.dataFinal = dataFinal;
			this.status = status;
		}
		
		public List<Produto> getProdutos() {
			return produtos;
		}
		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getCliente() {
			return cliente;
		}
		public void setCliente(int cliente) {
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
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		
	

		
		
}
