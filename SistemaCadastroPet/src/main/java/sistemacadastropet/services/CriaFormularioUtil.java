/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadastropet.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author leandro
 */
public class CriaFormularioUtil {

    private static final String[] PERGUNTAS = {
        "1 - Qual o nome e sobrenome do pet?",
        "2 - Qual o tipo do pet (Cachorro/Gato)?",
        "3 - Qual o sexo do animal?",
        "4 - Qual endereço e bairro que ele foi encontrado?",
        "5 - Qual a idade aproximada do pet?",
        "6 - Qual o peso aproximado do pet?",
        "7 - Qual a raça do pet?"
    };

    public static void criarFormularioSeNaoExistir() {
        File file = new File("formulario.txt");

        if (file.exists()) {
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (String pergunta : PERGUNTAS) {
                bw.write(pergunta);
                bw.newLine();
            }
            System.out.println("Formulário criado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
