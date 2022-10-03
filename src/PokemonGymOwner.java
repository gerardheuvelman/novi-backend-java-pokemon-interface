import java.util.Arrays;
import java.util.List;

 public class PokemonGymOwner extends Person {

     private FirePokemon charizard = new FirePokemon("Charizard");/*🔥*/
     private WaterPokemon blastoise = new WaterPokemon("Blastoise");/*🌊*/
     private GrassPokemon venusaur = new GrassPokemon("Venusaur");/*🌿*/
     private GrassPokemon ditto = new GrassPokemon("Ditto");/*🌿*/
     private ElectricPokemon raichu = new ElectricPokemon("Raichu");/*⚡*/
     private WaterPokemon gyarados = new WaterPokemon("Gyarados");/*🌊*/

     // Constructor //
     public PokemonGymOwner(String name) {
         super(name);
     }

     // Getters and Setters //

     public Pokemon getCharizard() {
         return charizard;
     }

     public Pokemon getBlastoise() {
         return blastoise;
     }

     public Pokemon getVenusaur() {
         return venusaur;
     }

     public Pokemon getDitto() {
         return ditto;
     }

     public Pokemon getRaichu() {
         return raichu;
     }

     public Pokemon getGyarados() {
         return gyarados;
     }

     public List<Pokemon> getPokemons() {
        return Arrays.asList(getCharizard(), getBlastoise(), getDitto(), getGyarados(), getRaichu(), getVenusaur());
    }
 }
