package org.hamsterlabs.cucumber_demo.persistence.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "file_loading")
public class FileLoadedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fileName;
    private Date dateLoaded;

    public FileLoadedEntity() {
    }

    public FileLoadedEntity(String fileName, Date dateLoaded) {
        this.fileName = fileName;
        this.dateLoaded = dateLoaded;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDateLoaded() {
        return dateLoaded;
    }

    public void setDateLoaded(Date dateLoaded) {
        this.dateLoaded = dateLoaded;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
