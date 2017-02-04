package seedu.addressbook.data;

import java.util.ArrayList;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class Tagging {
    private ArrayList<String> tagList;

    public Tagging() {
        tagList = new ArrayList<String>();
    }

    /**
     * records whenever a person has a tag added
     * 
     * @param tag
     *            tag to be added
     * @param person
     *            person who has the tag added to
     */
    public void addTag(String tag, ReadOnlyPerson person) {
        tagList.add("+ " + person.getName().toString() + " [" + tag + "]");
    }

    /**
     * records whenever a person has a tag removed
     * 
     * @param tag
     *            tag to be removed
     * @param person
     *            person who has the tag removed from
     */
    public void removeTag(String tag, ReadOnlyPerson person) {
        tagList.add("- " + person.getName().toString() + " [" + tag + "]");
    }

    public String getTagList() {
        StringBuilder builder = new StringBuilder();
        final String newLine = "\n";
        for (String line : this.tagList) {
            builder.append(line);
            builder.append(newLine);
        }
        return builder.toString().trim();
    }
}
