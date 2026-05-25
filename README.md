# Desafio PROGRAMAÇÃO - Sistema de Cadastros 🚀

### Desafio criado por Lucas Carrilho - [@devmagro](https://www.linkedin.com/in/karilho/)

Twitter: [@devmagro 🐦 ](https://x.com/devmagro)

Instagram: [@devmagro 📸](https://instagram.com/devmagro)

YouTube: [@devmagro 🎥](https://www.youtube.com/@devmagro)

## Introdução
Você chegou ao **primeiro grande desafio do guia**! 😎 Agora, é hora de colocar a mão na massa e aplicar seus conhecimentos na prática, criando um **Sistema de Adoção para Pets!**

Leia TODO o desafio com ATENÇÃO antes de começar a faze-lo e respeite as regras, evite o uso do GPT ao máximo e use-o com sabedoria quando necessário!
## Objetivo
Neste desafio, você será desafiado a criar um sistema de cadastro via CLI (interface de linha de comando), para nossos futuros adotantes poderem escolher o seu animalzinho.

O dono do abrigo de animais que será o usuário do seu programa será capaz de:

- Cadastrar um novo pet
- Buscar dados do pet cadastrado
- Deletar um pet cadastrado
- Listar todos os pets cadastrados
- Listar pets por algum critério (idade, nome, raça)
- E muito mais!

O sistema deve ser implementado utilizando conceitos de Orientação a Objetos e outras boas práticas de programação. 🚀

No final tem um vídeo demonstrativo da minha implementação do projeto!

## Conhecimentos que você irá aplicar:
- Orientação a Objetos (OO)
- Manipulação de arquivos e arrays
- Java IO
- Exceções
- Boas práticas de código
- File Systems

# Requisitos do Desafio 📋

O desafio será organizado em **PASSOS** em que você irá desenvolver novas funcionalidades para nossa aplicação CLI.

Fique a vontade para criar e organizar entidades, serviços, utils e como desejar para este projeto!

Para iniciar, crie um Fork deste repositório e clone-o em sua máquina local, e também deixe sua ⭐ no repositório.

## 📍Passo 1 - Leitura do arquivo de base com as perguntas essenciais. 📄
Crie um arquivo chamado `formulario.txt`, que deverá conter as seguintes perguntas:

**1 - Qual o nome e sobrenome do pet?**

**2 - Qual o tipo do pet (Cachorro/Gato)?**

**3 - Qual o sexo do animal?**

**4 - Qual endereço e bairro que ele foi encontrado?**

**5 - Qual a idade aproximada do pet?**

**6 - Qual o peso aproximado do pet?**

**7 - Qual a raça do pet?**

Sua aplicação deve ler o conteúdo desse arquivo `.txt` e exibir as perguntas no terminal. 

**<span style="color:red">Não é permitido usar o "print" nas perguntas no código, você deverá LER o arquivo!</span>** 

## 📍Passo 2: Criação do menu inicial 📝
Após o arquivo estar printando o conteúdo do `formulario.txt` no terminal, você deverá criar um menu inicial com as seguintes opções:

1. Cadastrar um novo pet
2. Alterar os dados do pet cadastrado
3. Deletar um pet cadastrado
4. Listar todos os pets cadastrados
5. Listar pets por algum critério (idade, nome, raça)
6. Sair

O menu deve ser exibido no terminal e o usuário deve poder escolher uma opção digitando o número correspondente.

### _Regras ⚠️_

1. O usuário não poderá usar 0 ou números negativos.
2. Caso o usuário digite um número inválido, o menu deve ser exibido novamente.
3. O usuário só poderá digitar números, não podendo digitar letras ou caracteres especiais.


## 📍Passo 3: Cadastro de novos Pets 📝

O usuário, ao selecionar a opção 1, deve ser capaz de cadastrar um novo pet.
Neste momento, você deverá ler as **PERGUNTAS** do arquivo `formulario.txt` e armazenar as respostas em um objeto do tipo `Pet`.

### _Regras ⚠️_

1. O usuário obrigatoriamente deverá cadastrar um pet com nome e sobrenome, caso contrário, lance uma exceção.
2. O nome completo NÃO poderá conter caracteres especiais, somente letras de A-Z.
3. Para o TIPO e SEXO do pet, você deverá usar ENUM.
4. Na pergunta sobre o endereço, você deverá perguntar:
    1. Número da casa
    2. Cidade
    3. Rua
5. Na idade e peso aproximados do pet, o usuário poderá digitar números com vírgulas ou ponto, mas somente números.
6. Caso o usuário digite um peso maior que 60kg ou um peso menor que 0.5kg, lance uma exceção.
7. Caso o usuário digite uma idade maior que 20 anos, lance uma exceção.
8. Caso o usuário digite uma idade menor que 1 ano (idade em meses), transforme em 0.x anos.
9. No campo raça o usuário não poderá usar números nem caracteres especiais.
10. Nas perguntas sobre NOME, RAÇA, PESO, IDADE e ENDEREÇO (somente o campo número), caso o usuário NÃO INFORME ou deixe em branco, você deverá preencher com NÃO INFORMADO (deve ser uma constante)!


## 📍Passo 4: Armazenamento em Arquivo 📂
Agora, ao salvar o PET em um objeto, você deverá salvar as respostas em um arquivo `.txt` com o nome formatado da seguinte maneira: 

`20231101T1234-FLORZINHADASILVA.TXT`.

### _Regras ⚠️_

1. O nome do arquivo deverá seguir o formato: ano, mês, dia,T, hora, minuto - NOME+SOBRENOME em maiúsculo.
2. O arquivo deverá ser salvo na pasta `petsCadastrados` na raiz do projeto.
3. O conteúdo do arquivo deverá conter TODAS AS RESPOSTAS POR LINHA, ou seja, cada resposta deverá estar em uma linha diferente.
4. O campo endereço deverá ser salvo todo na mesma linha.
5. O arquivo somente conterá **RESPOSTAS**, PERGUNTAS NÃO!

Exemplo de arquivo salvo:

```
1 - Florzinha da Silva 
2 - Gato 
3 - Femea 
4 - Rua 2, 456, Seilandia 
5 - 6 anos 
6 - 5kg 
7 - Siames
```

## 📍Passo 5: Buscar os dados do Pet Cadastrado 🔍
O usuário, ao selecionar a opção 2, deverá ser capaz de buscar o pet usando determinados dados.
O usuário poderá buscar o pet por:
- Nome ou sobrenome
- Sexo
- Idade
- Peso
- Raça
- Endereço 

Além disso, o usuário poderá combinar de 1 a 2 critérios de busca, ou seja: 

- Nome e / ou sobrenome E IDADE
- Idade E peso 

Então, neste momento, você deverá EXIBIR um novo menu perguntando sobre quais critérios o usuário desejará usar para buscar o pet.

Após o usuário selecionar os critérios, você deverá printar no terminal os pets que correspondem aos critérios de busca, podendo ser 1 ou mais, neste formato:


### _Regras ⚠️_
1. O usuário PRIMEIRAMENTE e SEMPRE deverá escolher o critério TIPO DE ANIMAL.
2. O formato de resposta, deverá exibir SEMPRE uma lista de possiveis resultados, por exemplo:

```
1.  Rex - Cachorro - Macho  - Rua 1, 123 - Cidade 1 - 2 anos - 5kg - Vira-lata
2.  Florzinha da Silva - Gato - Femea - Rua 2, 456 - Seilandia - 6 anos - 5kg - Siames
```

3. Caso o usuário escolha por exemplo, NOME, os resultados da busca devem trazer PARTES do nome, por exemplo, caso ele pesquise por FLOR, deverá trazer o caso 2 citado anteriormente.
4. Toda busca deverá ser case-sensitive, ou seja, ignorar maiuscula e minuscula (tratando como iguais) e acentos.

### _Regra nível 2 (não obrigatória) ⚠️_

1. Permitir que o usuário busque por DATA de CADASTRO no sistema, por exemplo, você informa mês e ano (+ 1 ou 2 critérios) e ele traz essas informações
2. Ao imprimir os resultados encontrados, colocar em NEGRITO o termo da pesquisa utilizado quando for encontrado na resposta. (Exemplo: Se ele pesquisar por FLOR, o nome do pet deverá ser impresso em NEGRITO)

## 📍Passo 6: Altera um pet cadastrado ✍️
Permitir que o usuário altere os dados de um pet cadastrado.

### _Regras ⚠️_
1. O usuário deverá BUSCAR seguindo os critérios da resposta anterior.
2. Caso o usuário digite um número de busca inválido, o menu de busca deverá ser exibido novamente.
3. O usuário receberá uma LISTA (igual a exibição anterior) com os resultados da busca, e deverá escolher o número do pet que deseja alterar.
4. O usuário poderá alterar TODOS os dados do pet, EXCETO o TIPO E SEXO

## 📍Passo 7: Deletar um animal cadastro 🔍
O usuário, ao selecionar a opção de 4, deverá ser capaz de deletar o pet.

### _Regras ⚠️_
1. O usuário deverá BUSCAR seguindo os critérios da resposta anterior.
2. Caso o usuário digite um número de busca inválido, o menu de busca deverá ser exibido novamente.
3. O usuário receberá uma LISTA (igual a exibição anterior) com os resultados da busca, e deverá escolher o número do pet que deseja deletar.
4. O usuário deverá confirmar a exclusão do pet, digitando SIM ou NÃO.
5. Só poderá ser deletado um pet por vez.
6. Caso o usuário digite SIM, o pet deverá ser deletado e uma mensagem de sucesso deverá ser exibida.


## 📍Passo 8: Sair 

Ao selecionar a opção 5, o programa deverá ser encerrado.

## 📍Passo EXTRA ☠️☠️☠️

Caso você tenha concluído todos os passos anteriores, você poderá implementar uma funcionalidade extra para o seu programa.

Você irá criar na tela inicial, uma nova tela de opções, sendo:

```
1 - Iniciar o sistema para cadastro de PETS
2 - Iniciar o sistema para alterar formulário
```

Caso o usuário escolha a opção 2, você deverá exibir um novo menu com as seguintes opções:

1. Criar nova pergunta 
2. Alterar pergunta existente
3. Excluir pergunta existente
4. Voltar para o menu inicial
5. Sair

### _Regras Opção 1 ⚠️_
1. O usuário deverá digitar a nova pergunta, e você deverá salvar no arquivo `formulario.txt` a nova pergunta
2. A pergunta deverá SEGUIR a ordem com a númeração obrigatória, ou seja, ele deverá olhar para a pergunta ANTERIOR e adicionar +1 na númeração.
3. Novas perguntas não tem obrigatoriedade de resposta, mas caso o usuário **NÃO** responda, coloque um NÃO INFORMADO.

### _Regras Opção 2 ⚠️_
1. O usuário NÃO PODERÁ modificar as perguntas ORIGINAIS (de 1 a 7), somente as perguntas que ele adicionou.
2. O usuário deverá digitar o número da pergunta que deseja alterar,então você deverá printar na tela e oferecer a opção a ser alterada.
3. O usuário poderá alterar a pergunta, mas não a resposta, ou seja, você deverá perguntar a nova pergunta e salvar no arquivo.

### _Regras Opção 3 ⚠️_
1. O usuário NÃO PODERÁ deletar as perguntas ORIGINAIS (de 1 a 7), somente as perguntas que ele adicionou.
2. O usuário deverá digitar o número da pergunta que deseja deletar, então você deverá printar na tela e oferecer a opção a ser deletada.
3. O usuário deverá confirmar a exclusão da pergunta, digitando SIM ou NÃO.

### _Regras GERAIS das novas opções ⚠️_

1. Caso existam 9 perguntas (2 adicionadas), e o usuário DELETE A PERGUNTA 8, a pergunta 9 deverá tomar o lugar da 8.
2. Não deixe NENHUMA LINHA VAZIA no arquivo de perguntas ou de respostas, sempre reorganize-os
3. Ao perguntar uma das novas PERGUNTAS adicionadas (caso existam), você deverá ler o arquivo de perguntas e exibir as perguntas adicionadas normalmente.
4. Caso o usuário RESPONDA, o arquivo salvo com o pet deverá conter a resposta da pergunta adicionada no seguinte formato:

```
1 - Florzinha da Silva 
2 - Gato 
3 - Femea 
4 - Rua 2, 456, Seilandia 
5 - 6 anos 
6 - 5kg 
7 - Siames
8 - [EXTRA - PERGUNTA NOVA ADICIONADA] - RESPOSTA DO USUÁRIO
9 - [EXTRA - PERGUNTA NOVA ADICIONADA] - RESPOSTA DO USUÁRIO
```

## Considerações Finais 📝

- **Siga implementando o projeto e fazendo commits à medida que for concluindo as funcionalidades, seguindo o padrão sempre de [Conventional commits](https://www.youtube.com/watch?v=sbK9h45Jc5o)**

- **Crie um arquivo README.md com uma descrição do seu projeto e instruções de como executá-lo.**

**## 🎬 Demonstração do Projeto

Neste vídeo é possível visualizar o funcionamento do sistema, incluindo:

- Cadastro de pets
- Busca por critérios
- Alteração de registros
- Exclusão de pets
- Navegação pelo menu CLI

▶️ Vídeo demonstrativo:  
[Clique aqui para assistir](https://youtu.be/rxTdT91jf-w)**

### Gostou do projeto?
Se você chegou até aqui, parabéns! Você concluiu o primeiro grande desafio do guia. 🚀
