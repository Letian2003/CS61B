package HigherOrderFunction;

public class Demo {
    public static int ApplyTwice(Function f,int x){
        return f.tenx(f.tenx(x));
    }

    public static void main(String[] args){
        int x=10;
        int ans = ApplyTwice(new TenX(),x);
        System.out.println("ans = "+ans);
    }
}
