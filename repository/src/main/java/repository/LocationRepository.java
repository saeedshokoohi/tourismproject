package repository;

import domain.base.Auther;
import domain.base.Location;
import domain.base.User;
import domain.base.VoteValues;
import repository.support.GenericRepository;

import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * Created by saeed on 4/14/2016.
 */
@Named
public class LocationRepository extends GenericRepository<Location> implements Serializable {
    public void addInfoVoting(UUID id, VoteValues voteValueModel) {

    }


    public List<Location> findByQuery(String query) {
        List<Location> retList;
        String where="select l from Location l where l.name like '%"+query+"%' ";
       retList= getEm().createQuery(where).getResultList();
        return retList;
    }
}
