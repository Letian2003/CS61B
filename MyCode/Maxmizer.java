public class Maxmizer {
    public static Comparable max(Comparable[] a){
        Comparable ans = a[0];
        for(Comparable e:a){
            if(e.compareTo(ans)>0)
                ans=e;
        }
        return ans;
    }
}
