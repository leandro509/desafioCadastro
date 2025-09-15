/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadastropet.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemacadastropet.model.Pet;

/**
 *
 * @author leandro
 */
public class App {

    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        boolean estaRodando = true;
        int escolha;
        try {
            FileReader arquivo = new FileReader("C:\\Users\\leandro\\Desktop\\Formulario.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linha = lerArquivo.readLine();

            while (linha != null) {
                System.out.printf("%s\n", linha);
                linha = lerArquivo.readLine();
            }

        } catch (IOException e) {
            e.getMessage();
            e.printStackTrace();
        }
        while (estaRodando) {
            System.out.println("\n1.Cadastrar um novo pet");
            System.out.println("2.Alterar os dados do pet cadastrado");
            System.out.println("3.Deletar um pet cadastrado");
            System.out.println("4.Listar todos os pets cadastrados");
            System.out.println("5.Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6.Sair");
            System.out.println("Digite a sua escolha : (1-6)");
            escolha = scan.nextInt();
            switch (escolha) {
                case 1 ->   
                            
                            
                    
                    break;
                case 2
                case 3
                case 4
                case 5 
                case 6 -> estaRodando = false;
            }
        }

    }
    
    public static void perguntasCadastro() {
        FileReader arquivo;
        try {
            arquivo = new FileReader("C:\\Users\\leandro\\Desktop\\Formulario.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String arquivoLido = lerArquivo.toString();
            String[] perguntas = arquivoLido.split("\\?");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
