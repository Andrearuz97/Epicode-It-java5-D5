package andrearuzittu.EpicodeItjava5D5.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import andrearuzittu.EpicodeItjava5D5.entity.Utente;

public class CustomUserDetails implements UserDetails {

	private final Utente user; // Importa la classe Utente

	public CustomUserDetails(Utente user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// Restituisci l'elenco dei ruoli/autorizzazioni dell'utente
		return null; // Da implementare
	}

	@Override
	public String getPassword() {
		return Utente.getPassword(); // Assumi che Utente abbia un campo "password"
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// Implementa gli altri metodi di UserDetails
}
