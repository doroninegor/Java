package Task6;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.*;
import java.util.regex.*;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(exe1.bell(3));
        System.out.println(exe2.translateWord("flag"));
        System.out.println(exe3.validColor("rgb(0,,0)"));
        System.out.println(exe4.stripUrlParams("https://edabit.com?a=1&b=2&a=2","b"));
        System.out.println(exe5.getHashTags("How the Avocado Became the Fruit of the Global Trade"));
        System.out.println(exe6.ulam(9));
        System.out.println(exe7.longestNonrepeatingSubstring("abcababb"));
        System.out.println(exe8.convertToRoman(12));
        System.out.println(exe9.formula("6 * 4 = 24"));
        System.out.println(exe10.palindromeDescendant(11211230));


    }
}
class exe1{
    public static int bell(int n) {
        int[][] mas = new int[n + 1][n + 1];
        mas[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            mas[i][0] = mas[i - 1][i - 1];
            for (int j = 1; j <= i; j++) {
                mas[i][j] = mas[i - 1][j - 1] + mas[i][j - 1];
            }
        }

        return mas[n][0];
    }}
    class exe2{
public static String translateWord(String word) {
        String[] words = word.split(" ");
        String result = "";
        String vowels = "EeAaUuIiOoYy";
        String charactes = "!@#$%%^&*()<>,./?;:'\"[{}]_-+=";
        String stringStart = "";
        WORDS:
        for (String sl: words) {
        for (char c: vowels.toCharArray()) {
        if (sl.charAt(0) == c) {
        sl += "yay";
        result += sl + " ";
        continue WORDS;
        }
        }
        stringStart = "";
        CHARS:
        for (char c: sl.toCharArray()) {
        for (char ch: vowels.toCharArray()) {
        if (c == ch) break CHARS;
        }
        stringStart += String.valueOf(c);
        }
        result += sl.replace(stringStart, "") + stringStart + "ay" + " ";
        for (char c: sl.toCharArray()) {
        for (char ch: charactes.toCharArray()) {
        if (c == ch) result = result.trim().replace(String.valueOf(c), "") + c + " ";
        }
        }
        }
        return result.trim();
        }
        }
        class exe3{
            public static boolean validColor(String col) {
                String rgb = "rgb\\(([0-9]|[1-9][0-9]|[1-2][0-9][0-9])\\,([0-9]|[1-9][0-9]|[1-2][0-9][0-9])\\,([0-9]|[1-9][0-9]|[1-2][0-9][0-9])\\)";
                String rgba = "rgba\\(([0-9]|[1-9][0-9]|[1-2][0-9][0-9])\\,([0-9]|[1-9][0-9]|[1-2][0-9][0-9])\\,([0-9]|[1-9][0-9]|[1-2][0-9][0-9])\\,[0-1]\\)";

                if (Pattern.matches(rgb, col)) return true;
                if (Pattern.matches(rgba, col)) return true;
                return false;
            }
        }
class exe4{
    public static String stripUrlParams(String link, String... args) {
        String result = "";
        Map<String, String> par = new HashMap<String, String>();
        if (link.split("\\?").length == 1)
            return link;
        String[] urlparams = link.split("\\?")[1].split("\\&");
        PARAMS:
        for (String param: urlparams) {
            String key = param.split("\\=")[0];
            String value = param.split("\\=")[1];
            for (String arg: args) {
                if (arg.equals(key))
                    continue PARAMS;
            }
            par.put(key, value);
        }
        for (Map.Entry<String, String> entry: par.entrySet()) {
            result += entry.getKey() + "=" + entry.getValue() + " ";
        }
        return link.split("\\?")[0] + "?" + result.trim().replace(" ", "&");
    }
}
class exe5{
    public static Pattern textPattern = Pattern.compile("[a-zA-Z]+");
    public static List<String> getHashTags(String tag) {
        List<String> result = new ArrayList<String>();
        Matcher matcher;
        String maximumWord = "";
        int indexMax = -1;
        int i = 0;
        List<String> hashtags = new ArrayList<String>();
        matcher = textPattern.matcher(tag);
        while (matcher.find()) {
            hashtags.add(matcher.group().toLowerCase());
        }
        System.out.println(hashtags);
        while (i < 3 && hashtags.size() != 0) {
            maximumWord = "";
            for (int j = 0; j < hashtags.size(); j++) {
                if (hashtags.get(j).length() > maximumWord.length()) {
                    maximumWord = hashtags.get(j);
                    indexMax = j;
                }
            }
            hashtags.remove(indexMax);
            result.add("#" + maximumWord);
            i++;
        }
        return result;
    }
}
class exe6{
    public static Integer ulam(Integer ch) {
        List<Integer> ulam2 = new ArrayList<Integer>();
        ulam2.add(1);
        ulam2.add(2);
        int next = ulam2.get(ulam2.size() - 1) + 1;
        int count;
        while (ulam2.size() != ch) {
            count = 0;
            for (int i = 0; i < ulam2.size() - 1; i++) {
                for (int j = i + 1; j < ulam2.size(); j++) {
                    if (ulam2.get(i) + ulam2.get(j) == next)
                        count++;
                    if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) ulam2.add(next);
            next++;
        }
        return ulam2.get(ch - 1);
    }
}
class exe7{
    public static String longestNonrepeatingSubstring(String w) {
        ArrayList<String> uniques = new ArrayList<String>();
        String curStr = "";
        String curChar;
        int indexMax = 0;
        for (char c: w.toCharArray()) {
            curChar = String.valueOf(c);
            if (curStr.indexOf(curChar) != -1) {
                uniques.add(curStr);
                curStr = curChar;
                continue;
            }
            curStr += curChar;
        }
        if (curStr.length() != 0) {
            uniques.add(curStr);
        }
        for (int i = 0; i < uniques.size(); i++) {
            if (uniques.get(indexMax).length() < uniques.get(i).length()) {
                indexMax = i;
            }
        }
        return uniques.get(indexMax);
    }
}
class exe8{
    private static String one(int a){
        if(a == 1) return "I";
        else if(a==2) return "II";
        else if(a==3) return "III";
        else if(a==4) return "IV";
        else if(a==5) return "V";
        else if(a==6) return "VI";
        else if(a==7) return "VII";
        else if(a==8) return "VIII";
        else if(a==9) return "IX";
        else if(a==0) return "";
        return "Error";
    }
    private static String des(int a){
        if(a == 1) return "X";
        else if(a==2) return "XX";
        else if(a==3) return "XXX";
        else if(a==4) return "XL";
        else if(a==5) return "L";
        else if(a==6) return "LX";
        else if(a==7) return "LXX";
        else if(a==8) return "LXXX";
        else if(a==9) return "XC";
        else if(a==0) return "";
        return "Error";
    }
    private static String sto(int a){
        if(a == 1) return "C";
        else if(a==2) return "CC";
        else if(a==3) return "CCC";
        else if(a==4) return "CD";
        else if(a==5) return "D";
        else if(a==6) return "DC";
        else if(a==7) return "DCC";
        else if(a==8) return "DCCC";
        else if(a==9) return "CM";
        else if(a==0) return "";
        return "Error";
    }
    private static String tis(int a){
        if(a == 1) return "M";
        else if(a==2) return "MM";
        else if(a==3) return "MMM";
        return "Error";
    }
    static String convertToRoman(int a){
        String rez = "";
        if(a<0 || a>3999) return "Error";
        String b = Integer.toString(a);
        if(b.length() == 1) rez = one(Character.getNumericValue(b.charAt(0)));
        else if(b.length() == 2){
            rez += des(Character.getNumericValue(b.charAt(0)));
            rez += one(Character.getNumericValue(b.charAt(1)));
        }
        else if(b.length() == 3){
            rez += sto(Character.getNumericValue(b.charAt(0)));
            rez += des(Character.getNumericValue(b.charAt(1)));
            rez += one(Character.getNumericValue(b.charAt(2)));
        }
        else if(b.length() == 4){
            rez += tis(Character.getNumericValue(b.charAt(0)));
            rez += sto(Character.getNumericValue(b.charAt(1)));
            rez += des(Character.getNumericValue(b.charAt(2)));
            rez += one(Character.getNumericValue(b.charAt(3)));
        }
        return rez;
    }
}
class exe9{
    static boolean formula(String str){
        int size = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' ') size++;
        }
        String a[] = new String[size+1];
        Arrays.fill(a,"");
        size = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == ' ') size++;
            else a[size] += str.charAt(i);
        }
        if(size > 4 || !(a[3].equals("=")))
            return false;
        try {
            int a1 = Integer.parseInt(a[0]);
            int a2 = Integer.parseInt(a[2]);
            int a3 = Integer.parseInt(a[4]);
            if (a[1].equals("+")) {
                return (a1 + a2) == a3;
            } else if (a[1].equals("-")) {
                return (a1 - a2) == a3;
            } else if (a[1].equals("*")) {
                return (a1 * a2) == a3;
            } else if (a[1].equals("/")) {
                return (a1 / a2) == a3;
            }
            else return false;
        } catch (Throwable e){
            return false;
        }
    }
}
class exe10{
    public static boolean palindromeDescendant(int number) {
        String a = Integer.toString(number);
        String b = "";
        for(int i = 0; i < a.length(); i++) {
            b = a.charAt(i) + b;
        }
        for(int i = 0; a.length() >= 2; i++){
            if(a.equals(b))
                return true;
            a = "";
            for(int y = b.length() - 1; y > 0; y = y - 2){
                a += Character.getNumericValue(b.charAt(y)) + Character.getNumericValue(b.charAt(y - 1));
            }
            b = "";
            for(int x = 0; x < a.length(); x++) {
                b = a.charAt(x) + b;
            }
        }
        return false;
    }
}