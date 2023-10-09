package andrearuzittu.EpicodeItjava5D5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import andrearuzittu.EpicodeItjava5D5.entity.Utente;
import andrearuzittu.EpicodeItjava5D5.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<Utente> getAllUsers() {
		return userRepository.findAll();
	}

	public Utente getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public Utente createUser(Utente user) {
		return userRepository.save(user);
	}

	public Utente updateUser(Long id, Utente user) {
		if (userRepository.existsById(id)) {
			user.setId(id);
			return userRepository.save(user);
		} else {
			return null;
		}
	}

	public boolean deleteUser(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Utente findByEmail(String email) {
		return userRepository.findByEmail(email).orElse(null);
	}

	public Utente findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	public Utente save(Utente user) {
		return userRepository.save(user);
	}
}
