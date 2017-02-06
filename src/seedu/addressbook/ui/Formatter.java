package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.util.List;

public class Formatter {
    /**
     * A decorative prefix added to the beginning of lines printed by
     * AddressBook
     */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    private static final String NEWLINE_DIVIDER = newLine(DIVIDER);

    /** Offset required to convert between 1-indexing and 0-indexing. */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    public String getEnterCommandString() {
        return LINE_PREFIX + "Enter command: ";
    }

    public String getCommandEnteredString(String fullInputLine) {
        return newLine("[Command entered:" + fullInputLine + "]");
    }

    public static String newLine(String message) {
        return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX) + LS;
    }

    public String getWelcomeMessage(String version, String storageFileInfo) {
        return NEWLINE_DIVIDER + NEWLINE_DIVIDER + newLine(MESSAGE_WELCOME) + newLine(version)
                + newLine(MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE) + newLine(storageFileInfo) + NEWLINE_DIVIDER;
    }

    public String addDoubleDividerToBack(String message) {
        return newLine(message) + NEWLINE_DIVIDER + NEWLINE_DIVIDER;
    }

    public String addSingleDividerToBack(String message) {
        return newLine(message) + NEWLINE_DIVIDER;
    }

    /** Formats a list of strings as a viewable indexed list. */
    public String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(newLine(getIndexedListItem(displayIndex, listItem)));
            displayIndex++;
        }
        return formatted.toString() + LINE_PREFIX + LS;
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex
     *            visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

}
