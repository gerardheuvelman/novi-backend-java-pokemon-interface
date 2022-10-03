import java.util.*;

 interface PokemonGym {

     public default void enteredTheGym(PokemonTrainer player1) {
         PokemonGymOwner gymOwner = new PokemonGymOwner("Brock");
         List<Pokemon> names = new ArrayList<>();
         names.add(gymOwner.getBlastoise());
         names.add(gymOwner.getGyarados());
         names.add(gymOwner.getCharizard());
         names.add(gymOwner.getDitto());
         names.add(gymOwner.getRaichu());
         names.add(gymOwner.getVenusaur());
         gymOwner.setPokemons(names);
         System.out.println("You have entered the gym");
         System.out.println("In front of you stands a pokemontrainer");
         System.out.println(gymOwner.getName() + ": Hello stranger, I'm " + gymOwner.getName() + ", the owner of this gym. Who are you?");
         System.out.println("I'm " + player1.getName() + " and i'm here to challenge you for a battle");
         System.out.println("So you're after my badge too, lets fight!!!");

         Pokemon gymPokemon = chooseGymPokemon(gymOwner);
         System.out.println(gymOwner.getName() + ": I'll choose you, " + gymPokemon.getName());
         Pokemon pokemon = choosePokemon(player1);
         System.out.println(player1.getName() + ": I'll choose you, " + pokemon.getName());

         fightRound(player1, gymOwner, pokemon, gymPokemon);
     }

     public default void printPokemon(List<Pokemon> pokemons) {
        for (Pokemon p : pokemons) {
            System.out.println(p.getName() + "(" + p.getType() +")");
        }
    }

    public default Pokemon selectPokemon(String pokemon, PokemonTrainer trainer) {
        List<Pokemon> pokemons = trainer.getPokemons();
        int number = 0;
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getName().equalsIgnoreCase(pokemon)) {
                number = i;
            }
        }
        return pokemons.get(number);
    }

    public default Pokemon chooseGymPokemon(PokemonGymOwner gymOwner){
        Random rand = new Random();
        List<Pokemon> pokemons = new ArrayList<>();
        for (Pokemon p : gymOwner.getPokemons()) {
            if(p.getHp() > 0 ){
                pokemons.add(p);
            }
        }
        int amountOfPokemons = pokemons.size();
        int randomNumber = rand.nextInt(amountOfPokemons);
        return pokemons.get(randomNumber);
    }

    public default Pokemon choosePokemon(PokemonTrainer trainer){
        Scanner speler_A = new Scanner(System.in);
        List<Pokemon> pokemons = new ArrayList<>();
        for (Pokemon p : trainer.getPokemons()) {
            if(p.getHp() > 0 ){
                pokemons.add(p);
            }
        }
        System.out.println("Please make your choice of pokemon to attack");
        for (Pokemon p : pokemons) {
            System.out.println(p.getName());
        }
        String pokemon = speler_A.nextLine();
        return selectPokemon(pokemon, trainer);
    }

    public default int randomAttackByGymOwner(){
        Random rand = new Random();
        int maxAttacks = 4;
        return rand.nextInt(maxAttacks);
    }

    public default void performAttackPlayer(Pokemon pokemon, Pokemon gymPokemon, String attack){
        FirePokemon fire;
        ElectricPokemon electric;
        GrassPokemon grass;
        WaterPokemon water;

        String choosenAttack = attack.toLowerCase(Locale.ROOT);

        switch (pokemon.getType()) {
            case "fire" -> {
                fire = new FirePokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (choosenAttack) {
                    case "inferno" -> fire.inferno(pokemon, gymPokemon);
                    case "pyroball" -> fire.pyroBall(pokemon, gymPokemon);
                    case "firelash" -> fire.fireLash(pokemon, gymPokemon);
                    default -> fire.flameThrower(pokemon, gymPokemon);
                }
            }
            case "water" -> {
                water = new WaterPokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (choosenAttack) {
                    case "surf" -> water.surf(pokemon, gymPokemon);
                    case "hydropump" -> water.hydroPump(pokemon, gymPokemon);
                    case "hydrocanon" -> water.hydroCanon(pokemon, gymPokemon);
                    default -> water.rainDance(pokemon, gymPokemon);
                }
            }
            case "grass" -> {
                grass = new GrassPokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (choosenAttack) {
                    case "leafstorm" -> grass.leafStorm(pokemon, gymPokemon);
                    case "solarbeam" -> grass.solarBeam(pokemon, gymPokemon);
                    case "leechseed" -> grass.leechSeed(pokemon, gymPokemon);
                    default -> grass.leafBlade(pokemon, gymPokemon);
                }
            }
            default -> {
                electric = new ElectricPokemon(pokemon.getName(), pokemon.getLevel(), pokemon.getHp(), pokemon.getFood(), pokemon.getSound());
                switch (choosenAttack) {
                    case "thunderpunch" -> electric.thunderPunch(pokemon, gymPokemon);
                    case "electroball" -> electric.electroBall(pokemon, gymPokemon);
                    case "thunder" -> electric.thunder(pokemon, gymPokemon);
                    default -> electric.voltTackle(pokemon, gymPokemon);
                }
            }
        }
    }

    public default void gymOwnerAttacks(Pokemon gymPokemon, Pokemon pokemon){
        FirePokemon fire;
        ElectricPokemon electric;
        GrassPokemon grass;
        WaterPokemon water;

        switch (gymPokemon.getType()) {
            case "fire" -> {
                fire = new FirePokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                String attack = fire.getAttacks().get(randomAttackByGymOwner());
                switch (attack) {
                    case "inferno" -> fire.inferno(gymPokemon, pokemon);
                    case "pyroBall" -> fire.pyroBall(gymPokemon, pokemon);
                    case "fireLash" -> fire.fireLash(gymPokemon, pokemon);
                    default -> fire.flameThrower(gymPokemon, pokemon);
                }
            }
            case "water" -> {
                water = new WaterPokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                String attack = water.getAttacks().get(randomAttackByGymOwner());
                switch (attack) {
                    case "surf" -> water.surf(gymPokemon, pokemon);
                    case "hydroPump" -> water.hydroPump(gymPokemon, pokemon);
                    case "hydroCanon" -> water.hydroCanon(gymPokemon, pokemon);
                    default -> water.rainDance(gymPokemon, pokemon);
                }
            }
            case "grass" -> {
                grass = new GrassPokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                String attack = grass.getAttacks().get(randomAttackByGymOwner());
                switch (attack) {
                    case "leafStorm" -> grass.leafStorm(gymPokemon, pokemon);
                    case "solarBeam" -> grass.solarBeam(gymPokemon, pokemon);
                    case "leechSeed" -> grass.leechSeed(gymPokemon, pokemon);
                    default -> grass.leafBlade(gymPokemon, pokemon);
                }
            }
            default -> {
                electric = new ElectricPokemon(gymPokemon.getName(), gymPokemon.getLevel(), gymPokemon.getHp(), gymPokemon.getFood(), gymPokemon.getSound());
                String attack = electric.getAttacks().get(randomAttackByGymOwner());
                switch (attack) {
                    case "thunderPunch" -> electric.thunderPunch(gymPokemon, pokemon);
                    case "electroBall" -> electric.electroBall(gymPokemon, pokemon);
                    case "thunder" -> electric.thunder(gymPokemon, pokemon);
                    default -> electric.voltTackle(gymPokemon, pokemon);
                }
            }
        }
    }

    public default String chooseAttackPlayer(Pokemon p){
        Scanner speler_A = new Scanner(System.in);
        String type = p.getType();
        switch (type) {
            case "fire" -> {
                FirePokemon fp = (FirePokemon) p;
                System.out.println("Choose your attack");
                System.out.println(fp.getAttacks());
                return speler_A.nextLine();
            }
            case "water" -> {
                WaterPokemon wp = (WaterPokemon) p;
                System.out.println("Choose your attack");
                System.out.println(wp.getAttacks());
                return speler_A.nextLine();
            }
            case "electric" -> {
                ElectricPokemon ep = (ElectricPokemon) p;
                System.out.println("Choose your attack");
                System.out.println(ep.getAttacks());
                return speler_A.nextLine();
            }
            default -> {
                GrassPokemon gp = (GrassPokemon) p;
                System.out.println("Choose your attack");
                System.out.println(gp.getAttacks());
                return speler_A.nextLine();
            }
        }
    }

    public default void attackOrChange(Pokemon pokemon, Pokemon gymPokemon, PokemonTrainer trainer, PokemonGymOwner gym){
        Scanner speler_A = new Scanner(System.in);

        System.out.println("Do you want to attack or change your pokemon?");
        System.out.println("Type a for attack, f for feed, or c for change");
        String choice = speler_A.nextLine();

        if (choice.equalsIgnoreCase("a")) {
            String attack = chooseAttackPlayer(pokemon);
            performAttackPlayer(pokemon, gymPokemon, attack);
        } else  if (choice.equalsIgnoreCase("c")){
            pokemon = choosePokemon(trainer);
            attackOrChange(pokemon, gymPokemon, trainer, gym);
            fightRound(trainer, gym, pokemon, gymPokemon);
        } else if (choice.equalsIgnoreCase("f")) {
            feedPokemon(trainer, pokemon);
        }
    }


     public default void fightRound(PokemonTrainer trainer, PokemonGymOwner owner, Pokemon pokemon, Pokemon gymPokemon) {
         Scanner speler_A = new Scanner(System.in);
         while (pokemon.getHp() > 0 && gymPokemon.getHp() > 0) {

             System.out.println("It's " + owner.getName() + "'s turn to attack");
             gymOwnerAttacks(gymPokemon, pokemon);
             System.out.println("It's " + trainer.getName() + "'s turn to attack");
             attackOrChange(pokemon, gymPokemon, trainer, owner);

         }
         if(pokemon.getHp() <= 0){
             System.out.println(gymPokemon.getName() + " has defeated " + pokemon.getName());
         } else if (gymPokemon.getHp() <= 0){
             System.out.println(pokemon.getName() + " has defeated " + gymPokemon.getName());
         }

         System.out.println("Would you like to keep playing? yes or no");
         String keepPlaying = speler_A.nextLine();
         if (keepPlaying.equals("yes")){
             enteredTheGym(trainer);
         } else {
             System.out.println("Thank you for playing");
         }
     }

     public default void feedPokemon(PokemonTrainer t, Pokemon p) {
         Scanner feedScanner = new Scanner(System.in);
         System.out.println("Choose the type of food to give to :" + p.name);
         HashMap<String, Integer> foodSupply = t.getFoodSupply();
         for (String foodType : foodSupply.keySet()) {
             System.out.println("Press " + foodType.substring(0, 1) + " for " + foodType + ": (" + foodSupply.get(foodType) + " in stock)");
         }

         String chosenFood = "unknown";
         String foodChoice = feedScanner.nextLine();

         if (foodChoice.equalsIgnoreCase("d")) {
             chosenFood = "droplets";
         } else if (foodChoice.equalsIgnoreCase("v")) {
             chosenFood = "volts";
         } else if (foodChoice.equalsIgnoreCase("n")) {
             chosenFood = "nutrients";
         } else if (foodChoice.equalsIgnoreCase("s")) {
             chosenFood = "sparks";
         }

         int supply = t.getFoodSupply().get(chosenFood);
         if (supply > 0) {
             supply--;
             t.getFoodSupply().put(chosenFood, supply);
             switch (chosenFood) {
                 case "droplets":
                     if (p instanceof WaterPokemon) {
                         p.hp += 5;
                     }
                     break;
                 case "volts":
                     if (p instanceof ElectricPokemon) {
                         p.hp += 5;
                     }
                     break;
                 case "nutrients":
                     if (p instanceof GrassPokemon) {
                         p.hp += 5;
                     }
                     break;
                 case "sparks":
                     if (p instanceof FirePokemon) {
                         p.hp += 5;
                     }
                     break;
                 default:
                     break;
             }
         }

         System.out.println(p.name + " was given a portion of " + chosenFood + " (hp now " + p.hp + ")");

     }
 }
