package org.hamsterlabs.cucumber_demo.persistence.repository;

import org.hamsterlabs.cucumber_demo.persistence.entities.FileLoadedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileLoadedRepository extends JpaRepository<FileLoadedEntity, Long> {

    Optional<FileLoadedEntity> findByFileName(String fileName);
}
