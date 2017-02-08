package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Represents a Person's name in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";
    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException
     *             if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        String trimmedName = name.trim();
        if (!isValidName(trimmedName)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = trimmedName;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                        && this.fullName.equals(((Name) other).fullName)); // state
                                                                           // check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }

    /**
     * Returns true of the other name is very similar to this name. Two names
     * are considered similar if ...
     */
    public boolean isSimilar(Name other) {
        if (other == null) {
            return false;
        }
        if (this.equals(other)) {
            return true;
        }
        if (this.isSubSetOfNameInLowercase(other)) {
            return true;
        }
        if (other.isSubSetOfNameInLowercase(this)) {
            return true;
        }
        return false;
    }

    /**
     * 
     * @param other
     *            the other name to be tested
     * @return true if the other name is a subset of the original name
     */
    private boolean isSubSetOfNameInLowercase(Name other) {
        List<String> nameSet = Arrays.asList(this.toString().toLowerCase().split(" "));
        String[] otherNameSet = other.toString().split(" ");
        for (String word : otherNameSet) {
            if (word.startsWith(",")) {
                word = word.replaceFirst(",", "");
            } else if (word.endsWith(",")) {
                word = word.substring(0, word.length() - 1);
            }
            if (!nameSet.contains(word.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}