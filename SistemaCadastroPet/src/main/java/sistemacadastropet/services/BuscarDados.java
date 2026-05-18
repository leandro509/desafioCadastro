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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class BuscarDados {

    Scanner scan = new Scanner(System.in);
    private String dado1;
    private String dado2;
    private ArrayList<String> caminhoArquivo = new ArrayList<>();

    public ArrayList<String> getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(ArrayList<String> caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public void setDado1(String dado1) {
        this.dado1 = dado1;
    }

    public void setDado2(String dado2) {
        this.dado2 = dado2;
    }

    public void imprimirTodosOsPets() {
        System.out.println(petsCadastrados());
    }
    
    public static String menuBuscas() {
        String menu = "--------------";
        menu += "\nBusca por criterios ";
        menu += "\n1-Nome ou sobrenome ";
        menu += "\n2-Sexo ";
        menu += "\n3-Endereco ";
        menu += "\n4-Idade ";
        menu += "\n5-Peso ";
        menu += "\n6-Raça ";
        menu += "\n7-Sair ";

        return menu;
    }

    public String lerCriterio(int criterio) {
        switch (criterio) {
            case 1:
                System.out.println("Digite o nome do Pet");
                break;
            case 2:
                System.out.println("Digite o sexo do Pet(macho/femea)");
                break;
            case 3:
                System.out.println("Digite o endereço do Pet");
                break;
            case 4:
                System.out.println("Digite a idade do Pet");
                break;
            case 5:
                System.out.println("Digite o peso do Pet");
                break;
            case 6:
                System.out.println("Digite a raça do Pet");
                break;
        }

        return scan.nextLine();
    }

    public String petsCadastrados() {
        String diretorioPetsCadastrados = "C:\\Users\\leandro\\Desktop\\SistemaCadastroPet\\SistemaCadastroPet\\petsCadastrados";
        File file = new File(diretorioPetsCadastrados);
        String resultado = "";
        File[] arquivos = file.listFiles();
        int contador = 0;

        if (arquivos != null) {
            //Entra dentro do diretorio pets Cadastrado e passa por todos os arquivos.txt
            for (File arquivo : arquivos) {
                try (FileReader fr = new FileReader(arquivo.getAbsoluteFile()); BufferedReader br = new BufferedReader(fr)) {

                    Path path = Paths.get(arquivo.getAbsolutePath());
                    List<String> lines = Files.readAllLines(path);

                    for (int j = 0; j < lines.size(); j++) {
                        String linhaFormatada = lines.get(j).substring(4);
                        if (j == 0) {
                            resultado += ((contador + 1) + ". " + linhaFormatada);
                            contador++;
                        } else {
                            resultado += " - " + linhaFormatada;
                        }

                        if (j == (lines.size() - 1)) {
                            resultado += "\n";
                        }

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("O caminho informado esta vazio!");
        }

        return resultado;
    }

    //metodo busca com 1 criterio
    public String resultadosBuscas(int num1) {
        if (num1 == 1) {
            num1 = 0;
        }
    
        boolean encontrado = false;

        String resultado = "";
        int contador = 0;

        //Entra dentro do diretorio pets Cadastrado e passa por todos os arquivos.txt
        for (int i = 0; i < caminhoArquivo.size(); i++) {

            try (FileReader fr = new FileReader(caminhoArquivo.get(i)); BufferedReader br = new BufferedReader(fr)) {

                String linha;
                //Le as linhas ate chegar na linha da pergunta digitada no switch
                for (int f = 0; f <= num1; f++) {

                    if (f == 1) {
                        br.readLine();
                        continue;
                    }

                    if (num1 != f) {
                        br.readLine();
                        continue;
                    }

                    linha = br.readLine();

                    if (linha == null) {
                        break;
                    }

                    String linhaFormatadaComparacao = linha.substring(4);
                    

                    if (linhaFormatadaComparacao.toLowerCase().contains(dado1.toLowerCase())) {

                        encontrado = true;

                        Path path = Paths.get(caminhoArquivo.get(i));
                        List<String> lines = Files.readAllLines(path);

                        for (int j = 0; j < lines.size(); j++) {
                            String linhaFormatada = lines.get(j).substring(4);
                            if (j == 0) {
                                resultado += ((contador + 1) + ". " + linhaFormatada);
                                contador++;
                            } else {
                                resultado += " - " + linhaFormatada;
                            }

                            if (j == (lines.size() - 1)) {
                                resultado += "\n";
                            }

                        }
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!encontrado) {
            resultado = "O dado procurado " + dado1 + " nao foi encontrado!";
        }

        limpaCaminhoArquivo();
        return resultado.trim();

    }

    //metodo busca com 2 criterios
    public String resultadosBuscas(int num1, int num2) {

        boolean encontrado = false;

        String resultado = "";
        int contador = 0;

        //Entra dentro do diretorio pets Cadastrado e passa por todos os arquivos.txt
        for (int i = 0; i < caminhoArquivo.size(); i++) {
            try (FileReader fr = new FileReader(caminhoArquivo.get(i)); BufferedReader br = new BufferedReader(fr)) {
                String linha;

                if (num2 < num1) {
                    int numReservado = num2;
                    num2 = num1;
                    num1 = numReservado;
                }

                if (num1 == 1) {
                    num1 = 0;
                }

                //Le as linhas ate chegar na linha da pergunta digitada no switch
                for (int f = 0; f <= num1; f++) {

                    if (f == 1) {
                        br.readLine();
                        continue;
                    }

                    if (num1 != f) {
                        br.readLine();
                        continue;
                    }

                    linha = br.readLine();

                    if (linha == null) {
                        break;
                    }

                    // String[] resultadosBuscaDado1 = new String[arquivos.length];
                    String linhaFormatadaComparacao = linha.substring(4);

                    if (linhaFormatadaComparacao.toLowerCase().contains(dado1.toLowerCase())) {

                        //achou o dado1 entra aqui, apos isso verificar o dado 2
                        for (int a = (num1 + 1); a <= num2; a++) {

                            if (num2 != a) {
                                br.readLine();
                                continue;
                            }

                            linha = br.readLine();

                            if (linha == null) {
                                break;
                            }

                            linhaFormatadaComparacao = linha.substring(4);

                            if (linhaFormatadaComparacao.toLowerCase().contains(dado2.toLowerCase())) {
                                encontrado = true;

                                Path path = Paths.get(caminhoArquivo.get(i));
                                List<String> lines = Files.readAllLines(path);

                                for (int j = 0; j < lines.size(); j++) {
                                    String linhaFormatada = lines.get(j).substring(4);
                                    if (j == 0) {
                                        resultado += ((contador + 1) + ". " + linhaFormatada);
                                        contador++;
                                    } else {
                                        resultado += " - " + linhaFormatada;
                                    }

                                    if (j == (lines.size() - 1)) {
                                        resultado += "\n";
                                    }
                                }
                            }
                        }

                    }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (!encontrado) {
            resultado = "Os dados procurados " + dado1 + " e " + dado2 + " nao foram encontrados!";
        }

        return resultado.trim();
    }

    public void limpaCaminhoArquivo() {
        ArrayList<String> novo = new ArrayList<>();
        setCaminhoArquivo(novo);
    }

    public void adicionaCaminhoArquivo(String arquivo) {
        caminhoArquivo.add(arquivo);
    }

    public void buscaTipo() {
        
        limpaCaminhoArquivo();

        String respostaTipoAnimal = "";
        System.out.println("Qual o tipo do Animal(Gato/Cachorro)");
        respostaTipoAnimal = scan.nextLine();
        respostaTipoAnimal = respostaTipoAnimal.toLowerCase();

        if (respostaTipoAnimal.startsWith("g")) {
            respostaTipoAnimal = "gato";
        } else if (respostaTipoAnimal.startsWith("c")) {
            respostaTipoAnimal = "cachorro";
        }

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

                    br.readLine();
                    linha = br.readLine();

                    if (linha == null) {
                        break;
                    }

                    String linhaFormatadaComparacao = linha.substring(4);

                    if (linhaFormatadaComparacao.toLowerCase().contains(respostaTipoAnimal)) {

                        Path path = Paths.get(arquivo.getAbsolutePath());
                        adicionaCaminhoArquivo(arquivo.getAbsolutePath());
                        List<String> lines = Files.readAllLines(path);

                        for (int j = 0; j < lines.size(); j++) {
                            String linhaFormatada = lines.get(j).substring(4);
                            if (j == 0) {
                                resultado += ((contador + 1) + ". " + linhaFormatada);
                                contador++;
                            } else {
                                resultado += " - " + linhaFormatada;
                            }

                            if (j == 6) {
                                resultado += "\n";
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

    }

    public void buscaPetsSwitch() {
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

                    buscaTipo();

                    System.out.println(menuBuscas());

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
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);
                            System.out.println(resultadosBuscas(escolha));
                            estaRodandoMenu2 = false;
                            break;

                        case 2:
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);
                            System.out.println(resultadosBuscas(escolha));
                            estaRodandoMenu2 = false;
                            break;

                        case 3:
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);
                            System.out.println(resultadosBuscas(escolha));
                            estaRodandoMenu2 = false;
                            break;

                        case 4:
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);
                            System.out.println(resultadosBuscas(escolha));
                            estaRodandoMenu2 = false;
                            break;

                        case 5:
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);
                            System.out.println(resultadosBuscas(escolha));
                            estaRodandoMenu2 = false;
                            break;

                        case 6:
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);
                            System.out.println(resultadosBuscas(escolha));
                            estaRodandoMenu2 = false;
                            break;

                        case 7:
                            estaRodandoMenu2 = false;
                            break;

                    }
                    break;

                //chama o metodo busca com 2 criterios
                case 2:

                    buscaTipo();

                    System.out.println(menuBuscas());

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
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);

                            switch (escolha2) {
                                case 2:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                                case 3:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                                case 4:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                                case 5:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                                case 6:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                            }

                            System.out.println(resultadosBuscas(escolha, escolha2));
                            estaRodandoMenu2 = false;
                            break;

                        case 2:
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);

                            switch (escolha2) {
                                case 3:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                                case 4:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                                case 5:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                                case 6:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                            }

                            System.out.println(resultadosBuscas(escolha, escolha2));
                            estaRodandoMenu2 = false;
                            break;

                        case 3:
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);
                            switch (escolha2) {
                                case 4:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                                case 5:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                                case 6:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                            }

                            System.out.println(resultadosBuscas(escolha, escolha2));
                            estaRodandoMenu2 = false;
                            break;

                        case 4:
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);
                            switch (escolha2) {
                                case 5:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                                case 6:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                            }

                            System.out.println(resultadosBuscas(escolha, escolha2));
                            estaRodandoMenu2 = false;
                            break;

                        case 5:
                            dado1 = lerCriterio(escolha);
                            setDado1(dado1);
                            switch (escolha2) {
                                case 6:
                                    dado2 = lerCriterio(escolha2);
                                    setDado2(dado2);
                                    break;
                            }

                            System.out.println(resultadosBuscas(escolha, escolha2));
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
