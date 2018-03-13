# ServerGames

## Ideia Geral
Fazer, provavelmente em java, um servidor de jogos de terminal a que todos se possam ligar para jogar em conjunto (multijogador) ou para bater os recordes uns dos outros.

Desta forma, treinaríamos java, git/trabalho colaborativo, sockets, classes/objetos, estruturas de dados, etc... 
Para além disso, é sempre bom ter vários projetos no github (depois para arranjar emprego), especialmente projetos que mostrem que sabemos trabalhar em equipa.

## Exemplos de Jogos
* Batalha Naval (multijogador - 1v1)
* ...

## Considerações extra
* É importante que haja possibilidade de estar mais do que um jogo (ou instância do mesmo jogo) a correr ao mesmo tempo, logo, é necessário que cada instância de jogo seja corrida numa thread separada da 'main'

* Para além de todo o código do servidor, é necessário ter um programa 'cliente', que deve ser o mais simples possível.

* Era interessante poder haver logins (por causa de recordes e tal). Cada utilizador teria um username e pass. A pass seria guardada em forma de hash e depois, no ato de fazer login, dava para comparar o hash da passe que está guardado com o hash da passe que o utilizador introduziu ao tentar fazer login. Assim ninguém consegue aceder às passes dos outros. Não teria necessariamente que ser uma base de dados, podia ser tudo guardado num ficheiro (?)

* É importante que o servidor mantenha (automaticamente) um ficheiro que detenha os recordes de todos os utilizadores

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
