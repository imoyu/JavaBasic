import org.junit.Test;

public class ExceptionTest {

    @Test
    public void tryCatchfinallyTest() {

        System.out.println(f());

    }

    private int f() throws RuntimeException{
        try {
            System.out.println(">>>");
            System.out.println("<<<");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return 2;
        } finally {
            return 1;
        }
    }
}
