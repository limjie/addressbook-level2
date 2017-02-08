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
        Name differentCaseName = null;
        Name subSetName = null;
        Name subSetNameDifferentCase = null;
        Name differentOrderName = null;
        try {
            testName = new Name("Lim Jie");
            otherName = new Name("Lim Jie");
            wrongName = new Name("Peter");
            differentCaseName = new Name("LIM JIE");
            subSetName = new Name("Lim");
            subSetNameDifferentCase = new Name("LIM");
            differentOrderName = new Name("Jie Lim");
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
        
        //check if similar to different case name
        assertTrue(testName.isSimilar(differentCaseName));
        
        //check if similar to a subset of name
        assertTrue(testName.isSimilar(subSetName));
        assertTrue(testName.isSimilar(subSetNameDifferentCase));
        
        //check if the name is in different order
        assertTrue(testName.isSimilar(differentOrderName));
    }

}
