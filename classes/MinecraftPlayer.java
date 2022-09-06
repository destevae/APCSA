public class MinecraftPlayer{
    String username;
    String skin;
    int health = 20; // all minecraft players start with the same health!!!
    boolean rightHanded;
    int totalDirt = 0; // will be used in the digDirt method

    MinecraftPlayer(){ // constructor --> method that runs when we create an object, initial setup
        username = "Minecraft Player";
        skin = "steve";
        rightHanded = false;
    }

    MinecraftPlayer(String user, String skinName, boolean rHanded){ 
        // defining all the variables
        username = user;
        skin = skinName;
        rightHanded = rHanded;
    }

    public void digDirt(){ // new method, void means not returning anything
        totalDirt++;
        System.out.println(username + " has digged " + totalDirt + " blocks.");
    }

    public int get_health(){
        System.out.println(username + " has " + health + " health.");
        return health;
    }

    int set_health(int change){ // setter method - changing variable
        health = health + change;
        return health;
    }

    void dmg_other(MinecraftPlayer plyr){
        plyr.set_health(-5);
        System.out.println(plyr.username + ": Oof!");
    }

}

