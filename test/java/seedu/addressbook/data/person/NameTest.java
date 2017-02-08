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
        Name superSetName = null;
        Name superSetNameDifferentCase = null;
        Name wrongSpellingName = null;
        Name subSetWordInName = null;
        try {
            testName = new Name("Lim Jie");
            otherName = new Name("Lim Jie");
            wrongName = new Name("Peter");
            differentCaseName = new Name("LIM JIE");
            subSetName = new Name("Lim");
            subSetNameDifferentCase = new Name("LIM");
            differentOrderName = new Name("Jie Lim");
            superSetName = new Name("Lim Jun Jie");
            superSetNameDifferentCase = new Name("LIM jun Jie");
            wrongSpellingName = new Name("Lim Jii");
            subSetWordInName = new Name("Li Ji");
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
        
        //check if similar to a superset of name
        assertTrue(testName.isSimilar(superSetName));
        assertTrue(testName.isSimilar(superSetNameDifferentCase));
        
        //check if similar if the name is in different order
        assertTrue(testName.isSimilar(differentOrderName));
        
        //check if not similar if the name is spelled wrongly
        assertFalse(testName.isSimilar(wrongSpellingName));
        assertFalse(testName.isSimilar(subSetWordInName)); // too far to be considered similar
    }

}
