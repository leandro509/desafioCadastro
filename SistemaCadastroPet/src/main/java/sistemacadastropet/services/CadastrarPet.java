/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadastropet.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import sistemacadastropet.model.Pet;
import sistemacadastropet.model.SexoAnimal;
import sistemacadastropet.model.TipoAnimal;
import sistemacadastropet.utils.StringUtil;
import static sistemacadastropet.utils.StringUtil.primeiraLetraMaiuscula;

/**
 *
 * @author leandro
 */
public class CadastrarPet {
   
  public void cadastraAndSalva() {
      StringUtil primeiraLetraMaiuscula = new StringUtil();
      ManipulacaoArquivoTxt manipulacao = new ManipulacaoArquivoTxt();
      manipulacao.inicializacaoPadrao();
        String nomePet = "";
        String sobrenomePet = "";

        Scanner scan = new Scanner(System.in);
        String[] perguntasFormulario = manipulacao.perguntasArquivo();

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
