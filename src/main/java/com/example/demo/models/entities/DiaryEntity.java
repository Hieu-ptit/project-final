package com.example.demo.models.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "diaries")
public class DiaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idUser;

    private String title;

    private String content;

    private boolean statusFavorite;

    @Column(updatable = false)
    private boolean status;

    @Column(updatable = false)
    private LocalDateTime createAt;

    @Column
    private LocalDateTime modifiedAt;

    public DiaryEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public boolean isStatusFavorite() {
        return statusFavorite;
    }

    public void setStatusFavorite(boolean statusFavorite) {
        this.statusFavorite = statusFavorite;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
