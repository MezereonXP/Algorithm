package FindNum;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created by Administrator on 2018/4/10.
 */
public class FindTripleGroupTest {
    @Test
    public void find() throws Exception {
        FindTripleGroup findTripleGroup = new FindTripleGroup();
        Assert.assertEquals("TestCase1","2",findTripleGroup.find("-1,0,1,2,-1,-4"));
        Assert.assertEquals("TestCase2","1",findTripleGroup.find("0,0,0,0"));
        Assert.assertEquals("TestCase3","0",findTripleGroup.find("-2,-1,1,2"));
        Assert.assertEquals("TestCase4","6",findTripleGroup.find("-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6"));

    }

}