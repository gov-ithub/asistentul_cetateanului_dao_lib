package org.govithub.govac.dao.repository;

import java.util.Optional;

import org.govithub.govac.dao.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
    
    Optional<User> findById(long id);
    
    Optional<User> findByUsername(String username);
}
