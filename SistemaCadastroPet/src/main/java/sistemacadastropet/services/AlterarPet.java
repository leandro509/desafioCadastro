/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadastropet.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import static sistemacadastropet.controller.App.menuBuscas;
import static sistemacadastropet.controller.App.primeiraLetraMaiuscula;
import sistemacadastropet.model.Pet;

/**
 *
 * @author leandro
 */
public class AlterarPet {

    private String opcoesAlterar;

    public AlterarPet() {

    }

    public String getOpcoesAlterar() {
        return opcoesAlterar;
    }

    public void setOpcoesAlterar(String opcoesAlterar) {
        if (Character.isDigit(opcoesAlterar.charAt(0))) {
            this.opcoesAlterar = opcoesAlterar;
        } else {
            throw new IllegalArgumentException("Lista de pets inválida");
        }
    }

    public void alterarPet() {
        boolean isNomeModificado = false;
        String nomePet = "";
        String sobrenomePet = "";
        String nomeCompleto = "";
        Scanner scan = new Scanner(System.in);
        String opcoes = getOpcoesAlterar();
        String[] opcoesChange = opcoes.split("\\R");
        String petSelecionado = "";
        String resultado = "";
        int contador = 0;

        for (String linha : opcoesChange) {
            contador++;
            System.out.println(linha);
        }

        int numeroPetExcluir;

        do {
            System.out.println("Digite o número do pet que deseja alterar (1 até " + contador + ")");
            numeroPetExcluir = Integer.parseInt(scan.nextLine());

            if (numeroPetExcluir < 0 || numeroPetExcluir > contador) {
                System.out.println("Número inválido! Tente novamente.");
            }

        } while (numeroPetExcluir < 0 || numeroPetExcluir > contador);

        petSelecionado = opcoesChange[numeroPetExcluir - 1];
        petSelecionado = petSelecionado.substring(3);
        String diretorioPetsCadastrados = "C:\\Users\\leandro\\Desktop\\SistemaCadastroPet\\SistemaCadastroPet\\petsCadastrados";
        File file = new File(diretorioPetsCadastrados);
        
        File[] arquivos = file.listFiles();
        int contador2 = 0;

        if (arquivos != null) {

            //Entra dentro do diretorio pets Cadastrado e passa por todos os arquivos.txt
            for (File arquivo : arquivos) {
                try {
                    String[] verificadorPet = new String[arquivos.length];

                    String[] nomesDosPets = new String[arquivos.length];
                    Path path = Paths.get(arquivo.getAbsolutePath());
                    List<String> lines = Files.readAllLines(path);

                    for (int j = 0; j < lines.size(); j++) {
                        String linhaFormatada = lines.get(j).substring(4);

                        if (j == 0) {
                            resultado += (linhaFormatada);
                            nomesDosPets[contador2] = linhaFormatada;
                        } else {
                            resultado += " - " + linhaFormatada;
                        }

                    }

                    nomeCompleto = nomesDosPets[contador2];
                    verificadorPet[contador2] = resultado;

                    if (petSelecionado.trim().equals(verificadorPet[contador2].trim())) {
                        boolean estaRodando = true;
                        String[] nomeSeparado = new String[nomeCompleto.split(" ").length];
                        nomeSeparado = nomeCompleto.split(" ");

                        for (int contNome = 0; contNome < nomeSeparado.length; contNome++) {
                            if (contNome == 0) {
                                nomePet = nomeSeparado[contNome];
                            } else if (contNome == nomeSeparado.length - 1) {
                                sobrenomePet += nomeSeparado[contNome];
                            } else {
                                sobrenomePet += nomeSeparado[contNome] + " ";
                            }
                        }

                        nomePet = primeiraLetraMaiuscula(nomePet);
                        sobrenomePet = primeiraLetraMaiuscula(sobrenomePet);

                        Pet pet = new Pet(nomePet, sobrenomePet);

                        while (estaRodando) {
                            int escolha = 0;
                            System.out.println(perguntasSwitchAlteracao());

                            try {
                                escolha = Integer.parseInt(scan.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Somente numeros sao aceitos");
                                continue;
                            }

                            switch (escolha) {
                                case 1:
                                  
                                    System.out.println("Deve seguir o formato : " + "nome" + " " + "sobrenome");
                                    nomePet = scan.nextLine();

                                    if (nomePet == null || nomePet.isEmpty()) {
                                        nomeCompleto = Pet.getSEM_INFORMACAO();
                                        break;
                                    } else {

                                        String[] nomeSeparado2 = new String[nomePet.split(" ").length];
                                        nomeSeparado2 = nomePet.split(" ");
                                        sobrenomePet = "";
                                        for (int contNome = 0; contNome < nomeSeparado2.length; contNome++) {
                                            if (contNome == 0) {
                                                nomePet = nomeSeparado2[contNome];
                                            } else if (contNome == nomeSeparado2.length - 1) {
                                                sobrenomePet += nomeSeparado2[contNome];
                                            } else {
                                                sobrenomePet += nomeSeparado2[contNome] + " ";
                                            }
                                        }
                                    }

                                    nomePet = primeiraLetraMaiuscula(nomePet);
                                    sobrenomePet = primeiraLetraMaiuscula(sobrenomePet);
                                    pet.setNome(nomePet);
                                    pet.setSobrenome(sobrenomePet);
                                    pet.setNomeCompleto();
                                    isNomeModificado = true;

                                    
                                   
                                    lines.set(0, "1 - " + pet.getNomeCompleto());
                                    Files.write(path, lines);

                                    break;

                                case 2:
                                    String endereco = "";
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
                                    lines.set(3, "4 - " + pet.getEndereco());
                                    Files.write(path, lines);
                                    break;

                                case 3:
                                    System.out.println("Qual a idade do Pet :");
                                    String idade = scan.nextLine();
                                    pet.setIdade(idade);
                                    lines.set(4, "5 - " + pet.getIdade());
                                    Files.write(path, lines);
                                    break;
                                case 4:
                                    System.out.println("Qual o peso do Pet :");
                                    String peso = scan.nextLine();
                                    pet.setPeso(peso);
                                    lines.set(5, "6 - " + pet.getPeso());
                                    Files.write(path, lines);
                                    break;
                                case 5:
                                    System.out.println("Qual a raca do Pet :");
                                    String raca = scan.nextLine();
                                    if (raca == null || raca.isEmpty()) {
                                        raca = Pet.getSEM_INFORMACAO();
                                    }
                                    raca = primeiraLetraMaiuscula(raca);
                                    pet.setRaca(raca);
                                    lines.set(6, "7 - " + pet.getRaca());
                                    Files.write(path, lines);
                                    break;
                                case 6:
                                    if (isNomeModificado) {
                                        Instant agora = Instant.now();
                                        DateTimeFormatter formatoPadrao = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HHmm");
                                        LocalDateTime dataLocal = LocalDateTime.ofInstant(agora, ZoneId.systemDefault());
                                        String dataFormatada = dataLocal.format(formatoPadrao);
                                        String nomeCompletoFormatado = pet.getNomeCompleto();
                                        nomeCompletoFormatado = nomeCompletoFormatado.replaceAll("\\s+", "");
                                        String nomeArquivo = dataFormatada + ("-") + (nomeCompletoFormatado.toUpperCase() + ".TXT");
                                        File renomear = new File(diretorioPetsCadastrados + "\\" + nomeArquivo);
                                        arquivo.renameTo(renomear);
                                    }
                                    estaRodando = false;
                                    break;
                            }
                           
                        }
                        
                        break;
                    } else {
                        contador2++;
                        resultado = "";
                        nomeCompleto = "";
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("O caminho informado esta vazio!");
        }
    }

    public String perguntasSwitchAlteracao() {
        String perguntas = "--------------";
        perguntas += "\n1.Alterar o nome";
        perguntas += "\n2.Alterar o endereco";
        perguntas += "\n3.Alterar a idade";
        perguntas += "\n4.Alterar o peso";
        perguntas += "\n5.Alterar a raca";
        perguntas += "\n6.Voltar";
        perguntas += "\n--------------";

        return perguntas;
    }

    public void alterarPetSwitch() {
        String respostaScanner;
        boolean estaRodandoMenu2 = false;
        int escolhaCriterioBusca = 0;
        int escolha = 0;
        int escolha2 = 0;
        BuscarDados busca = new BuscarDados();
        AlterarPet alteraPet = new AlterarPet();
        estaRodandoMenu2 = true;

        while (estaRodandoMenu2) {
            Scanner scan = new Scanner(System.in);
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
                    scan.close();
                    estaRodandoMenu2 = false;
                    break;

                //chama o metodo busca com 1 criterio
                case 1:

                    System.out.println(menuBuscas());

                    try {
                        escolha = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Somente numeros sao aceitos");
                        continue;
                    }

                    switch (escolha) {

                        case 1:
                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 2:
                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 3:
                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 4:

                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 5:
                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 6:
                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 7:
                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 8:
                            scan.close();
                            estaRodandoMenu2 = false;
                            break;

                    }
                    break;

                //chama o metodo busca com 2 criterios
                case 2:

                    System.out.println(menuBuscas());

                    try {
                        System.out.println("Escolha o primeiro criterio: (numero)");
                        escolha = Integer.parseInt(scan.nextLine());

                        System.out.println("Escolha o segundo criterio: (numero)");
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

                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha, escolha2));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 2:
                            System.out.println("Digite o criterio " + escolha);
                            String tipoPett = scan.nextLine();

                            busca.setDado1(tipoPett);
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

                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha, escolha2));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 3:
                            System.out.println("Digite o criterio " + escolha);
                            String sexo = scan.nextLine();

                            busca.setDado1(sexo);
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
                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha, escolha2));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 4:
                            System.out.println("Digite o criterio " + escolha);
                            String enderecoPet = scan.nextLine();
                            busca.setDado1(enderecoPet);
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

                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha, escolha2));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 5:
                            System.out.println("Digite o criterio " + escolha);
                            String idadePet = scan.nextLine();
                            busca.setDado1(idadePet);
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

                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha, escolha2));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 6:
                            System.out.println("Digite o criterio " + escolha);
                            String pesoPet = scan.nextLine();
                            busca.setDado1(pesoPet);
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

                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha, escolha2));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 7:
                            System.out.println("Digite o criterio " + escolha);
                            String racaPet = scan.nextLine();
                            busca.setDado1(racaPet);
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

                            alteraPet.setOpcoesAlterar(busca.resultadosBuscas(escolha, escolha2));
                            alteraPet.alterarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 8:
                            estaRodandoMenu2 = false;
                            break;

                    }

                    break;

            }

        }

    }

}
