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
import sistemacadastropet.services.AlterarPet;
import sistemacadastropet.services.BuscarDados;

import sistemacadastropet.services.CriaFormularioUtil;
import sistemacadastropet.services.DeletarPet;

/**
 *
 * @author leandro
 */
public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        boolean estaRodando = true;
        //boolean estaRodandoMenu2 = false;
        int escolha = 0;
        int escolha2 = 0;
        // int escolhaCriterioBusca = 0;
        String nomePet = "";
        String sobrenomePet = "";

        CriaFormularioUtil.criarFormularioSeNaoExistir();
        //fazer somente uma instancia do buscaDados
        //String[] perguntasFormulario = perguntasArquivo();
        while (estaRodando) {

            System.out.println(perguntasFuncoes());

            try {
                escolha = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Somente numeros sao aceitos");
                continue;
            }

            switch (escolha) {

                case 1:
                    cadastroPet();
                    break;
                
                case 2:
                    AlterarPet alteracao = new AlterarPet();
                    alteracao.alterarPetSwitch();
                    break;
                case 3:
                    DeletarPet delete = new DeletarPet();
                    delete.deletaPetSwitch();
                    break;
                case 4:
                    BuscarDados busca1 = new BuscarDados();
                    System.out.println(busca1.petsCadastrados());
                    break;
                case 5:
                    BuscarDados busca2 = new BuscarDados();
                    busca2.buscaPetsSwitch();
                    break;
                case 6:
                    scan.close();
                    estaRodando = false;
                    break;
            }
        }

    }
   
    //Metodo para ler o arquuivo 
    public static String[] perguntasArquivo() {
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

    public static String primeiraLetraMaiuscula(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    public static String menuBuscas() {
        String menu = "--------------";
        menu += "\nBusca por criterios ";
        menu += "\n1-Nome ou sobrenome ";
        menu += "\n2-Tipo ";
        menu += "\n3-Sexo ";
        menu += "\n4-Endereco ";
        menu += "\n5-Idade ";
        menu += "\n6-Peso ";
        menu += "\n7-Raça ";
        menu += "\n8-Sair ";

        return menu;
    }

    public static String perguntasFuncoes() {
        String telaInicialCmd = "----------------------";
        telaInicialCmd += "\n1.Cadastrar um novo pet";
        telaInicialCmd += "\n2.Alterar os dados do pet cadastrado";
        telaInicialCmd += "\n3.Deletar um pet cadastrado";
        telaInicialCmd += "\n4.Listar todos os pets cadastrados";
        telaInicialCmd += "\n5.Listar pets por algum critério (idade, nome, raça)";
        telaInicialCmd += "\n6.Sair";
        telaInicialCmd += "\nDigite a sua escolha : (1-6)";
        telaInicialCmd += "\n----------------------";

        return telaInicialCmd;
    }

    public static void cadastroPet() {
        String nomePet = "";
        String sobrenomePet = "";

        Scanner scan = new Scanner(System.in);

        String[] perguntasFormulario = perguntasArquivo();

        System.out.println(perguntasFormulario[0]);
        System.out.println("Deve seguir o formato : " + "nome" + " " + "sobrenome");
        nomePet = scan.nextLine();

        if (nomePet == null || nomePet.isEmpty()) {
            nomePet = Pet.getSEM_INFORMACAO();
            sobrenomePet = "";
        } else {

            String[] nomeSeparado = new String[nomePet.split(" ").length];
            nomeSeparado = nomePet.split(" ");

            for (int contNome = 0; contNome < nomeSeparado.length; contNome++) {
                if (contNome == 0) {
                    nomePet = nomeSeparado[contNome];
                } else if (contNome == nomeSeparado.length - 1) {
                    sobrenomePet += nomeSeparado[contNome];
                } else {
                    sobrenomePet += nomeSeparado[contNome] + " ";
                }
            }
        }

        nomePet = primeiraLetraMaiuscula(nomePet);
        sobrenomePet = primeiraLetraMaiuscula(sobrenomePet);

        Pet pet = new Pet(nomePet, sobrenomePet);

        System.out.println(perguntasFormulario[1]);
        String tipoPet = scan.nextLine();
        tipoPet = tipoPet.toLowerCase();

        if (tipoPet.equals("cachorro") || tipoPet.startsWith("c")) {
            pet.setTipo(TipoAnimal.CACHORRO);
            tipoPet = "Cachorro";
        } else if (tipoPet.equals("gato") || tipoPet.startsWith("g")) {
            pet.setTipo(TipoAnimal.GATO);
            tipoPet = "Gato";
        }

        System.out.println(perguntasFormulario[2]);
        String sexoPet = scan.nextLine();
        if (sexoPet.toLowerCase().startsWith("m") || sexoPet.toLowerCase().equals("macho")) {
            pet.setSexo(SexoAnimal.M);
            sexoPet = "Macho";
        } else if (sexoPet.toLowerCase().startsWith("f") || sexoPet.toLowerCase().equals("femea")) {
            pet.setSexo(SexoAnimal.F);
            sexoPet = "Femea";
        }

        String endereco = "";
        System.out.println(perguntasFormulario[3]);
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

        System.out.println(perguntasFormulario[4]);
        String idade = scan.nextLine();
        pet.setIdade(idade);

        System.out.println(perguntasFormulario[5]);
        String peso = scan.nextLine();
        pet.setPeso(peso);

        System.out.println(perguntasFormulario[6]);
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

        String[] nomeFormatado = pet.getNomeCompleto().split(" ");
        String nomeSemEspaco = "";

        for (int i = 0; i < nomeFormatado.length; i++) {
            nomeSemEspaco += nomeFormatado[i];
        }

        String nomeArquivo = dataFormatada + ("-") + (nomeSemEspaco.toUpperCase() + ".TXT");

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
        System.out.println("Pet cadastrado com sucesso!");
    }

    
}
