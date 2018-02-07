package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents an Address's block number in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidBlock(String)}
 */
public class Block {
    public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Address block should only contain only numbers";
    public static final String BLOCK_VALIDATION_REGEX = "\\d+";

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given phone number.
     *
     * @throws IllegalValueException if given block string is invalid.
     */
    public Block(String block, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedBlock = block.trim();
        if (!isValidBlock(trimmedBlock)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        this.value = trimmedBlock;
    }

    /**
     * Returns true if the given string is a valid address block number.
     */
    public static boolean isValidBlock(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.value.equals(((Block) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
