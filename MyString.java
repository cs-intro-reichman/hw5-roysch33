/**
 * A library of string functions.
 */
public class MyString {
    public static void main(String args[]) {
        System.out.println(MyString.countChar("space", 's'));
        System.out.println(MyString.countChar("football", 'o'));
        System.out.println(MyString.countChar("taking a bath", 'a'));
        System.out.println(MyString.subsetOf("sap","space"));
        System.out.println(MyString.subsetOf("spa","space"));
        System.out.println(MyString.subsetOf("pass","space"));
        System.out.println(MyString.subsetOf("c","space"));
        System.out.println("..." + MyString.spacedString("foobar") + "...");
        System.out.println("..." + MyString.spacedString("foodie") + "...");
        System.out.println("..." + MyString.spacedString("looking") + "...");
        System.out.println(MyString.randomStringOfLetters(3));
        System.out.println(MyString.randomStringOfLetters(7));
        System.out.println(MyString.randomStringOfLetters(10));
        System.out.println(MyString.randomStringOfLetters(27));
        System.out.println(MyString.remove("committee", "meet")); //comit
        System.out.println(MyString.remove("computer", "more")); //cput


        // Put more tests of your own here.
    }

    /**
     * Returns the number of times the given character appears in the given string.
     * 
     * @param str - a string
     * @param c - a character
     * @return the number of times c appears in str
     */
    public static int countChar(String str, char c) {
        int counting = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c){
                counting ++;
                }
            }
        return counting;
    }

    /** Returns true if str1 is a subset string str2, false otherwise.
     *  For example, "spa" is a subset of "space", and "pass" is not
     *  a subset of "space".
     *
     * @param str1 - a string
     * @param str2 - a string
     * @return true is str1 is a subset of str2, false otherwise
     */
    public static boolean subsetOf(String str1, String str2) {
        String str1Substring = str1; 
        String str2String = str1;
        for (int i = 0; i < str2.length(); i++){
            for (int j = 0; j < str2String.length(); j++){
                if (str2String.charAt(j) == ' ' ){
                    break;
                }
                if (str2.charAt(i) == str2String.charAt(j)){
                    // deleting the first letter in the string and breaking the for loop:
                    str1Substring = str1Substring.substring(1);
                    break;
                }
            
            }
        }
        return (str1Substring.isEmpty());  
    }

    /** Returns a string which is the same as the given string, with a space
     * character inserted after each character in the given string, except
     * for last character of the string, that has no space after it. 
     * Example: if str is "silent", returns "s i l e n t".
     * 
     * @param str - a string
     * @return a string consisting of the characters of str, separated by spaces.
     */
    public static String spacedString(String str) {
        String newString = "";
        if (str.length() == 1 || str.length() == 0){
            return str;
        }

        for (int i = 0; i < str.length()-1; i++){
            String spacedAndString = str.charAt(i) + " ";
            newString += spacedAndString;
        }
        newString += str.charAt(str.length()-1);


        return newString;
    }
  
    /**
     * Returns a string of n lowercase letters, selected randomly from 
     * the English alphabet 'a', 'b', 'c', ..., 'z'. Note that the same
     * letter can be selected more than once.
     * 
     * @param n - the number of letter to select
     * @return a randomly generated string, consisting of 'n' lowercase letters
     */
    public static String randomStringOfLetters(int n) {
        String randomString = "";
        for (int i = 0; i < n; i++){
            double randomLetter = Math.floor(Math.random() * 26);
            randomString += (char)(randomLetter + 97);
        }
        return randomString;
    }

    /**
     * Returns a string consisting of the string str1, minus all the characters in the
     * string str2. Assumes (without checking) that str2 is a subset of str1.
     * Example: "committee" minus "meet" returns "comit". 
     * 
     * @param str1 - a string
     * @param str2 - a string
     * @return a string consisting of str1 minus all the characters of str2
     */
    public static String remove(String str1, String str2) {
        String str1Substring = str1;
        
        for (int i = 0; i < str2.length(); i++){
            for (int j = 0; j < str1Substring.length(); j++) {
                if (str2.charAt(i) == str1Substring.charAt(j)){
                    // deleting the (j) letter in the string and breaking the for loop:
                    str1Substring = str1Substring.substring(0,j)+str1Substring.substring(j+1);
                    break;
                }
            }
        }
        return str1Substring;
    }
}
