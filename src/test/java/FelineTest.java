import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;

    @Test
    public void eatMeatTest() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualFood = feline.eatMeat();
        Assert.assertEquals(expectedFood, actualFood);
    }

    @Test
    public void getFamilyTest() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        Assert.assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void getKittensNoCountTest() {
        Mockito.when(feline.getKittens(1)).thenReturn(1);
        int expectedKittensNoCount = 1;
        int actualKittensNoCount = feline.getKittens();
        Assert.assertEquals(expectedKittensNoCount, actualKittensNoCount);
    }

    @Test
    public void getKittensWithCount() {
        int expectedKittensWithCount = 3;
        int actualKittensWithCount = feline.getKittens(3);
        Assert.assertEquals(expectedKittensWithCount, actualKittensWithCount);
    }
}
