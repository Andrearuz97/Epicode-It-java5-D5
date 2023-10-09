package andrearuzittu.EpicodeItjava5D5.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import andrearuzittu.EpicodeItjava5D5.entity.Utente;
import andrearuzittu.EpicodeItjava5D5.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserService utenteService;

	@Autowired
	private JWTTools jwtTools;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public Utente saveUser(@RequestBody Utente utente) {
		Utente created = utenteService.save(utente);
		return created;
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Utente credentials) {
		Utente user = utenteService.findByEmail(credentials.getEmail());
		if (user != null && credentials.getPassword().equals(user.getPassword())) {
			String token = jwtTools.createToken(user);
			return ResponseEntity.ok(token);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenziali non valide!");
		}
	}
}
