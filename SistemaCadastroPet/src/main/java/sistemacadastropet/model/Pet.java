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
    private String bairro;
    private double idade;
    private double peso;
    private String raca;
    private static final String SEM_INFORMACAO = "NAO INFORMADO";
    
    
    public Pet(String nome, String sobrenome) {
        setNome(nome);
        setSobrenome(sobrenome);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nome.concat(nome) + sobrenome.concat(sobrenome);
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(sobrenome);
       
        if(matcher.matches()) {
        this.sobrenome = sobrenome;
        }else if(sobrenome == null){
            throw new IllegalArgumentException("Sobrenome nao pode ser null");
        }else {
            throw new IllegalArgumentException("O sobrenome so deve conter letras");
        }
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        Pattern pattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = pattern.matcher(nome);
       
        if(matcher.matches()) {
        this.nome = nome;
        }else if(nome == null || nome.trim().isEmpty()){
            this.nome = getSEM_INFORMACAO();
        }else {
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public double getIdade() {
        return idade;
    }

    public void setIdade(double idade) {
        if(idade > 20) {
            throw new IllegalArgumentException("A idade digitada e invalida");
        }
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if(peso > 60 || peso < 0.5 ) {
            throw new IllegalArgumentException("O peso digitado e invalido");
        }
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public static String getSEM_INFORMACAO() {
        return SEM_INFORMACAO;
    }
    
    
    
}
