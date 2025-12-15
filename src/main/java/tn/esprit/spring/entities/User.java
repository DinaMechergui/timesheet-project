package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "t_user")
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

	public User() { }

	public User(String firstName, String lastName, Date dateNaissance, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateNaissance = dateNaissance;
		this.role = role;
	}

	public User(Long id, String firstName, String lastName, Date dateNaissance, Role role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateNaissance = dateNaissance;
		this.role = role;
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	// ✅ Méthode utilisée par le DTO
	public String getUsername() {
		return firstName + "." + lastName;
	}

	@Override
	public String toString() {
		return "User [id=" + id +
				", firstName=" + firstName +
				", lastName=" + lastName +
				", dateNaissance=" + dateNaissance +
				", role=" + role + "]";
	}
}
