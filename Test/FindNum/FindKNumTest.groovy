package FindNum

/**
 * Created by Administrator on 2018/4/8.
 */
class FindKNumTest extends GroovyTestCase {
    void testFind() {
        FindKNum findKNum = new FindKNum();
        String s = findKNum.find("1,1,1,2,2,3 2");
        System.out.println(s);
    }
}
