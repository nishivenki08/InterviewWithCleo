package ItemsPrinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemizedItemsPrinter {
    public static void main(String[] args) {
        List<Items> inputItemsList = getInputItemsList();
        itemizeList("Example", inputItemsList);
    }

    public static void itemizeList(String header, List<Items> inputItemsList) {
        List<String> printableStrings = new ArrayList<>();
        getPrintableItemList(header, inputItemsList, printableStrings);
        printableStrings.forEach(System.out::println);
    }

    public static void getPrintableItemList(String header, List<Items> inputItemsList, List<String> printableStrings) {
        int level = 0;

        for (Items item : inputItemsList) {
            String h = header + "." + level;
            if (item.data != null) {
                printableStrings.add(h + ":" + "\t" + item.data);
            } else {
                getPrintableItemList(h, item.items, printableStrings);
            }
            level++;
        }
    }

    private static List<Items> getInputItemsList() {
        //Example nested list [‘a string’, [‘a’,’b’,[‘1’,’2’,’3’]], ‘spam’, [‘eggs’]]
        Items example1 = new Items("a string", null);
        Items example2 = new Items(null, new ArrayList<>(Arrays.asList(
                new Items("a", null),
                new Items("b", null),
                new Items(null, new ArrayList<>(Arrays.asList(
                        new Items("1", null),
                        new Items("2", null),
                        new Items("3", null)
                ))))));
        Items example3 = new Items("spam", null);
        Items example4 = new Items(null, new ArrayList<>(Arrays.asList(
                new Items("eggs", null))));
        List<Items> inputItemsList = new ArrayList<>(Arrays.asList(example1, example2, example3, example4));
        return inputItemsList;
    }

    static class Items {
        String data;
        List<Items> items;

        public Items(String data, List<Items> items) {
            this.data = data;
            this.items = items;
        }
    }
}
