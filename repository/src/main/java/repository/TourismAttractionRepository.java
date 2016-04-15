package repository;

import domain.base.TourismAttraction;
import domain.base.VoteValues;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import repository.support.GenericRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by saeed on 4/14/2016.
 */
@Repository
public class TourismAttractionRepository extends GenericRepository<TourismAttraction> implements Serializable {

    @PersistenceContext(name = "punit")
    EntityManager entityManager;
    public void addInfoVoting(UUID id, VoteValues voteValueModel) {
    }


    public List<TourismAttraction> search(String param) {
        String q="select tour from TourismAttraction tour where tour.name like :param";
        Query query = entityManager.createQuery(q);
        query.setParameter("param","%"+param+"%");
        List<TourismAttraction> resultList = query.getResultList();
        if(resultList!=null){
            return resultList;
        }else{
            return new ArrayList<TourismAttraction>();
        }
    }
}
