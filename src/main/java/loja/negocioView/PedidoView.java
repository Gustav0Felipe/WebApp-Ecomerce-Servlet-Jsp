package loja.negocioView;

import java.util.List;

import loja.negocio.Produto;

public class PedidoView {
	
	
		private int id;
		private String cliente;
		private String dataInicial;
		private String dataFinal;	
		private Double valorTotal;
		private String status;
		private List<Produto> produtos;
		
		public PedidoView() {
		
		}


		
		public PedidoView(int idPedido, String cliente, String dataInicial, String dataFinal,
				Double valorTotal, String status) {
			this.id = idPedido;
			this.cliente = cliente;
			this.dataInicial = dataInicial;
			this.dataFinal = dataFinal;
			this.valorTotal = valorTotal;
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
		
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public Double getValorTotal() {
			return valorTotal;
		}
		public void setValorTotal(Double valorTotal) {
			this.valorTotal = valorTotal;
		}
	

		
		
}
