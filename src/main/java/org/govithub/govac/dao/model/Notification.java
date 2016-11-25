package org.govithub.govac.dao.model;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.govithub.govac.dao.model.json.JsonMetadata;
import org.govithub.govac.dao.model.json.JsonMetadataConverter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "notifications")
@JsonIgnoreProperties({"user", "application"})
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", insertable = false, updatable = false)
    public Application application;

    @Column(name = "application_id")
    public Long applicationId;
    
    public String title;
    public String description;
    
    @Column(name="metadata")
    @Convert(converter = JsonMetadataConverter.class)
    public JsonMetadata metadata;
    
    @Column(name="short_description")
    public String shortDescription;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public User user;
    
    @Column(name = "user_id")
    public Long userId;
    
    public long timestamp;

    public Notification(Application application, String title, String desc, String shortDesc, long timestamp, User user, JsonMetadata meta) {
        this(application.id, title, desc, shortDesc, timestamp, user, meta);
    	this.application = application;
    }
    
    public Notification(Long applicationId, String title, String desc, String shortDesc, long timestamp, User user, JsonMetadata meta) {
    	this(applicationId, title, desc, shortDesc, timestamp, user.id, meta);
    	this.user = user;
    }
    
    public Notification(Long applicationId, String title, String desc, String shortDesc, long timestamp, Long userId, JsonMetadata meta) {
    	this.applicationId = applicationId;
        this.userId = userId;
        this.title = title;
        this.description = desc;
        this.shortDescription = shortDesc;
        this.timestamp = timestamp;
        this.metadata = meta;
    }

    Notification() { // jpa only
    }
}
