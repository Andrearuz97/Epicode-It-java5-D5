package andrearuzittu.EpicodeItjava5D5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import andrearuzittu.EpicodeItjava5D5.entity.Utente;
import andrearuzittu.EpicodeItjava5D5.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<Utente> getAllUsers() {
		return userRepository.findAll();
	}

	public Utente getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public Utente createUser(Utente user) {
		return userRepository.save(user);
	}

	public Utente updateUser(Long id, Utente updatedUser) {
		Utente user = userRepository.findById(id).orElse(null);
		if (user == null) {
			return null;
		}
		// Update user properties with the new values
		user.setUsername(updatedUser.getUsername());
		user.setNome(updatedUser.getNome());
		user.setCognome(updatedUser.getCognome());
		user.setEmail(updatedUser.getEmail());

		return userRepository.save(user);
	}

	public boolean deleteUser(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
