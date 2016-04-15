package base;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * Created by peyman on 4/15/2016.
 */
public class SearchPojo implements Serializable {
    @PostConstruct
    public void init(){
        System.out.println("ddddd");
    }
    private String param;

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
