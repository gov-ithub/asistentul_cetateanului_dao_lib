package org.govithub.govac.dao.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.govithub.govac.dao.model.json.JsonMetadata;
import org.govithub.govac.dao.model.json.JsonMetadataConverter;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    @ManyToOne
    @JoinColumn(name = "provider_id")
    public Provider provider;

    public String name;
    public String description;
    public String tkn;
    
    @Column(name="requirements")
    @Convert(converter = JsonMetadataConverter.class)
    public JsonMetadata requirements;

    public Application(Provider provider, String name, String desc, String tkn, JsonMetadata reqs) {
        this.provider = provider;
        this.name = name;
        this.description = desc;
        this.tkn = tkn;
        this.requirements = reqs;
    }

    Application() { // jpa only
    }
}
