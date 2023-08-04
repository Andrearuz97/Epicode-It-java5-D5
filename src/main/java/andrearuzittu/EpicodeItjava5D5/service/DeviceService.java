package andrearuzittu.EpicodeItjava5D5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import andrearuzittu.EpicodeItjava5D5.entity.Device;
import andrearuzittu.EpicodeItjava5D5.repository.DeviceRepository;

@Service
public class DeviceService {
	private final DeviceRepository deviceRepository;

	@Autowired
	public DeviceService(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	public List<Device> getAllDevices() {
		return deviceRepository.findAll();
	}

	public Device getDeviceById(Long id) {
		return deviceRepository.findById(id).orElse(null);
	}

	public Device createDevice(Device device) {
		return deviceRepository.save(device);
	}

	public Device updateDevice(Long id, Device updatedDevice) {
		Device device = deviceRepository.findById(id).orElse(null);
		if (device == null) {
			return null;
		}
		// Update device properties with the new values
		device.setType(updatedDevice.getType());
		device.setStatus(updatedDevice.getStatus());

		return deviceRepository.save(device);
	}

	public boolean deleteDevice(Long id) {
		if (deviceRepository.existsById(id)) {
			deviceRepository.deleteById(id);
			return true;
		}
		return false;
	}
}



