package string;

public class AppendString {
	public static void main(String[] args) {
        String input = "java language";
        String output = replaceChars(input);
        System.out.println(output);
    }

    public static String replaceChars(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'A' || c == 'v' || c == 'V') {
                output.append('@');
            } else {
                output.append(c);
            }
        }
        return output.toString();
    }
}