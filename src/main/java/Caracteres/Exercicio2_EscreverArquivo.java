package Caracteres;

import java.io.*;


// Criar arquivo "recomendacoes.txt" com a indicação de 3 filmes com entrada via console
public class Exercicio2_EscreverArquivo {

    public static void lerTecladoEscreverArquivo() throws IOException {

        PrintWriter pw = new PrintWriter(System.out, true); // autoflush ativado para descarregar no console
        pw.println("Escreva a recomendação de 3 filmes: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        // cria o arquivo na pasta raiz do projeto
        // FileWriter cria o arquivo
        // File dá informações sobre o diretorio e o  arquivo
        // ou BufferedWriter bw = new BufferedWriter(new FileWriter(new File("recomendacoes.txt")); <- mas aqui eu não consigo pegar as info do arquivo
        File file = new File("recomendacoes.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush(); // força o envio dos dados no arquivo, não espera o buffer ficar cheio para o envio
            line = br.readLine();
        } while (!(line.equalsIgnoreCase("fim"))); // a lógica nao é boa se a primeira palavra for 'fim'

        pw.printf("Arquivo %s criado com sucesso !" , file.getName());

        // boas práticas
        pw.close();
        br.close();
        bw.close();
    }


    public static void main(String[] args) {
        try {
            lerTecladoEscreverArquivo();
        } catch (IOException e) {
            System.err.println("Erro: " + e.getCause());
        }
    }
}
