package andrearuzittu.EpicodeItjava5D5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import andrearuzittu.EpicodeItjava5D5.entity.Utente;

public interface UserRepository extends JpaRepository<Utente, Long> {
	Utente findByUsername(String username);
}
