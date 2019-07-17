package com.formatter;

import java.util.Random;

public class Knight extends Character {

    /*
        This is a random number generator to determine if Knight's primary special attack is successful.
        This member variable is only visible to the Knight class and couldn't be called if
     */
    private Random criticalHitChance;

    public Knight(String name){
        super(name);
        criticalHitChance = new Random();
    }


    /**
     * The knight class overrides this method, making the character's regular attack now do 15 damage.
     *
     * @param c The character being targeted
     */
    @Override
    public void regularAttack(Character c) {
        Animations.knightRegAttack(this.getCharacterName(),c);
        c.receiveDamage(15);
    }

    /**
     * Generates a random number between 0-49 then adds one to make it between 1-50. If that number divided by 3
     * is equal to 0, the critical hit is successful and does 50 damage. If it is anything other than 0 the attack
     * misses and does no damage.
     *
     * @param c The character being targeted
     */
    @Override
    public void primarySpecial(Character c) {

        // Create a random into between 0-49, then add one for 1-50.
        // Remember: Java is 0 indexed, so counting starts from 0.

        int success = criticalHitChance.nextInt(50);
        success+=1;

        // If success/3 has no remainder the attack is successful

        if(success%3 == 0){
            c.receiveDamage(50);
            Animations.knightSpecial1(this.getCharacterName(),c,true);
        }
        else{
            Animations.knightSpecial1(this.getCharacterName(),c,false);
        }

    }

    @Override
    public void secondarySpecial(Character c) {
        c.receiveDamage(20);
        Animations.knightSpecial2(this.getCharacterName(),c);
    }
}
