package org.govithub.govac.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String cnp;
    public String email;    
    public String phone;
    
    @Column(name = "first_name")
    public String firstName;
    
    @Column(name = "last_name")
    public String lastName;
    
    @Column(name = "username")
    public String username;

    User() { // jpa only
    }

	public User(String username, String firstName, String lastName, String email, String phone, String cnp) {
	    this.username = username;
		this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.cnp = cnp;
	}
}
