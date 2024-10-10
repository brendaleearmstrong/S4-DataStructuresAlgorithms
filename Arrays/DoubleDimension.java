package arrays;

public class DoubleDimension {
    int[][] arr = null;

    public DoubleDimension(int rows, int cols) {
        arr = new int[rows][cols];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = Integer.MIN_VALUE;
            }
        }
    }

    // 1. Insert method
    public void insert(int valueToInsert, int row, int col) {
        try {
            if (arr[row][col] == Integer.MIN_VALUE) {
                arr[row][col] = valueToInsert;
                System.out.println("Successfully inserted");
            } else {
                System.out.println("This Cell is already occupied");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array");
        }
    }

    // 2. Traverse method
    public void traverse() {
        try {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Array no longer exists");
        }
    }

    // 3. Search for an element
    public void searchArray(int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == valueToSearch) {
                    System.out.println("Value is found at the index [" + i + "][" + j + "]");
                    return;
                }
            }
        }
        System.out.println(valueToSearch + " is not found");
    }

    // 4. Delete an element from a specific index
    public void deleteValueAtIndex(int row, int col) {
        try {
            arr[row][col] = Integer.MIN_VALUE;
            System.out.println("The value has been deleted successfully");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("The value that is provided is not in the range of array");
        }
    }

    public static void main(String[] args) {
        DoubleDimension doubleDimension = new DoubleDimension(3, 3);

        // Test insert method
        doubleDimension.insert(1, 0, 0);
        doubleDimension.insert(2, 0, 1);
        doubleDimension.insert(3, 1, 1);
        doubleDimension.insert(4, 2, 2);

        // Test traverse method
        System.out.println("Array after insertion:");
        doubleDimension.traverse();

        // Test search method
        doubleDimension.searchArray(3);
        doubleDimension.searchArray(5);

        // Test delete method
        doubleDimension.deleteValueAtIndex(1, 1);

        System.out.println("Array after deletion:");
        doubleDimension.traverse();
    }
}