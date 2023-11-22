package loja.util;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EcommerceUtil {
	
	/**
	 * Pega o valor da chave passada no arquivo configuration.txt
	 * 
	 * @param propriedade Chave.
	 * @return Valor armazenado nesta chave no arquivo configuration.txt
	 */
	public static String get(String propriedade) {
	
		Properties prop = new Properties();
		String valor = null;
		
		try {
			prop.load(EcommerceUtil.class.getResourceAsStream("/resources/configuration.txt"));
			valor = prop.getProperty(propriedade); 
		} catch (IOException e) {
			assert false : "Configuração não carregada.";
		}
		return valor;
	}
	
	/**
	 * Envia email confirmando se quem solicitou a troca de senha foi o cliente.
	 * 
	 * @param email
	 * @param senha
	 * @param remetente = email do remetente.
	 * @param destinatario = email do destinatario.
	 * @param token = String alphanurica aleatoria usada para autenticação.
	 */
	public static void enviarEmailAutorizar(String email, String senha, String remetente, String destinatario, String token) {
		try {
			
			HtmlEmail htmlEmail = new HtmlEmail();
			htmlEmail.setCharset("UTF-8");
			htmlEmail.setHtmlMsg(
					 "<h1>Aviso!: Tentaram alterar a senha de sua conta no site Ecommerce</h1>"
					+ "<p>Se for o dono da conta e não for aquele que efetuou o pedido, entre em contato, caso tenha efetuado o pedido: </p>"
					+ String.format("<a href='http://192.168.100.16:8080/loja/perfil/editar-senha?auth=%s'>Para prosseguir e alterar sua senha clique aqui.<a>", token)
					);
			htmlEmail.addTo(destinatario);//destinatario
			htmlEmail.setSubject("Assunto");
			htmlEmail.setFrom(remetente);//remetente
			htmlEmail.setHostName("smtp.office365.com");
			htmlEmail.setSmtpPort(587);
			htmlEmail.setAuthentication(email, senha);    
			htmlEmail.setStartTLSEnabled(true);
			htmlEmail.send();
			}catch(EmailException e){
				System.out.print(e.getMessage());
				System.out.println(e.getCause());
			}
	}
	
	/**
	 * Gera o token de autenticação que vai ser mandado pelo email para acessar a troca de senha.
	 * @return String alphanumerica de 20 digitos.
	 */
	public static String gerarStringAlphanumerica() {

		int leftLimit = 48; // numero '0'
	    int rightLimit = 122; // letra 'z'
	    int targetStringLength = 20;
	    Random random = new Random();

	    String generatedString = random.ints(leftLimit, rightLimit + 1)
	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
	      .limit(targetStringLength)
	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
	      .toString();

	    return generatedString;
	}
	
	public static Boolean stringIsInteger(String texto) {
		
		Boolean isInteger = false;
		
		for(int a=0;a<texto.length();a++) {
			if(Character.isDigit(texto.charAt(a))) {
				isInteger = true;
			}else {
				return false;
			}
		}
		
		return isInteger;
	}
}
