package vote;

import base.TourismAttractionInfoDto;

/**
 * Created by saeed on 4/14/2016.
 */

public class TourismAttractionVoteInfoDto {
    /**
     * the item which has been voted
     */
    TourismAttractionInfoDto targetItem;
    /**
     * vote values for this item
     */
    VoteValuesDto votes;

    public TourismAttractionInfoDto getTargetItem() {
        return targetItem;
    }

    public void setTargetItem(TourismAttractionInfoDto targetItem) {
        this.targetItem = targetItem;
    }

    public VoteValuesDto getVotes() {
        return votes;
    }

    public void setVotes(VoteValuesDto votes) {
        this.votes = votes;
    }
}
