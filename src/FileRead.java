import java.io.File;
import java.util.Scanner;

public class FileRead {

    public String filename;
    private Scanner scanner;

    FileRead(String filename) {

        readFile(filename);

    }

    private void readFile(String filename) {

        try {

            scanner = new Scanner(new File(filename));

        } catch(Exception e) {

            System.out.println("Error, could not open file: " + filename);
            e.printStackTrace();

        }

    }

    public int[] getIntegers(int n) {

        int[] ints = new int[n];

        int i = 0;
        while(scanner.hasNextInt() && i < n) {
            ints[i++] = scanner.nextInt();
        }

        return ints;
    }

    public double[] getDoubles(int n) {

        double[] doubles = new double[n];

        int i = 0;
        while(scanner.hasNextDouble() && i < n) {
            doubles[i++] = scanner.nextDouble();
        }

        return doubles;
    }

    public void closeFile() {
        scanner.close();
    }

}
