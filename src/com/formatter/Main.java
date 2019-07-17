package com.formatter;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * A rudimentary game loop which handles the game logic. There are probably better ways to handle
     * this task in terms of software architecture, but since I'm not a game programmer this will be ok for now.
     *
     * @param args
     */

    public static void main(String[] args) {
        int turn = 1;
        ArrayList<Character> characters;
        Scanner scanner = new Scanner(System.in);

        characters = introPrompt();

        boolean running = true;
        while(running){
            System.out.println("Turn: "+turn);
            turn+=1;
            for(int i=0; i<2;i++){
                if(i==0){
                    System.out.println(characters.get(0).getCharacterName()+": please choose an attack");
                }else{
                    System.out.println(characters.get(1).getCharacterName()+": please choose an attack");
                }
                    System.out.println("1. Regular Attack");
                    System.out.println("2. Special Attack 1");
                    System.out.println("3. Special Attack 2");
                    int selection = scanner.nextInt();
                    scanner.nextLine();
                    switch (selection){
                        case 1:
                            if(i==0){
                                characters.get(0).regularAttack(characters.get(1));
                            }else{
                                characters.get(1).regularAttack(characters.get(0));
                            }
                            break;
                        case 2:
                            if(i==0){
                                characters.get(0).primarySpecial(characters.get(1));
                            }else{
                                characters.get(1).primarySpecial(characters.get(0));
                            }
                            break;
                        case 3:
                            if(i==0){
                                characters.get(0).secondarySpecial(characters.get(1));
                            }else{
                                characters.get(1).secondarySpecial(characters.get(0));
                            }
                            break;
                    }
                    System.out.println();
                    System.out.println("========================");
                    System.out.println(characters.get(0).getCharacterName()+" health: "+characters.get(0).getHP());
                    System.out.println(characters.get(1).getCharacterName()+" health: "+characters.get(1).getHP());
                    System.out.println("========================");
                    System.out.println();

                    /*
                        This isn't a great way to accomplish this, because a nested for loop has a big O complexity of O(n^2)
                        Because the game will only ever have 2 characters though it isn't a huge deal in this case.

                    */
                    for(Character c: characters){
                        if(c.getHP()<=0){
                            Animations.gameOver();
                            System.out.println(c.getCharacterName()+" has died. Game over!");
                            System.out.println("Would you like to play again? y/n");
                            String response = scanner.nextLine();
                            if(response.equals("n")){
                                running = false;
                                break;
                            }
                            else{
                                characters = introPrompt();
                                break;
                            }
                        }
                        if(running == false){
                            break;
                        }
                    }
            }
        }





    }

    public static ArrayList<Character> introPrompt(){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Character> characters = new ArrayList<>();
        Animations.introImage();
        System.out.println("Press enter to continue...");
        scanner.nextLine();
        for(int i=0; i<2; i++){
            System.out.println("Player "+(i+1)+": Select your character class by inputting its number and pressing Enter");
            System.out.println("1. Knight");
            System.out.println("2. Wizard");
            System.out.println("3. Peasant");
            int charClass = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter character name: ");
            String name = scanner.nextLine();
            switch (charClass){
                case 1:
                    Knight knight = new Knight(name);
                    characters.add(knight);
                    break;
                case 2:
                    Wizard wizard = new Wizard(name);
                    characters.add(wizard);
                    break;
                case 3:
                    Peasant peasant = new Peasant(name);
                    characters.add(peasant);
                    break;
            }
            System.out.println();
        }
        return characters;
    }
}


