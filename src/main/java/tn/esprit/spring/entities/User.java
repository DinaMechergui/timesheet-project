package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_user")
@Data  // Generates getters, setters, toString, equals, hashCode (use cautiously with JPA relationships)
@NoArgsConstructor  // Required for JPA persistence
@AllArgsConstructor  // Full constructor
@Builder  // Builder pattern for object creation
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "date_naissance")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;

	// Custom method for DTO compatibility
	public String getUsername() {
		return firstName + "." + lastName;
	}
}
