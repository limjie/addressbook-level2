package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.TestName;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    @Test
    public void testIsSimilar() {
        Name testName = null;
        Name otherName = null;
        Name wrongName = null;
        try {
            testName = new Name("Lim Jie");
            otherName = new Name("Lim Jie");
            wrongName = new Name("Peter");
        } catch (IllegalValueException ive) {
            throw new RuntimeException("test name should be valid by definition");
        }
        
        //null test
        assertFalse(testName.isSimilar(null));
        assertFalse(testName.isSimilar((Name) null));
        
        // check if similar to oneself
        assertTrue(testName.isSimilar(testName));
        assertTrue(testName.isSimilar(otherName));
        
        //check if similar to other names
        assertFalse(testName.isSimilar(wrongName));
    }

}
