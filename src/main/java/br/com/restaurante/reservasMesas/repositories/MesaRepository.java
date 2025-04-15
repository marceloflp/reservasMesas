package br.com.restaurante.reservasMesas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restaurante.reservasMesas.entities.Mesa;

public interface MesaRepository extends JpaRepository<Mesa, Long> {

}
