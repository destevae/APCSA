package inheritance;

public class Mob {
    String name;
    int health;

    Mob(String name_p, int health_p){
        name = name_p;
        health = health_p;
    }

    void sound(){

    }

    void printAttributes(){
        System.out.println("Name: " + name + ", health: " + health);
    }
}
