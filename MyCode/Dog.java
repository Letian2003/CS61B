public class Dog implements Comparable<Dog>{

    int age;
    String name;

    public int compareTo(Dog a){
        return age-a.age;
    }

    public Dog(int a,String n){
        age=a;
        name = n;
    }

    public void bark(){
        System.out.println("bark ");
    }

    public void barkmany(int n){
        for(int i=1;i<=n;i++){
            bark();
        }
    }

    public static Dog minDog(Dog a,Dog b){
        if(a.age<b.age)
            return a;
        return b;
    }

    
    public void print(){
        System.out.println(age+" "+name);
    }
}
