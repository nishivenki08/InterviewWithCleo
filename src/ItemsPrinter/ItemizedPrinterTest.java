package ItemsPrinter;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ItemizedPrinterTest {
    @Test
    public void shouldPrintTheItemsiNexpectedOrder() {
        List<ItemizedItemsPrinter.Items> inputItemsList = getInputItemsList();
        List<String> output = getOutputItemsList();
        List<String> input = new ArrayList<>();
        ItemizedItemsPrinter.getPrintableItemList("Example", inputItemsList, input);
        Assert.assertTrue(input.containsAll(output));
    }

    private ArrayList<String> getOutputItemsList() {
        //Expected example output
        return new ArrayList<>(Arrays.asList(
                "Example.0:\ta string",
                "Example.1.0:\ta",
                "Example.1.1:\tb",
                "Example.1.2.0:\t1",
                "Example.1.2.1:\t2",
                "Example.1.2.2:\t3",
                "Example.2:\tspam",
                "Example.3.0:\teggs"));
    }

    private List<ItemizedItemsPrinter.Items> getInputItemsList() {
        //Example nested list [‘a string’, [‘a’,’b’,[‘1’,’2’,’3’]], ‘spam’, [‘eggs’]]
        ItemizedItemsPrinter.Items example1 = new ItemizedItemsPrinter.Items("a string", null);
        ItemizedItemsPrinter.Items example2 = new ItemizedItemsPrinter.Items(null, new ArrayList<>(Arrays.asList(
                new ItemizedItemsPrinter.Items("a", null),
                new ItemizedItemsPrinter.Items("b", null),
                new ItemizedItemsPrinter.Items(null, new ArrayList<>(Arrays.asList(
                        new ItemizedItemsPrinter.Items("1", null),
                        new ItemizedItemsPrinter.Items("2", null),
                        new ItemizedItemsPrinter.Items("3", null)
                ))))));
        ItemizedItemsPrinter.Items example3 = new ItemizedItemsPrinter.Items("spam", null);
        ItemizedItemsPrinter.Items example4 = new ItemizedItemsPrinter.Items(null, new ArrayList<>(Arrays.asList(
                new ItemizedItemsPrinter.Items("eggs", null))));
        List<ItemizedItemsPrinter.Items> inputItemsList = new ArrayList<>(Arrays.asList(example1, example2, example3, example4));
        return inputItemsList;
    }
}
