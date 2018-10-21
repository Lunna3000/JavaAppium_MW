import org.junit.Test;

public class MainClassTest extends MainClass {

//    @Test
//    public void testGetLocalNumber(){
//        int a = this.getLocalNumber();
//
//        if (a == 14) {
//            System.out.println("Yes, number = 14");
//        } else {
//            System.out.println("No, number != 14");
//        }
//    }
//
//    @Test
//    public void testGetClassNumber(){
//        int b = this.getClassNumber();
//
//        if (b > 45) {
//            System.out.println("Yes, number > 45");
//        } else {
//            System.out.println("No, number < 45 or number = 45");
//        }
//    }

    @Test
    public void testGetClassString() {
        String c = getClassString();

        boolean text = c.contains("Hello");
        boolean text2 = c.contains("hello");
        boolean check = ((text || text2) == true);

        if (check){
            System.out.println("Yes, the line contains the word \"Hello\" or \"hello\"");
        } else {
            assert check;
        }

    }

}
