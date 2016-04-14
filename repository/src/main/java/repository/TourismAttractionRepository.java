package repository;

import domain.base.TourismAttraction;
import domain.base.VoteValues;
import repository.support.GenericRepository;

import java.util.UUID;

/**
 * Created by saeed on 4/14/2016.
 */
public class TourismAttractionRepository extends GenericRepository<TourismAttraction> {

    public void addInfoVoting(UUID id, VoteValues voteValueModel) {
    }

}
