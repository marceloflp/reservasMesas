package br.com.restaurante.reservasMesas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.restaurante.reservasMesas.entities.Cliente;
import br.com.restaurante.reservasMesas.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository Clienterepository;
	
	public ClienteService(ClienteRepository repository) {
		this.Clienterepository = repository;
	}

	public List<Cliente> findAll(){
		return Clienterepository.findAll();
	}
	
	public Cliente findById(Long id) {
		Optional<Cliente> obj = Clienterepository.findById(id);
		return obj.orElseThrow();
	}
	
	public Cliente insert(Cliente obj) {
		return Clienterepository.save(obj);
	}
	
	public Cliente update(Long id, Cliente obj) {
		Cliente cliente = Clienterepository.getReferenceById(id);
		updateCliente(cliente, obj);
		
		return Clienterepository.save(cliente);
	}
	
	private void updateCliente(Cliente cliente, Cliente obj) {
		cliente.setId(obj.getId());
		cliente.setNome(obj.getNome());
		cliente.setTelefone(obj.getTelefone());
		cliente.setEmail(obj.getEmail());
		cliente.setSenha(obj.getSenha());
	}
	
	public void delete(Long id){
		Clienterepository.deleteById(id);
	}
}
