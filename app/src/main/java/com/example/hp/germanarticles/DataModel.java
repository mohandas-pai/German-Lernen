package com.example.hp.germanarticles;

/**
 * Created by hp on 16-07-2019.
 */

public class DataModel {
    String GermanName;
    String EnglishName;

    String PGermanName;
    String PEnglishName;

    int id_;

    public DataModel(String germanName, String englishName, int id_) {
        GermanName = germanName;
        EnglishName = englishName;
        this.id_ = id_;
    }

    public DataModel(String PGermanName, String PEnglishName) {
        this.PGermanName = PGermanName;
        this.PEnglishName = PEnglishName;
    }

    public String getGermanName() {
        return GermanName;
    }

    public String getEnglishName() {
        return EnglishName;
    }

    public int getId_() {
        return id_;
    }

    public String getPGermanName() {
        return PGermanName;
    }

    public String getPEnglishName() {
        return PEnglishName;
    }
}
