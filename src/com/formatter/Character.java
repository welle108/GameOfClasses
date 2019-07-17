package com.formatter;

/**
 *  This is the base class for the character types in the game. Another way of accomplishing this
 *  same kind of hierarchy could be to make Character an abstract class like:
 *
 *  >        public abstract class Character implements SpecialMoves{
 *  >                 private int HP = 100;
 *  >                 private String characterName;
 *  >                 ...
 *  >                 public abstract void regularAttack(Character c){}
 *  >                 etc...
 *  >            }
 *
 *  and then define regularAttack() in each child class. I didn't do that here though because I want
 *  you to see how the Peasant class inherits everything from Character without having to write anything,
 *  but both are perfectly valid approaches depending on your situation.
 */
public class Character implements SpecialMoves {
    private int HP = 100;
    private String characterName;


    public Character(String name){
        this.characterName = name;
    }


    /*
        A couple methods like this one are just getters and setters
        to allow me to change the character's stats. There are
        more elegant ways to do this, but this way works for right now
     */
    public void receiveDamage(int damage){
        HP-=damage;
    }

    public void regularAttack(Character c){
        Animations.characterRegAttack(characterName,c);
        c.receiveDamage(5);
    }


    public void heal(int amount){
        HP+=amount;
    }

    public String getCharacterName(){return characterName;}

    public int getHP(){return HP;}


    @Override
    public void primarySpecial(Character c) {
        Animations.characterSpecial1(characterName,c);
        c.receiveDamage(15);
    }

    @Override
    public void secondarySpecial(Character c) {
        Animations.characterSpecial2(characterName);
        this.heal(5);
    }
}

/*
    This interface could live in any of these files, but I'm putting it here because Character is the top layer of
    abstraction in the character hierarchy, so it makes sense to put these two "baseline" definitions in the same place.
 */
interface SpecialMoves{
    void primarySpecial(Character c);
    void secondarySpecial(Character c);

}