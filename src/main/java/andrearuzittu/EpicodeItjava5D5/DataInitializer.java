package andrearuzittu.EpicodeItjava5D5;

import org.springframework.stereotype.Component;

import andrearuzittu.EpicodeItjava5D5.entity.Device;
import andrearuzittu.EpicodeItjava5D5.entity.Utente;
import andrearuzittu.EpicodeItjava5D5.repository.DeviceRepository;
import andrearuzittu.EpicodeItjava5D5.repository.UserRepository;
import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    private final UserRepository userRepository;
    private final DeviceRepository deviceRepository;

    public DataInitializer(UserRepository userRepository, DeviceRepository deviceRepository) {
        this.userRepository = userRepository;
        this.deviceRepository = deviceRepository;
    }

    @PostConstruct
    public void initializeData() {
        // Inizializza dati utente
        Utente user1 = new Utente();
		user1.setUsername("ajeje__");
		user1.setNome("ajeje");
		user1.setCognome("brazors");
		user1.setEmail("ajeje@brazors.com");

        Utente user2 = new Utente();
        user2.setUsername("jane_smith");
        user2.setNome("Jane");
        user2.setCognome("Smith");
		user2.setEmail("hotmail.com");

        userRepository.save(user1);
        userRepository.save(user2);

        // Inizializza dati dispositivi
        Device device1 = new Device();
        device1.setType("Smartphone");
        device1.setStatus("Active");

        Device device2 = new Device();
        device2.setType("Laptop");
        device2.setStatus("Inactive");


        deviceRepository.save(device1);
        deviceRepository.save(device2);
    }
}
