import spbu.hw4.task1.UniqueList;
import spbu.hw4.task1.List;
import org.junit.Test;
import org.junit.Assert;
import java.util.Random;

public class UniqueListTest {
    private final int OPERATION_REPEAT = 1024;

    @Test
    public void testUniqueList() {
        List<Integer> testList = new UniqueList<>();
        Random randomizer = new Random();
        int repeatAlreadyExistsException = 0;
        int repeatNotFoundException = 0;

        for (int i = 0; i < OPERATION_REPEAT; i++) {
            int number = randomizer.nextInt();

            testList.add(number);
            try {
                testList.add(number);
            } catch (Exception e) {
                repeatAlreadyExistsException++;
            }
            testList.remove(number);

            number = randomizer.nextInt();
            try {
                testList.remove(number);
            } catch (Exception e) {
                repeatNotFoundException++;
            }
        }

        Assert.assertTrue("Some Already Exists exception not happened", repeatAlreadyExistsException == OPERATION_REPEAT);
        Assert.assertTrue("Some Not Found exception not happened", repeatNotFoundException == OPERATION_REPEAT);
    }
}