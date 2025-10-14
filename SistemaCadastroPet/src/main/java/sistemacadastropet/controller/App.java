/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadastropet.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import sistemacadastropet.model.Pet;
import sistemacadastropet.model.SexoAnimal;
import sistemacadastropet.model.TipoAnimal;

/**
 *
 * @author leandro
 */
public class App {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        boolean estaRodando = true;
        boolean estaRodandoMenu2 = false;
        boolean segundoCriterioBusca = false;
        int escolha = 0;
        //int escolhaMenu2 = 0;
        String nomePet = "";
        String[] perguntas = perguntasFormulario();
        File file = new File("formulario.txt");

        if (!file.exists()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
                for (String linha : perguntas) {
                    bw.write(linha);
                    bw.newLine();
                }
                System.out.println("Arquivo " + file + " foi criado com sucesso!");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] perguntasPet = perguntasCadastro();

        while (estaRodando) {
            System.out.println("----------------------");
            System.out.println("\n1.Cadastrar um novo pet");
            System.out.println("2.Alterar os dados do pet cadastrado");
            System.out.println("3.Deletar um pet cadastrado");
            System.out.println("4.Listar todos os pets cadastrados");
            System.out.println("5.Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6.Sair");
            System.out.println("Digite a sua escolha : (1-6)");
            System.out.println("----------------------");

            try {
                escolha = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Somente numeros sao aceitos");
                continue;
            }

            switch (escolha) {

                case 1:

                    System.out.println(perguntasPet[0]);
                    System.out.println("Deve seguir o formato : " + "nome" + " " + "sobrenome");
                    nomePet = scan.nextLine();

                    if (nomePet == null || nomePet.isEmpty()) {
                        nomePet = Pet.getSEM_INFORMACAO();
                    }

                    String[] nomeSeparado = nomePet.split(" ");
                    Pet pet = new Pet(nomeSeparado[0], nomeSeparado[1]);

                    if (nomeSeparado.length > 2) {
                        String sobrenome = "";
                        pet.setNome(nomeSeparado[0]);

                        for (int i = 1; i < nomeSeparado.length; i++) {
                            sobrenome += nomeSeparado[i] + " ";
                            sobrenome = primeiraLetraMaiuscula(sobrenome);
                        }

                        pet.setSobrenome(sobrenome);
                        nomeSeparado[0] = primeiraLetraMaiuscula(nomeSeparado[0]);
                        pet.setNomeCompleto(nomeSeparado[0]);

                    }

                    System.out.println(perguntasPet[1]);
                    String tipoPet = scan.nextLine();
                    tipoPet.toLowerCase();
                    if (tipoPet.equals("cachorro") || tipoPet.startsWith("c")) {
                        pet.setTipo(TipoAnimal.CACHORRO);
                        tipoPet = "Cachorro";
                    } else if (tipoPet.equals("gato") || tipoPet.startsWith("g")) {
                        pet.setTipo(TipoAnimal.GATO);
                        tipoPet = "Gato";
                    }

                    System.out.println(perguntasPet[2]);
                    String sexoPet = scan.nextLine();
                    if (sexoPet.toLowerCase().startsWith("m")) {
                        pet.setSexo(SexoAnimal.M);
                        sexoPet = "Macho";
                    } else if (sexoPet.toLowerCase().startsWith("f")) {
                        pet.setSexo(SexoAnimal.F);
                        sexoPet = "Femea";
                    }

                    String endereco = "";
                    System.out.println(perguntasPet[3]);
                    System.out.println("Qual o numero da casa : ");
                    String numeroCasa = scan.nextLine();
                    if (numeroCasa == null || numeroCasa.isEmpty()) {
                        numeroCasa = Pet.getSEM_INFORMACAO();
                    }
                    System.out.println("Qual a cidade : ");
                    String cidade = scan.nextLine();
                    cidade = primeiraLetraMaiuscula(cidade);

                    System.out.println("Qual a rua : ");
                    String rua = scan.nextLine();
                    rua = primeiraLetraMaiuscula(rua);

                    endereco = endereco.concat(rua + ", " + numeroCasa + ", " + cidade);
                    pet.setEndereco(endereco);

                    System.out.println(perguntasPet[4]);
                    String idade = scan.nextLine();
                    pet.setIdade(idade);

                    System.out.println(perguntasPet[5]);
                    String peso = scan.nextLine();
                    pet.setPeso(peso);

                    System.out.println(perguntasPet[6]);
                    String raca = scan.nextLine();
                    if (raca == null || raca.isEmpty()) {
                        raca = Pet.getSEM_INFORMACAO();
                    }
                    raca = primeiraLetraMaiuscula(raca);
                    pet.setRaca(raca);

                    File fileDiretorio = new File("petsCadastrados");
                    boolean isDiretorioCreated = false;
                    if (!fileDiretorio.exists()) {
                        isDiretorioCreated = fileDiretorio.mkdir();
                        if (isDiretorioCreated) {
                            System.out.println("Diretorio criado com sucesso ");
                        } else {
                            System.out.println("Falha ao criar diretorio");
                        }
                    } else {
                        System.out.println("O diretorio ja existe!");
                    }

                    Instant agora = Instant.now();
                    DateTimeFormatter formatoPadrao = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HHmm");
                    LocalDateTime dataLocal = LocalDateTime.ofInstant(agora, ZoneId.systemDefault());
                    String dataFormatada = dataLocal.format(formatoPadrao);

                    String nomeArquivo = dataFormatada + ("-") + (pet.getNome().toUpperCase() + pet.getSobrenome().toUpperCase() + ".TXT");

                    File petsSalvos = new File(fileDiretorio, nomeArquivo);
                    try (FileWriter fw = new FileWriter(petsSalvos, true); BufferedWriter bw = new BufferedWriter(fw)) {
                        bw.write("1 - " + pet.getNomeCompleto());
                        bw.newLine();
                        bw.write("2 - " + tipoPet);
                        bw.newLine();
                        bw.write("3 - " + sexoPet);
                        bw.newLine();
                        bw.write("4 - " + pet.getEndereco());
                        bw.newLine();
                        bw.write("5 - " + pet.getIdade());
                        bw.newLine();
                        bw.write("6 - " + pet.getPeso());
                        bw.newLine();
                        bw.write("7 - " + pet.getRaca());
                        System.out.println("Arquivo salvo em: " + petsSalvos.getAbsolutePath());
                    } catch (IOException e) {
                        System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
                    }
                    
                    break;

                case 5:
                    estaRodandoMenu2 = true;
                    while (estaRodandoMenu2) {

                        System.out.println("--------------");
                        System.out.println("Busca por criterios ");
                        System.out.println("1-Nome ou sobrenome");
                        System.out.println("2-Sexo");
                        System.out.println("3-Idade");
                        System.out.println("4-Peso");
                        System.out.println("5-Raça");
                        System.out.println("6-Endereço");
                        System.out.println("7-Sair");

                        try {
                            escolha = Integer.parseInt(scan.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Somente numeros sao aceitos");
                            continue;
                        }

                        switch (escolha) {
                            case 1:
                                System.out.println("Deseja Adicionar mais 1 criterio de busca");
                                
                                break;
                                
                            case 7:
                                estaRodandoMenu2 = false;
                                break;
                        }
                    }
                    break;

                case 6:
                    estaRodando = false;
                    break;
            }

        }

    }

    //Metodo para ler o arquuivo 
    public static String[] perguntasCadastro() {
        FileReader arquivo;
        String[] perguntas = null;
        try {
            arquivo = new FileReader("formulario.txt");
            BufferedReader lerArquivo = new BufferedReader(arquivo);
            String linhas = "";
            String linha;
            while ((linha = lerArquivo.readLine()) != null) {
                linhas = linhas.concat(linha);
            }
            perguntas = linhas.split("[?]");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return perguntas;
    }

    public static String[] perguntasFormulario() {
        String[] perguntas = new String[7];
        perguntas[0] = ("1 - Qual o nome e sobrenome do pet?");
        perguntas[1] = ("2 - Qual o tipo do pet (Cachorro/Gato)?");
        perguntas[2] = ("3 - Qual o sexo do animal?");
        perguntas[3] = ("4 - Qual endereço e bairro que ele foi encontrado?");
        perguntas[4] = ("5 - Qual a idade aproximada do pet?");
        perguntas[5] = ("6 - Qual o peso aproximado do pet?");
        perguntas[6] = ("7 - Qual a raça do pet?");

        return perguntas;
    }

    public static String primeiraLetraMaiuscula(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
