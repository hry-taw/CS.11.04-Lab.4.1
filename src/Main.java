public class Main {
    public static void main(String[] args) {
        System.out.println(parenthesesCheck("()"));
        System.out.println(parenthesesCheck(")(()))"));
        System.out.println(parenthesesCheck("("));
        System.out.println(parenthesesCheck("(())((()())())"));

        System.out.println(reverseInteger(1234));
        System.out.println(reverseInteger(2468));
        System.out.println(reverseInteger(7771));

        System.out.println(encryptThis("Hello good day"));
        System.out.println(encryptThis("Ready set go"));

        System.out.println(decipherThis("72olle 103doo 100ya"));
        System.out.println(decipherThis("82yade 115te 103o"));
    }
    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '('){
                count++;
            }
            else{
                count--;
            }
            if (count < 0){
                return false;
            }
        }
        return count == 0;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num){
        String returnString = "";
        for (int i = String.valueOf(num).length() - 1; i >= 0; i--) {
            returnString += String.valueOf(num).charAt(i);
        }
        return returnString;
    }

    // 3. encryptThis
    public static String encryptThis(String str){
        str += " ";
        StringBuilder rString = new StringBuilder();
        int fLetter = 0;
        rString.append((int)str.charAt(fLetter));
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                rString.append(i - 1 != fLetter ? str.charAt(i - 1) : "").append(i - 1 - fLetter > 1 ? str.substring(fLetter + 2, i - 1) + str.charAt(fLetter + 1) : "");
            }
            if (str.charAt(i - 1) == ' '){
                fLetter = i;
                rString.append(" ").append((int)str.charAt(fLetter));
            }
        }
        return rString.toString();
    }
    // public static String encryptThis(String str){ str += " "; String rString = ""; int fLetter = 0; int i - 1 = 0; rString += (int)str.charAt(fLetter); for (int i = 1; i < str.length(); i++) { if (str.charAt(i) == ' '){ i - 1 = i - 1; } if (str.charAt(i) == ' '){ rString += (i - 1 != fLetter ? str.charAt(i - 1) : "") + (i - 1 - fLetter > 1 ? str.substring(fLetter + 2, i - 1) + str.charAt(fLetter + 1) : ""); } if (str.charAt(i - 1) == ' '){ fLetter = i; rString += " " + (int)str.charAt(fLetter); } } return rString; }

    // 4. decipherThis
    public static String decipherThis(String str){
        str += " ";
        StringBuilder rString = new StringBuilder();
        int[] fLetter = new int[]{0, 0};
        fLetter[0] = 0;
        for (int j = 0; Character.isDigit(str.charAt(j)); j++){
            fLetter[1] = j;
        }
        rString.append((char)Integer.parseInt(str.substring(fLetter[0], fLetter[1] + 1)));
        for (int i = fLetter[1] + 1; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                rString.append(i - 1 != fLetter[1] ? str.charAt(i - 1) : "").append(i - 1 - fLetter[1] > 1 ? str.substring(fLetter[1] + 2, i - 1) + str.charAt(fLetter[1] + 1) : "");
            }
            if (str.charAt(i - 1) == ' '){
                fLetter[0] = i;
                for (int j = fLetter[0]; Character.isDigit(str.charAt(j)); j++){
                    fLetter[1] = j;
                }
                rString.append(" ").append((char)Integer.parseInt(str.substring(fLetter[0], fLetter[1] + 1)));
            }
        }
        return rString.toString();
    }

}