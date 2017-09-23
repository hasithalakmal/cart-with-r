package com.smile24es.ts_project.beans.Model;

public class LikelihoodRecode {
    private String property;
    private int numberOfPositiveResponse;
    private int numberOfNegativeResponse;
    private double criteriaProbability;

    public LikelihoodRecode() {
    }

    public LikelihoodRecode(String property, int numberOfPositiveResponse, int numberOfNegativeResponse,
                            double criteriaProbability) {
        this.property = property;
        this.numberOfPositiveResponse = numberOfPositiveResponse;
        this.numberOfNegativeResponse = numberOfNegativeResponse;
        this.criteriaProbability = criteriaProbability;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public int getNumberOfPositiveResponse() {
        return numberOfPositiveResponse;
    }

    public void setNumberOfPositiveResponse(int numberOfPositiveResponse) {
        this.numberOfPositiveResponse = numberOfPositiveResponse;
    }

    public int getNumberOfNegativeResponse() {
        return numberOfNegativeResponse;
    }

    public void setNumberOfNegativeResponse(int numberOfNegativeResponse) {
        this.numberOfNegativeResponse = numberOfNegativeResponse;
    }

    public double getCriteriaProbability() {
        return criteriaProbability;
    }

    public void setCriteriaProbability(double criteriaProbability) {
        this.criteriaProbability = criteriaProbability;
    }

    public int increaseNumberOfPositiveResponse(){
        this.numberOfPositiveResponse++;
        return this.numberOfNegativeResponse;
    }

    public int increaseNumberOfNegativeResponse(){
        this.numberOfNegativeResponse++;
        return this.numberOfNegativeResponse;
    }

    @Override
    public String toString() {
        return "LikelihoodRecode{" +
                "property='" + property + '\'' +
                ", numberOfPositiveResponse=" + numberOfPositiveResponse +
                ", numberOfNegativeResponse=" + numberOfNegativeResponse +
                ", criteriaProbability=" + criteriaProbability +
                '}';
    }
}
