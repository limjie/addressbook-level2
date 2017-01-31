package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book. Guarantees: immutable; is
 * valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street, #01-01, 123456";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = "\\S+, \\S+, \\S+, \\S+";
    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTAL_CODE_INDEX = 3;
    private static final String SPACE = " ";
    private static final int LARGE_PRIME = 1013;
    
    private boolean isPrivate;
    public Block block;
    public Street street;
    public Unit unit;
    public PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException
     *             if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = removeAddressPrefix(address).trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        try {
            String[] addressArray = trimmedAddress.split(", ");
            this.block = new Block(addressArray[BLOCK_INDEX]);
            this.street = new Street(addressArray[STREET_INDEX]);
            this.unit = new Unit(addressArray[UNIT_INDEX]);
            this.postalCode = new PostalCode(addressArray[POSTAL_CODE_INDEX]);
        } catch (Exception e) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
    }

    private class Block {
        private int blockNumber;

        /**
         * Constructor of Block
         * 
         * @param block
         *            block number of the address
         */
        public Block(String block) {
            blockNumber = Integer.parseInt(block);
        }

        /**
         * 
         * @return returns the block number
         */
        public int getBlockNumber() {
            return this.blockNumber;
        }
    }

    private class Street {
        private String streetName;

        /**
         * Constructor of Street
         * 
         * @param street
         *            street name of the address
         */
        public Street(String street) {
            streetName = street;
        }

        /**
         * 
         * @return returns the street name
         */
        public String getStreetName() {
            return this.streetName;
        }
    }

    private class Unit {
        private String unitNumber;

        /**
         * Constructor of Unit
         * 
         * @param unit
         *            unit number of the address
         */
        public Unit(String unit) {
            unitNumber = unit;
        }

        /**
         * 
         * @return returns the unit number
         */
        public String getUnitNumber() {
            return this.unitNumber;
        }
    }

    private class PostalCode {
        private int postalCodeNumber;

        /**
         * Constructor of PostalCode
         * 
         * @param postalCode
         *            postal code of the address
         */
        public PostalCode(String postalCode) {
            postalCodeNumber = Integer.parseInt(postalCode);
        }

        /**
         * 
         * @return returns the postal code
         */
        public int getPostalCode() {
            return this.postalCodeNumber;
        }
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    /**
     * 
     * @param input
     *            string to take the a/ out from
     * @return return the string without the a/ prefix
     */
    private static String removeAddressPrefix(String input) {
        if (input.startsWith("a/")) {
            return input.replaceFirst("a/", "");
        } else {
            return input;
        }
    }

    @Override
    public String toString() {
        return this.block.getBlockNumber() + SPACE + this.street.getStreetName() + SPACE 
               + this.unit.getUnitNumber() + SPACE + this.postalCode.getPostalCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true; // short circuit if same object
        } else if (other instanceof Address) {// instanceof handles nulls
            Address otherAddress = (Address) other;
            boolean isBlockEqual = this.block.getBlockNumber() == otherAddress.block.getBlockNumber();
            boolean isStreetEqual = this.street.getStreetName().equals(otherAddress.street.getStreetName());
            boolean isUnitEqual = this.unit.getUnitNumber().equals(otherAddress.unit.getUnitNumber());
            boolean isPostalEqual = this.postalCode.getPostalCode() == otherAddress.postalCode.getPostalCode();
            return isBlockEqual && isStreetEqual && isUnitEqual && isPostalEqual;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int code = LARGE_PRIME;
        code = code*LARGE_PRIME + this.block.hashCode();
        code = code*LARGE_PRIME + this.street.hashCode();
        code = code*LARGE_PRIME + this.unit.hashCode();
        code = code*LARGE_PRIME + this.postalCode.hashCode();
        return code;
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
