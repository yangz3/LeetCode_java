package javacp;

public class ReverseWordsList {
    
    public static void main(String[] args) {
        String s = "I love you";
        
        System.out.println(reverse(s));
        
    }
    
    public static String reverse(String s){
        String[] words = s.split(" ");
        String ret = "";
        for(int i = 0; i < words.length; i++){
            ret = words[i] + " " + ret;
        }
        
        return ret;
    }
    
}
