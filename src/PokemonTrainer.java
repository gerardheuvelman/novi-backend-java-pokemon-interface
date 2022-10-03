import java.util.ArrayList;
import java.util.List;

public class PokemonTrainer extends Person {

    // Constructor //
    public PokemonTrainer(String name) {
        super(name);

    }

    // Getters and setters //
    public Pokemon getBlastoise() {
        return new WaterPokemon("Blastoise");
    }
    public Pokemon getGyarados() {
        return new WaterPokemon("Gyarados");
    }
    public Pokemon getCharizard() {
        return new FirePokemon("Charizard");
    }
    public Pokemon getDitto() {
        return new GrassPokemon("Ditto");
    }
    public Pokemon getRaichu() {
        return new ElectricPokemon("Raichu");
    }
    public Pokemon getVenusaur() {
        return new WaterPokemon("Gyarados");
    }
}
