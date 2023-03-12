public class VerboseDog extends Dog{
    public VerboseDog(int a,String n){
        super(a,n);
    }   

    @Override
    public void barkmany(int n){
        System.out.println("I say:");
        for(int i=1;i<=n;i++){
            bark();
        }
    }

    public void print(){
        System.out.println("printtest");
    }

    public static void main(String[] args){
        Dog d1 = new Dog(5,"a");
        Dog d2 = new Dog(7,"b");
        Dog d3 = new Dog(6,"C");
        Dog d4 = new Dog(10,"aac");
        Dog[] dogs = new Dog[]{d1,d2,d3,d4};
        Dog mx = (Dog) Maxmizer.max(dogs);

        mx.print();
    }

}
