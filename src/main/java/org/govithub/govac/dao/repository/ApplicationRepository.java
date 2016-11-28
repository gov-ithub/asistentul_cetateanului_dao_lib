package org.govithub.govac.dao.repository;

import java.util.Optional;

import org.govithub.govac.dao.model.Application;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {
	Optional<Application> findById(Long id);
}