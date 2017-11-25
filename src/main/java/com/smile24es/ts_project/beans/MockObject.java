/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smile24es.ts_project.beans;

/**
 *
 * @author hasithagamage
 */
public class MockObject {
    private String movie;
    private boolean overall;
    private int pos;
    private int neg;

    public MockObject(String movie, boolean overall, int pos, int neg) {
        this.movie = movie;
        this.overall = overall;
        this.pos = pos;
        this.neg = neg;
    }

    
    
    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public boolean isOverall() {
        return overall;
    }

    public void setOverall(boolean overall) {
        this.overall = overall;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getNeg() {
        return neg;
    }

    public void setNeg(int neg) {
        this.neg = neg;
    }
    
    
}
