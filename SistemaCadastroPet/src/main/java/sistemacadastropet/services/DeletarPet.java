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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class DeletarPet {

    Scanner scan = new Scanner(System.in);
    private BuscarDados busca = new BuscarDados();
    private String opcoesDeletar;

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
                            resposta = resposta.toLowerCase();
                            if (resposta.equals("s") || (resposta.equals("sim"))) {
                                System.out.println("O arquivo selecionado " + arquivo.getName() + " foi excluido com sucesso");
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
        String resultadoBusca;
        boolean estaRodandoMenu2 = false;
        int escolhaCriterioBusca = 0;
        int escolha = 0;
        int escolha2 = 0;
        estaRodandoMenu2 = true;

        while (estaRodandoMenu2) {
            String dado1;
            String dado2;

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

                //chama o metodo busca com 1 criterio
                case 1:

                    busca.buscaTipo();

                    System.out.println(BuscarDados.menuBuscas());

                    try {
                        escolha = Integer.parseInt(scan.nextLine());
                        if (escolha < 1 || escolha > 7) {
                            throw new IllegalArgumentException("O numero digitado é inválido!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Somente numeros sao aceitos");
                        continue;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    switch (escolha) {

                        case 1:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            resultadoBusca = busca.resultadosBuscas(escolha);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 2:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            resultadoBusca = busca.resultadosBuscas(escolha);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 3:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            resultadoBusca = busca.resultadosBuscas(escolha);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 4:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            resultadoBusca = busca.resultadosBuscas(escolha);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 5:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            resultadoBusca = busca.resultadosBuscas(escolha);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 6:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            resultadoBusca = busca.resultadosBuscas(escolha);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 7:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            resultadoBusca = busca.resultadosBuscas(escolha);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 8:
                            estaRodandoMenu2 = false;
                            break;

                    }
                    break;

                //chama o metodo busca com 2 criterios
                case 2:

                    busca.buscaTipo();

                    System.out.println(BuscarDados.menuBuscas());

                    try {
                        System.out.println("Escolha o primeiro criterio: (numero)");
                        escolha = Integer.parseInt(scan.nextLine());

                        if (escolha < 1 || escolha > 7) {
                            throw new IllegalArgumentException("O numero digitado é inválido!");
                        }

                        if (escolha == 7) {
                            estaRodandoMenu2 = false;
                            break;
                        }

                        System.out.println("Escolha o segundo criterio: (numero)");
                        escolha2 = Integer.parseInt(scan.nextLine());

                        if (escolha2 < 1 || escolha2 > 7) {
                            throw new IllegalArgumentException("O numero digitado é inválido!");
                        }

                        if (escolha2 == 7) {
                            estaRodandoMenu2 = false;
                            break;
                        }

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
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }

                    switch (escolha) {
                        case 1:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);

                            switch (escolha2) {
                                case 2:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                                case 3:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                                case 4:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                                case 5:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                                case 6:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                            }

                            resultadoBusca = busca.resultadosBuscas(escolha, escolha2);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 2:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            switch (escolha2) {
                                case 3:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                                case 4:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                                case 5:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                                case 6:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                            }

                            resultadoBusca = busca.resultadosBuscas(escolha, escolha2);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 3:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            switch (escolha2) {
                                case 4:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                                case 5:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                                case 6:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                            }

                            resultadoBusca = busca.resultadosBuscas(escolha, escolha2);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 4:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            switch (escolha2) {
                                case 5:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                                case 6:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                            }

                            resultadoBusca = busca.resultadosBuscas(escolha, escolha2);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 5:
                            dado1 = busca.lerCriterio(escolha);
                            busca.setDado1(dado1);
                            switch (escolha2) {
                                case 6:
                                    dado2 = busca.lerCriterio(escolha2);
                                    busca.setDado2(dado2);
                                    break;
                            }

                            resultadoBusca = busca.resultadosBuscas(escolha, escolha2);
                            this.setOpcoesDeletar(resultadoBusca);
                            this.deletarPet();
                            estaRodandoMenu2 = false;
                            break;

                        case 7:
                            estaRodandoMenu2 = false;
                            break;

                    }

                    break;

            }

        }

    }
}
