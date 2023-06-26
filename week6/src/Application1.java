public class Application1 {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].isEmpty()) {
            System.out.println("");
        } else {
            String input = args[0];
            String encoded = encodeRLE(input);
            System.out.println(encoded);
        }
    }

    private static String encodeRLE(String input) {
        StringBuilder encoded = new StringBuilder();
        int count = 1;

        for (int i = 0; i < input.length() - 1; i++) {
            char currentChar = input.charAt(i);
            char nextChar = input.charAt(i + 1);

            if (currentChar == nextChar) {
                count++;
            } else {
                encoded.append(currentChar);
                if (count > 1 && count < 10) {
                    encoded.append(count);
                } else if (count >= 10) {
                    int remainder = count % 9;
                    int repeat = count / 9;

                    for (int j = 0; j < repeat; j++) {
                        encoded.append(currentChar);
                        encoded.append(9);
                    }

                    if (remainder > 1) {
                        encoded.append(currentChar);
                        encoded.append(remainder);
                    }
                }

                count = 1;
            }
        }

        // Append the last character in the input string
        encoded.append(input.charAt(input.length() - 1));

        if (count > 1 && count < 10) {
            encoded.append(count);
        } else if (count >= 10) {
            int remainder = count % 9;
            int repeat = count / 9;

            for (int j = 0; j < repeat; j++) {
                encoded.append(input.charAt(input.length() - 1));
                encoded.append(9);
            }

            if (remainder > 1) {
                encoded.append(input.charAt(input.length() - 1));
                encoded.append(remainder);
            }
        }

        return encoded.toString();
    }
}
