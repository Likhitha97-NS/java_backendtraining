import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VariablesTests
{
    @DisplayName("Check variable value are coorect")
    @Test
    void learnTheVaraiablesValidCase(){
        int osNum=12;
        int expectedValue=12;
        Assertions.assertEquals(expectedValue, osNum);
    }
    @DisplayName("Check variable value are incoorect")
    @Test
    void learnTheVaraiablesInValidCase(){
        int osNum=12;
        int expectedValue=13;
        Assertions.assertNotEquals(expectedValue, osNum);
    }
}
