package repository;

import domain.base.Auther;
import domain.base.InfoReference;
import domain.base.Location;
import domain.base.VoteValues;
import repository.support.GenericRepository;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by saeed on 4/14/2016.
 */
public class InfoReferenceRepository extends GenericRepository<InfoReference> implements Serializable {
    public void addInfoVoting(UUID id, VoteValues voteValueModel) {

    }


}
