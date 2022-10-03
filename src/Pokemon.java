import java.util.Arrays;
import java.util.List;

 public abstract class Pokemon {
    protected String type;
    protected String name;
    protected int level = 1;
    protected int hp = 10;
    protected String sound;

    // Constructor //
    public Pokemon (String type) {
        this.type = type;
    }

     public Pokemon(String name, int level, int hp, String food, String sound) {
         this.name = name;
         this.level = level;
         this.hp = hp;
         this.sound = sound;
     }

     // Getters and Setters //


     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public String getSound() {
         return sound;
     }

     public void setSound(String sound) {
         this.sound = sound;
     }

     public int getLevel() {
         return level;
     }

     public void setLevel(int level) {
         this.level = level;
     }

     public int getHp() {
         return hp;
     }

     public void setHp(int hp) {
         this.hp = hp;
     }

     public abstract String getFood();

    protected void attack(Pokemon attacker, Pokemon enemy, String attackType) {

        int damage = 0 ;

        if (attacker instanceof WaterPokemon) {

            if (enemy instanceof WaterPokemon) {damage=1;}
            else if (enemy instanceof FirePokemon) {damage=4;}
            else if (enemy instanceof GrassPokemon) {damage=2;}
            else if (enemy instanceof ElectricPokemon) {damage=3;}

        } else if (attacker instanceof FirePokemon) {

            if (enemy instanceof WaterPokemon) {damage=3;}
            else if (enemy instanceof FirePokemon) {damage=1;}
            else if (enemy instanceof GrassPokemon) {damage=4;}
            else if (enemy instanceof ElectricPokemon) {damage=2;}

        } else if (attacker instanceof GrassPokemon) {

            if (enemy instanceof WaterPokemon) {damage=2;}
            else if (enemy instanceof FirePokemon) {damage=3;}
            else if (enemy instanceof GrassPokemon) {damage=1;}
            else if (enemy instanceof ElectricPokemon) {damage=4;}

        } else if (attacker instanceof ElectricPokemon) {

            if (enemy instanceof WaterPokemon) {damage=4;}
            else if (enemy instanceof FirePokemon) {damage=2;}
            else if (enemy instanceof GrassPokemon) {damage=3;}
            else if (enemy instanceof ElectricPokemon) {damage = 1;}

        }

        int hpBoost = 0;
        if (attackType == "raindance") {
            if (enemy instanceof ElectricPokemon) {
            damage = 0;
            } else if (enemy instanceof GrassPokemon) {
                damage = 0;
                hpBoost = 2;
            }
        }
        if (attackType == "thunder" && enemy instanceof ElectricPokemon) {
            damage = 0;
            hpBoost = 2;
        }

        int absorb = 0;
        if (attackType == "leechseed") {
            absorb = damage;
        }
        enemy.hp -= damage;
        enemy.hp += hpBoost;
        attacker.hp += absorb;

        System.out.println(attacker.name + " attacks " + enemy.name + " with " + attackType);

        if (damage > 0 ) {
            System.out.println(enemy.name + " loses " + damage + " hp (now " + enemy.hp +")" );
        } else {
            System.out.println("It has no effect on" + enemy.name);
        }
        if (hpBoost > 0 ) {
            System.out.println(enemy.name + " gets a hp boost of " + hpBoost);
        }
        if (absorb > 0) {
            System.out.println(attacker.name + " absorbs " + absorb + " (now " + attacker.hp + ")");
        }
    }
 }
