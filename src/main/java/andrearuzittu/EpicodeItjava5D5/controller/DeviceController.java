package andrearuzittu.EpicodeItjava5D5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import andrearuzittu.EpicodeItjava5D5.service.DeviceService;

@RestController
@RequestMapping("/devices")
public class DeviceController {
	private final DeviceService deviceService;

	@Autowired
	public DeviceController(DeviceService deviceService) {
		this.deviceService = deviceService;
	}

}
