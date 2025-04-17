package br.com.restaurante.reservasMesas.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.restaurante.reservasMesas.entities.Cliente;
import br.com.restaurante.reservasMesas.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	private final ClienteService clienteService;
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService  = clienteService;
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll(){
		List<Cliente> cliente = clienteService.findAll();
		return ResponseEntity.ok(cliente);
	}
}
