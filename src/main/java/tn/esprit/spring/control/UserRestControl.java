package tn.esprit.spring.control;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.dto.UserDTO;

@RestController
@RequestMapping("/user")
public class UserRestControl {

	private final IUserService userService;

	// ✅ Injection par constructeur (Sonar recommandé)
	public UserRestControl(IUserService userService) {
		this.userService = userService;
	}

	@GetMapping("/retrieve-all-users")
	public List<UserDTO> retrieveAllUsers() {
		return userService.retrieveAllUsers()
				.stream()
				.map(UserDTO::fromEntity)
				.collect(Collectors.toList());
	}

	@GetMapping("/retrieve-user/{user-id}")
	public UserDTO retrieveUser(@PathVariable("user-id") String userId) {
		return UserDTO.fromEntity(userService.retrieveUser(userId));
	}

	@PostMapping("/add-user")
	public UserDTO addUser(@RequestBody UserDTO dto) {
		User user = dto.toEntity();
		return UserDTO.fromEntity(userService.addUser(user));
	}

	@DeleteMapping("/remove-user/{user-id}")
	public void removeUser(@PathVariable("user-id") String userId) {
		userService.deleteUser(userId);
	}

	@PutMapping("/modify-user")
	public UserDTO updateUser(@RequestBody UserDTO dto) {
		User user = dto.toEntity();
		return UserDTO.fromEntity(userService.updateUser(user));
	}
}
