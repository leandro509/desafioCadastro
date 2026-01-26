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

/**
 *
 * @author leandro
 */
public class BuscarDados {

    private String dado1;
    private String dado2;

    public void setDado1(String dado1) {
        this.dado1 = dado1;
    }

    public void setDado2(String dado2) {
        this.dado2 = dado2;
    }

    public String resultadosBuscas(int num1) {
        boolean encontrado = false;

        String diretorioPetsCadastrados = "C:\\Users\\leandro\\Desktop\\SistemaCadastroPet\\SistemaCadastroPet\\petsCadastrados";
        File file = new File(diretorioPetsCadastrados);
        String resultado = "";
        File[] arquivos = file.listFiles();
        int contador = 0;

        if (arquivos != null) {
            //Entra dentro do diretorio pets Cadastrado e passa por todos os arquivos.txt
            for (File arquivo : arquivos) {
                try (FileReader fr = new FileReader(arquivo.getAbsoluteFile()); BufferedReader br = new BufferedReader(fr)) {
                    String linha;
                    //Le as linhas ate chegar na linha da pergunta digitada no switch
                    for (int i = 0; i < num1; i++) {
                        linha = br.readLine();

                        if (linha == null) {
                            break;
                        }

                        String linhaFormatadaComparacao = linha.substring(4);

                        if (linhaFormatadaComparacao.toLowerCase().contains(dado1.toLowerCase())) {

                            encontrado = true;

                            Path path = Paths.get(arquivo.getAbsolutePath());
                            List<String> lines = Files.readAllLines(path);

                            for (int j = 0; j < lines.size(); j++) {
                                String linhaFormatada = lines.get(j).substring(4);
                                if (j == 0) {
                                    resultado += ("\n" + (contador + 1) + ". " + linhaFormatada);
                                    contador++;
                                } else {
                                    resultado += " - " + linhaFormatada;
                                }

                            }
                        }

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("O caminho informado esta vazio!");
        }

        if (!encontrado) {
            resultado = "O dado procurado " + dado1 + " nao foi encontrado!";
        }

        return resultado;
    }

    public String resultadosBuscas(int num1, int num2) {
        boolean encontrado = false;

        String diretorioPetsCadastrados = "C:\\Users\\leandro\\Desktop\\SistemaCadastroPet\\SistemaCadastroPet\\petsCadastrados";
        File file = new File(diretorioPetsCadastrados);
        String resultado = "";
        File[] arquivos = file.listFiles();
        int contador = 0;

        if (arquivos != null) {
            //Entra dentro do diretorio pets Cadastrado e passa por todos os arquivos.txt
            for (File arquivo : arquivos) {
                try (FileReader fr = new FileReader(arquivo.getAbsoluteFile()); BufferedReader br = new BufferedReader(fr)) {
                    String linha;

                    if (num2 < num1) {
                        int numReservado = num2;
                        num2 = num1;
                        num1 = numReservado;
                    }

                    //Le as linhas ate chegar na linha da pergunta digitada no switch
                    for (int i = 0; i < num1; i++) {
                        linha = br.readLine();

                        if (linha == null) {
                            break;
                        }

                        String linhaFormatadaComparacao = linha.substring(4);

                        if (linhaFormatadaComparacao.toLowerCase().contains(dado1.toLowerCase())) {
                            //achou o dado1 entra aqui, apos isso verificar o dado 2
                            for (int a = num2; i < num2; i++) {
                                linha = br.readLine();

                                if (linha == null) {
                                    break;
                                }

                                linhaFormatadaComparacao = linha.substring(4);

                                if (linhaFormatadaComparacao.toLowerCase().contains(dado2.toLowerCase())) {
                                    encontrado = true;

                                    Path path = Paths.get(arquivo.getAbsolutePath());
                                    List<String> lines = Files.readAllLines(path);

                                    for (int j = 0; j < lines.size(); j++) {
                                        String linhaFormatada = lines.get(j).substring(4);
                                        if (j == 0) {
                                            resultado += ("\n" + (contador + 1) + ". " + linhaFormatada);
                                            contador++;
                                        } else {
                                            resultado += " - " + linhaFormatada;
                                        }

                                    }
                                }
                            }
                            /*
                            //encontrado = true;
                            Path path = Paths.get(arquivo.getAbsolutePath());
                            List<String> lines = Files.readAllLines(path);

                            for (int j = 0; j < lines.size(); j++) {
                                String linhaFormatada = lines.get(j).substring(4);
                                if (j == 0) {
                                    resultado += ("\n" + (contador + 1) + ". " + linhaFormatada);
                                    contador++;
                                } else {
                                    resultado += " - " + linhaFormatada;
                                }

                            }
                             */
                        }


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("O caminho informado esta vazio!");
        }

        if (!encontrado) {
            resultado = "Os dados procurados " + dado1 + " e " + dado2  + " nao foram encontrados!";
        }

        return resultado;
    }
    
}
