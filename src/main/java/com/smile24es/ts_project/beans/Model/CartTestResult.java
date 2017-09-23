/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smile24es.ts_project.beans.Model;

/**
 *
 * @author hasithagamage
 */
public class CartTestResult {

    private int totalFalsePositiveCount;
    private int totalFalseNegativeCount;
    private int totalUnsuccessCount;
    private double unsuccessProbability;

    private int totalSuccessPositiveCount;
    private int totalSuccessNegativeCount;
    private int totalSuccessCount;
    private double successProbability;

    public int getTotalFalsePositiveCount() {
        return totalFalsePositiveCount;
    }

    public void setTotalFalsePositiveCount(int totalFalsePositiveCount) {
        this.totalFalsePositiveCount = totalFalsePositiveCount;
    }

    public int getTotalFalseNegativeCount() {
        return totalFalseNegativeCount;
    }

    public void setTotalFalseNegativeCount(int totalFalseNegativeCount) {
        this.totalFalseNegativeCount = totalFalseNegativeCount;
    }

    public int getTotalUnsuccessCount() {
        return totalUnsuccessCount;
    }

    public void setTotalUnsuccessCount(int totalUnsuccessCount) {
        this.totalUnsuccessCount = totalUnsuccessCount;
    }

    public double getUnsuccessProbability() {
        return unsuccessProbability;
    }

    public void setUnsuccessProbability(double unsuccessProbability) {
        this.unsuccessProbability = unsuccessProbability;
    }

    public int getTotalSuccessPositiveCount() {
        return totalSuccessPositiveCount;
    }

    public void setTotalSuccessPositiveCount(int totalSuccessPositiveCount) {
        this.totalSuccessPositiveCount = totalSuccessPositiveCount;
    }

    public int getTotalSuccessNegativeCount() {
        return totalSuccessNegativeCount;
    }

    public void setTotalSuccessNegativeCount(int totalSuccessNegativeCount) {
        this.totalSuccessNegativeCount = totalSuccessNegativeCount;
    }

    public int getTotalSuccessCount() {
        return totalSuccessCount;
    }

    public void setTotalSuccessCount(int totalSuccessCount) {
        this.totalSuccessCount = totalSuccessCount;
    }

    public double getSuccessProbability() {
        return successProbability;
    }

    public void setSuccessProbability(double successProbability) {
        this.successProbability = successProbability;
    }

    @Override
    public String toString() {
        return "CartTestResult{" +
                "totalFalsePositiveCount=" + totalFalsePositiveCount +
                ", totalFalseNegativeCount=" + totalFalseNegativeCount +
                ", totalUnsuccessCount=" + totalUnsuccessCount +
                ", unsuccessProbability=" + unsuccessProbability +
                ", totalSuccessPositiveCount=" + totalSuccessPositiveCount +
                ", totalSuccessNegativeCount=" + totalSuccessNegativeCount +
                ", totalSuccessCount=" + totalSuccessCount +
                ", successProbability=" + successProbability +
                '}';
    }
}
