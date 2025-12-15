package tn.esprit.spring.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import tn.esprit.spring.dto.UserDTO;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import java.util.Date;

class UserDTOTest {

    @Test
    void testFromEntityAndToEntity() {
        User user = new User(1L, "Dina", "Mechergui", new Date(), Role.ADMINISTRATEUR);

        // Test fromEntity
        UserDTO dto = UserDTO.fromEntity(user);
        assertEquals(user.getId(), dto.getId());
        assertEquals(user.getFirstName(), dto.getFirstName());
        assertEquals(user.getLastName(), dto.getLastName());
        assertEquals(user.getDateNaissance(), dto.getDateNaissance());
        assertEquals(user.getRole(), dto.getRole());

        // Test toEntity
        User convertedUser = dto.toEntity();
        assertEquals(user.getId(), convertedUser.getId());
        assertEquals(user.getFirstName(), convertedUser.getFirstName());
        assertEquals(user.getLastName(), convertedUser.getLastName());
        assertEquals(user.getDateNaissance(), convertedUser.getDateNaissance());
        assertEquals(user.getRole(), convertedUser.getRole());
    }
}
