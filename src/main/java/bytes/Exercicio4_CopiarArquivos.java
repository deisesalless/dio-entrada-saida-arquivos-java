package bytes;

import java.io.*;

// Faça uma cópia do arquivo "recomendacoes-copy.txt"
public class Exercicio4_CopiarArquivos {

    public static void copiarArquivo() throws IOException {

//        Código separado e mais mastigado:
//        ----------------------------------------------------
//        File file = new File("recomendacoes-copy.txt");
//        InputStream inputStream = new FileInputStream(file.getName());
//        ----------------------------------------------------

//      Forma mais utilizada: Decorator Partten, se precisar no código ter mais informações do File, basta declarar fora do Decorator
        File fileOriginal = new File("recomendacoes-copy.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileOriginal.getName()));

        String fileNameCopy = fileOriginal.getName().substring(0, fileOriginal.getName().indexOf("-")).concat("-copy2.txt");
        File fileCopy = new File(fileNameCopy);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileCopy));

        int info = 0;
        do {
            info = bufferedInputStream.read();
            bufferedOutputStream.write(info); // metodo write já faz a conversão do int para char
            bufferedOutputStream.flush();
        } while (info != -1);

        System.out.printf("Arquivo \"%s\" copiado com sucesso, arquivo de cópia \"%s\" possui tamanho \"%d\" bytes", fileOriginal.getName(), fileCopy.getName(), fileCopy.length());
        // Saida console: Arquivo "recomendacoes-copy.txt" copiado com sucesso, arquivo de cópia "recomendacoes-copy2.txt"  possui tamanho "84" bytes

    }

    public static void main(String[] args) {
        try {
            copiarArquivo();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
