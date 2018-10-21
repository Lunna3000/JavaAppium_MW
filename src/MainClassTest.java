import org.junit.Test;

public class MainClassTest extends MainClass {

    @Test
    public void testGetLocalNumber(){
        int a = this.getLocalNumber();

        if (a == 14) {
            System.out.println("Yes, number = 14");
        } else {
            System.out.println("No, number != 14");
        }

    }
}
