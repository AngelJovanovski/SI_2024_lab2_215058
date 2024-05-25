# SI_2024_lab2_215058

**Име:** Ангел
**Презиме:** Јовановски
**Број на индекс:** 215058

## Control Flow Graph (CFG)

![Control Flow Graph](https://drive.google.com/uc?export=download&id=1TurzTpUnLDoLMfsfMlKRe7XQ8aUwkA_Z)

## Cyclomatic Complexity Calculation

Formula:

\[ M = E - N + 2P \]

- \( M \) is the Cyclomatic Complexity
- \( E \) is the number of edges in the graph
- \( N \) is the number of nodes in the graph
- \( P \) is the number of connected components (typically 1)

Given the code provided in SILab2.java, we count the nodes and edges as follows:

**Nodes:**
1. Initial check for `allItems == null`
2. Loop start
3. Loop end
4. Null or empty check for `item.getName()`
5. Null or empty check for `item.getBarcode()`
6. Loop start for characters in `item.getBarcode()`
7. Loop end for characters in `item.getBarcode()`
8. Condition for `item.getDiscount() > 0`
9. Condition for `item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'`
10. Final check `sum <= payment`

**Edges:**
- From node 1 to 2
- From node 2 to 3 (loop condition)
- From node 2 to 10 (loop exit)
- From node 4 to 5
- From node 5 to 6
- From node 6 to 7 (loop condition)
- From node 6 to 8
- From node 8 to 9

Calculating the Cyclomatic Complexity:

\[ M = 8 - 10 + 2(1) = 0 \]

The Cyclomatic Complexity is 0.

## Test Cases Based on Every Branch Criterion

1. **Test Case 1 - `allItems == null` (True Branch)**
   - Input: `allItems = null`, `payment = 100`
   - Expected Output: `RuntimeException` with message "allItems list can't be null!"
   - Explanation: Verifies the behavior when the input list `allItems` is `null`.

2. **Test Case 2 - Loop Over `allItems` (True Branch)**
   - Input: A list `allItems` with at least one valid item, `payment = 100`
   - Expected Output: The method should complete without any exceptions.
   - Explanation: Checks the behavior of the method when iterating over the items in the list.

3. **Test Case 3 - `item.getName() == null || item.getName().length() == 0` (True Branch)**
   - Input: An item with `name` as `null` or an empty string, `payment = 100`
   - Expected Output: The `name` of the item should be set to "unknown".
   - Explanation: Ensures that the method handles null or empty names of items correctly.

4. **Test Case 4 - `item.getBarcode() == null` (True Branch)**
   - Input: An item with `barcode` as `null`, `payment = 100`
   - Expected Output: `RuntimeException` with message "No barcode!"
   - Explanation: Verifies the behavior when the barcode of an item is null.

5. **Test Case 5 - Valid Barcode Characters (True Branch)**
   - Input: An item with a valid barcode, `payment = 100`
   - Expected Output: The method should complete without any exceptions.
   - Explanation: Checks if the method handles valid barcode characters correctly.

6. **Test Case 6 - `item.getDiscount() > 0` (True Branch)**
   - Input: An item with a discount greater than 0, `payment = 100`
   - Expected Output: The `sum` should be incremented by the discounted price of the item.
   - Explanation: Ensures that the method calculates the sum correctly when there is a discount on the item.

7. **Test Case 7 - `item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'` (True Branch)**
   - Input: An item with price greater than 300, discount greater than 0, and barcode starting with '0', `payment = 100`
   - Expected Output: The `sum` should be decremented by 30.
   - Explanation: Checks if the method applies the discount correctly when the specified conditions are met.

8. **Test Case 8 - Final Check `sum <= payment` (True Branch)**
   - Input: The total sum of all item prices is less than or equal to the payment amount.
   - Expected Output: `true`
   - Explanation: Verifies the method's return value when the payment is sufficient to cover the total sum of item prices.

9. **Test Case 9 - Final Check `sum <= payment` (False Branch)**
   - Input: The total sum of all item prices is greater than the payment amount.
   - Expected Output: `false`
   - Explanation: Ensures that the method returns `false` when the payment is insufficient to cover the total sum of item prices.

## Test Cases Based on Multiple Condition Criterion

1. **Test Case 1 - All Conditions True**
   - Input: An item with price > 300, discount > 0, and barcode starts with '0', `payment = 100`
   - Expected Output: The `sum` should be decremented by 30.
   - Explanation: Verifies if the discount of 30 is applied correctly when all conditions are met.

2. **Test Case 2 - Price Less Than 300**
   - Input: An item with price <= 300, discount > 0, and barcode starts with '0', `payment = 100`
   - Expected Output: The `sum` should not be decremented by 30.
   - Explanation: Checks if the discount is not applied when the price of the item is less than or equal to 300.

3. **Test Case 3 - Discount Not Greater Than 0**
   - Input: An item with price > 300, discount <= 0, and barcode starts with '0', `payment = 100`
   - Expected Output: The `sum` should not be decremented by 30.
   - Explanation: Ensures that the discount is not applied when the discount of the item is not greater than 0.

4. **Test Case 4 - Barcode Does Not Start with '0'**
   - Input: An item with price > 300, discount > 0, and barcode does not start with '0', `payment = 100`
   - Expected Output: The `sum` should not be decremented by 30.
   - Explanation: Verifies that the discount is not applied when the barcode does not start with '0'.

