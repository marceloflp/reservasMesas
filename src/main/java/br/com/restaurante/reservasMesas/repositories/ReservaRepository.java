package br.com.restaurante.reservasMesas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.restaurante.reservasMesas.entities.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

}
