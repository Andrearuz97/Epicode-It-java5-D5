package andrearuzittu.EpicodeItjava5D5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import andrearuzittu.EpicodeItjava5D5.entity.Device;
import andrearuzittu.EpicodeItjava5D5.repository.DeviceRepository;

@Service
public class DeviceServiceImpl implements DeviceService {

	private final DeviceRepository deviceRepository;

	@Autowired
	public DeviceServiceImpl(DeviceRepository deviceRepository) {
		this.deviceRepository = deviceRepository;
	}

	@Override
	public List<Device> getAllDevices() {
		return deviceRepository.findAll();
	}

	@Override
	public Device getDeviceById(Long id) {
		Optional<Device> deviceOptional = deviceRepository.findById(id);
		return deviceOptional.orElse(null);
	}

	@Override
	public Device createDevice(Device device) {
		return deviceRepository.save(device);
	}

	@Override
	public Device updateDevice(Long id, Device device) {
		Device existingDevice = getDeviceById(id);
		if (existingDevice != null) {

			existingDevice.setName(device.getName());
			existingDevice.setType(device.getType());
			existingDevice.setStatus(device.getStatus());
			return deviceRepository.save(existingDevice);
		}
		return null;
	}

	@Override
	public void deleteDevice(Long id) {
		deviceRepository.deleteById(id);
	}
}

