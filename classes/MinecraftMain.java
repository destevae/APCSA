// BROKEN ASF - just click run //

public class MinecraftMain{
    public static void main(String[] args){
        MinecraftPlayer HIHI = new MinecraftPlayer("JoeBob", "steve", true); // calls the constructor of the MinecraftPlayer class 
        MinecraftPlayer alex= new MinecraftPlayer("alex", "alex", false);
        alex.get_health();
        HIHI.dmg_other(alex);
        alex.get_health();
        System.out.println(HIHI.username); // it's username, not user!!
        // HIHI.digDirt();
        // int x = HIHI.get_health() + 5;
        // System.out.println(x);

        // HIHI.set_health(-10);
        // System.out.println(HIHI.health);
    }
}

