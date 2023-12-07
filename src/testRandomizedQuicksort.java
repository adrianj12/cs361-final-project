public class testRandomizedQuicksort {

    public static void main(String[] args) {

        // for tracking timing of algorithm
        long startTime, endTime, duration;

        int[] intArray;
        double[] doubleArray;

        FileRead fileRead;

        /** sizes of data sets **/
        int[] ns = {
                1_048_576,      // 2^20
                2_097_152,      // 2^21
                4_194_304,      // 2^22
                8_388_608,      // 2^23
                16_777_216,     // 2^24
                33_554_432,     // 2^25
                67_108_864,     // 2^26
                134_217_728,    // 2^27
                268_435_456,    // 2^28
                536_870_912,    // 2^29
                1_073_741_824   // 2^30
        };

        int[] powersOfTwo = {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};

        /** Testing integers **/
        for(int i = 0; i <= 10; i++) {

            fileRead = new FileRead("C:\\Users\\ajasa\\2_" + powersOfTwo[i] + "_int.txt");
            intArray = fileRead.getIntegers(ns[i]);

            startTime = System.nanoTime();
            RandomizedQuickSort.quickSort(intArray, 0, intArray.length);
            endTime = System.nanoTime();

            duration = endTime - startTime;

            System.out.printf("n = 2^%d\nDuration: %10.2f ms or %6.2f s\n\n",
                    powersOfTwo[i],
                    ((float) duration / 1_000_000),
                    ((float) duration / 1_000_000_000));

            fileRead.closeFile();

        }

        /** Testing doubles **/

        for(int i = 0; i <= 10; i++) {

            fileRead = new FileRead("C:\\Users\\ajasa\\2_" + powersOfTwo[i] + "_double.txt");
            doubleArray = fileRead.getDoubles(ns[i]);

            startTime = System.nanoTime();
            RandomizedQuickSort.quickSort(doubleArray, 0, doubleArray.length);
            endTime = System.nanoTime();

            duration = endTime - startTime;

            System.out.printf("n = 2^%d\nDuration: %10.2f ms or %6.2f s\n\n",
                    powersOfTwo[i],
                    ((float) duration / 1_000_000),
                    ((float) duration / 1_000_000_000));

            fileRead.closeFile();

        }

    }

}
