package infnet.loja;

import infnet.Menu;
import infnet.Principal;
import infnet.loja.veiculos.*;
import infnet.loja.enums.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Classe Loja define uma loja e faz a manutencao de seu "estoque"
 * @author Antonio Henrique, Leandro Varella, Vanessa Ely
 * @version 1.0
 * @since 15-04-2015
 */
public class Loja 
{

	//VARIAVEIS DA CLASSE
	private String endereco;
	private String nome;
	private ArrayList <Carro>	estoqueDeCarros       = new ArrayList <Carro>();
	private ArrayList <Motocicleta>  estoqueDeMotocicletas = new ArrayList <Motocicleta>();
	private static PrintWriter gravarArq;

	/**
	 * Construtor Default
	 * Cria uma loja sem valores definidos
	 */
	public Loja() {}

	/**
	 * Construtor Loja constroi uma nova loja
	 * @param nome nome da loja
	 * @param endereco endereco da loja
	 */
	public Loja(String nome, String endereco) 
	{
		this.endereco              = endereco;
		this.nome                  = nome;
	}

	/**
	 * Caso o usuario clique em cancel, esse metodo faz com que o sistema seja fechado
	 * @param input input do usuario
	 * @return input input do usuario
	 */
	public static String validarInput(String input) {

		//quando usuario clica em cancel, input recebe o valor null
		if (input == null)
		{
			JOptionPane.showMessageDialog(null,"Voce optou por sair do sistema, ate a proxima!");
			System.exit(0);	
		}
		return input;
	}
	/**
	 * Cria uma nova loja e um novo arquivo para a mesma (caso ele ainda nao exista)
	 * @return loja retorna a loja criada
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static Loja salvarEstoque() throws IOException {
		Loja loja = new Loja();
		String input = (JOptionPane.showInputDialog("Digite o nome do seu arquivo de estoque(Ex: 'loja.txt'): "));
		Principal.nomearq = validarInput(input);
		if (!(Principal.nomearq.contains(".txt")))
			Principal.nomearq = Principal.nomearq + ".txt";

		//se nome vazio ou sem o formato txt, repete a acao
		while (Principal.nomearq == null)
		{
			input = (JOptionPane.showInputDialog("Nome Invalido. Digite o nome do seu arquivo .txt(Ex: 'loja.txt'): "));
			Principal.nomearq = validarInput(input);
		}


		//cria objeto file
		File arq = new File(Principal.nomearq);

		//se arquivo nao existir, cria novo arquivo e nova loja
		if (!arq.exists()) 
		{
			input = (JOptionPane.showInputDialog("Digite o nome da loja: "));
			loja.nome = validarInput(input);
			input = (JOptionPane.showInputDialog("Digite o endereco da loja: "));
			loja.endereco = validarInput(input);

			//cria arquivo txt
			arq.createNewFile();

			//escreve nome da loja e endereco no arquivo
			try
			{
				gravarArq = new PrintWriter((new BufferedWriter(new FileWriter(Principal.nomearq, true)))); //true garante que a escrita nao sobrescreva o conteudo atual
				gravarArq.printf("\nLoja %s", loja.nome);
				gravarArq.printf(" - Endereco %s", loja.endereco); //dados que serao escritos
				gravarArq.println();
				gravarArq.flush(); //limpa buffer
				JOptionPane.showMessageDialog(null,"Arquivo " + Principal.nomearq + " criado com sucesso. Agora voce esta trabalhando com essa loja.");
			} 
			finally 
			{
				if (gravarArq != null) 
					gravarArq.close();
			}
		}
		else
			JOptionPane.showMessageDialog(null,"Arquivo ja existe. Dados acrescentados serao incluidos no mesmo.");
		Menu.chamarMenu(loja);
		return loja;
	}

	/**
	 * Adiciona um novo carro com os atributos imputados pelo usuario
	 * @param loja loja cujo estoque recebera o carro 
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static void adicionarCarro(Loja loja) throws IOException
	{
		//variaveis nescessarias para a construcao de um novo Carro
		Montadora   _montadora   = null;
		ModeloCarro _modelo      = null;
		TipoCarro   _tipo 	     = null;
		Cambio 		_cambio      = null;
		Cor 		_cor 	     = null;
		float 		_motorizacao = 0; 
		String 		_chassi      = "";
		float 		_preco 		 = 0;
		int aux;

		String input = (JOptionPane.showInputDialog("Digite o chassi: "));
		for (Carro c: loja.estoqueDeCarros)
		{
			if (c.getChassi().equals(input))
			{
				JOptionPane.showMessageDialog(null, "Esse carro ja esta cadastrado.");
				Menu.chamarMenuCarro(loja);
			}
		}
		_chassi = input;

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da montadora: (VOLKSWAGEN(1),FORD(2),CHEVROLET(3),FIAT(4))"));
		while (aux <= 0 || aux >=5) //tratamento de excecao limitando o indice que pode ser escolhido, utilizado sempre que tratar-se de uma enumeracao
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da montadora: \n (VOLKSWAGEN(1),FORD(2),CHEVROLET(3),FIAT(4))"));
		}
		for (Montadora m: Montadora.values()) //percorre a enumeracao
		{
			if (m.getIndice() == (aux-1)) //verifica qual valor da enumeracao possui o indice escolhido
				_montadora = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo: 	(FOX(1),GOL(2),CELTA(3))"));
		while (aux <= 0 || aux >=4)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo: 	(FOX(1),GOL(2),CELTA(3))"));
		}
		for (ModeloCarro m: ModeloCarro.values())
		{
			if (m.getIndice() == (aux-1))
				_modelo = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:      (SEDAN (1),HATCH (2),SUV (3))"));
		while (aux <= 0 || aux >=4)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:      (SEDAN (1),HATCH (2),SUV (3))"));
		}
		for (TipoCarro m: TipoCarro.values())
		{
			if (m.getIndice() == (aux-1))
				_tipo = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do cambio:    (MANUAL(1),SEMI (2),AUTO (3))"));
		while (aux <= 0 || aux >=4)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do cambio:    (MANUAL(1),SEMI (2),AUTO (3))"));
		}
		for (Cambio m: Cambio.values())
		{
			if (m.getIndice() == (aux-1))
				_cambio = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))"));
		while (aux <= 0 || aux >=7)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))"));
		}
		for (Cor m: Cor.values())
		{
			if (m.getIndice() == (aux-1))
				_cor = m;
		}

		_motorizacao = Float.parseFloat(JOptionPane.showInputDialog("Digite numero do motor:		(1.0/1.4/1.6/1.8/2.0)"));

		_preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preco do carro"));

		//chamando o metodo construtor e colocando o carro criado no array de carros da loja
		Carro carroaux = new Carro(_chassi, _montadora, _modelo, _tipo, _cor, _motorizacao, _cambio, _preco);
		loja.estoqueDeCarros.add(carroaux);

		//-----------------ESCREVENDO NO ARQUIVO-------------------------------------------------------------------//
		try
		{
			gravarArq = new PrintWriter((new BufferedWriter(new FileWriter(Principal.nomearq, true)))); //true garante que a escrita nao sobrescreva o conteudo atual
			gravarArq.printf("\nCarro %s", carroaux); //dados que serao escritos
			gravarArq.println();
			gravarArq.flush(); //limpa buffer
		} 
		finally 
		{
			if (gravarArq != null) 
			{
				gravarArq.close();
			} 
		}
		JOptionPane.showMessageDialog(null,"Carro cadastrado com sucesso.");
		Menu.chamarMenu(loja);
	}

	/**
	 * Adiciona uma nova moto com os atributos imputados pelo usuario
	 * @param loja loja cujo estoque recebera a moto 
	 * @throws IOException para excecoes de entrada e saida
	 */
	public static void adicionarMoto(Loja loja) 
			throws IOException
	{
		Montadora   _montadora          = null;
		ModeloMoto  _modelo             = null;
		TipoMoto    _tipo 	    	    = null;
		int 		_capacidadeDoTanque = 0;
		Cor 		_cor 	            = null;
		int 		_cilindradas 		= 0; 
		String 		_chassi      		= "";
		float 		_preco 		 		= 0;
		int aux;

		String input = (JOptionPane.showInputDialog("Digite o chassi: "));
		for (Motocicleta c: loja.estoqueDeMotocicletas)
		{
			if (c.getChassi().equals(input))
			{
				JOptionPane.showMessageDialog(null, "Essa moto ja esta cadastrada.");
				Menu.chamarMenuMoto(loja);
			}
		}
		_chassi = input;
		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da montadora: (HONDA(5),SUZUKI(6),YAMAHA(7),KAWASAKI(8))"));
		while (aux <= 4 || aux >=9)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da montadora: (HONDA(5),SUZUKI(6),YAMAHA(7),KAWASAKI(8))"));
		}
		for (Montadora m: Montadora.values())
		{
			if (m.getIndice() == aux)
				_montadora = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo: 	(CBR(1),NINJA(2),CB_HORNET(3))"));
		while (aux <= 0 || aux >=4)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do modelo: 	(CBR(1),NINJA(2),CB_HORNET(3))"));
		}
		for (ModeloMoto m: ModeloMoto.values())
		{
			if (m.getIndice() == (aux-1))
				_modelo = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:      (CHOPPER (1),SCOOTER (2),ESPORTIVO (3))"));
		while (aux <= 0 || aux >=4)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero do tipo:      (CHOPPER (1),SCOOTER (2),ESPORTIVO (3))"));
		}
		for (TipoMoto m: TipoMoto.values())
		{
			if (m.getIndice() == (aux-1))
				_tipo = m;
		}

		aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))"));
		while (aux <= 0 || aux >= 7)
		{
			JOptionPane.showMessageDialog(null,"Valor Invalido. Insira outro valor:");
			aux = Integer.parseInt(JOptionPane.showInputDialog("Digite numero da Cor:       (PRETO(1),BRANCO(2),AZUL(3),VERDE(4),ROSA(5),AMARELO(6))"));
		}
		for (Cor m: Cor.values())
		{
			if (m.getIndice() == (aux-1))
				_cor = m;
		}

		_cilindradas = Integer.parseInt(JOptionPane.showInputDialog("Digite numero de cilindradas (Ex: 50, 60, 100, 120, 150):"));	
		_capacidadeDoTanque = Integer.parseInt(JOptionPane.showInputDialog("Digite a capacidade do Tanque:"));
		_preco = Float.parseFloat(JOptionPane.showInputDialog("Digite o preco da moto:"));

		Motocicleta motoaux = new Motocicleta (_chassi, _montadora, _modelo, _tipo, _cor, _cilindradas, _capacidadeDoTanque, _preco);
		loja.estoqueDeMotocicletas.add(motoaux);

		//-----------------ESCREVENDO NO ARQUIVO-------------------------------------------------------------------//
		try
		{
			gravarArq = new PrintWriter((new BufferedWriter(new FileWriter(Principal.nomearq, true))));
			gravarArq.printf("Moto %s", motoaux);
			gravarArq.println();
			gravarArq.flush();
		} 
		finally 
		{
			if (gravarArq != null) 
			{
				gravarArq.close();
			} 
		}

		JOptionPane.showMessageDialog(null,"Moto Cadastrada com Sucesso");
		Menu.chamarMenu(loja);
	}

	/**
	 * Metodo listarEstoqueDeCarros exibe todos os carros que foram adicionados ao estoque da loja
	 * @param loja loja que esta sendo pesquisada
	 */
	public static void listarEstoqueDeCarros (Loja loja){

		// Criacao de Buffer para receber os valores do Array A
		StringBuilder carrosA = new StringBuilder();
		int i = 1;

		for (Carro c: loja.estoqueDeCarros)
		{
			carrosA.append(" - " + c + "\n");
			i++;
		}
		JOptionPane.showMessageDialog(null,"Lista de Carros: \n" + carrosA.toString());
	}

	/**
	 * Metodo listarEstoqueDeMotocicletas exibe todas as motocicletas que foram adicionadas ao estoque da loja
	 * @param loja loja que esta sendo pesquisada
	 */
	public static void listarEstoqueDeMotocicletas (Loja loja){
		// Criacao de Buffer para receber os valores do Array A
		StringBuilder motosA = new StringBuilder();
		int i = 1;

		for (Motocicleta m: loja.estoqueDeMotocicletas)
		{
			motosA.append(" - " + m + "\n");
			i++;
		}
		JOptionPane.showMessageDialog(null,"Lista de Motos: \n" + motosA.toString());
	}

	/**
	 * Busca por um carro baseado pelo chassi recebido por parametro
	 * @param chassi chassi do carro que sera buscado
	 * @param loja na qual sera efetada a busca
	 * @return carro carro que foi encontrado pela busca
	 */
	public static Carro buscarCarro(String chassi, Loja loja){
		Carro carro = null;

		for (Carro car: loja.estoqueDeCarros)
		{
			if (chassi.equals(car.getChassi())) {
				carro = car;
			}
		}
		return carro;
	}

	/**
	 * Busca por uma moto baseado pelo chassi recebido por parametro
	 * @param chassi chassi da moto que sera buscada
	 * @param loja na qual sera efetada a busca
	 * @return moto moto que foi encontrado pela busca
	 */
	public static Motocicleta buscarMoto(String chassi, Loja loja){
		Motocicleta moto = null;

		for (Motocicleta m: loja.estoqueDeMotocicletas)
		{
			if (chassi.equals(m.getChassi())) {
				moto = m;
			}
		}
		return moto;
	}

	/**
	 * Printa um carro, utilizando os atributos passados, caso exista no inventário.
	 * @param loja loja sendo tratada
	 * @throws IOException Excecoes de entrada e saida e seus tratamentos
	 */
	public static void pesquisarCarro(Loja loja) throws IOException
	{
		int indice = Menu.menuPesquisaCarro(loja);
		switch (indice)
		{
		case 0:
			String chassi = JOptionPane.showInputDialog("Insira o Chassi que voce deseja procurar: ");
			Carro car = Loja.buscarCarro(chassi, loja);
			if (car != null)
				JOptionPane.showMessageDialog(null, "Carro Encontrado!\n" + car);
			else
				JOptionPane.showMessageDialog(null, "Carro Nao Encontrado.");
			break;
		case 1:
			int auxMon = 0;
			Object[] itensMon = {"Listar carros " + Montadora.VOLKSWAGEN, "Listar carros " + Montadora.FORD, "Listar carros " + Montadora.CHEVROLET, "Listar carros " + Montadora.FIAT,
			"Voltar para o Menu Pesquisa de Carros"};
			Object selectedMon = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itensMon, itensMon [0]);

			if ((selectedMon == itensMon[4])||(selectedMon == null))
			{
				JOptionPane.showMessageDialog(null,"Voltando para o menu Pesquisa de Carros");
				Menu.menuPesquisaCarro(loja);
			}
			for (int i = 0; i < 4; i++)
			{
				if (selectedMon == itensMon[i])
					auxMon = i;
			}

			ArrayList <Carro> carrosMontadora = new ArrayList <Carro>();
			for (Carro c: loja.estoqueDeCarros)
			{
				int indMont = c.getMontadora().getIndice();
				if (indMont == auxMon)
					carrosMontadora.add(c);
			}
			if ((carrosMontadora.size() != 0))
			{
				JOptionPane.showMessageDialog(null,"Carros encontrados:");
				for (Carro c: carrosMontadora)
					JOptionPane.showMessageDialog(null, c);			
			}
			else
				JOptionPane.showMessageDialog(null,"Nenhum Carro dessa Montadora foi encontrado.");
			break;
		case 2:
			int auxMod = -1;
			Object[] itensMod = {"Listar carros " + ModeloCarro.FOX, "Listar carros " + ModeloCarro.GOL, "Listar carros " + ModeloCarro.CELTA, "Voltar para Menu Pesquisa de Carros"};
			Object selectedMod = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itensMod, itensMod [0]);

			if ((selectedMod == itensMod[3])||(selectedMod == null))
			{
				JOptionPane.showMessageDialog(null,"Voltando para o menu Pesquisa de Carros");
				Menu.menuPesquisaCarro(loja);
			}
			for (int i = 0; i < 3; i++)
			{
				if (selectedMod == itensMod[i])
					auxMod = i;
			}

			ArrayList <Carro> carrosModelo = new ArrayList <Carro>();
			for (Carro c: loja.estoqueDeCarros)
			{
				int indMod = c.getModelo().getIndice();
				if (indMod == auxMod)
					carrosModelo.add(c);
			}
			if ((carrosModelo.size() != 0))
			{
				JOptionPane.showMessageDialog(null,"Carros encontrados:");
				for (Carro c: carrosModelo)
					JOptionPane.showMessageDialog(null, c);			
			}
			else
				JOptionPane.showMessageDialog(null,"Nenhum Carro desse Modelo foi encontrado.");
			break;
		case 3:
			int auxTipo = -1;
			Object[] itensTipo = {"Listar carros " + TipoCarro.SEDAN, "Listar carros " + TipoCarro.HATCH, "Listar carros " + TipoCarro.SUV, "Voltar para Menu Pesquisa de Carros"};
			Object selectedTipo = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itensTipo, itensTipo [0]);

			if ((selectedTipo == itensTipo[3])||(selectedTipo == null))
			{
				JOptionPane.showMessageDialog(null,"Voltando para o menu Pesquisa de Carros");
				Menu.menuPesquisaCarro(loja);
			}
			for (int i = 0; i < 3; i++)
			{
				if (selectedTipo == itensTipo[i])
					auxTipo = i;
			}

			ArrayList <Carro> carrosTipo = new ArrayList <Carro>();
			for (Carro c: loja.estoqueDeCarros)
			{
				int indTipo = c.getTipo().getIndice();
				if (indTipo == auxTipo)
					carrosTipo.add(c);
			}
			if ((carrosTipo.size() != 0))
			{
				JOptionPane.showMessageDialog(null,"Carros encontrados:");
				for (Carro c: carrosTipo)
					JOptionPane.showMessageDialog(null, c);			
			}
			else
				JOptionPane.showMessageDialog(null,"Nenhuma Carro desse Tipo foi encontrado");
			break;
		case 4:
			int auxCor = -1;
			Object[] itensCor = {"Listar carros na cor " + Cor.PRETO, "Listar carros na cor " + Cor.BRANCO, "Listar carros na cor " + Cor.AZUL,"Listar carros na cor " + Cor.VERDE,
					"Listar carros na cor " + Cor.ROSA, "Listar carros na cor " + Cor.AMARELO, "Voltar para Menu Pesquisa de Carros"};
			Object selectedCor = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itensCor, itensCor [0]);

			if ((selectedCor == itensCor[6])||(selectedCor == null))
			{
				JOptionPane.showMessageDialog(null,"Voltando para o menu Pesquisa de Carros");
				Menu.menuPesquisaCarro(loja);
			}
			for (int i = 0; i < 6; i++)
			{
				if (selectedCor == itensCor[i])
					auxCor = i;
			}

			ArrayList <Carro> carrosCor = new ArrayList <Carro>();
			for (Carro c: loja.estoqueDeCarros)
			{
				int indCor = c.getCor().getIndice();
				if (indCor == auxCor)
					carrosCor.add(c);
			}
			if ((carrosCor.size() != 0))
			{
				JOptionPane.showMessageDialog(null,"Carros encontrados:");
				for (Carro c: carrosCor)
					JOptionPane.showMessageDialog(null, c);			
			}
			else
				JOptionPane.showMessageDialog(null,"Nenhuma Carro dessa Cor foi encontrado");
			break;
		case 5:
			try{
				String input = JOptionPane.showInputDialog("Insira a Motorizacao que voce deseja procurar: ");
				float motorizacao = Float.parseFloat(validarInput(input));
				ArrayList <Carro> carrosMotor = new ArrayList <Carro>();
				for (Carro c: loja.estoqueDeCarros)
				{
					if (c.getMotorizacao() == motorizacao)
						carrosMotor.add(c);
				}
				if ((carrosMotor.size() != 0))
				{
					JOptionPane.showMessageDialog(null,"Carros encontrados:");
					for (Carro c: carrosMotor)
						JOptionPane.showMessageDialog(null, c);			
				}
				else
					JOptionPane.showMessageDialog(null,"Nenhum Carro dessa Motorizacao foi encontrado");	
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor invalido. Voltando para o menu Pesquisa de Carros");
				Menu.menuPesquisaCarro(loja);
			}
			break;
		case 6:
			int auxCambio = -1;
			Object[] itensCambio = {"Listar carros " + Cambio.MANUAL, "Listar carros " + Cambio.SEMI, "Listar carros " + Cambio.AUTO, "Voltar para Menu Pesquisa de Carros"};
			Object selectedCambio = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itensCambio, itensCambio [0]);

			if ((selectedCambio == itensCambio[3])||(selectedCambio == null))
			{
				JOptionPane.showMessageDialog(null,"Voltando para o menu Pesquisa de Carros");
				Menu.menuPesquisaCarro(loja);
			}
			for (int i = 0; i < 3; i++)
			{
				if (selectedCambio == itensCambio[i])
					auxCambio = i;
			}

			ArrayList <Carro> carrosCambio = new ArrayList <Carro>();
			for (Carro c: loja.estoqueDeCarros)
			{
				int indCambio = c.getTipo().getIndice();
				if (indCambio == auxCambio)
					carrosCambio.add(c);
			}
			if ((carrosCambio.size() != 0))
			{
				JOptionPane.showMessageDialog(null,"Carros encontrados:");
				for (Carro c: carrosCambio)
					JOptionPane.showMessageDialog(null, c);			
			}
			else
				JOptionPane.showMessageDialog(null,"Nenhuma Carro desse Cambio foi encontrado");
			break;
		case 7:
			try{
				String input = JOptionPane.showInputDialog("Insira o Preco que voce deseja procurar: ");
				float preco = Float.parseFloat(validarInput(input));
				ArrayList <Carro> carrosPreco = new ArrayList <Carro>();
				for (Carro c: loja.estoqueDeCarros)
				{
					if (c.getPreco() == preco)
						carrosPreco.add(c);
				}
				if ((carrosPreco.size() != 0))
				{
					JOptionPane.showMessageDialog(null,"Carros encontrados:");
					for (Carro c: carrosPreco)
						JOptionPane.showMessageDialog(null, c);			
				}
				else
					JOptionPane.showMessageDialog(null,"Nenhum Carro desse Preco foi encontrado");	
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor invalido. Voltando para o menu Pesquisa de Carros");
				Menu.menuPesquisaCarro(loja);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Valor Inválido, escolha outra opcao.");
			Menu.menuPesquisaCarro(loja);
		}
		Menu.chamarMenuCarro(loja);
	}

	/**
	 * Printa uma moto, utilizando os atributos passados, caso exista no inventário.
	 * @param loja loja sendo tratada
	 * @throws IOException Excecoes de entrada e saida e seus tratamentos
	 */
	public static void pesquisarMoto(Loja loja) throws IOException
	{
		int indice = Menu.menuPesquisaMoto(loja);
		switch (indice)
		{
		case 0:
			String chassi = JOptionPane.showInputDialog("Insira o Chassi que voce deseja procurar: ");
			Motocicleta moto = Loja.buscarMoto(chassi, loja);
			if (moto != null)
				JOptionPane.showMessageDialog(null, "Moto Encontrada!\n" + moto);
			else
				JOptionPane.showMessageDialog(null, "Moto Nao Encontrada.");
			Menu.chamarMenuMoto(loja);
			break;
		case 1:
			int auxMon = 0;
			Object[] itensMon = {"Listar motos " + Montadora.HONDA, "Listar motos " + Montadora.SUZUKI, "Listar motos " + Montadora.YAMAHA, "Listar motos " + Montadora.KAWASAKI,
			"Voltar para o Menu Pesquisa de Motos"};
			Object selectedMon = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itensMon, itensMon [0]);

			if ((selectedMon == itensMon[4])||(selectedMon == null))
			{
				JOptionPane.showMessageDialog(null,"Voltando para o menu Pesquisa de Motos");
				Menu.menuPesquisaMoto(loja);
			}
			for (int i = 0; i < 4; i++)
			{
				if (selectedMon == itensMon[i])
					auxMon = i+5;
			}

			ArrayList <Motocicleta> motosMontadora = new ArrayList <Motocicleta>();
			for (Motocicleta m: loja.estoqueDeMotocicletas)
			{
				int indMont = m.getMontadora().getIndice();
				if (indMont == auxMon)
					motosMontadora.add(m);
			}
			if ((motosMontadora.size() != 0))
			{
				JOptionPane.showMessageDialog(null,"Motos encontradas:");
				for (Motocicleta m: motosMontadora)
					JOptionPane.showMessageDialog(null, m);			
			}
			else
				JOptionPane.showMessageDialog(null,"Nenhuma Moto dessa Montadora foi encontrada.");
			break;
		case 2:
			int auxMod = -1;
			Object[] itensMod = {"Listar motos " + ModeloMoto.CBR, "Listar motos " + ModeloMoto.NINJA, "Listar motos " + ModeloMoto.CB_HORNET, "Voltar para Menu Pesquisa de Motos"};
			Object selectedMod = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itensMod, itensMod [0]);

			if ((selectedMod == itensMod[3])||(selectedMod == null))
			{
				JOptionPane.showMessageDialog(null,"Voltando para o menu Pesquisa de Motos");
				Menu.menuPesquisaMoto(loja);
			}
			for (int i = 0; i < 3; i++)
			{
				if (selectedMod == itensMod[i])
					auxMod = i;
			}

			ArrayList <Motocicleta> motosModelo = new ArrayList <Motocicleta>();
			for (Motocicleta m: loja.estoqueDeMotocicletas)
			{
				int indMod = m.getModelo().getIndice();
				if (indMod == auxMod)
					motosModelo.add(m);
			}
			if ((motosModelo.size() != 0))
			{
				JOptionPane.showMessageDialog(null,"Motos encontradas:");
				for (Motocicleta m: motosModelo)
					JOptionPane.showMessageDialog(null, m);			
			}
			else
				JOptionPane.showMessageDialog(null,"Nenhuma Moto desse Modelo foi encontrada.");
			break;
		case 3:
			int auxTipo = -1;
			Object[] itensTipo = {"Listar motos " + TipoMoto.CHOPPER, "Listar motos " + TipoMoto.SCOOTER, "Listar motos " + TipoMoto.ESPORTIVO, "Voltar para Menu Pesquisa de Motos"};
			Object selectedTipo = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itensTipo, itensTipo [0]);

			if ((selectedTipo == itensTipo[3])||(selectedTipo == null))
			{
				JOptionPane.showMessageDialog(null,"Voltando para o menu Pesquisa de Motos");
				Menu.menuPesquisaMoto(loja);
			}
			for (int i = 0; i < 3; i++)
			{
				if (selectedTipo == itensTipo[i])
					auxTipo = i;
			}

			ArrayList <Motocicleta> motosTipo = new ArrayList <Motocicleta>();
			for (Motocicleta m: loja.estoqueDeMotocicletas)
			{
				int indTipo = m.getTipo().getIndice();
				if (indTipo == auxTipo)
					motosTipo.add(m);
			}
			if ((motosTipo.size() != 0))
			{
				JOptionPane.showMessageDialog(null,"Motos encontradas:");
				for (Motocicleta m: motosTipo)
					JOptionPane.showMessageDialog(null, m);			
			}
			else
				JOptionPane.showMessageDialog(null,"Nenhuma Moto desse Tipo foi encontrada");
			break;
		case 4:
			int auxCor = -1;
			Object[] itensCor = {"Listar motos na cor " + Cor.PRETO, "Listar motos na cor " + Cor.BRANCO, "Listar motos na cor " + Cor.AZUL,"Listar motos na cor " + Cor.VERDE,
					"Listar motos na cor " + Cor.ROSA, "Listar motos na cor " + Cor.AMARELO, "Voltar para Menu Pesquisa de Motos"};
			Object selectedCor = JOptionPane.showInputDialog(null, "O que voce deseja fazer?", "Opcao", JOptionPane.INFORMATION_MESSAGE, null, itensCor, itensCor [0]);

			if ((selectedCor == itensCor[6])||(selectedCor == null))
			{
				JOptionPane.showMessageDialog(null,"Voltando para o menu Pesquisa de Motos");
				Menu.menuPesquisaMoto(loja);
			}
			for (int i = 0; i < 6; i++)
			{
				if (selectedCor == itensCor[i])
					auxCor = i;
			}

			ArrayList <Motocicleta> motosCor = new ArrayList <Motocicleta>();
			for (Motocicleta m: loja.estoqueDeMotocicletas)
			{
				int indCor = m.getCor().getIndice();
				if (indCor == auxCor)
					motosCor.add(m);
			}
			if ((motosCor.size() != 0))
			{
				JOptionPane.showMessageDialog(null,"Motos encontradas:");
				for (Motocicleta m: motosCor)
					JOptionPane.showMessageDialog(null, m);			
			}
			else
				JOptionPane.showMessageDialog(null,"Nenhuma Moto dessa Cor foi encontrada");
			break;
		case 5:
			try{
				String input = JOptionPane.showInputDialog("Insira as Cilindradas que voce deseja procurar: ");
				int cilindrada = Integer.parseInt(validarInput(input));
				ArrayList <Motocicleta> motosCilin = new ArrayList <Motocicleta>();
				for (Motocicleta m: loja.estoqueDeMotocicletas)
				{
					if (m.getCilindrada() == cilindrada)
						motosCilin.add(m);
				}
				if ((motosCilin.size() != 0))
				{
					JOptionPane.showMessageDialog(null,"Motos encontradas:");
					for (Motocicleta m: motosCilin)
						JOptionPane.showMessageDialog(null, m);			
				}
				else
					JOptionPane.showMessageDialog(null,"Nenhuma Moto dessa Cilindrada foi encontrada");	
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor invalido. Voltando para o menu Pesquisa de Motos");
				Menu.menuPesquisaMoto(loja);
			}
			break;
		case 6:
			try{
				String input = JOptionPane.showInputDialog("Insira a Capacidade do Tanque que voce deseja procurar: ");
				float capacidade = Float.parseFloat(validarInput(input));
				ArrayList <Motocicleta> motosCap = new ArrayList <Motocicleta>();
				for (Motocicleta m: loja.estoqueDeMotocicletas)
				{
					if (m.getCapacidadeDoTanque() == capacidade)
						motosCap.add(m);
				}
				if ((motosCap.size() != 0))
				{
					JOptionPane.showMessageDialog(null,"Motos encontradas:");
					for (Motocicleta m: motosCap)
						JOptionPane.showMessageDialog(null, m);			
				}
				else
					JOptionPane.showMessageDialog(null,"Nenhuma Moto dessa Capacidade de Tanque foi encontrada");	
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor invalido. Voltando para o menu Pesquisa de Motos");
				Menu.menuPesquisaMoto(loja);
			}
			break;
		case 7:
			try{
				String input = JOptionPane.showInputDialog("Insira o Preco que voce deseja procurar: ");
				float preco = Float.parseFloat(validarInput(input));
				ArrayList <Motocicleta> motosPreco = new ArrayList <Motocicleta>();
				for (Motocicleta m: loja.estoqueDeMotocicletas)
				{
					if (m.getPreco() == preco)
						motosPreco.add(m);
				}
				if ((motosPreco.size() != 0))
				{
					JOptionPane.showMessageDialog(null,"Motos encontradas:");
					for (Motocicleta m: motosPreco)
						JOptionPane.showMessageDialog(null, m);			
				}
				else
					JOptionPane.showMessageDialog(null,"Nenhuma Moto desse Preco foi encontrada");	
			}
			catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Valor invalido. Voltando para o menu Pesquisa de Motos");
				Menu.menuPesquisaMoto(loja);
			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Valor Inválido, escolha outra opcao.");
			Menu.menuPesquisaMoto(loja);
		}
		Menu.chamarMenuMoto(loja);
	}

	/**
	 * Pesquisa e retorna um carro com valores específicos no estoque, caso ele exista
	 * @param loja loja do estoque
	 * @param chassi chassi do carro
	 * @param montadora montadora do carro
	 * @param modelo modelo do carro
	 * @param tipo tipo do carro
	 * @param cor cor do carro
	 * @param motorizacao motorizacao do carro
	 * @param cambio cambio do carro
	 * @param preco preco do carro
	 * @return carroOk retorna o carro, caso ele exista
	 */
	public static Carro pesquisarCarroEspecifico(Loja loja, String chassi, int montadora, int modelo, int tipo, int cor, float motorizacao, int cambio, float preco)
	{
		Carro carroOk = null;
		for (Carro c: loja.estoqueDeCarros)
		{
			if (c.getChassi().equals(chassi))
				if (c.getMontadora().getIndice() == (montadora-1))
					if (c.getModelo().getIndice() == (modelo-1))
						if (c.getTipo().getIndice() == (tipo-1))
							if (c.getCor().getIndice() == (cor-1))
								if (c.getMotorizacao() == motorizacao)
									if (c.getCambio().getIndice() == (cambio-1))
										if (c.getPreco() == preco)
										{
											carroOk = c;
											break;
										}

		}
		return carroOk;
	}
	
	/**
	 * Pesquisa e retorna uma moto com valores específicos no estoque, caso ela exista
	 * @param loja loja do estoque
	 * @param chassi chassi da moto
	 * @param montadora montadora da moto
	 * @param modelo modelo da moto
	 * @param tipo tipo da moto
	 * @param cor cor da moto
	 * @param cilindrada cilindrada da moto
	 * @param capacidadeDoTanque capacidade do tanque da moto
	 * @param preco preco da moto
	 * @return motoOk retorna motocicleta, caso ela exista
	 */
	public static Motocicleta pesquisarMotoEspecifica(Loja loja, String chassi, int montadora, int modelo, int tipo, int cor, int cilindrada, int capacidadeDoTanque, float preco)
	{
		Motocicleta motoOk = null;
		for (Motocicleta m: loja.estoqueDeMotocicletas)
		{
			if (m.getChassi().equals(chassi))
				if (m.getMontadora().getIndice() == (montadora+4))
					System.out.println("ok");
					if (m.getModelo().getIndice() == (modelo-1))
						if (m.getTipo().getIndice() == (tipo-1))
							if (m.getCor().getIndice() == (cor-1))
								if (m.getCilindrada() == cilindrada)
									if (m.getCapacidadeDoTanque() == capacidadeDoTanque)
										if (m.getPreco() == preco)
										{
											motoOk = m;
											break;
										}
		}
		return motoOk;
	}
	/**
	 * Metodo removerCarro remove o carro com o chassi desejado da array estoqueDeMotocicletas
	 * @param chassi chassi do carro
	 * @param loja loja do estoque
	 */
	public static void removerCarro(String chassi, Loja loja)	
	{
		Carro carro = null;
		for (int i = 0; i< loja.estoqueDeCarros.size(); i++)
		{
			if (loja.estoqueDeCarros.get(i).getChassi().equals(chassi))
			{
				carro = loja.estoqueDeCarros.get(i);
				loja.estoqueDeCarros.remove(loja.estoqueDeCarros.get(i));
				break;
			}
		}
		if (carro == null)
			JOptionPane.showMessageDialog(null, "Nao existe Carro com esse Chassi no Estoque");
		else
		{
			
			JOptionPane.showMessageDialog(null, "Carro Removido com sucesso.");
		}	
	}

	/**
	 * Metodo removerMotocicleta remove a motocicleta com o chassi desejado da array estoqueDeMotocicletas
	 * @param chassi chassi da moto
	 * @param loja loja do estoque
	 */
	public static void removerMotocicleta(String chassi, Loja loja)	
	{
		Motocicleta moto = null;
		for (int i = 0; i< loja.estoqueDeMotocicletas.size(); i++)
		{
			if (loja.estoqueDeMotocicletas.get(i).getChassi().equals(chassi))
			{
				moto = loja.estoqueDeMotocicletas.get(i);
				loja.estoqueDeMotocicletas.remove(loja.estoqueDeMotocicletas.get(i));
				break;
			}
		}
		if (moto == null)
			JOptionPane.showMessageDialog(null, "Nao existe moto com esse Chassi no Estoque");
		else
		{
			JOptionPane.showMessageDialog(null, "Moto Removida com sucesso.");
		}	
	}

	/**
	 * Metodo equals sobrescreve o equals da classe
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loja other = (Loja) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estoqueDeCarros == null) {
			if (other.estoqueDeCarros != null)
				return false;
		} else if (!estoqueDeCarros.equals(other.estoqueDeCarros))
			return false;
		if (estoqueDeMotocicletas == null) {
			if (other.estoqueDeMotocicletas != null)
				return false;
		} else if (!estoqueDeMotocicletas.equals(other.estoqueDeMotocicletas))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	//GETTERS
	/**
	 * getNome Retorna o nome da Loja
	 * @return nome nome da loja
	 */
	public String                 getNome() {
		return nome;
	}
	/**
	 * getEndereco Retorna o endereco da loja
	 * @return endereco endereco da loja
	 */
	public String                 getEndereco() {
		return endereco;
	}
	/**
	 * getEstoqueDeCarros retorna o ArrayList do estoque de carros da loja
	 * @return estoqueDeCarros estoque de carros da loja
	 */
	public ArrayList<Carro>       getEstoqueDeCarros() {
		return estoqueDeCarros;
	}

	/**
	 * getEstoqueDeMotocicletas retorna o ArrayList do estoque de motocicletas da loja
	 * @return estoqueDeMotocicletas estoque de motocicletas da loja
	 */
	public ArrayList<Motocicleta> getEstoqueDeMotocicletas() {
		return estoqueDeMotocicletas;
	}

	//SETTERS
	/**
	 * setNome altera o valor da variavel nome para o que foi passado pelo parametro nome
	 * @param nome nome da loja
	 */
	public void                   setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * setEndereco altera o valor da variavel endereco para o que foi passado pelo parametro endereco
	 * @param endereco endereco da loja
	 */

	public void                   setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * setEstoqueDeCarros altera os valores da ArrayList estoqueDeCarros para os valores da ArrayList que foi passada pelo parametro estoqueDeCarros
	 * @param estoqueDeCarros estoque de carros da loja
	 */
	public void                   setEstoqueDeCarros(ArrayList<Carro> estoqueDeCarros) {
		this.estoqueDeCarros = estoqueDeCarros;
	}

	/**
	 * setEstoqueDeMotocicletas altera os valores da ArrayList estoqueDeMotocicletas para os valores da ArrayList que foi passada pelo parametro estoqueDeMotocicletas
	 * @param estoqueDeMotocicletas estoque de motocicletas da loja
	 */
	public void 		      setEstoqueDeMotocicletas(ArrayList<Motocicleta> estoqueDeMotocicletas) {
		this.estoqueDeMotocicletas = estoqueDeMotocicletas;
	}
}