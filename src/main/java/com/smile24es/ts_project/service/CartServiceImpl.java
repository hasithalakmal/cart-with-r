package com.smile24es.ts_project.service;

import com.smile24es.ts_project.beans.Model.CartResult;
import com.smile24es.ts_project.beans.Model.CartTestResult;
import com.smile24es.ts_project.beans.Model.DataSet;
import com.smile24es.ts_project.beans.Model.Recode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("niveBayesService")
@Transactional
public class CartServiceImpl implements CartService {

    private static final Logger SL4J_LOGGER = LoggerFactory.getLogger(CartServiceImpl.class);

    @Override
    public String trainAlgo(DataSet dataSet) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("/home/hasithagamage/cart_data.csv"));
        } catch (FileNotFoundException e) {
        }
        StringBuilder sb = new StringBuilder();
        setHeaderOfCsv(sb);
        for(Recode recode: dataSet.getListOfRecodes()){
            setDataLineOnCsv(sb, recode);
        }

        pw.write(sb.toString());
        pw.close();
        try {
            Runtime.getRuntime().exec("Rscript /home/hasithagamage/Hasitha/OtherProjects/GIT/cart-with-r/Training.R");
        } catch (IOException e) {
        }
        return "url";
    }

    private void setDataLineOnCsv(StringBuilder sb, Recode recode) {
        sb.append(recode.getDuration());
        sb.append(',');
        sb.append(recode.getGenres());
        sb.append(',');
        sb.append(recode.getDirector());
        sb.append(',');
        sb.append(recode.getActorOne());
        sb.append(',');
        sb.append(recode.getCountry());
        sb.append(',');
        sb.append(recode.getLanguage());
        sb.append(',');
        sb.append(recode.getBudgetID());
        sb.append(',');
        sb.append(recode.isProfitable());
        sb.append('\n');
    }

    private void setHeaderOfCsv(StringBuilder sb) {
        sb.append("Duration");
        sb.append(',');
        sb.append("Genres");
        sb.append(',');
        sb.append("Director Name ");
        sb.append(',');
        sb.append("Actor Name");
        sb.append(',');
        sb.append("Country");
        sb.append(',');
        sb.append("Language");
        sb.append(',');
        sb.append("BudgetID");
        sb.append(',');
        sb.append("Profit");
        sb.append('\n');
    }

    @Override
    public CartTestResult testAlgo(DataSet dataSet) {
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("/home/hasithagamage/test_data.csv"));
        } catch (FileNotFoundException e) {
        }
        StringBuilder sb = new StringBuilder();
        setHeaderOfCsv(sb);
        for(Recode recode: dataSet.getListOfRecodes()){
            setDataLineOnCsv(sb, recode);
        }

        pw.write(sb.toString());
        pw.close();
        try {
            Runtime.getRuntime().exec("Rscript /home/hasithagamage/Hasitha/OtherProjects/GIT/cart-with-r/TestCart.R");
        } catch (IOException e) {
        }
        
        CartTestResult testResult = new CartTestResult();

        readTestReasultCsv(testResult);
        testResult.setTotalSuccessCount(testResult.getTotalSuccessNegativeCount()+testResult.getTotalSuccessPositiveCount());
        testResult.setTotalUnsuccessCount(testResult.getTotalFalsePositiveCount()+testResult.getTotalFalseNegativeCount());

        return testResult;
    }

    @Override
    public CartResult getPrediction(Recode recode) {
        CartResult cartResult = new CartResult();
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("/home/hasithagamage/predict_data.csv"));
        } catch (FileNotFoundException e) {
        }
        SL4J_LOGGER.info("Create predict_data csv");
        StringBuilder sb = new StringBuilder();
        setHeaderOfCsv(sb);
        setDataLineOnCsv(sb, recode);
        pw.write(sb.toString());
        pw.close();
        try {
            Runtime.getRuntime().exec("Rscript /home/hasithagamage/Hasitha/OtherProjects/GIT/cart-with-r/TestCart.R");
        } catch (IOException e) {
        }

        readReasultCsv(cartResult);

        return cartResult;
    }

    private void readReasultCsv(CartResult cartResult) {
        String csvFile = "/home/hasithagamage/predict_result.csv";
        String line = "";
        String cvsSplitBy = ",";
        int countOfTestResultCsv= 1;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if(countOfTestResultCsv == 2){
                    String[] country = line.split(cvsSplitBy);
                    cartResult.setResult(country[1]);
                }
                countOfTestResultCsv++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readTestReasultCsv(CartTestResult testResult) {
        String csvFile = "/home/hasithagamage/test_result.csv";
        String line = "";
        String cvsSplitBy = ",";
        int countOfTestResultCsv= 1;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if(countOfTestResultCsv == 2){
                    String[] country = line.split(cvsSplitBy);
                    final String successNegativeCount = country[1];
                    final String falsePostiveCount = country[2];
                    SL4J_LOGGER.info("Data A = [{}] and B = [{}] count [{}]", successNegativeCount,falsePostiveCount,countOfTestResultCsv);
                    testResult.setTotalSuccessNegativeCount(Integer.parseInt(successNegativeCount));
                    testResult.setTotalFalsePositiveCount(Integer.parseInt(falsePostiveCount));
                }else if(countOfTestResultCsv == 3){
                    String[] country = line.split(cvsSplitBy);
                    final String successPositiveCount = country[2];
                    final String falseNegativeCount = country[1];
                    SL4J_LOGGER.info("Data A = [{}] and B = [{}] count [{}]",falseNegativeCount, successPositiveCount,countOfTestResultCsv);
                    testResult.setTotalFalseNegativeCount(Integer.parseInt(falseNegativeCount));
                    testResult.setTotalSuccessPositiveCount(Integer.parseInt(successPositiveCount));
                }
                countOfTestResultCsv++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
