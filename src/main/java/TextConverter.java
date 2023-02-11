import java.util.Scanner;
/* Hello. This little program takes some input from the user then converts it into
Spongebob meme text (ex. hello --> hELlO). There are two methods. One returns
a random number so the if statements in main can decide whether to a letter will be
uppercase or lowercase. The other one reviews the line again so there aren't three lowercase
or uppercase letters in a row because that ruins the aesthetic.
 */

public class TextConverter {

    public static void main(String [] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Type something here: ");
        String input = keyboard.nextLine();
        System.out.println("YOUR LINE: " + input); //good up to here
        String string2 = ""; //new string
        for(int i = 0; i < input.length(); i++) {
            int num = randomNum();
            if(Character.isLetter(input.charAt(i))){
                if(num % 2 == 0) {
                    string2 += Character.toUpperCase(input.charAt(i));
                }
                else {
                    string2 += Character.toLowerCase(input.charAt(i));
                }
            }
            else {
                string2 += input.charAt(i);
            }
        }

        System.out.println("New Line: " + check(string2)); //this would be the final string
    }

    //returns random number
    public static int randomNum() {
        int num = (int)Math.round(20*Math.random());
        return num + 1;
    }

    //returns reviewed input line
    public static String check(String s) {
        String s2 = ""; //string that is returned at end
        int countL = 0;
        int countU = 0;
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))){
                if(Character.isUpperCase(s.charAt(i))) {
                    countL++;
                }
                else {
                    countU++;
                }

                if(countL == 2) {
                    s2 += Character.toLowerCase(s.charAt(i));
                    countL = 0;
                }
                else if(countU == 2) {
                    s2 += Character.toUpperCase(s.charAt(i));
                    countU = 0;
                }
                else {
                    s2 += s.charAt(i);
                }
            }
            else {
                s2 += s.charAt(i);
            }
        }
        return s2;
    }

}
