package com.example.demo.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "diaries_categories")
public class DiaryCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idCategory;

    private int idDiary;

    @Column(updatable = false)
    private boolean statusCategory;

    @Column(updatable = false)
    private boolean statusDiary;

    public DiaryCategoryEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getIdDiary() {
        return idDiary;
    }

    public void setIdDiary(int idDiary) {
        this.idDiary = idDiary;
    }

    public boolean isStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(boolean statusCategory) {
        this.statusCategory = statusCategory;
    }

    public boolean isStatusDiary() {
        return statusDiary;
    }

    public void setStatusDiary(boolean statusDiary) {
        this.statusDiary = statusDiary;
    }
}
