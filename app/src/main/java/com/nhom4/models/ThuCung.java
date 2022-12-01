package com.nhom4.models;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class ThuCung implements Serializable {
    int idthucung, pettype, gender;
    String petname, species;
    Double weight;

    public ThuCung(int idthucung, String petname, int pettype, int gender, String species, Double weight) {
        this.idthucung = idthucung;
        this.pettype = pettype;
        this.gender = gender;
        this.petname = petname;
        this.species = species;
        this.weight = weight;
    }

    public int getIdthucung() {
        return idthucung;
    }

    public void setIdthucung(int idthucung) {
        this.idthucung = idthucung;
    }

    public int getPettype() {
        return pettype;
    }

    public void setPettype(int pettype) {
        this.pettype = pettype;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @NonNull
    @Override
    public String toString() {
        return getPetname();
    }
}
