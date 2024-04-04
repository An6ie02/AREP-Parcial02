package edu.escuelaing.arep;

import static spark.Spark.*;

/*
 * Class that contains the math services: linealSearch and BinarySearch
 */
public class MathServices {

    public static void main(String[] args) {
        port(getPort());
        get("linealSearch", (req, res) -> {
            String[] numbers = req.queryParams("numbers").split(",");
            int[] numbersInt = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                numbersInt[i] = Integer.parseInt(numbers[i]);
            }
            int numberSearch = Integer.parseInt(req.queryParams("number"));
            int valueSolution = linealSearch(numbersInt, numberSearch);
            return makeJson("linealSearch", valueSolution, numbersInt, numberSearch);
        });

        get("binarySearch", (req, res) -> {
            String[] numbers = req.queryParams("numbers").split(",");
            int[] numbersInt = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                numbersInt[i] = Integer.parseInt(numbers[i]);
            }
            int numberSearch = Integer.parseInt(req.queryParams("number"));
            int valueSolution = binarySearch(numbersInt, numberSearch, 0, numbersInt.length - 1);
            return makeJson("binarySearch", valueSolution, numbersInt, numberSearch);
        });
    }

    /*
     * Method that search a number in a list of numbers using binary search
     * 
     * @param numbers list of numbers
     * 
     * @param number number to search
     * 
     * @return the position of number in the list of numbers or -1 if the number is
     * not in the list
     */
    public static int linealSearch(int[] numbers, int number) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == number) {
                return i;
            }
        }
        return -1;
    }

    /*
     * Method that search recursy a number in a list of numbers using binary search
     * 
     * @param numbers list of numbers
     * 
     * @param number number to search
     * 
     * @return the position of number in the list of numbers or -1 if the number is
     * not in the list
     */
    public static int binarySearch(int[] numbers, int numberSearch, int initial, int end) {
        int middle = initial + (end - initial) / 2;
        if (numbers[middle] == numberSearch) {
            return middle;
        } else if (numbers[middle] > numberSearch) {
            return binarySearch(numbers, numberSearch, initial, middle - 1);
        } else if (numbers[middle] < numberSearch) {
            return binarySearch(numbers, numberSearch, middle + 1, end);
        }
        return -1;
    }

    /*
     * Method that make json answer
     * 
     * @param number int that is the position of the number in the list
     * 
     * @retturn a json with name operation, listnumbers, valueSearch and output
     */
    public static String makeJson(String operation, int numberSolution, int[] numbers, int numberSearch) {
        String json = "{\n";
        json += "\"operation\": \"" + operation + "\",\n";
        json += "\"inputlist\": [";
        for (int i = 0; i < numbers.length; i++) {
            json += numbers[i];
            if (i != numbers.length - 1) {
                json += ",";
            }
        }
        json += "],\n";
        json += "\"valueSearch\": " + numberSearch + ",\n";
        json += "\"output\": " + numberSolution + "\n";
        json += "}";
        return json;
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }

}
