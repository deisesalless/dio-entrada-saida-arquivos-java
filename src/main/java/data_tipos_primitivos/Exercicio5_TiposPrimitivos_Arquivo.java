package data_tipos_primitivos;

import java.io.*;

/*
* Crie um arquivos "roupas.bin" e armazene:
* 1. Nome do produto, tamanho, (P/M/G), quantidade e preço
* 2. Leia este arquibo e imprima no console
*/
public class Exercicio5_TiposPrimitivos_Arquivo {

    public static void incluirProduto() throws IOException {
        File file = new File("./documents/roupas.bin");

        // Entrada
        PrintStream printStream = new PrintStream(System.out, true);
        printStream.flush();

        // Saida
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // Para escrever os tipos primitivos no file
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file.getPath()));

        printStream.println("Digite o nome do produto de roupa: ");
        String name = bufferedReader.readLine();

        printStream.println("Digite o tamanho da peça de roupa: P, M ou G");
        char size = (char) System.in.read(); // lê a letra como um inteiro e o typecast converte em char
        System.in.read(); // limpa o buffer

        printStream.println("Digite a quantidade: ");
        int quantity = Integer.parseInt(bufferedReader.readLine());

        printStream.println("Digite o preço: ");
        double price = Double.parseDouble(bufferedReader.readLine());

        dataOutputStream.writeUTF(name);
        dataOutputStream.writeChar(size);
        dataOutputStream.writeInt(quantity);
        dataOutputStream.writeDouble(price);

        lerProduto(file.getPath());

        printStream.flush();
        printStream.close();
        bufferedReader.close();
    }

    public static void lerProduto(String filePath) throws IOException {
        File file = new File(filePath);
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));

        String name = dataInputStream.readUTF();
        char size = dataInputStream.readChar();
        int quantity = dataInputStream.readInt();
        double price = dataInputStream.readDouble();
        System.out.printf("nome: %s | tamanho: %s | quantidade em estoque: %d | preço: %.2f | preço total do estoque %.2f", name, size, quantity, price, (quantity * price));

        dataInputStream.close();
    }

    public static void main(String[] args) throws IOException {
        incluirProduto();
    }
}
