package services.rating;

import base.AutherDto;
import base.TourismAttractionInfoDto;
import base.UserDto;
import domain.base.Auther;
import domain.vote.VoteValues;
import repository.RatingRepository;
import repository.UserRepository;
import util.AverageAlgorithm;
import util.BayesianAlgorithm;
import util.RateValue;
import vote.TourismAttractionVoteInfoDto;
import vote.VoteValuesDto;

import javax.inject.Inject;
import java.util.List;
import java.util.UUID;

/**
 * Created by saeed on 4/14/2016.
 */
public class RateService {

    @Inject
    UserRepository userRepository;

    @Inject
    RatingRepository voteRepository;
    /***
     * submit user vote for an item
     *
     * @param voter the one who is submitting vote
     * @param infoDto the object which is vote for
     * @param vote the given vote
     */
    public void rateItem(UserDto voter, TourismAttractionInfoDto infoDto, VoteValuesDto vote)
    {

        TourismAttractionVoteInfoDto tourismAttractionVoteInfoDto=new TourismAttractionVoteInfoDto();
        tourismAttractionVoteInfoDto.setTargetItem(infoDto);

        double userlevel = voter.getUserRankLevel();

        //changing given votes based on
        //user rate level
        //high rate level cause more effective rate
        overRateVoteValues(vote,userlevel);

        //recalculating item rate
        //on new rate values
        recalculateTotalRank(vote);

        //changing the auther of info rate
        //on changing the rate changed on his info
        upgradeInfoAutherRating(infoDto.getAuther(),vote);

        //convert dto to model object to save on repository
        VoteValues voteValueModel = convertToVoteModel(vote);
         Auther auther=convertToAutherModel(infoDto.getAuther());


        //updating vote rates on repository
        voteRepository.addInfoVoting(infoDto.getId(),voteValueModel);
        userRepository.updateAutherRate(auther);




    }

    /**
     *
     * @param auther
     * @return
     */
    private Auther convertToAutherModel(AutherDto auther) {
        return null;
    }


    /**
     * this method change the auther rating level
     * @param auther
     * @param vote
     */
    private void upgradeInfoAutherRating(AutherDto auther, VoteValuesDto vote) {

    }

    /**
     * get the new vote values and recalcute the average algorithm
     * @param vote
     */
    private void recalculateTotalRank(VoteValuesDto vote) {

        //making average algorithm
        AverageAlgorithm algorithm=new BayesianAlgorithm();

        double newRank= algorithm.calculate(makeInputList(vote));
        vote.setTotalRank(newRank);

    }

    private List<RateValue> makeInputList(VoteValuesDto vote) {
        return null;
    }

    /**
     * convert voteValueDtos to voteValueObject
     * @param vote
     * @return
     */
    private VoteValues convertToVoteModel(VoteValuesDto vote) {
        VoteValues retVoteValues=new VoteValues();
        retVoteValues.setOneStarCount(vote.getOneStarCount());
        retVoteValues.setTwoStarCount(vote.getTwoStarCount());
        retVoteValues.setThreeStarCount(vote.getThreeStarCount());
        retVoteValues.setFourStarCount(vote.getFourStarCount());
        retVoteValues.setFiveStarCount(vote.getFiveStarCount());
return  retVoteValues;
    }

    /**
     * change the vote values based the user level
     * @param vote
     * @param userlevel
     */
    private void overRateVoteValues(VoteValuesDto vote, double userlevel) {
       vote.setOneStarCount( vote.getOneStarCount()*userlevel);
       vote.setTwoStarCount( vote.getTwoStarCount()*userlevel);
       vote.setThreeStarCount( vote.getThreeStarCount()*userlevel);
       vote.setFourStarCount( vote.getFourStarCount()*userlevel);
       vote.setFiveStarCount( vote.getFiveStarCount()*userlevel);

    }


}
