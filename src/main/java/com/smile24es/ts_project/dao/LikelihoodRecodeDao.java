package com.smile24es.ts_project.dao;

import com.smile24es.ts_project.beans.LikelihoodRecode;
import com.smile24es.ts_project.beans.LikelihoodTable;
import java.util.List;

/**
 * Created by hasithagamage on 5/15/17.
 */
public interface LikelihoodRecodeDao {

    List<LikelihoodRecode> findAllLikelihoodRecodes();

    void saveLikelihoodRecode(LikelihoodRecode likelihoodRecode);
    
    LikelihoodRecode findLikelihoodRecodeByName(String propertyName);
    
    List<LikelihoodRecode> findLikelihoodRecodeByLikelihoodTable(LikelihoodTable likelihoodTable);

    void deleteAllLikelihoodRecodes();
}
