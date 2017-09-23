package com.smile24es.ts_project.dao;

import com.smile24es.ts_project.beans.LikelihoodTable;
import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 * Created by hasithagamage
 *         on 5/15/17.
 */
@Repository("LikelihoodTableDao")
public class LikelihoodTableImpl extends AbstractDao<Integer, LikelihoodTable>  implements LikelihoodTableDao {

    private static final Logger SL4J_LOGGER = LoggerFactory.getLogger(LikelihoodTableImpl.class);

    @Override
    public List<LikelihoodTable> findAllLikelihoodTables() {
        SL4J_LOGGER.info("Starting to run HQL Query to find all row data.");
        Criteria criteria = createEntityCriteria();
        return (List<LikelihoodTable>) criteria.list();
    }

    @Override
    public void saveLikelihoodTable(LikelihoodTable likelihoodTable) {
        SL4J_LOGGER.info("Starting to run HQL Query to save row data.");
        persist(likelihoodTable);
    }

   @Override
    public LikelihoodTable findLikelihoodTableByName(String criteriaName) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("criteria", criteriaName));
        return (LikelihoodTable) criteria.uniqueResult();
    }

    @Override
    public void deleteAllLikelihoodTables() {
        Query query = getSession().createSQLQuery("delete from LIKELIHOOD_TABLE");
        query.executeUpdate();
    }
}
