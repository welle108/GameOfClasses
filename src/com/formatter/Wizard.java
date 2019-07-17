package com.formatter;

    /*
       In this class (And in the Knight class) I have to implement the SpecialMoves interface because
       it is implemented by the Character base class, even though I didn't explicitly tell Java to
       implement it in this class.
    */

public class Wizard extends Character {

    /**
     * Calls the super constructor for Character.java with name String
     * argument.
     *
     * @param name Name of character
     */
    public Wizard(String name){
        super(name);
    }

    @Override
    public void regularAttack(Character c) {
        c.receiveDamage(17);
        Animations.wizardRegAttack(this.getCharacterName(),c);
    }



    @Override
    public void primarySpecial(Character c) {
        Animations.wizardSpecial1(this.getCharacterName(),c);
        c.receiveDamage(45);
    }

    @Override
    public void secondarySpecial(Character c) {
        this.heal(15);
        Animations.wizardSpecial2(this.getCharacterName());
    }
}
