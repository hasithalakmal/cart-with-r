package com.smile24es.ts_project.dao;

import com.smile24es.ts_project.beans.LikelihoodRecode;
import com.smile24es.ts_project.beans.LikelihoodTable;
import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 * Created by hasithagamage on 5/15/17.
 */
@Repository("likelihoodRecodeDao")
public class LikelihoodRecodeImpl extends AbstractDao<Integer, LikelihoodRecode> implements LikelihoodRecodeDao {

    private static final Logger SL4J_LOGGER = LoggerFactory.getLogger(LikelihoodRecodeImpl.class);

    @Override
    public List<LikelihoodRecode> findAllLikelihoodRecodes() {
        SL4J_LOGGER.info("Starting to run HQL Query to find all row data.");
        Criteria criteria = createEntityCriteria();
        return (List<LikelihoodRecode>) criteria.list();
    }

    @Override
    public void saveLikelihoodRecode(LikelihoodRecode likelihoodRecode) {
        SL4J_LOGGER.info("Starting to run HQL Query to save row data.");
        persist(likelihoodRecode);
    }

    @Override
    public LikelihoodRecode findLikelihoodRecodeByName(String propertyName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("propertyName", propertyName));
        return (LikelihoodRecode) criteria.uniqueResult();
    }
    
    @Override
    public List<LikelihoodRecode> findLikelihoodRecodeByLikelihoodTable(LikelihoodTable likelihoodTable) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("likelihoodTableId", likelihoodTable));
        return (List<LikelihoodRecode>) criteria.list();
    }

    @Override
    public void deleteAllLikelihoodRecodes() {
        Query query = getSession().createSQLQuery("delete from LIKELIHOOD_RECODE");
        query.executeUpdate();
    }

}
