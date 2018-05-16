package Counts;

import static org.junit.Assert.*;

import org.jboss.netty.logging.Slf4JLoggerFactory;
import org.junit.Assert;
import org.junit.Test;
import org.testng.log4testng.Logger;

/**
 * Created by Administrator on 2018/5/16.
 */
public class ArithmeticTest {

  private static final Logger logger = Logger.getLogger(ArithmeticTest.class);

  @Test
  public void solution() throws Exception {
    logger.debug(Arithmetic.solution("1 + 3 / 3"));
    Assert.assertEquals("185", Arithmetic.solution("323 + 160 / 40 - 142"));
    Assert.assertEquals("603", Arithmetic.solution("455 - 144 / 18 + 156"));
    Assert.assertEquals("err", Arithmetic.solution("455 - 144 / 0 + 156"));
    Assert.assertEquals("246", Arithmetic.solution("17 + 233 - 43 / 10"));
    Assert.assertEquals("50", Arithmetic.solution("60 + 10 / 17 - 10"));
  }

}