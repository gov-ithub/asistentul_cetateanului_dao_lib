package org.govithub.govac.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    @ManyToOne
    @JoinColumn(name = "admin_id")
    public User admin;

    public String name;
    public String url;

    public Provider(User admin, String name, String url) {
        this.admin = admin;
        this.name = name;
        this.url = url;
    }

    Provider() { // jpa only
    }
}
