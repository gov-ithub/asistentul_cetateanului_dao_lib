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

@Entity
@Table(name = "subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    public User user;
    
    @Column(name = "user_id")
    public Long userId;
    
    @ManyToOne
    @JoinColumn(name = "application_id", insertable = false, updatable = false)
    public Application application;

    @Column(name = "application_id")
    public Long applicationId;

    @Column(name = "subscribed_on")
    public Long subscribedOn;
    
    @Column(name="metadata")
    @Convert(converter = JsonMetadataConverter.class)
    public JsonMetadata metadata;
    
    public Subscription(User user, Application app, Long subscribedOn, JsonMetadata metadata) {
        this(user.id, app.id, subscribedOn, metadata);
    	this.user = user;
        this.application = app;
    }
    
    public Subscription(Long userId, Long applicationId, Long subscribedOn, JsonMetadata metadata) {
    	this.userId = userId;
        this.subscribedOn = subscribedOn;
        this.metadata = metadata;
        this.applicationId = applicationId;
    }

    Subscription() { // jpa only
    }
}
