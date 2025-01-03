package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String numbers) {
        int sum = 0;
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = ",|\\n";
        if (numbers.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.*?)\\n").matcher(numbers);
            if (matcher.find()) {
                delimiter = Pattern.quote(matcher.group(1));
                numbers = numbers.substring(matcher.end());
            }
        }

        String[] numArray = numbers.split(delimiter);
        List<Integer> negatives = new ArrayList<>();
        // Process the numbers
        for (String numStr : numArray) {
            if (!numStr.isEmpty()) {
                int num = Integer.parseInt(numStr);

                if (num < 0) {
                    negatives.add(num); // Collect negatives
                } else {
                    // Add positive numbers to the sum
                    sum += num;
                }
            }
        }

        // Throw exception if there are any negatives
        if (!negatives.isEmpty()) {
            throw new RuntimeException("Negative numbers not allowed: " + negatives);
        }
        return sum;
    }
}
