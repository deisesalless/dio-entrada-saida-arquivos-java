import java.io.*;

public class Exercicio1_Caractere {

    public static void receberTecladoImprimirConsole() throws IOException {

//        Código separado e mais mastigado:

//        InputStream sys = System.in;
//        InputStreamReader input = new InputStreamReader(sys);
//        BufferedReader br = new BufferedReader(input);

//        OutputStream sout = System.out;
//        OutputStreamWriter out = new OutputStreamWriter(sout);
//        BufferedWriter bw = new BufferedWriter(out);

//        ----------------------------------------------------


        System.out.println("Recomende 3 filmes: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        } while (!(line.isBlank()));

        // é uma boa prática descarregar e fechar o fluxo de entrada e saida
        bw.flush(); // força o envio dos dados no console, não espera o buffer ficar cheio para o envio
        br.close();
        bw.close();
    }

    public static void main(String[] args) {
        try {
            receberTecladoImprimirConsole();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
