package average;

public class Average {
    /**
     * Returns the average of an array of numbers
     * 
     * @param the array of integer numbers
     * @return the average of the numbers
     */
    public float computeAverage(int[] nums) {
        float result = 0;
        /**
         * USE THIS WAY TO ITERATE ARRAY
         */
        for (int elem : nums) {
            result += elem;
        }
        result /= nums.length;
        return result;
    }

    public static void main(String[] args) {
        int[] myArray = {0, 1, 2, 3, 4, 5};
        Average avg = new Average();
        float result = avg.computeAverage(myArray);
        System.out.println(result);

    }
}
