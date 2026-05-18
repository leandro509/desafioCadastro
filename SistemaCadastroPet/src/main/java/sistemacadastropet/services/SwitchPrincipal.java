/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemacadastropet.services;

import java.util.Scanner;

/**
 *
 * @author leandro
 */
public class SwitchPrincipal {
    
    public void rodarSwitch() {
         Scanner scan = new Scanner(System.in);

        boolean estaRodando = true;
        
        int escolha = 0;
        
        
        ManipulacaoArquivoTxt manipulacao = new ManipulacaoArquivoTxt();
        manipulacao.inicializacaoPadrao();
        
        
        while (estaRodando) {

            System.out.println(perguntasFuncoes());

            try {
                escolha = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Somente numeros sao aceitos");
                continue;
            }

            switch (escolha) {

                case 1:
                    CadastrarPet cadastro = new CadastrarPet();
                    cadastro.cadastraAndSalva();
                    break;
                
                case 2:
                    AlterarPet alteracao = new AlterarPet();
                    alteracao.alterarPetSwitch();
                    break;
                case 3:
                    DeletarPet delete = new DeletarPet();
                    delete.deletaPetSwitch();
                    break;
                case 4:
                    BuscarDados busca1 = new BuscarDados();
                    busca1.imprimirTodosOsPets();
                    break;
                case 5:
                    BuscarDados busca2 = new BuscarDados();
                    busca2.buscaPetsSwitch();
                    break;
                case 6:
                    scan.close();
                    estaRodando = false;
                    break;
            }
        }
    }
    
    public String perguntasFuncoes() {
        String telaInicialCmd = "----------------------";
        telaInicialCmd += "\n1.Cadastrar um novo pet";
        telaInicialCmd += "\n2.Alterar os dados do pet cadastrado";
        telaInicialCmd += "\n3.Deletar um pet cadastrado";
        telaInicialCmd += "\n4.Listar todos os pets cadastrados";
        telaInicialCmd += "\n5.Listar pets por algum critério (idade, nome, raça)";
        telaInicialCmd += "\n6.Sair";
        telaInicialCmd += "\nDigite a sua escolha : (1-6)";
        telaInicialCmd += "\n----------------------";

        return telaInicialCmd;
    }
}
