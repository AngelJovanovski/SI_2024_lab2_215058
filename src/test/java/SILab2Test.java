import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class SILab2Test {

    @Test
    public void testEveryBranchCriteria() {
        // Write test cases based on the Every Branch testing criteria
        Item item1 = new Item("item1", "12345", 100, 0.1f);
        Item item2 = new Item("item2", "23456", 200, 0.2f);
        Item item3 = new Item("item3", "34567", 400, 0.3f);

        List<Item> itemList = Arrays.asList(item1, item2, item3);

        // Case 1: Valid items, payment more than sum
        assertTrue(SILab2.checkCart(itemList, 200));

        // Case 2: Valid items, payment less than sum
        assertFalse(SILab2.checkCart(itemList, 50));

        // Case 3: Item with no name
        item1.setName(null);
        assertTrue(SILab2.checkCart(itemList, 200));

        // Case 4: Item with invalid barcode
        item1.setBarcode("abcde");
        try {
            SILab2.checkCart(itemList, 200);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    @Test
    public void testMultipleConditionCriteria() {
        // Write test cases based on the Multiple Condition testing criteria
        Item item1 = new Item("item1", "023456", 350, 0.1f);
        Item item2 = new Item("item2", "123456", 250, 0.2f);

        // Case 1: Price > 300, discount > 0, barcode starts with '0'
        List<Item> itemList = Arrays.asList(item1);
        assertTrue(SILab2.checkCart(itemList, 200));

        // Case 2: Price <= 300, discount > 0, barcode does not start with '0'
        itemList = Arrays.asList(item2);
        assertTrue(SILab2.checkCart(itemList, 200));

        // Case 3: Price > 300, discount == 0, barcode starts with '0'
        item1.setDiscount(0);
        itemList = Arrays.asList(item1);
        assertFalse(SILab2.checkCart(itemList, 200));

        // Case 4: Price > 300, discount > 0, barcode does not start with '0'
        item1.setDiscount(0.1f);
        item1.setBarcode("123456");
        itemList = Arrays.asList(item1);
        assertFalse(SILab2.checkCart(itemList, 200));
    }
}
