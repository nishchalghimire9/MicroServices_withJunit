package RestAPIUnitTesting.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import RestAPIUnitTesting.Service.WelcomeService;
@RestController
public class WelcomeRestController {
	@Autowired
	private WelcomeService welcomeService;

	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		String responseMsg = welcomeService.getWelcomeMsg();
		return new ResponseEntity<>(responseMsg, HttpStatus.OK);
	}

	@GetMapping("/greet")
	public ResponseEntity<String> greet() {
		String responseMsg = welcomeService.getGreetMsg();
		return new ResponseEntity<>(responseMsg, HttpStatus.OK);
	}
	
}
