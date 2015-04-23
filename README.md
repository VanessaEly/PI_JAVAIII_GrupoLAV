# PI_JAVAIII_GrupoLAV
Projeto Integrado de JavaIII para AV1

Integrantes: Antônio Laurindo, Leandro Varella e Vanessa Ely

# TAREFA
Os alunos devem se dividir em grupos de três alunos

O grupo deve elaborar um projeto no Eclipse 

O grupo deve utilizar o plugin EGit [Visitar http://eclipse.org/egit/ para última versão] 

Todo o projeto deve ser desenvolvido remotamente, através do GitHub. A correção será realizada  através do repositório 

Todo o código deve ser comentado e utilizar o mesmo padrão de desenvolvimento/nomenclatura

O grupo deve elaborar uma apresentação Power Point com críticas ao projeto e aϖ modelagem proposta, acompanhadas das soluções encontradas. Todas as soluções devem estar implementadas no projeto entregue

O tratamento de exceções será um dos pontos de maior peso na avaliação do projeto 

Ponto Extra [15]: Modelagem UML (Astah, Visio, etc.) 

Ponto Extra [15]: Desenvolver o método salvarEstoque() e recuperarEstoque(), utilizando arquivos texto. 


#Projeto de uma loja de veículos de uma grande rede 

##ENTIDADES
###CARRO

Entidade Carro 

Chassi: String 

Montadora: String 

Modelo: String 

Tipo (Sedan, Hatch, etc.): String 

Cor: String 

Motorização: Float 

Câmbio: String 

Preço: Float 

###MOTOCICLETA

Entidade Motocicleta 

Chassi: String 

Montadora: String 

Modelo: String 

Tipo (Sedan, Hatch, etc.): String 

Cor: String 

Cilindrada: Int 

Capacidade do Tanque: Int 

Preço: Float 


###LOJA

Entidade Loja 

Endereço: String 

Nome: String 

Estoque de Carros: Array primitivo de carros 

Estoque de Motocicletas: Array primitivo de motocicletas 


###MÉTODOS
adicionarCarro(): Adiciona um carro ao inventário, recebendo os dados do usuário. 

adicionarMoto(): Adiciona uma moto ao inventário, recebendo os dados do usuário.   

pesquisarCarro(...): Retorna um carro, utilizando os atributos passados, caso exista no inventário. 

pesquisarMoto(...): Retorna uma moto, utilizando os atributos passados, caso exista no inventário.   

buscarCarro(Chassi): Retorna um carro, caso exista no estoque um com o Chassi indicado. 

buscarMoto(Chassi): Retorna uma moto, caso exista no estoque uma com o Chassi indicado.   

listarEstoquedeMotos() 

listarEstoquedeCarros() 
