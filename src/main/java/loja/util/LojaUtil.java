package loja.util;

import java.io.IOException;
import java.util.Properties;

import loja.negocio.Produto;

public class LojaUtil {
	
	public static String get(String propriedade) {
		
		Properties prop = new Properties();
		String valor = null;
		
		try {
			prop.load(LojaUtil.class.getResourceAsStream("/resources/configuration.txt"));
			valor = prop.getProperty(propriedade); 
		} catch (IOException e) {
			assert false : "Configuração não carregada.";
		}
		return valor;
	}

	public Produto criarProduto(String nome, String desc, String quantidade, String custo, String valor) {

		Produto produto = new Produto(nome, desc, Integer.parseInt(quantidade) ,Double.parseDouble(custo), Double.parseDouble(valor));
		
		return produto;
	}
}
