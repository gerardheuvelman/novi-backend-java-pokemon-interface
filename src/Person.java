import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Person {

    private String name;

    private List<Pokemon> pokemons = new ArrayList<>();

    private HashMap<String, Integer> FoodSupply = new HashMap<String, Integer>();

    // Constructor //
    public Person(String name) {

        this.name = name;
        FoodSupply.put("droplets", 2);
        FoodSupply.put("volts", 2);
        FoodSupply.put("nutrients", 2);
        FoodSupply.put("sparks", 2);
    }

    // Getters and setters //


    public HashMap<String, Integer> getFoodSupply() {
        return FoodSupply;
    }

    public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
