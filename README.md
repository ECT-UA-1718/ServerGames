# ServerGames

## Ideia Geral
Fazer, provavelmente em java, um servidor de jogos de terminal a que todos se possam ligar para jogar em conjunto (multijogador) ou para bater os recordes uns dos outros.

Desta forma, treinaríamos java, git/trabalho colaborativo, sockets, classes/objetos, estruturas de dados (que vamos dar em P2), etc... 
Para além disso, é sempre bom ter vários projetos no github (depois para arranjar emprego), especialmente projetos que mostrem que sabemos trabalhar em equipa.

## Exemplos de Jogos
* Batalha Naval (multijogador - 1v1)
* Minesweeper (jogador único - compete-se à base de recordes
* Snake, Space Invaders (jogador único - compete-se à base de recordes)
* Palavras com amigos (versão melhor xD) (multijogador - 1v1 (?))
* Quatro-em-linha, Jogo do Galo (multijogador - 1v1)
* Sueca, UNO (?) (multijogador - vários)
* Xadrez
* ...

## Considerações extra
* É importante que haja possibilidade de estar mais do que um jogo (ou instância do mesmo jogo) a correr ao mesmo tempo, logo, é necessário que cada instância de jogo seja corrida numa thread separada da 'main'

* Para além de todo o código do servidor, é necessário ter um programa 'cliente', que deve ser o mais simples possível.

* Era interessante poder haver logins (por causa de recordes e tal). Cada utilizador teria um username e pass. A pass seria guardada em forma de hash e depois, no ato de fazer login, dava para comparar o hash da passe que está guardado com o hash da passe que o utilizador introduziu ao tentar fazer login. Assim ninguém consegue aceder às passes dos outros. Não teria necessariamente que ser uma base de dados, podia ser tudo guardado num ficheiro (?)

* É importante que o servidor mantenha (automaticamente) um ficheiro que detenha os recordes de todos os utilizadores

* Era fixe conseguir ter, concorrente com o jogo, um chatroom para se ir falando. (discutir melhor implementação)

* A organização do código em si te que ser discutida primeiro. (quantos ficheiros? cada jogo é uma classe? ...)
Convinha fazer uma classe (ou package de classes) com funções úteis para usar no resto do código

* Não há qualquer deadline, é para ir fazendo quando houver tempo

* O repositório é publico, mas apenas pessoas que façam parte da organização podem fazer commits.

## Membros Propostos
(Apenas na vertente da programação do servidor. Para jogar convidava-se todo o pessoal que quisesse)
* Rosmaninho
* Eurico
* Valério
* Hackerman
* Risitas
* ... (proponham quem quiserem)

## Possibilidades para hospedagem do servidor
 * Raspberry Pi ligado ao Hamachi
 * Raspberry Pi aberto à rede externa (seria necessário mexer no router)
 * ...

## Flow
1. O servidor liga-se. Fica à escuta de novas conecções
2. Um cliente liga-se. Tenta conectar-se ao servidor
3. O servidor aceita a conexão do cliente. O cliente faz login com user e pass
    * OK --> Continua
    * FAIL --> Mata a conexão
4. O cliente imprime o menu e a lista de players online
5. O cliente escolhe um jogo (jogo x)
    * Se o jogo é singleplayer, executa o jogo e no final manda o score (e mais estatísticas relevantes) para o server. 
    * Se o jogo é multiplayer:
        1. Verificar se o jogo escolhido está na lista de jogos pendentes
            * Se não, envia um sinal ao server para que o jogo x seja adicionado a uma lista de jogos pendentes (esse cliente fica o player1, primeiro a começar)
            * Se sim, começa o jogo (fica como player2)
        2. Executa o jogo
        3. O server guarda recordes e estatísticass
6. Volta ao passo 4

