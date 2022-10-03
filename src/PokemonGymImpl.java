import java.util.ArrayList;
import java.util.List;

public class PokemonGymImpl implements PokemonGym {

    private final String village;

    public PokemonGymImpl(String village) {
        this.village = village;
        System.out.printf("The setting is a Pokemon Gym in the village of %s.\n", village);
    }

//    @Override
//    public void printPokemon(List<Pokemon> pokemons) {
//    }
//
//    @Override
//    public Pokemon chooseGymPokemon(PokemonGymOwner gymOwner) {
//        return null;
//    }
//
//    @Override
//    public Pokemon choosePokemon(PokemonTrainer trainer) {
//        return null;
//    }
//
//    @Override
//    public int randomAttackByGymOwner() {
//        return 0;
//    }
//
//    @Override
//    public void performAttackPlayer(Pokemon pokemon, Pokemon gymPokemon, String attack) {
//
//    }
//
//    @Override
//    public void gymOwnerAttacks(Pokemon gymPokemon, Pokemon pokemon) {
//
//    }
//
//    @Override
//    public Pokemon selectPokemon(String pokemon, PokemonTrainer trainer) {
//        return null;
//    }
}
