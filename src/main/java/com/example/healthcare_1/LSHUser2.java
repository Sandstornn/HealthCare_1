package com.example.healthcare_1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LSHUser2 {
    @PrimaryKey(autoGenerate = true)
    private int ID=0;
    private String Date;
    private int UsedKcal=0;
    private double Carbohydrate;
    private double Protain;
    private double Fat;
    private double Kcal;
    byte[] morning;
    byte[] brunch;
    byte[] lunch;
    byte[] snack;
    byte[] dinner;

    public byte[] getBrunch() {
        return brunch;
    }

    public void setBrunch(byte[] brunch) {
        this.brunch = brunch;
    }

    public byte[] getSnack() {
        return snack;
    }

    public void setSnack(byte[] snack) {
        this.snack = snack;
    }

    public byte[] getMidnight() {
        return midnight;
    }

    public void setMidnight(byte[] midnight) {
        this.midnight = midnight;
    }

    byte[] midnight;
    public byte[] getMorning() {
        return morning;
    }

    public void setMorning(byte[] morning) {
        this.morning = morning;
    }

    public byte[] getLunch() {
        return lunch;
    }

    public void setLunch(byte[] lunch) {
        this.lunch = lunch;
    }

    public byte[] getDinner() {
        return dinner;
    }

    public void setDinner(byte[] dinner) {
        this.dinner = dinner;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public double getCarbohydrate() {
        return Carbohydrate;
    }

    public void setCarbohydrate(double carbohydrate) {
        Carbohydrate = carbohydrate;
    }

    public double getProtain() {
        return Protain;
    }

    public void setProtain(double protain) {
        Protain = protain;
    }

    public double getFat() {
        return Fat;
    }

    public void setFat(double fat) {
        Fat = fat;
    }

    public double getKcal() {
        return Kcal;
    }

    public void setKcal(double kcal) {
        Kcal = kcal;
    }

    public int getUsedKcal() {
        return UsedKcal;
    }

    public void setUsedKcal(int usedKcal) {
        UsedKcal = usedKcal;
    }
}