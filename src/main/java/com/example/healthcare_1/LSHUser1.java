package com.example.healthcare_1;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class LSHUser1 {
    @PrimaryKey(autoGenerate = true)
    private int ID=0;
    private int notice=0;
    private int mode=0;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNotice() {
        return notice;
    }

    public void setNotice(int notice) {
        this.notice = notice;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return Nickname;
    }

    public void setNickname(String nickname) {
        Nickname = nickname;
    }

    public double getHeight() {
        return Height;
    }

    public void setHeight(double height) {
        Height = height;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getEggCondition() {
        return EggCondition;
    }

    public void setEggCondition(int eggCondition) {
        EggCondition = eggCondition;
    }

    public int getMilkCondition() {
        return MilkCondition;
    }

    public void setMilkCondition(int milkCondition) {
        MilkCondition = milkCondition;
    }

    public int getBuckWheatCondition() {
        return BuckWheatCondition;
    }

    public void setBuckWheatCondition(int buckWheatCondition) {
        BuckWheatCondition = buckWheatCondition;
    }

    public int getNutCondition() {
        return NutCondition;
    }

    public void setNutCondition(int nutCondition) {
        NutCondition = nutCondition;
    }

    public int getSoyBeanCondition() {
        return SoyBeanCondition;
    }

    public void setSoyBeanCondition(int soyBeanCondition) {
        SoyBeanCondition = soyBeanCondition;
    }

    public int getWheatCondition() {
        return WheatCondition;
    }

    public void setWheatCondition(int wheatCondition) {
        WheatCondition = wheatCondition;
    }

    public int getFishCondition() {
        return FishCondition;
    }

    public void setFishCondition(int fishCondition) {
        FishCondition = fishCondition;
    }

    public int getCrabCondition() {
        return CrabCondition;
    }

    public void setCrabCondition(int crabCondition) {
        CrabCondition = crabCondition;
    }

    public int getFruitCondition() {
        return FruitCondition;
    }

    public void setFruitCondition(int fruitCondition) {
        FruitCondition = fruitCondition;
    }

    public int getTomatoCondition() {
        return TomatoCondition;
    }

    public void setTomatoCondition(int tomatoCondition) {
        TomatoCondition = tomatoCondition;
    }

    public int getSulfurousCondition() {
        return SulfurousCondition;
    }

    public void setSulfurousCondition(int sulfurousCondition) {
        SulfurousCondition = sulfurousCondition;
    }

    public int getChickenCondition() {
        return ChickenCondition;
    }

    public void setChickenCondition(int chickenCondition) {
        ChickenCondition = chickenCondition;
    }

    public int getMeatCondition() {
        return MeatCondition;
    }

    public void setMeatCondition(int meatCondition) {
        MeatCondition = meatCondition;
    }

    public int getSquidCondition() {
        return SquidCondition;
    }

    public void setSquidCondition(int squidCondition) {
        SquidCondition = squidCondition;
    }

    private int gender=0;
    private String Nickname="";
    private double Height=0f;
    private double Weight=0f;
    private int age=0;
    private int goal=0;
    private int EggCondition=0;
    private int MilkCondition=0;
    private int BuckWheatCondition=0;
    private int NutCondition=0;
    private int SoyBeanCondition=0;
    private int WheatCondition=0;
    private int FishCondition=0;
    private int CrabCondition=0;
    private int FruitCondition=0;
    private int TomatoCondition=0;
    private int SulfurousCondition=0;
    private int ChickenCondition=0;
    private int MeatCondition=0;
    private int SquidCondition=0;


}