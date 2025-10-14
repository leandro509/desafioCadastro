/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadastropet.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author leandro
 */
public class Pet {

    private String nomeCompleto;
    private String sobrenome;
    private String nome;
    private TipoAnimal tipo;
    private SexoAnimal sexo;
    private String endereco;
    private String idade;
    private String peso;
    private String raca;
    private static final String SEM_INFORMACAO = "NAO INFORMADO";

    public Pet(String nome, String sobrenome) {
        setNome(nome);
        setSobrenome(sobrenome);
        setNomeCompleto(nome);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nome.concat(" " + this.sobrenome);
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");
        Matcher matcher = pattern.matcher(sobrenome);

        if (sobrenome == null) {
            throw new IllegalArgumentException("Sobrenome nao pode ser null");
        } else if (matcher.matches()) {
            this.sobrenome = sobrenome;
        } else {
            throw new IllegalArgumentException("O sobrenome so deve conter letras");
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");
        Matcher matcher = pattern.matcher(nome);

        if (nome == null) {
            throw new IllegalArgumentException("O nome nao pode ser null");
        } else if (matcher.matches()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("O nome so deve conter letras");
        }
    }

    public TipoAnimal getTipo() {
        return tipo;
    }

    public void setTipo(TipoAnimal tipo) {
        this.tipo = tipo;
    }

    public SexoAnimal getSexo() {
        return sexo;
    }

    public void setSexo(SexoAnimal sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {

        if (idade == null || idade.isEmpty()) {
            idade = Pet.getSEM_INFORMACAO();
            this.idade = idade;
        } else {

            double idadeConversao = Double.parseDouble(idade);

            if (idadeConversao > 20) {
                throw new IllegalArgumentException("A idade digitada e invalida");
            }

            if (idadeConversao < 1.0) {

                idade = idadeConversao + " anos";
                this.idade = idade;
            } else {
                this.idade = idade + " anos";
            }
        }
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {

        if (peso == null || peso.isEmpty()) {
            peso = Pet.getSEM_INFORMACAO();
            this.peso = peso;
        } else {

            double pesoConversao = Double.parseDouble(peso);
            if (pesoConversao > 60 || pesoConversao < 0.5) {
                throw new IllegalArgumentException("O peso digitado e invalido");
            }
            this.peso = peso + "kg";
        }
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        Pattern pattern = Pattern.compile("[a-zA-Z\\s]+");
        Matcher matcher = pattern.matcher(raca);

        if (matcher.matches()) {
            this.raca = raca;
        } else {
            throw new IllegalArgumentException("O raca so deve conter letras");
        }
    }

    public static String getSEM_INFORMACAO() {
        return SEM_INFORMACAO;
    }

}
