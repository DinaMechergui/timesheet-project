package tn.esprit.spring.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.UserServiceImpl;

class UserServiceImplTest {

    private UserRepository userRepository;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userRepository = mock(UserRepository.class);
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void testRetrieveAllUsers() {
        when(userRepository.findAll()).thenReturn(Arrays.asList(
                new User(1L, "Dina", "Mechergui", null, Role.ADMINISTRATEUR)
        ));
        assertEquals(1, userService.retrieveAllUsers().size());
        verify(userRepository).findAll();
    }

    @Test
    void testAddUser() {
        User user = new User(null, "Dina", "Mechergui", null, Role.ADMINISTRATEUR);
        User saved = new User(1L, "Dina", "Mechergui", null, Role.ADMINISTRATEUR);
        when(userRepository.save(user)).thenReturn(saved);

        User result = userService.addUser(user);
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(userRepository).save(user);
    }

    @Test
    void testUpdateUser() {
        User user = new User(1L, "Dina", "Mechergui", null, Role.ADMINISTRATEUR);
        when(userRepository.save(user)).thenReturn(user);

        User result = userService.updateUser(user);
        assertEquals(1L, result.getId());
        verify(userRepository).save(user);
    }

    @Test
    void testRetrieveUser() {
        User user = new User(1L, "Dina", "Mechergui", null, Role.ADMINISTRATEUR);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.retrieveUser("1");
        assertEquals(1L, result.getId());
        verify(userRepository).findById(1L);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser("1");
        verify(userRepository).deleteById(1L);
    }
}
