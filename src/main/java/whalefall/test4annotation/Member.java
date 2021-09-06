package whalefall.test4annotation;

/**
 * @author: WhaleFall541
 * @date: 2021/10/6 17:33
 */
public class Member {

    @MemberLevel(type = "Annotation value in Normal class")
    public static class Normal {
        @MemberLevel(type = "Annotation value on testMth method")
        public void testMth() {

        }

        void doSmt() {
            System.err.println("normal");
        }
    }

}
