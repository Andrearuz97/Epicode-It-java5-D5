package andrearuzittu.EpicodeItjava5D5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Device {
	public enum Stato {
		ASSEGNATO, MANUTENZIONE, DISMESSO
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Stato stato;
	private String type;
	private String status;

	@ManyToOne
	private Utente utente;

	public void setType(String type) {
		this.type = type;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
