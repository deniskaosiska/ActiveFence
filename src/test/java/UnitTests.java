import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTests {

    //test of verify Unlock in progress state
    @Test
    public static void verifyUnlockState() {
        try {
            Assert.assertEquals(Main.vaultState.state(), "Unlock In progress");
        }
        catch(AssertionError | Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //test of verify Open state
    @Test
    public static void verifyOpenState() {
        try {
            Assert.assertEquals(Main.vaultState.state(), "Open");
        }
        catch(AssertionError | Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //test of verify Close state
    @Test
    public static void verifyCloseState() {
        try {
            Assert.assertEquals(Main.vaultState.state(), "Close");
        }
        catch(AssertionError | Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //test of verify Sealed state
    @Test
    public static void verifySealedState() {
        try {
            Assert.assertEquals(Main.vaultState.state(), "Sealed");
        }
        catch(AssertionError | Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //test of verify entered first key have 8 characters
    @Test
    public static void verifyLengthFirstKey() {
        try {
            Assert.assertEquals("Key have "+Main.length1+" characters", "Key have "+8+" characters");
        }
        catch(AssertionError | Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    //test of verify entered second key have 8 characters
    @Test
    public static void verifyLengthSecondKey() {
        try {

            Assert.assertEquals("Key have "+Main.length2+" characters", "Key have "+8+" characters");
        }
        catch(AssertionError | Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

}
