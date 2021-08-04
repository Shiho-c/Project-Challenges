package sample;

import java.util.HashMap;
import java.util.ArrayList;
public class MathFunctions {

    public double convertToDecimal(HashMap<Integer, Integer> binary) {
        int base = 2;
        double decimal = 0;
        for(Integer exponent: binary.keySet()) {
            decimal += (Math.pow(base, exponent)) * binary.get(exponent);
        }
        return decimal;
    }

    public HashMap<Integer, Integer> getExponents(String binary) {
        HashMap<Integer, Integer> exponent_binary = new HashMap<>();
        int binary_length = binary.length();
        for(char c: binary.toCharArray()) {
            binary_length--;
            exponent_binary.put(binary_length, Integer.parseInt(String.valueOf(c)));
        }
        return exponent_binary;
    }

    public ArrayList<HashMap<Integer, Integer>> getFractionalExponents(String binary) {
        String[] splitted_binary = binary.split("\\.");
        String first = splitted_binary[0];
        String second = splitted_binary[1];

        HashMap<Integer, Integer> exponents_1 = getExponents(first);
        HashMap<Integer, Integer> exponents_2 = new HashMap<>();

        int binary_length = 0;
        for(char c: second.toCharArray()) {
            binary_length--;
            exponents_2.put(binary_length, Integer.parseInt(String.valueOf(c)));
        }
        ArrayList<HashMap<Integer, Integer>> exponents = new ArrayList<>();
        exponents.add(exponents_1);
        exponents.add(exponents_2);
        return exponents;
    }
}
