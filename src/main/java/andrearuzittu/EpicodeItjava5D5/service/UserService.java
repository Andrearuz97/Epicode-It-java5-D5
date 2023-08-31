package andrearuzittu.EpicodeItjava5D5.service;

import java.util.List;

import andrearuzittu.EpicodeItjava5D5.entity.Utente;

public interface UserService {
    List<Utente> getAllUsers();
    Utente getUserById(Long id);
    Utente createUser(Utente user);
    Utente updateUser(Long id, Utente user);
    void deleteUser(Long id);
}

