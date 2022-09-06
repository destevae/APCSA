public class person {
    double height;
    String name;
    int age;

    person(double h, String n, int a){
        height = h;
        name = n;
        age = a;
    }

    void greet(){ // method
        System.out.println("Hello! My name is " + name + ". I am " + age + " years old.");
    }

    void tall(){
        System.out.println("I am " + height + " inches tall.");
    }
}
