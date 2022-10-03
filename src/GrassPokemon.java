import java.util.Arrays;
import java.util.List;

public class GrassPokemon extends Pokemon {

    private String food = "nutrients";

    private List<String> attacks = Arrays.asList("leafstorm","leechseed","leafblade","solarbeam");

    public GrassPokemon(String name) {
        super("grass");
        this.name = name;
    }

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super("grass");
        this.name = name;
        this.level = level;
        this.hp = hp;
        this.food = food;
        this.sound = sound;
    }

    public String getFood() {
        return food;
    }

    public List<String> getAttacks() {
        return attacks;
    }

    public void leafStorm(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "leafstorm");
    }
    public void leechSeed(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "leechseed");
    }
    public void leafBlade(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "leafblade");
    }
    public void solarBeam(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "solarbeam");
    }





}
