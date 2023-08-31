package andrearuzittu.EpicodeItjava5D5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import andrearuzittu.EpicodeItjava5D5.entity.Utente;
import andrearuzittu.EpicodeItjava5D5.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public List<Utente> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Utente getUserById(Long id) {
		Optional<Utente> userOptional = userRepository.findById(id);
		return userOptional.orElse(null);
	}

	@Override
	public Utente createUser(Utente user) {
		return userRepository.save(user);
	}

	@Override
	public Utente updateUser(Long id, Utente user) {
		User existingUser = getUserById(id);
		if (existingUser != null) {
			// Aggiornare i campi necessari dell'utente esistente con i dati del nuovo
			// utente
			existingUser.setUsername(user.getUsername());
			existingUser.setName(user.getNome());
			existingUser.setCognome(Utente.getCognome());
			existingUser.setEmail(user.getEmail());
			return userRepository.save(existingUser);
		}
		return null;
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
}
