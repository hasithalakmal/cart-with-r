package com.smile24es.ts_project.beans.Model;

public class Recode {

    private String duration;
    private String director;
    private String actorOne;
    private String genres;
    private String budgetID;
    private String language;
    private String country;


    private boolean isProfitable;

    public Recode() {
    }

    //temp construct
    public Recode(String Director, String actorOne, String language,
                  String country, boolean isProfitable) {
        this.director = Director;
        this.actorOne = actorOne;
        this.language = language;
        this.country = country;
        this.isProfitable = isProfitable;
    }

    public Recode(String duration, String Director, String actorOne, String genres,
                  String actorThreeName, String language, String country) {
        this.duration = duration;
        this.director = Director;
        this.actorOne = actorOne;
        this.genres = genres;
        this.budgetID = actorThreeName;
        this.language = language;
        this.country = country;
    }

    public Recode(String duration, String genres,  String director, String actorOne, String country, String language, String budgetID,   boolean isProfitable) {
        this.duration = duration;
        this.director = director;
        this.actorOne = actorOne;
        this.genres = genres;
        this.budgetID = budgetID;
        this.language = language;
        this.country = country;
        this.isProfitable = isProfitable;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActorOne() {
        return actorOne;
    }

    public void setActorOne(String actorOne) {
        this.actorOne = actorOne;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getBudgetID() {
        return budgetID;
    }

    public void setBudgetID(String budgetID) {
        this.budgetID = budgetID;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isProfitable() {
        return isProfitable;
    }

    public void setProfitable(boolean profitable) {
        isProfitable = profitable;
    }

    @Override
    public String toString() {
        return "Recode{" + "duration=" + duration + ", director=" + director + ", actorOne=" + actorOne + ", genres=" + genres + ", budgetID=" + budgetID + ", language=" + language + ", country=" + country + ", isProfitable=" + isProfitable + '}';
    }
    
    
}
