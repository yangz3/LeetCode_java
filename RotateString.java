package javacp;

public class RotateString {
    
    public static void main(String[] args) {
        String s = "abcdefg";
        int offset = 3;
        
        System.out.println(rotateString(s,offset));
    }
    
    public static String rotateString(String s, int offset){
        String ret = "";
        ret = s.substring(s.length() - offset) + s.substring(0,s.length() - offset);
        return ret;
    }
    
}
