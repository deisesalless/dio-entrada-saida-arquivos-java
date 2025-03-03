import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exemplo_File {
    public static void main(String[] args) {
        // só passo o nome porque o arquivo está no diretorio raiz, ou seja, no mesmo local que o src
        File f = new File("arquivo-teste.txt");
        System.out.println("Nome do arquivo: " + f.getName());
        System.out.println("Caminho: " + f.getPath());
        System.out.println("Caminho absoluto: " + f.getAbsolutePath());
        System.out.println("Diretório pai: " + f.getParent());
        System.out.println(f.exists() ? "existe" : "nao existe");
        System.out.println(f.canWrite() ? "pode ser gravado" :  "nao pode ser gravado");
        System.out.println(f.canRead() ? "pode ser lido" : "nao pode ser lido");
        System.out.println(f.isDirectory() ? "é um diretório" : "nao é um diretório");
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(f.lastModified());
        System.out.println("Ultima data de modificação do arquivo : " + dateFormat.format(date));
        System.out.println("Tamanho do arquivo: " + f.length() + " bytes");
    }
}
