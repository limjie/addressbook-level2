package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.TestName;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {

    @Test
    public void testIsSimilar() {
        Name Testname = null;
        try {
            Testname = new Name("Lim Jie");
        } catch (IllegalValueException ive) {
            throw new RuntimeException("test name should be valid by definition");
        }
        assertFalse(Testname.isSimilar(null));
    }

}
