package tn.esprit.spring.dto;

import java.util.Date;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Date dateNaissance;
    private Role role;

    public static UserDTO fromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setDateNaissance(user.getDateNaissance());
        dto.setRole(user.getRole());
        return dto;
    }

    public User toEntity() {
        User user = new User();
        user.setId(this.id);
        user.setFirstName(this.firstName);
        user.setLastName(this.lastName);
        user.setDateNaissance(this.dateNaissance);
        user.setRole(this.role);
        return user;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(Date dateNaissance) { this.dateNaissance = dateNaissance; }

    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
}
