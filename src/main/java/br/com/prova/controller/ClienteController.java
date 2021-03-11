package br.com.prova.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
		List<Cliente> clientes =this.clienteRepository.findAll();
		return new ModelAndView("/clientes/list","clientes",clientes);
	}
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Cliente cliente) {
		ModelAndView modelAndView = new ModelAndView("clientes/view");
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
		Cliente cliente = clienteDto.toCliente();
		cliente = this.clienteRepository.save(cliente);
		return new ModelAndView("redirect:/" + "clientes");
	}

	
}
