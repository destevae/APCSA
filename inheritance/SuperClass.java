package inheritance;
public class SuperClass {
    int x = 0;
    int y = 5;
    int z = 10;

    SuperClass(){
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
        System.out.println(x + y + z);
    }

    SuperClass(int x_p){
        x = x_p;
        System.out.println("x: " + x);
        System.out.println("y: " + y);
        System.out.println("z: " + z);
        System.out.println(x + y + z);
    }

    void subtract(){
        System.out.println(z-x);
    }
}
