public class RecArray {
    private static int[] intArray = {-20, -30, -50, -40, -10};

    /**
     * This method adds all array element from index to the end.
     * @param index - valid array index
     * @return - integer that is the sum of array elements from index
     * to the end of the array.
     */
    private static int sumByHead(int index) {
        if (index == intArray.length-1)  // if we reached the end
            return intArray[index];
        else {
            int sumOfRest = sumByHead(index+1); // add up all elements after index
            return sumOfRest + intArray[index]; // add current element to result
        }
    }
    // sum is the sum of elements thus far
    private static int sumByTail(int index, int sum) {
        if (index == intArray.length -1)
            return sum + intArray[index];
        else {
            int currentSum = sum + intArray[index];
            return sumByTail(index+1, currentSum);
        }
    }
    public static int sumArray() {
        //return sumByHead(0);
        return sumByTail(0,0);
    }

    public static int maxArray(int index) {
        if (index  >= intArray.length-1) {
            return intArray[index];
        } else {
            int previousMax = maxArray(index+1);
            return Math.max(intArray[index], previousMax);
        }
    }
    // tail 
    public static int maxIntArray(int index, int max) {
        if (index == intArray.length)
            return max;
        else {
            if (intArray[index] > max) 
                max = intArray[index];

            return maxIntArray(index+1, max);
        }
    }
    public static int findMax() {
        return maxIntArray(0, Integer.MIN_VALUE);
    }

    private static int binarySearch(int low, int high, int key) {
        if (high >= low) {
            int mid = (low + high) /2;

            if (intArray[mid] == key)
                return mid;
            
            if (key < intArray[mid]) // key is on the left
                return binarySearch(low, mid-1, key); // look to left of middel
            else // key > middle element, key is on the right
                return binarySearch(mid+1, high, key);
        }
        // if we reach here, the element is not in the array
        return -1;
    } 
    public static int binarySearch(int key) {
        return binarySearch(0, intArray.length-1, key);
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(-100000));
    }


}
