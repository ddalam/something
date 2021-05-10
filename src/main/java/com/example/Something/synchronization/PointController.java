package com.example.Something.synchronization;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/point")
public class PointController {

	@PatchMapping("")
	public void consumePoint() {
		Point point = new Point();
		point.consumePoint();
	}
}
