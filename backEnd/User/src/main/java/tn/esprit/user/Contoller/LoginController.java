package tn.esprit.user.Contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.user.Entity.ApiResponse;
import tn.esprit.user.Entity.LoginRequest;
import tn.esprit.user.Entity.User;
import tn.esprit.user.Repo.UserRepo;

@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    private UserRepo userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail());

        if (user == null) {
            return new ResponseEntity<>(new ApiResponse("User not found, please sign up first."), HttpStatus.NOT_FOUND);
        }

        if (!user.getPassword().equals(loginRequest.getPassword())) {
            return new ResponseEntity<>(new ApiResponse("Invalid email or password. Please check your credentials."), HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(new ApiResponse("Success"));
    }
}