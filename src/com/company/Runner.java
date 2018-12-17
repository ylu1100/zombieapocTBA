package com.company;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("You enter a dark mall that has been infested by zombies.");
        System.out.println("You must reach the second floor[S] in order to be rescued by a helicopter.");
        System.out.println("You leave a trail behind so you don't get lost");
        System.out.println("You have a knife that you can use to kill one zombie. However, that knife will only be available on the first floor");
        System.out.println("W to walk north, A to walk west, E to walk east, S to walk south"); //prints instructions and player goal.
        System.out.println("Type start to begin");
        String[][] firstfloor = new String[5][5];  //creates firstfloor array dimensions
        String[] dodgeinputs ={"w","a","s","d"};
        board board1 = new board(firstfloor,dodgeinputs);
        board1.fill("[ ]"); //creates [ ] for each point on the array
        board1.edit("");  //needed to first print the array with [P] and [H]. without it, program will only print the [ ]'s
        board board2 = new board();
        board2.fill2("[ ]");
        board2.edit2("");
        Scanner start = new Scanner(System.in);
        String start1 = start.nextLine().toLowerCase(); //players can start the game by typing "start" after they read the instructions
        while (!start1.equals("start")) {       //if player types anything else other than start, program will keep telling them to type start
            System.out.println("Type start to begin");
            start1 = start.nextLine().toLowerCase();
        }
        System.out.println(board1);
        while (board1.playerstatus > 0) {   //keeps the game going while player is not dead
            if(board1.playerstatus == 1) {
                while (board1.playerstatus == 1) {
                    Scanner input1 = new Scanner(System.in);
                    String move = input1.nextLine();
                    if (move.equals("d")) {
                        board1.edit("d");
                        System.out.println(board1.toString());       //reprints array after every player move
                    }
                    if (move.equals("s")) {
                        board1.edit("s");
                        System.out.println(board1.toString());
                    }
                    if (move.equals("w")) {
                        board1.edit("w");
                        System.out.println(board1.toString());
                    }
                    if (move.equals("a")) {
                        board1.edit("a");
                        System.out.println(board1.toString());
                    }
                    board1.zombieattack(); //stimulates a zombie attack if player location is at specific coordinates.
                    board1.stairs(); //breaks the loop for first floor

                }
            }
                board1.knife();
            if (board1.playerstatus == 2 && board2.reprint==0) {
                System.out.println(board2.toString2());
            }
            if (board1.playerstatus == 2) {
                while (board2.playerstatus == 2) {
                    Scanner input1 = new Scanner(System.in);
                    String move = input1.nextLine();
                    if (move.equals("d")) {
                        board2.edit2("d");
                        System.out.println(board2.toString2());
                    }
                    if (move.equals("s")) {
                        board2.edit2("s");
                        System.out.println(board2.toString2());
                    }
                    if (move.equals("w")) {
                        board2.edit2("w");
                        System.out.println(board2.toString2());
                    }
                    if (move.equals("a")) {
                        board2.edit2("a");
                        System.out.println(board2.toString2());
                    }
                    board2.zombieattack2(); //zombie attacks in different coordinates than zombieattack
                    board2.pickupknife2();
                    board2.win();   //breaks the loop
                }
                board2.knife2();
                }//after player wins, changing playerstatus will break the loop so program can proceed to line 80
                if (board2.playerstatus == 0 || board2.playerstatus == 3) {
                    board1.playerstatus = 0;
            }
        }
        if (board2.playerstatus == 3) {
            System.out.println("Congratulations. You have reached the helicoper!"); //prints the win line instead of overrun line if playerstatus for board2 is 3

        } else {
            System.out.println("You were overrun");
        }
    }
}



