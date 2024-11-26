import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    private int binarySearch(String element) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = list.get(mid).compareTo(element);

            if (comparison == 0) {
                return mid; // Element already exists
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public void add(String element) {
        int index = binarySearch(element);
        list.add(index, element);
    }

    public String getListAsString() {
        return list.toString();
    }

    public String search(String element) {
        int index = binarySearch(element);
        if (index < list.size() && list.get(index).equals(element)) {
            return "Element found at index: " + index;
        } else {
            return "Element not found. It would be inserted at index: " + index;
        }
    }
}