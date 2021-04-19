package hu.szabo.painmeasure.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Entity
@Table(name = "USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(unique = true, nullable = false, name = "USERNAME", length = 100)
	private String username;

	@Column(name = "FIRST_NAME", length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50)
	private String lastName;

	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String email;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	@Column(nullable = false, name = "ROLE")
	@Enumerated(EnumType.STRING)
	Role role;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "dd.MM.yyyy HH:mm")
	@Column(name = "LAST_LOGIN")
	private Date lastLogin;

}
