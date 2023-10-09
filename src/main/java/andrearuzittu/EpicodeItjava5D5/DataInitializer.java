package andrearuzittu.EpicodeItjava5D5;

import java.util.Arrays;

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
        Utente user1 = new Utente();
		user1.setUsername("ajeje__");
		user1.setNome("ajeje");
		user1.setCognome("brazors");
		user1.setEmail("ajeje@brazors.com");
		user1.setRoles(Arrays.asList("USER"));

        Utente user2 = new Utente();
		user2.setUsername("will_smith");
		user2.setNome("Will");
        user2.setCognome("Smith");
		user2.setEmail("Will_smith@hotmail.com");
		user2.setRoles(Arrays.asList("USER"));

        userRepository.save(user1);
        userRepository.save(user2);

        Device device1 = new Device();
		device1.setNome("Iphone 15 pro");
		device1.setStato(Device.Stato.ASSEGNATO);
        device1.setType("Smartphone");
        device1.setStatus("Active");
		device1.setUtente(user1);

        Device device2 = new Device();
		device2.setNome("mcbook air");
		device2.setStato(Device.Stato.ASSEGNATO);
        device2.setType("Laptop");
        device2.setStatus("Inactive");
		device2.setUtente(user2);

        deviceRepository.save(device1);
        deviceRepository.save(device2);
    }
}
