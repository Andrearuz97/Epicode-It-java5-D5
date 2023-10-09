package andrearuzittu.EpicodeItjava5D5.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import andrearuzittu.EpicodeItjava5D5.entity.Device;
import andrearuzittu.EpicodeItjava5D5.repository.DeviceRepository;

@Service
public class DeviceService {

	@Autowired
	private DeviceRepository deviceRepository;

	public Device createDevice(Device device) {
		return deviceRepository.save(device);
	}

	public Device updateDevice(Long id, Device device) {
		if (deviceRepository.existsById(id)) {
			return deviceRepository.save(device);
		} else {
			throw new RuntimeException("Device non trovato con ID: " + id);
		}
	}

	public boolean deleteDevice(Long id) {
		if (deviceRepository.existsById(id)) {
			deviceRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Device getDeviceById(Long id) {
		return deviceRepository.findById(id).orElse(null);
	}

	public List<Device> getAllDevices() {
		return deviceRepository.findAll();
	}
}