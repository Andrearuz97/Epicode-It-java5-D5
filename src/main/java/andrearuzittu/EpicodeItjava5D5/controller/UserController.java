package andrearuzittu.EpicodeItjava5D5.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import andrearuzittu.EpicodeItjava5D5.entity.Utente;
import andrearuzittu.EpicodeItjava5D5.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public List<Utente> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Utente> getUserById(@PathVariable Long id) {
		Utente user = userService.getUserById(id);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}

	@PostMapping
	public ResponseEntity<Utente> createUser(@RequestBody Utente user) {
		Utente createdUser = userService.createUser(user);
		return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Utente> updateUser(@PathVariable Long id, @RequestBody Utente user) {
		Utente updatedUser = userService.updateUser(id, user);
		if (updatedUser == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedUser);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		boolean deleted = userService.deleteUser(id);
		if (!deleted) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}
}
