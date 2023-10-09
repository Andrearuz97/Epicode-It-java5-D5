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

import andrearuzittu.EpicodeItjava5D5.entity.Device;
import andrearuzittu.EpicodeItjava5D5.service.DeviceService;

@RestController
@RequestMapping("/devices")
public class DeviceController {
	private final DeviceService deviceService;

	@Autowired
	public DeviceController(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

	@GetMapping
	public List<Device> getAllDevices() {
		return deviceService.getAllDevices();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
		Device device = deviceService.getDeviceById(id);
		if (device == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(device);
	}

	@PostMapping
	public ResponseEntity<Device> createDevice(@RequestBody Device device) {
		Device createdDevice = deviceService.createDevice(device);
		return ResponseEntity.created(URI.create("/devices/" + createdDevice.getId())).body(createdDevice);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device device) {
		Device updatedDevice = deviceService.updateDevice(id, device);
		if (updatedDevice == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedDevice);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
		boolean deleted = deviceService.deleteDevice(id);
		if (!deleted) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

}
