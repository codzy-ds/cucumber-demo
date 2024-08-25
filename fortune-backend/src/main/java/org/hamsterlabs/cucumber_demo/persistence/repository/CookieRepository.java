package org.hamsterlabs.cucumber_demo.persistence.repository;

import org.hamsterlabs.cucumber_demo.persistence.entities.CookieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookieRepository extends JpaRepository<CookieEntity, Long> {
}
