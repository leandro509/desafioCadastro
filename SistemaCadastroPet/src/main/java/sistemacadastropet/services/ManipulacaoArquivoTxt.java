/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadastropet.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import sistemacadastropet.utils.StringUtil;
import static sistemacadastropet.utils.StringUtil.primeiraLetraMaiuscula;

/**
 *
 * @author leandro
 */
public class ManipulacaoArquivoTxt {

    private boolean isCreated;
    private ArrayList<String> listaPergunta = new ArrayList<>();

    private void verificaArquivo() {
        Path caminho = Paths.get("formulario.txt");

        if (Files.exists(caminho) && Files.isRegularFile(caminho)) {
           isCreated = true;
        } else {
            isCreated = false;
        }
    }

    public ArrayList<String> getListaPergunta() {
        return listaPergunta;
    }

    public void setListaPergunta(ArrayList<String> listaPergunta) {
        this.listaPergunta = listaPergunta;
    }

    public void adicionaPergunta(String pergunta) {
        StringUtil primeiraLetraMaiuscula = new StringUtil();
        pergunta = primeiraLetraMaiuscula(pergunta);
        listaPergunta.add((listaPergunta.size() + 1) + " - " + pergunta + "?");
    }
    
    public void inicializacaoPadrao() {
        perguntasPadrao();
        criaArquivo();
        perguntasArquivo();
    }

    public void perguntasPadrao() {
        adicionaPergunta("qual o nome e o sobrenome do pet");
        adicionaPergunta("qual o tipo do pet (Cachorro/Gato)");
        adicionaPergunta("qual o sexo do animal");
        adicionaPergunta("qual o endereço e bairro que ele foi encontrado");
        adicionaPergunta("qual a idade aproximada do pet");
        adicionaPergunta("qual o peso aproximado do pet");
        adicionaPergunta("qual a raça do pet");
    }

    public String[] perguntasArquivo() {
        String[] perguntas = null;
        if (isCreated == true) {
            FileReader arquivo;
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

        }else {
            System.out.println("O arquivo.txt não foi criado");
        }
        return perguntas;
    }

    public void criaArquivo() {
        verificaArquivo();
        if (isCreated == false) {
            File arquivo = new File("formulario.txt");
            try (FileWriter fw = new FileWriter(arquivo, true); BufferedWriter bw = new BufferedWriter(fw)){
                for (int i = 0; i < listaPergunta.size(); i++) {
                    bw.write(listaPergunta.get(i));
                   
                    if (i == (listaPergunta.size() - 1)) {
                        break;
                    }
                    bw.newLine();
                }
                
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                isCreated = true;
                System.out.println("formulario.txt criado com sucesso!" );
            }
        }
    }

}
