import java.util.Arrays;
import java.util.List;

public class WaterPokemon extends Pokemon {

    private String food = "droplets";

    private List<String> attacks = Arrays.asList("surf","hydropump","hydrocanon","raindance");

    public WaterPokemon(String name) {
        super("water");
        this.name = name;
    }

    public WaterPokemon(String name, int level, int hp, String food, String sound) {
        super("water");
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

    void surf(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "surf");
    }
    void hydroPump(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "hydropump");
    }
    void hydroCanon(Pokemon name, Pokemon enemy) { attack (name, enemy, "hydrocanon");
    }
    void rainDance(Pokemon name, Pokemon enemy) { attack (name, enemy, "raindance");}
}
