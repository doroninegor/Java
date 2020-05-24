package Task3;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class Task3{
    public static void main(String[] args){
        System.out.println(exercise1.solutions(1,0,0));
        System.out.println(exercise2.findZip("all zip files are compressed"));
        System.out.println(exercise3.checkPerfect(12));
        System.out.println(exercise4.flipEndChars("Cat, dog, and mouse."));
        System.out.println(exercise5.isValidHexCode("#CD5C5C"));
        System.out.println(exercise6.same(new Integer[]{1, 3, 4, 4, 4},new Integer[] {2, 5, 7}));
        System.out.println(exercise7.isKaprekar(3));
        System.out.println(exercise8.longestZero("01100001011000"));
        System.out.println(exercise9.nextPrime(12));
        System.out.println(exercise10.rightTriangle(145,105,100));
    }
}
class exercise1 {
    public static int solutions(int a, int b, int c) {
        if ((b * b - 4 * a * c) == 0) return (1);
        if ((b * b - 4 * a * c) < 0) return (0);
        if ((b * b - 4 * a * c) > 0) return (2);
        return a;
    }
}
class exercise2{
    public static int findZip(String a){
        return a.indexOf("zip",a.indexOf("zip")+1);
    }
}
class exercise3{
    public static boolean checkPerfect(int a){
         int sum=0;
         for(int i=1; i<a; i++){
             if (a%i==0){
                 sum+=i;
             }
         }
         if (a==sum){return (true);}
         else{ return (false);}
    }
}
class exercise4{
    public static String flipEndChars(String a) {
        if (a.length()<2)return ("Incompatible.");
        if (a.charAt(0)==a.charAt(a.length()-1)) return ("Two's a pair.");
        else{
            return (a.charAt(a.length() - 1) + a.substring(1, a.length() - 1) + a.charAt(0));
        }
    }
}
class exercise5{
    public static boolean isValidHexCode(String s) {
        return s.matches("(\\#)[a-fA-F0-9]{6}");
    }
}
class exercise6{
    static boolean same (Integer[] arr1,Integer[] arr2) {
        Set<Integer> set1 = new LinkedHashSet<>(Arrays.asList(arr1));
        Set<Integer> set2 = new LinkedHashSet<>(Arrays.asList(arr2));
        if (set1.size()==set2.size()) return true;
        return false;
    }
}
class exercise7{
    public static boolean isKaprekar(int a){
        int a3=a;
        a=a*a;
        int a2=a;
        int i=0;
        int cl,cr;
        while (a2!=0){
            a2=a2/10;
            i++;
        }
        if (i%2==1){
            cl = (int) (a/(Math.pow(10,i/2+1)));
            cr = (int) (a%(Math.pow(10,i/2+1)));
            System.out.println(cl + " " + cr + "  1");
        } else {
            cl = (int) (a/(Math.pow(10,i/2)));
            cr = (int) (a%(Math.pow(10,i/2)));
            System.out.println(cl + " " + cr + "  0");
        }
        return (a3==cl+cr);}
}
class exercise8{
    public static String longestZero(String s){
        int max=0;
        int maxi=0;
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i)=='0'){
                maxi++;
                if (maxi>max) max=maxi;
            } else {
                maxi=0;
            }
        }
        String res="";
        for (int i=1; i<=max; i++) res+="0";
        return res;}
}
class exercise9{
    public static int nextPrime(int a){
        int i=a;
        while (!IsPrime(i)) i++;
        return i;}
    private static boolean IsPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
class exercise10{
    public static boolean rightTriangle(int a, int b, int c){
        return triangle(a,b,c) | triangle(b,c,a) | triangle(c,a,b);
    }
    private static boolean triangle(int a,int b, int c){
        return Math.sqrt(a*a+b*b)==Math.sqrt(c*c);
    }
}