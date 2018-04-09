package FindNum

/**
 * Created by Administrator on 2018/4/9.
 */
class FindNiceNumTest extends GroovyTestCase {
    void testFind() {
        FindNiceNum findNiceNum = new FindNiceNum();
        System.out.println(findNiceNum.find('3'));
    }
}
