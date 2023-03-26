import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;


@RunWith(Parameterized.class)
public class LionParamTest {

    private final boolean isMane;
    private final String sex;

    @Mock
    private Feline feline;
    private Lion lion;

    public LionParamTest(String sex, boolean isMane) {
        this.sex = sex;
        this.isMane = isMane;
    }

    @Parameterized.Parameters(name = "Тест LionParamTest - {0}")
    public static Object[] getParameters() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
                {"NOT_DEFINED", false},
        };
    }

    @Test
    public void doesHaveManeTest() {
        try {
            lion = new Lion(sex, feline);
            Boolean expectedIsMane = isMane;
            Boolean actualIsMane = lion.doesHaveMane();
            Assert.assertEquals(expectedIsMane, actualIsMane);
        } catch (Exception e) {
            System.out.println("Неизвестный пол льва");
        }
    }
}
