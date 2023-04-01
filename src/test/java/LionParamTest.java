import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import com.example.Feline;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParamTest {
    private final String sex;
    private final Feline feline;
    private final boolean isHasMane;

    public LionParamTest(String sex, boolean isHasMane) {
        this.sex = sex;
        this.isHasMane = isHasMane;
        this.feline = new Feline();
    }

    @Parameterized.Parameters
    public static Object[] getDataHasMane() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void getHaveManeReturns() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(isHasMane, actualHasMane);
    }
}