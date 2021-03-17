package br.com.prova.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.prova.dto.ClienteDto;
import br.com.prova.model.Cliente;
import br.com.prova.repository.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository  clienteRepository;
	
	@GetMapping
	public ModelAndView listar() {
		List<Cliente> clientes = this.clienteRepository.findAll();
		return new ModelAndView("/clientes/list","clientes",clientes);
	}
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Long clienteId) {
		ModelAndView modelAndView = new ModelAndView("clientes/view");
		Cliente cliente = this.clienteRepository.findOneById(clienteId).orElse(new Cliente());
	    modelAndView.addObject("cliente", cliente);
	    modelAndView.addObject("endereco", cliente.getEndereco());
		return modelAndView;

	}	
	@GetMapping("/novo")
	public String createForm(@ModelAttribute ClienteDto clienteDto) {
		return "clientes/form";
	}
	
	@PostMapping(params="form")
	public ModelAndView create(ClienteDto clienteDto) {
		this.clienteRepository.save(clienteDto.toCliente());
		List<Cliente> clientes = this.clienteRepository.findAll();
		ModelAndView mv = new ModelAndView("clientes/list", "clientes", clientes);
		mv.addObject("globalMessage", clienteDto.getId() != null ? "Cliente atualizado com sucesso" : "Cliente cadastrado com sucesso");
		return mv;
	}
	
	@GetMapping(value="/alterar/{id}")
	public	ModelAndView alterarForm(@PathVariable("id") Long clienteId)	{
		Cliente cliente = this.clienteRepository.findOneById(clienteId).orElse(new Cliente());
		ModelAndView mv = new ModelAndView("clientes/form","clienteDto", cliente.toClienteDto());
		mv.addObject("globalMessage", "Cliente atualizado com sucesso");
		return mv;
	
	}
	
	@GetMapping(value = "remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirect) {
		this.clienteRepository.deleteById(id);
		Iterable<Cliente> clientes = this.clienteRepository.findAll();
		
		ModelAndView mv = new ModelAndView("clientes/list", "clientes", clientes);
		mv.addObject("globalMessage", "Cliente removido com sucesso");
		return mv;
	}
	

	
}
