/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadastropet.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import static sistemacadastropet.controller.App.menuBuscas;

/**
 *
 * @author leandro
 */
public class DeletarPet {

    private String opcoesDeletar;

    public DeletarPet() {

    }

    public String getOpcoesDeletar() {
        return opcoesDeletar;
    }

    public void setOpcoesDeletar(String opcoesDeletar) {
        if (Character.isDigit(opcoesDeletar.charAt(0))) {
            this.opcoesDeletar = opcoesDeletar;
        } else {
            throw new IllegalArgumentException("Lista de pets inválida");
        }
    }

    public void deletarPet() {
        Scanner scan = new Scanner(System.in);
        String opcoes = getOpcoesDeletar();
        String[] opcoesDelete = opcoes.split("\\R");
        String petSelecionado = "";
        String resultado = "";
        int contador = 0;

        for (String linha : opcoesDelete) {
            contador++;
            System.out.println(linha);
        }

        int numeroPetExcluir;

        do {
            System.out.println("Digite o número do pet que deseja deletar (1 até " + contador + ")");
            numeroPetExcluir = Integer.parseInt(scan.nextLine());

            if (numeroPetExcluir < 0 || numeroPetExcluir > contador) {
                System.out.println("Número inválido! Tente novamente.");
            }

        } while (numeroPetExcluir < 0 || numeroPetExcluir > contador);

        petSelecionado = opcoesDelete[numeroPetExcluir - 1];
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
                    Path path = Paths.get(arquivo.getAbsolutePath());
                    List<String> lines = Files.readAllLines(path);

                    for (int j = 0; j < lines.size(); j++) {
                        String linhaFormatada = lines.get(j).substring(4);

                        if (j == 0) {
                            resultado += (linhaFormatada);
                        } else {
                            resultado += " - " + linhaFormatada;
                        }

                    }

                    verificadorPet[contador2] = resultado;

                    if (petSelecionado.trim().equals(verificadorPet[contador2].trim())) {
                        try {
                            System.out.println("Voce deseja deletar o Pet?(S/N)");
                            String resposta = scan.nextLine();
                            resposta.toLowerCase();
                            if (resposta.equals("s") || (resposta.equals("sim"))) {
                                System.out.println("O arquivo selecionado " + arquivo.getAbsolutePath() + " foi excluido com sucesso");
                                Files.delete(path);
                            } else if (resposta.equals("n") || (resposta.equals("nao"))) {
                                System.out.println("Exclusao cancelada");
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        break;
                    } else {
                        contador2++;
                        resultado = "";
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("O caminho informado esta vazio!");
        }
    }

    public void deletaPetSwitch() {
        String respostaScanner;
        boolean estaRodandoMenu2 = false;
        int escolhaCriterioBusca = 0;
        int escolha = 0;
        int escolha2 = 0;
        BuscarDados busca = new BuscarDados();
        DeletarPet deletar = new DeletarPet();
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
                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha));
                            deletar.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 2:

                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            System.out.println(busca.resultadosBuscas(escolha));
                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha));
                            deletar.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 3:
                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha));
                            deletar.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 4:

                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha));
                            deletar.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 5:

                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha));
                            deletar.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 6:

                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha));
                            deletar.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 7:

                            respostaScanner = scan.nextLine();
                            busca.setDado1(respostaScanner);
                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha));
                            deletar.deletarPet();
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

                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha, escolha2));
                            deletar.deletarPet();
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

                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha, escolha2));
                            deletar.deletarPet();
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

                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha, escolha2));
                            deletar.deletarPet();
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

                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha, escolha2));
                            deletar.deletarPet();
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

                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha, escolha2));
                            deletar.deletarPet();
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

                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha, escolha2));
                            deletar.deletarPet();
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

                            deletar.setOpcoesDeletar(busca.resultadosBuscas(escolha, escolha2));
                            deletar.deletarPet();
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
