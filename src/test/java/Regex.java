import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

public class Regex {
   /* public static void main(String[] args) throws IOException {
        // String[] testData = { "0975156900", "(097)5156900", "(097)515-69-00", "(097)51-56-900", "+380975156900",
        //         "+38 097 515 69 00" };
        test1_isPhone();
        test2_isPhone();
    }*/
    public static boolean isPhone(String text) {
        String regex = "(?:\\+38)? ?(?:0\\d{2}|\\(0\\d{2}\\)) ?\\d{2}(?:\\d{3}|\\d[- ]\\d{2}[- ]|[ -]\\d{2}[ -]\\d)\\d{2}";
        return text.matches(regex);
    }
    @Test
    public static void test1_isPhone() {
        String testData = "0975156900";

        boolean result = isPhone(testData);
        Assert.assertTrue(result, "test1");
       /* if (result == true) {
            System.out.println("Test1 passed");
        } else {
            System.out.println("Test1 failed");
        }*/
    }
    @Test
    public static void test2_isPhone() {
        String testData = "asdaddasds";

        boolean result = isPhone(testData);
        Assert.assertFalse(result,"test2");
       /* if (result == false) {
            System.out.println("Test2 passed");
        } else {
            System.out.println("Test2 failed");
        }*/
           }
    @Test
    public static void test3_isPhone(){
        String testData = "(097)515-69-00";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "test3");
    }
    @Test
    public static void test4_isPhone(){
        String testData = "+38 097 515 69 00";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "test4");
    }
    @Test
    public static void test5_isPhone(){
        String testData = "(097)51-56-900";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "test5");
    }
    @Test
    public static void test6_isPhone(){
        String testData = "asdasdasdfa";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "test6");
    }
    @Test
    public static void test7_isPhone(){
        String testData = "+380975156900";
        boolean result = isPhone(testData);
        Assert.assertTrue(result, "test7");
    }
    @Test
    public static void test8_isPhone(){
        String testData = "+()123-123-123";
        boolean result = isPhone(testData);
        Assert.assertFalse(result, "test8");
    }
}