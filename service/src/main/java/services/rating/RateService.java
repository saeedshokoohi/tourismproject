package services.rating;

import base.AutherDto;
import base.TourismAttractionInfoDto;
import base.UserDto;
import domain.base.Auther;
import domain.vote.VoteValues;
import repository.VoteRepository;
import vote.TourismAttractionVoteInfoDto;
import vote.VoteValuesDto;

import javax.inject.Inject;

/**
 * Created by saeed on 4/14/2016.
 */
public class RateService {

    @Inject
    VoteRepository voteRepository;
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

//        Auther auther=convert

        //updating vote rates on repository
        voteRepository.addInfoVoting(infoDto.getId(),voteValueModel);



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
