package repository;

import domain.base.Auther;
import domain.base.User;
import domain.base.VoteValues;
import repository.support.GenericRepository;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by saeed on 4/14/2016.
 */
public class UserRepository extends GenericRepository<User> implements Serializable {
    public void addInfoVoting(UUID id, VoteValues voteValueModel) {

    }


}
