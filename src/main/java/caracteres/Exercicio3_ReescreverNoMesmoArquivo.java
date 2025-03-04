package caracteres;

import java.io.*;

// Faça uma cópia do arquivo "recomendacoes.txt" e agora adicione 3 recomendações de livros

public class Exercicio3_ReescreverNoMesmoArquivo {

    public static void copiarArquivo() throws IOException {

//        Código separado e mais mastigado:
//        ----------------------------------------------------
//        File file = new File("recomendacoes.txt");
//        Reader reader = new FileReader(file.getName());
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        ----------------------------------------------------


//      Forma mais utilizada: Decorator Partten , se precisar no código ter mais informações do File, bas declarar fora do Decorator
        File file = new File("recomendacoes.txt");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = bufferedReader.readLine();

/*
*       O substring retorna o nome completo do file que esta no indice 0 'pois o nome do arquivo nao esta dividido em outros indices',
*       dentro do substring repassando o indice 0 também esta pedindo para trazer tudo do indice 0 ate enontrar o ponto, retornando assim "recomendacoes"
*/      String fileNameCopy = file.getName().substring(0, file.getName().indexOf(".")).concat("-copy.txt");
        File fileCopy = new File(fileNameCopy);

//      Nome do novo arquivo: recomendacoes-copy.txt
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileCopy.getName()));


        do {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            line = bufferedReader.readLine();
        } while (!(line == null));

        bufferedWriter.flush();

        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.printf("Arquivo \"%s\" copiado com sucesso, tamanho %d bytes", file.getName(), file.length()).append("\n");
        printWriter.printf("Arquivo \"%s\" criado com sucesso, tamanho %d bytes", fileNameCopy, fileCopy.length()).append("\n");


        addNovasInfoArquivo(fileCopy.getName());
        printWriter.printf("Novas recomendações adicionadas com sucesso no arquivo \"%s\", tamanho %d em bytes", fileCopy.getName(), fileCopy.length());
        printWriter.flush();


        bufferedReader.close();
        bufferedWriter.close();
        printWriter.close(); // fecha aqui, dai ele é fechado em toda a aplicação

    }

    public static void addNovasInfoArquivo(String file) throws IOException {

        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("\nRecomende 3 livros: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line = bufferedReader.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true)); // se não colocar o true sobrescreve o arquivo

        do {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
            line = bufferedReader.readLine();
        } while (!(line.isBlank()));

        bufferedWriter.flush();

        bufferedReader.close();
        bufferedWriter.close();

    }

    public static void main(String[] args) {
        try {
            copiarArquivo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
