package com.journaldev.spring.model;

/**
 * Created by pcthomas on 10/01/2017.
 */

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="STRONGBOX")
public class StrongBox {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String localisation;

    private int frais;

    public StrongBox(){}

    public StrongBox(String aLocalisation, Integer aFrais){
        this.localisation = aLocalisation;
        this.frais = aFrais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public int getFrais() {
        return frais;
    }

    public void setFrais(int frais) {
        this.frais = frais;
    }

    @Override
    public String toString(){
        return "id="+id+", localisation="+localisation+", frais="+frais;
    }
}
