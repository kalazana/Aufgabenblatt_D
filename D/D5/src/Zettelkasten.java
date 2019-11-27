import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Zettelkasten implements Iterable<Medium>, Serializable {
    private SortedState sorted = SortedState.NONE;
    private ArrayList<Medium> mediumArrayList = new ArrayList<>();

    /**
     * add's a medium instance
     * @param medium the Medium instance to add
     * @throws Medium.ValidationException
     */
    public void addMedium(Medium medium) throws Medium.ValidationException {
        // check if all fields are valid
        medium.validate();

        // add media to list
        mediumArrayList.add(medium);

        // set sorted state to none
        this.sorted = SortedState.NONE;
    }

    /**
     * removes a medium by it's title
     * @param title title of the medium
     * @throws DuplicateEntryException when multiple entries were found
     * @throws EntryNotFoundException when no entry was found
     */
    public void dropMedium(String title) throws DuplicateEntryException, EntryNotFoundException {
        ArrayList<Medium> results = new ArrayList<>();

        // iterate through ArrayList and compare titles
        for (Medium medium : mediumArrayList) {
            if (medium.getTitel().equals(title)) {
                // add medium to results list
                results.add(medium);
            }
        }

        if (results.size() > 1) {
            throw new DuplicateEntryException();
        } else if (results.size() == 0) {
            throw new EntryNotFoundException();
        } else {
            results.remove(results.get(0));
        }
    }

    /**
     * removes a medium by it's title, and index for the case there are multiple entries
     * @param title the title of the medium to remove
     * @param index the index within the results list
     * @throws EntryNotFoundException when there is no result at all or the index doesn't exists within results
     */
    public void dropMedium(String title, int index) throws EntryNotFoundException {
        if (index < 0) {
            throw new IllegalArgumentException("index can't be lower than 0");
        }

        ArrayList<Medium> results = this.findMedium(title);

        if (results.size() > index) {
            mediumArrayList.remove(index);
        }

        throw new EntryNotFoundException();
    }

    /**
     * returns a medium by title
     * @param title title of the medium
     * @return an ArrayList of results (could be empty)
     */
    public ArrayList<Medium> findMedium(String title) {
        ArrayList<Medium> results = new ArrayList<>();

        // iterate through ArrayList and compare titles
        for (Medium medium : mediumArrayList) {
            if (medium.getTitel().equals(title)) {
                // add medium to results list
                results.add(medium);
            }
        }

        // order by type
        results.sort(Comparator.comparing(a -> a.getClass().getCanonicalName()));

        // return results
        return results;
    }

    /**
     * sorts the internal ArrayList by media title from a-z
     * @param reversed if true, sorting will be done from z-a instead a-z
     */
    public void sort(boolean reversed) {
        if (this.sorted == SortedState.NONE) {
            this.mediumArrayList.sort(Comparator.naturalOrder());
            this.sorted = SortedState.ASC;
        }

        if ((reversed && this.sorted != SortedState.DESC) || (!reversed && this.sorted != SortedState.ASC)) {
            this.mediumArrayList.sort(Comparator.reverseOrder());
            this.sorted = SortedState.DESC;
        }
    }


    /**
     * sorts the internal ArrayList by media title from a-z
     */
    public void sort() {
        this.sort(false);
    }

    @Override
    public Iterator<Medium> iterator() {
        return mediumArrayList.iterator();
    }

    static class DuplicateEntryException extends Exception {
        DuplicateEntryException() {
            super();
        }
    }

    static class EntryNotFoundException extends Exception {
        EntryNotFoundException() {
            super();
        }
    }

    static enum SortedState {
        NONE, ASC, DESC;
    }
}