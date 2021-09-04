import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    // Your tests go here.

    @Test
    public void TestequalChars(){
        assertTrue(offByOne.equalChars('a','b'));
        assertFalse(offByOne.equalChars('y','Y'));
        assertFalse(offByOne.equalChars('4','4'));
        assertTrue(offByOne.equalChars('X','Y'));
    }

}
