package com.smile24es.ts_project.service;

import com.smile24es.ts_project.beans.Model.CartResult;
import com.smile24es.ts_project.beans.Model.CartTestResult;
import com.smile24es.ts_project.beans.Model.DataSet;
import com.smile24es.ts_project.beans.Model.Recode;

import java.io.FileNotFoundException;

public interface CartService {

    String trainAlgo(DataSet dataSet) throws FileNotFoundException;
    
    CartTestResult testAlgo(DataSet dataSet);

    CartResult getPrediction(Recode recode);

}
