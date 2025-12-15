package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	private final UserRepository userRepository;

	// ✅ Constructor injection (Sonar recommandé)
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public List<User> retrieveAllUsers() {
		l.info("Retrieving all users");
		return userRepository.findAll();
	}



	@Override
	public User addUser(User u) {
		l.info("Adding new user");
		try {
			User savedUser = userRepository.save(u);
			l.info("User added successfully with id {}", savedUser.getId());
			return savedUser;
		} catch (Exception e) {
			l.error("Error in addUser()", e);
			return null;
		}
	}

	@Override
	public User updateUser(User u) {
		l.info("Updating user with id {}", u.getId());
		try {
			User updatedUser = userRepository.save(u);
			l.info("User updated successfully");
			return updatedUser;
		} catch (Exception e) {
			l.error("Error in updateUser()", e);
			return null;
		}
	}

	@Override
	public void deleteUser(String id) {
		l.info("Deleting user with id {}", id);
		try {
			userRepository.deleteById(Long.parseLong(id));
			l.info("User deleted successfully");
		} catch (Exception e) {
			l.error("Error in deleteUser()", e);
		}
	}

	@Override
	public User retrieveUser(String id) {
		l.info("Retrieving user with id {}", id);
		try {
			Optional<User> userOpt = userRepository.findById(Long.parseLong(id));
			return userOpt.orElse(null); // ✅ Sonar OK
		} catch (Exception e) {
			l.error("Error in retrieveUser()", e);
			return null;
		}
	}
}
