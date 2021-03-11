package br.com.prova.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.prova.model.Cliente;
import br.com.prova.model.Endereco;
@Component
public class RepositoryTest implements ApplicationRunner {
	
	private static final long	ID_CLIENTE_JOAO	    =	1l;
	private static final long	ID_CLIENTE_PEDRO	=	2l;
	private static final long	ID_CLIENTE_RAILSON	=	3l;
	private static final long	ID_CLIENTE_TIAGO	=	4l;
	private static final long	ID_CLIENTE_LUCAS	=	5l;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public	void run(ApplicationArguments	applicationArguments)
		throws	Exception	{
		
		System.out.println(">>>	Iniciando	carga	de	dados...");
		Endereco joaoEndereco = new Endereco("11111-111", "Rua Silveira Martins, 10", "Cabula");
		Endereco pedroEndereco = new Endereco("22222-222", "Rua Antonio Luiz, 20", "Brotas");
		Endereco railsonEndereco = new Endereco("33333-333", "Rua Alameda Grande,30", "Amaralina");
		Endereco tiagoEndereco = new Endereco("44444-444", "Rua Santo Antonio,40", "Pituba");
		Endereco lucasEndereco = new Endereco("55555-555", "Rua Campo de Luz,50", "Rio Vermelho");
		
		Cliente	joao =	new	Cliente(ID_CLIENTE_JOAO,"João Victor",25, joaoEndereco);
		Cliente	pedro = new	Cliente(ID_CLIENTE_PEDRO,"Pedro",20, pedroEndereco);
		Cliente	railson = new  Cliente(ID_CLIENTE_RAILSON,"Railson",28, railsonEndereco);
		Cliente	tiago = new	Cliente(ID_CLIENTE_TIAGO,"Tiago",29, tiagoEndereco);
		Cliente	lucas = new	Cliente(ID_CLIENTE_LUCAS,"Lucas",23, lucasEndereco);
		
		clienteRepository.saveAndFlush(joao);
		clienteRepository.saveAndFlush(pedro);
		clienteRepository.saveAndFlush(railson);
		clienteRepository.saveAndFlush(tiago);
		clienteRepository.saveAndFlush(lucas);
		
		
		
	}

}	
