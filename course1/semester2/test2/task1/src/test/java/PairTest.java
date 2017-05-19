import org.junit.Assert;
import org.junit.Test;
import spbu.test2.task1.Pair;

/** Test class for pair game. */
public class PairTest {
    /** Create test. */
    @Test
    public void createPair() {
        Pair pair = new Pair(4);
    }

    /** Make a game move test. */
    @Test
    public void makeMove() {
        Pair pair = new Pair(4);

        pair.checkButtons(0, 0, 1, 1);
        Assert.assertTrue("Move error!", pair.getFirstButton().equals(pair.getSecondButton()) == pair.checkEquals());
    }
}
