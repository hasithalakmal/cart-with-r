package com.smile24es.ts_project.beans.Model;

import java.util.List;
import java.util.Map;

public class LikelihoodTable {
    private String criteria;
    private Map<String, LikelihoodRecode> listOfLikelihoodRecode;
    private int totalPositive;
    private int totalNegative;
    private double positiveProbability;
    private double negativeProbability;

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public Map<String, LikelihoodRecode> getListOfLikelihoodRecode() {
        return listOfLikelihoodRecode;
    }

    public void setListOfLikelihoodRecode(Map<String, LikelihoodRecode> listOfLikelihoodRecode) {
        this.listOfLikelihoodRecode = listOfLikelihoodRecode;
    }

    public int getTotalPositive() {
        return totalPositive;
    }

    public void setTotalPositive(int totalPositive) {
        this.totalPositive = totalPositive;
    }

    public int getTotalNegative() {
        return totalNegative;
    }

    public void setTotalNegative(int totalNegative) {
        this.totalNegative = totalNegative;
    }

    public double getPositiveProbability() {
        return positiveProbability;
    }

    public void setPositiveProbability(double positiveProbability) {
        this.positiveProbability = positiveProbability;
    }

    public double getNegativeProbability() {
        return negativeProbability;
    }

    public void setNegativeProbability(double negativeProbability) {
        this.negativeProbability = negativeProbability;
    }

    @Override
    public String toString() {
        return "LikelihoodTable{" +
                "criteria='" + criteria + '\'' +
                ", listOfLikelihoodRecode=" + listOfLikelihoodRecode +
                ", totalPositive=" + totalPositive +
                ", totalNegative=" + totalNegative +
                ", positiveProbability=" + positiveProbability +
                ", negativeProbability=" + negativeProbability +
                '}';
    }
}
