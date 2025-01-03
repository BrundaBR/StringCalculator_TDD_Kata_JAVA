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
        // Process the numbers
        for (String numStr : numArray) {
            if (!numStr.isEmpty()) {
                int num = Integer.parseInt(numStr);

                if (num < 0) {
                    // Ignore negative numbers and print a warning
                    System.out.println("Warning: Ignoring negative number " + num);
                } else {
                    // Add positive numbers to the sum
                    sum += num;
                }
            }
        }
        return sum;
    }
}
