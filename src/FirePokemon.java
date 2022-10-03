import java.util.Arrays;
import java.util.List;

public class FirePokemon extends Pokemon {

    private String food = "sparks";

    private List<String> attacks = Arrays.asList("firelash","flamethrower","pyroball","inferno");

    public FirePokemon(String name) {
        super("fire");
        this.name = name;
    }

    public FirePokemon(String name, int level, int hp, String food, String sound) {
        super("fire");
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

    void fireLash(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "firelash");
    }
    void flameThrower(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "flamethrower");
    }
    void pyroBall(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "pyroball");
    }
    void inferno(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "inferno");
    }
}
