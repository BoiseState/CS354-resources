// javac ArrayCPUCache.java && java ArrayCPUCache

public class ArrayCPUCache {
    
    public static void main(String[] args) {
        //explore traversing large multidimensional arrays row order and column order

        long [][] array = new long[10000][10000];

        long rowOrderTraversal = System.currentTimeMillis();

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = 1L;
            }
        }

        rowOrderTraversal = System.currentTimeMillis() - rowOrderTraversal;

        System.out.println("Row order traversal time: " + rowOrderTraversal);

        long columnOrderTraversal = System.currentTimeMillis();

        for (int col = 0; col < array[0].length; col++) {
            for (int row = 0; row < array.length; row++) {
                array[row][col] = 1L;
            }
        }

        columnOrderTraversal = System.currentTimeMillis() - columnOrderTraversal;

        System.out.println("Column order traversal time: " + columnOrderTraversal);
    }
}
