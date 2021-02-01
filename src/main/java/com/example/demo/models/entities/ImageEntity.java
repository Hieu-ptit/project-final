package com.example.demo.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idDiary;

    private String name;

    @Lob
    private byte[] fileData;

    @Column(columnDefinition = "TEXT")
    private String link;

    @Column(updatable = false)
    private boolean status;

    @Column(updatable = false)
    private boolean statusDiary;

    public ImageEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getIdDiary() {
        return idDiary;
    }

    public void setIdDiary(int idDiary) {
        this.idDiary = idDiary;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatusDiary() {
        return statusDiary;
    }

    public void setStatusDiary(boolean statusDiary) {
        this.statusDiary = statusDiary;
    }
}
