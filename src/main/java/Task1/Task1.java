package Task1;
class Task1{
public static void main (String[] args){
        System.out.println(exercise1.remainder(1,3));
    System.out.println(exercise2.triArea(7,4));
    System.out.println(exercise3.animals(2,3,5));
    System.out.println(exercise4.profitableGamble(0.9,1,2));
    System.out.println(exercise5.operation(24,15,9));
    System.out.println(exercise6.ctoa("A"));
    System.out.println(exercise7.addUpTo(3));
    System.out.println(exercise8.nextEdge(8,10));
    System.out.println(exercise9.sumOfCubes(1,5,9));
    System.out.println(exercise10.abcmath(5,2,1));
}
}

        class exercise1 {
    public static int
    remainder(int a, int b) {
        return (a % b);
    }
}
class exercise2{
    public static int
    triArea(int b, int h){
        return((b*h)/2);
    }
        }
class exercise3{
    public static int
    animals(int chickens,int cows, int pigs){
        return(chickens*2+cows*4+pigs*4);
    }
}
class exercise4{
    public static boolean
    profitableGamble(double prod, double prize, double pay) {
        if (prod * prize > pay) {
            return (true);}
            else{
                return (false);
            }
        }
    }
class exercise5{
    public static String operation(int N,int a,int b){
        String res="none";
        if ((a-b==N) | (b-a==N)) res = "substacted";
        if (a+b==N) res="added";
        if ((a/b==N)|(b/a==N)) res="division";
        if (a*b==N) res="multiplication";
        return res;
    }

}
class exercise6{
    public static int ctoa(String a) {
        return ((int) a.charAt(0));
    }
}
class exercise7{
    public static int addUpTo(int a){
        int s=0;
        for(int i=0; i<=a;i++) s+=i;
        return (s);
    }
}
class exercise8{
    public static int nextEdge(int a, int b){
        return(a+b-1);
    }
}
class exercise9{
    public static int sumOfCubes(int... a) {
        int s = 0;
        for (int i : a) {
            s += Math.pow(i, 3);
        }
            return (s);

    }
}
class exercise10 {
    public static boolean abcmath(int a, int b, int c) {
        for (int i = 0; i <= b; i++) {
            a += a;
        }
        if (a % c == 0) {
            return (true);}
         else {
            return (false);}

        }
    }
