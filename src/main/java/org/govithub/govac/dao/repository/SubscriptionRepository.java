package org.govithub.govac.dao.repository;

import java.util.List;
import java.util.Optional;

import org.govithub.govac.dao.model.Subscription;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {
    Optional<Subscription> findById(long id);
    
    Optional<Subscription> findByUserIdAndApplicationId(Long userId, Long applicationid);
    
    List<Subscription> findByUserId(Long userId);
}
