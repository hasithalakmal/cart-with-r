package com.smile24es.ts_project.dao;

import com.smile24es.ts_project.beans.LikelihoodTable;

import java.util.List;

/**
 * Created by hasithagamage on 5/15/17.
 */
public interface LikelihoodTableDao {

    List<LikelihoodTable> findAllLikelihoodTables();

    void saveLikelihoodTable(LikelihoodTable likelihoodTable);

    LikelihoodTable findLikelihoodTableByName(String criteriaName);

    void deleteAllLikelihoodTables();
}
