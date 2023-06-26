public class Application2 {
    public static void main(String[] args) {
        if (args.length == 0 || args[0].isEmpty()) {
            System.out.println("");
        } else {
            String input = args[0];
            String decoded = decodeRLE(input);
            System.out.println(decoded);
        }
    }

    private static String decodeRLE(String input) {
        StringBuilder decoded = new StringBuilder();
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            if (Character.isLetter(currentChar)) {
                if (count == 0) {
                    decoded.append(currentChar);
                    count = 1;
                } else {
                    return "";
                }
            } else if (Character.isDigit(currentChar)) {
                int repeat = Character.getNumericValue(currentChar);

                if (repeat >= 2 && repeat <= 9) {
                    if (count == 0) {
                        return "";
                    }

                    for (int j = 0; j < repeat - 1; j++) {
                        decoded.append(decoded.charAt(decoded.length() - 1));
                    }

                    count = 0;
                } else {
                    return "";
                }
            } else {
                return "";
            }
        }

        return decoded.toString();
    }
}
