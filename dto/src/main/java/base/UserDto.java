package base; /**
 * Created by saeed on 4/14/2016.
 */

/**
 * this dto is sttended to user info
 */
public class UserDto extends AutherDto {


    private double userRankLevel;

    public double getUserRankLevel() {
        return userRankLevel;
    }

    public void setUserRankLevel(double userRankLevel) {
        this.userRankLevel = userRankLevel;
    }
}
