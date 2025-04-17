package br.com.restaurante.reservasMesas.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		Cliente cliente = clienteService.findById(id);
		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping("/adicionarCliente")
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente){
		cliente = clienteService.insert(cliente);
		 URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				 .path("/{id}").buildAndExpand(cliente.getId()).toUri();
		 return ResponseEntity.created(uri).body(cliente);
	}
}
