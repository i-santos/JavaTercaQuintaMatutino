/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula5terqui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Professor
 */
public class GoogleChrome {

    static void request() {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o email: ");
        String email = sc.nextLine();
        System.out.print("Digite a senha: ");
        String senha = sc.nextLine();

        try {

            /**
             * Defino a URL pra onde vou mandar a requisição
             */
            URL url = new URL("http://localhost:8084/SiteJavaTercaMatutino/LoginServlet");

            // Abro a conexão com o Tomcat
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            
            // Vou começar a configurar minha requisição
            conexao.setRequestMethod("POST");
            conexao.setDoOutput(true);
            
            conexao.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            
            // Vou usar um ESCRITO DE FLUXO DE SAÍDA
            OutputStreamWriter wr = new OutputStreamWriter(conexao.getOutputStream());
            
            // Envio meu conjunto de pares CHAVE/VALOR
            wr.write("email=" + email + "&senha=" + senha);
            // Sinalizo que terminei de enviar os dados
            wr.close();
            
            InputStreamReader is = new InputStreamReader(conexao.getInputStream());
            BufferedReader buffer = new BufferedReader(is);
            StringBuilder response = new StringBuilder();
            
            String line;
            
            while((line = buffer.readLine()) != null) {
                response.append(line);
                response.append("\n");
            }
            
            System.out.println(response);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
