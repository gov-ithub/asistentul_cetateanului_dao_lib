package org.govithub.govac.dao.repository;

import java.util.List;

import org.govithub.govac.dao.model.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, Long> {

	List<Notification> findById(long id);

	List<Notification> findByUserId(long id);

	List<Notification> findByApplicationId(long applicationId);

	@Query("SELECT n FROM Notification as n INNER JOIN n.application as a  INNER JOIN a.provider as p "
			+ " WHERE n.userId = :userId AND " + " n.timestamp >= :startTs AND n.timestamp <= :endTs AND ( "
			+ " a.name LIKE :application AND p.name LIKE :provider AND "
			+ " (n.title LIKE :keyword OR n.description LIKE :keyword OR "
			+ " n.shortDescription LIKE :keyword OR a.name LIKE :keyword OR p.name LIKE :keyword ))")
	List<Notification> findByUserAndOtherFilters(@Param("userId") long userId, @Param("keyword") String keyword,
			@Param("application") String application, @Param("provider") String provider,
			@Param("startTs") long startTs, @Param("endTs") long endTs);

	@Query("SELECT n FROM Notification n INNER JOIN n.application as a INNER JOIN a.provider as p "
			+ " WHERE a.id = :applicationId AND (:userId < 0L OR n.userId = :userId) AND "
			+ " n.timestamp >= :startTs AND n.timestamp <= :endTs AND ( p.name LIKE :provider AND "
			+ " (n.title LIKE :keyword OR n.description LIKE :keyword OR "
			+ " n.shortDescription LIKE :keyword OR a.name LIKE :keyword OR p.name LIKE :keyword ))")
	List<Notification> findByApplicationAndOtherFilters(@Param("applicationId") long applicationId,
			@Param("keyword") String keyword, @Param("userId") long userId, @Param("provider") String provider,
			@Param("startTs") long startTs, @Param("endTs") long endTs);
}