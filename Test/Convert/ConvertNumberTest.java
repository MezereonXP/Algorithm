package Convert;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2018/5/17.
 */
public class ConvertNumberTest {

  @Test
  public void solution() throws Exception {
    Assert.assertEquals("捌拾玖亿元整", ConvertNumber.solution("8900000000"));
    Assert.assertEquals("肆万零陆佰零柒元整", ConvertNumber.solution("40607"));
    Assert.assertEquals("壹仟零壹元整", ConvertNumber.solution("1001"));
    Assert.assertEquals("拾万零拾元整", ConvertNumber.solution("100010"));
    Assert.assertEquals("拾亿零壹佰万零拾元整", ConvertNumber.solution("1001000010"));
    Assert.assertEquals("壹佰亿零壹佰万零拾元整", ConvertNumber.solution("10001000010"));
  }

}