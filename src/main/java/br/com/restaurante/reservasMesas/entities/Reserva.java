package br.com.restaurante.reservasMesas.entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.restaurante.reservasMesas.entities.enums.ReservaStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_reserva")
public class Reserva  implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant data;
	
	@JsonFormat(pattern = "HH:mm")
	private LocalTime horario;
	
	private Integer numPessoas;
	private Integer status;
	
	public Reserva() {
		
	}

	public Reserva(Long id, Instant data, LocalTime horario, Integer numPessoas, ReservaStatus status) {
		super();
		this.id = id;
		this.data = data;
		this.horario = horario;
		this.numPessoas = numPessoas;
		setStatus(status);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}

	public Integer getNumPessoas() {
		return numPessoas;
	}

	public void setNumPessoas(Integer numPessoas) {
		this.numPessoas = numPessoas;
	}

	public ReservaStatus getStatus() {
		return ReservaStatus.valueOf(status);
	}

	public void setStatus(ReservaStatus status) {
		if(status != null) {
			this.status = status.getCode();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		return Objects.equals(id, other.id);
	}
	
}
