package andrearuzittu.EpicodeItjava5D5.service;


import java.util.List;

import andrearuzittu.EpicodeItjava5D5.entity.Device;

public interface DeviceService {
	List<Device> getAllDevices();

	Device getDeviceById(Long id);

	Device createDevice(Device device);

	Device updateDevice(Long id, Device device);

	void deleteDevice(Long id);
}
