package RestAPIUnitTesting.Service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

    public String getWelcomeMsg() {
        return "Welcome to this beautiful world.";
    }

    public String getGreetMsg() {
        return "Hello, how are you?";
    }

}
