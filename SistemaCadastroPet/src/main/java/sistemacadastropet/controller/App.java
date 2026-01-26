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
import sistemacadastropet.services.BuscarDados;

import sistemacadastropet.services.CriaFormularioUtil;

/**
 *
 * @author leandro
 */
public class App {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        boolean estaRodando = true;
        boolean estaRodandoMenu2 = false;
        int escolha = 0;
        int escolha2 = 0;
        int escolhaCriterioBusca = 0;
        String nomePet = "";
        String sobrenomePet = "";

        CriaFormularioUtil.criarFormularioSeNaoExistir();

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

                //break antes do case 5
                case 5:
                    estaRodandoMenu2 = true;
                    while (estaRodandoMenu2) {
                        System.out.println("--------------");
                        System.out.println("Deseja buscar por quantos criterios(1 ou 2) ou 0 para voltar");

                        try {
                            escolhaCriterioBusca = Integer.parseInt(scan.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Somente numeros sao aceitos");
                            continue;
                        }

                        switch (escolhaCriterioBusca) {

                            case 0:
                                estaRodandoMenu2 = false;
                                break;

                            case 1:

                                System.out.println("--------------");
                                System.out.println("Busca por criterios ");
                                System.out.println("1-Nome ou sobrenome");
                                System.out.println("2-Tipo");
                                System.out.println("3-Sexo");
                                System.out.println("4-Endereco");
                                System.out.println("5-Idade");
                                System.out.println("6-Peso");
                                System.out.println("7-Raça");
                                System.out.println("8-Sair");

                                try {
                                    escolha = Integer.parseInt(scan.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Somente numeros sao aceitos");
                                    continue;
                                }

                                switch (escolha) {
                                    case 1:
                                        String nome = scan.nextLine();
                                        BuscarDados busca = new BuscarDados();
                                        busca.setDado1(nome);
                                        System.out.println(busca.resultadosBuscas(escolha));
                                        break;

                                    case 2:
                                        String tipoPett = scan.nextLine();
                                        BuscarDados busca2 = new BuscarDados();
                                        busca2.setDado1(tipoPett);
                                        System.out.println(busca2.resultadosBuscas(escolha));
                                        break;

                                    case 3:
                                        String sexo = scan.nextLine();
                                        BuscarDados busca3 = new BuscarDados();
                                        busca3.setDado1(sexo);
                                        System.out.println(busca3.resultadosBuscas(escolha));
                                        break;

                                    case 4:
                                        String enderecoPet = scan.nextLine();
                                        BuscarDados busca4 = new BuscarDados();
                                        busca4.setDado1(enderecoPet);
                                        System.out.println(busca4.resultadosBuscas(escolha));
                                        break;

                                    case 5:
                                        String idadePet = scan.nextLine();
                                        BuscarDados busca5 = new BuscarDados();
                                        busca5.setDado1(idadePet);
                                        System.out.println(busca5.resultadosBuscas(escolha));
                                        break;

                                    case 6:
                                        String pesoPet = scan.nextLine();
                                        BuscarDados busca6 = new BuscarDados();
                                        busca6.setDado1(pesoPet);
                                        System.out.println(busca6.resultadosBuscas(escolha));
                                        break;

                                    case 7:
                                        String racaPet = scan.nextLine();
                                        BuscarDados busca7 = new BuscarDados();
                                        busca7.setDado1(racaPet);
                                        System.out.println(busca7.resultadosBuscas(escolha));
                                        break;

                                    case 8:
                                        estaRodandoMenu2 = false;
                                        break;

                                }
                                break;

                            
                            case 2:

                                System.out.println("--------------");
                                System.out.println("Busca por criterios ");
                                System.out.println("1-Nome ou sobrenome");
                                System.out.println("2-Tipo");
                                System.out.println("3-Sexo");
                                System.out.println("4-Endereco");
                                System.out.println("5-Idade");
                                System.out.println("6-Peso");
                                System.out.println("7-Raça");
                                System.out.println("8-Sair");

                                try {
                                    System.out.println("Escolha o primeiro criterio: ");
                                    escolha = Integer.parseInt(scan.nextLine());

                                    System.out.println("Escolha o segundo criterio: ");
                                    escolha2 = Integer.parseInt(scan.nextLine());

                                    if (escolha2 < escolha) {
                                        int numReservado = escolha2;
                                        escolha2 = escolha;
                                        escolha = numReservado;
                                    }

                                    if (escolha == escolha2) {
                                        System.out.println("Os dois criterios nao podem ser iguais");
                                        continue;
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("Somente numeros sao aceitos");
                                    continue;
                                }

                                switch (escolha) {
                                    case 1:
                                        System.out.println("Digite o criterio " + escolha);
                                        String nome = scan.nextLine();
                                        BuscarDados busca = new BuscarDados();
                                        busca.setDado1(nome);

                                        switch (escolha2) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                                System.out.println("Digite o criterio " + escolha2);
                                                String dado = scan.nextLine();
                                                busca.setDado2(dado);
                                                break;
                                        }

                                        System.out.println(busca.resultadosBuscas(escolha, escolha2));
                                        break;

                                    case 2:
                                        System.out.println("Digite o criterio " + escolha);
                                        String tipoPett = scan.nextLine();
                                        BuscarDados busca2 = new BuscarDados();
                                        busca2.setDado1(tipoPett);
                                        switch (escolha2) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                                System.out.println("Digite o criterio " + escolha2);
                                                String dado = scan.nextLine();
                                                busca2.setDado2(dado);
                                                break;
                                        }
                                        System.out.println(busca2.resultadosBuscas(escolha, escolha2));
                                        break;

                                    case 3:
                                        System.out.println("Digite o criterio " + escolha);
                                        String sexo = scan.nextLine();
                                        BuscarDados busca3 = new BuscarDados();
                                        busca3.setDado1(sexo);
                                        switch (escolha2) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                                System.out.println("Digite o criterio " + escolha2);
                                                String dado = scan.nextLine();
                                                busca3.setDado2(dado);
                                                break;
                                        }
                                        System.out.println(busca3.resultadosBuscas(escolha, escolha2));
                                        break;

                                    case 4:
                                        System.out.println("Digite o criterio " + escolha);
                                        String enderecoPet = scan.nextLine();
                                        BuscarDados busca4 = new BuscarDados();
                                        busca4.setDado1(enderecoPet);
                                        switch (escolha2) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                                System.out.println("Digite o criterio " + escolha2);
                                                String dado = scan.nextLine();
                                                busca4.setDado2(dado);
                                                break;
                                        }
                                        System.out.println(busca4.resultadosBuscas(escolha, escolha2));
                                        break;

                                    case 5:
                                        System.out.println("Digite o criterio " + escolha);
                                        String idadePet = scan.nextLine();
                                        BuscarDados busca5 = new BuscarDados();
                                        busca5.setDado1(idadePet);
                                        switch (escolha2) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                                System.out.println("Digite o criterio " + escolha2);
                                                String dado = scan.nextLine();
                                                busca5.setDado2(dado);
                                                break;
                                        }
                                        System.out.println(busca5.resultadosBuscas(escolha, escolha2));
                                        break;

                                    case 6:
                                        System.out.println("Digite o criterio " + escolha);
                                        String pesoPet = scan.nextLine();
                                        BuscarDados busca6 = new BuscarDados();
                                        busca6.setDado1(pesoPet);
                                        switch (escolha2) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                                System.out.println("Digite o criterio " + escolha2);
                                                String dado = scan.nextLine();
                                                busca6.setDado2(dado);
                                                break;
                                        }
                                        System.out.println(busca6.resultadosBuscas(escolha, escolha2));
                                        break;

                                    case 7:
                                        System.out.println("Digite o criterio " + escolha);
                                        String racaPet = scan.nextLine();
                                        BuscarDados busca7 = new BuscarDados();
                                        busca7.setDado1(racaPet);
                                        switch (escolha2) {
                                            case 2:
                                            case 3:
                                            case 4:
                                            case 5:
                                            case 6:
                                            case 7:
                                                System.out.println("Digite o criterio " + escolha2);
                                                String dado = scan.nextLine();
                                                busca7.setDado2(dado);
                                                break;
                                        }
                                        System.out.println(busca7.resultadosBuscas(escolha, escolha2));
                                        break;

                                    case 8:
                                        estaRodandoMenu2 = false;
                                        break;

                                }

                                break;

                        }

                    }
                    //break case 5 estaRodando
                    break;
                //case 6
                case 6:
                    estaRodando = false;
                    break;

                //final do switch escolha aqui 
            }
        }

        //final do while esta rodando aqui 
    }
    // final da public static void main aqui    

    /*
  

    //BACKUP case 5 SE DER TUDO ERRADO 
    /*
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
                                String nome = scan.nextLine();
                                BuscarDados busca = new BuscarDados();
                                busca.setDado1(nome);
                                System.out.println(busca.resultadosBuscas(escolha));
                                break;

                            case 2:
                                String sexo = scan.nextLine();
                                BuscarDados busca2 = new BuscarDados();
                                busca2.setDado1(sexo);
                                System.out.println(busca2.resultadosBuscas(1 + escolha));
                                break;

                            case 3:
                                String idadePet = scan.nextLine();
                                BuscarDados busca3 = new BuscarDados();
                                busca3.setDado1(idadePet);
                                System.out.println(busca3.resultadosBuscas(2 + escolha));
                                break;

                            case 4:
                                String pesoPet = scan.nextLine();
                                BuscarDados busca4 = new BuscarDados();
                                busca4.setDado1(pesoPet);
                                System.out.println(busca4.resultadosBuscas(2 + escolha));
                                break;

                            case 5:
                                String racaPet = scan.nextLine();
                                BuscarDados busca5 = new BuscarDados();
                                busca5.setDado1(racaPet);
                                System.out.println(busca5.resultadosBuscas(2 + escolha));
                                break;

                            case 6:
                                String enderecoPet = scan.nextLine();
                                BuscarDados busca6 = new BuscarDados();
                                busca6.setDado1(enderecoPet);
                                System.out.println(busca6.resultadosBuscas(escolha - 2));
                                break;

                            case 7:
                                estaRodandoMenu2 = false;
                                break;
                        }
                       
                    }
                    //break case 5 estaRodando
                    break;
                    //case 6
                case 6:
                    estaRodando = false;
                    break;
     */
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

        Pet pet = new Pet(nomePet, sobrenomePet);

        System.out.println(perguntasFormulario[1]);
        String tipoPet = scan.nextLine();
        tipoPet.toLowerCase();
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
