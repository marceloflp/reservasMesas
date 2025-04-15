package br.com.restaurante.reservasMesas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restaurante.reservasMesas.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
