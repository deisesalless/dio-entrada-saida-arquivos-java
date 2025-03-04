package Caracteres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exemplo_InputStreamReader {
    public static void main(String[] args) {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Digite seu nome: ");
            String name = input.readLine();
            System.out.println("Olá " + name);
            input.close();
        } catch (IOException e) {
            System.err.println("Error : " + e.getCause());
        }
    }
}
