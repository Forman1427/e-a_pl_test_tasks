import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskTwo {

    public static void main(String[] args) {
        List<Integer> elements = loadFile(args);
        System.out.println(countMinimumMoves(elements, intAverage(elements)));
    }

    static List<Integer> loadFile(String[] argsFromCL) {
        File inFile = null;
        if (0 < argsFromCL.length) {
            inFile = new File(argsFromCL[0]);
        }
        List<Integer> elements = new ArrayList<>();
        if (inFile != null) {
            try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    elements.add(Integer.parseInt(line));
                }
            } catch (IOException ignored) {
//                По необходимости добавить перехват различных exceptions
            }
        }
        return elements;
    }

    static int intAverage(List<Integer> intArray) {
        int sum = 0;
        for (int i : intArray) {
            sum = sum + i;
        }
        return Math.round(sum / intArray.size());
    }

    static int countMinimumMoves(List<Integer> intArray, int middleValue) {
        int numberOperations = 0;
        for (int elem : intArray) {
            while (elem != middleValue) {
                if (elem < middleValue) {
                    elem++;
                    numberOperations++;
                }
                if (elem > middleValue) {
                    elem--;
                    numberOperations++;
                }
            }
        }
        return numberOperations;
    }
}