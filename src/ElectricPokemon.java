import java.util.Arrays;
import java.util.List;

public class ElectricPokemon  extends Pokemon {

    private String food = "volts";
    private List<String> attacks = Arrays.asList("thunderpunch","electroball","thunder","volttackle");

    public ElectricPokemon(String name) {
        super("electric");
        this.name = name;
    }

    public ElectricPokemon(String name, int level, int hp, String food, String sound) {
        super("electric");
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

    void thunderPunch(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "thunderpunch");
    }
    void electroBall(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "electroball");
    }
    void thunder(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "thunder");
    }
    void voltTackle(Pokemon name, Pokemon enemy) {
        attack (name, enemy, "volttackle");
    }
}
