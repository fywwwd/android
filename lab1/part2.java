import java.util.ArrayList;

public class Main
{
    static ArrayList<String> word_list = new ArrayList<>();
    static String test_str = "this string is used for verification. it has multi-purpose punctuation marks";
    static String temp_str = "";
    
    public static void main(String[] args) {
        mySplit(test_str);
    }
    
    public static void mySplit(String str){
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) temp_str += ch;
            else if (ch == '-') {
                if (i > 0 && i < str.length() - 1 &&
                    Character.isLetter(str.charAt(i - 1)) && 
                    Character.isLetter(str.charAt(i + 1))) {
                    temp_str += ch;
                }
            }
            if (ch == ' ' || i == str.length()-1){
                word_list.add(temp_str);
                temp_str = "";
            } 
            
        }
        for (String element : word_list) System.out.println(element);
    }
    
    }
    
    