package andrearuzittu.EpicodeItjava5D5.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import andrearuzittu.EpicodeItjava5D5.entity.Utente;

public interface UserRepository extends JpaRepository<Utente, Long> {
	Optional<Utente> findByUsername(String username);

	Optional<Utente> findByEmail(String email);
}