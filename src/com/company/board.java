package com.company;
//playerstatus 0 = dead,1 = alive, 2 = secondfloor alive, 3 = win


import java.util.Scanner;

public class board  {
    private int x;
    private int y;
    private int x2;
    private int y2;
    public int playerstatus; //public because runner class needs access to these variables.
    public int knife;
    public int reprint; //makes it so that an array doesn't print right after player uses knife. Let's player know that they've used a knife
    private String [][]firstfloor;
    private String[][]secondfloor;
    private String[]dodgeinput;

    public board(String [][]firstfloor,String[]dodgeinput) {
        this.dodgeinput=dodgeinput;
       this.firstfloor=firstfloor;
        this.playerstatus = 1;
        this.knife = 1;
    }
    public board(){
        String[][]secondfloor = new String[7][7];  //overloads the board constructor with the secondfloor. creates a new array for secondfloor
        this.secondfloor=secondfloor;
        this.x2 = 6;
        this.y2= 4;
        this.playerstatus=2;
        this.knife = 0;
        this.reprint = 0;
    }


    public void fill(String str) {
        for (int h = 0; h < firstfloor.length; h++) {
            for (int w = 0; w < firstfloor[h].length; w++) {        //fills each array coordinate with [ ]
                firstfloor[w][h] = str;
            }
        }
    }
    public void fill2(String str){
        for (int h = 0; h < secondfloor.length; h++) {
            for (int w = 0; w < secondfloor[h].length; w++) {
                secondfloor[w][h] = str;
            }
        }
    }



    public void edit(String move) {
        if (playerstatus == 1) {
            if (move.equals("d") && firstfloor[y][4] != "[P]") {      //y is the index for rows 1st floor
                x++;                                                  //x is the index for columns 1st floor
                firstfloor[y][x - 1] = "[-]";
            }
            if (move.equals("s") && firstfloor[4][x] != "[P]") {
                y++;
                firstfloor[y - 1][x] = "[-]";
            }
            if (move.equals("a") && firstfloor[y][0] != "[P]") {
                x--;
                firstfloor[y][x + 1] = "[-]";
            }
            if (move.equals("w") && firstfloor[0][x] != "[P]") {
                y--;
                firstfloor[y + 1][x] = "[-]";
            }
            firstfloor[3][4] = "[S]";
            firstfloor[y][x] = "[P]";
        }
    }
    public void edit2(String move){
        if (playerstatus == 2) {
            if (move.equals("d") && secondfloor[y2][6] != "[P]") {      //y2 is the index for rows of second floor
                x2++;                                                   //x2 is the index for columns of second floor
                secondfloor[y2][x2 - 1] = "[-]";
            }
            if (move.equals("s") && secondfloor[6][x2] != "[P]") {
                y2++;
                secondfloor[y2 - 1][x2] = "[-]";
            }
            if (move.equals("a") && secondfloor[y2][0] != "[P]") {
                x2--;
                secondfloor[y2][x2 + 1] = "[-]";
            }
            if (move.equals("w") && secondfloor[0][x2] != "[P]") {
                y2--;
                secondfloor [y2+1][x2] = "[-]";
            }
           secondfloor[1][0] = "[H]";
           secondfloor[y2][x2] = "[P]";
        }
    }

    public String toString() {
        String floor = "";
            for (int y = 0; y < firstfloor.length; y++) {
                for (int x = 0; x < firstfloor[y].length; x++) {    //returns the printable string of the array with the edits/fill
                    floor = floor + firstfloor[y][x];
                }
                floor = floor + "\n";
            }
        return floor;
    }
    public String toString2(){
        String floor = "";
        for (int y = 0; y < secondfloor.length; y++) {
            for (int x = 0; x < secondfloor[y].length; x++) {
                floor = floor + secondfloor[y][x];
            }
            floor = floor + "\n";
        }
        return floor;
    }


    public void zombieattack() {
        if (y == 1 && x == 1 )  {
            playerstatus = 0;
        }
        if (y == 3 && x == 2) {      //coordinates of the zombies
            playerstatus = 0;
        }
        if (y == 4 && x == 4) {
            playerstatus = 0;
        }
        if (y == 0 && x == 4) {
            playerstatus = 0;
        }
        if (y == 4 && x == 0) {
            playerstatus = 0;
        }
        if (y == 2 && x == 4) {
            playerstatus = 0;
        }
}
public void zombieattack2(){
    if (y2 == 2 && x2 == 6 )  {
        playerstatus = 0;
    }
    if (y2 == 3 && x2 == 4) {
        playerstatus = 0;
    }
    if (y2 == 4 && x2 == 4) {
        playerstatus = 0;
    }
    if (y2 == 0 && x2 == 4) {
        playerstatus = 0;
    }
    if (y2 == 4 && x2 == 0) {
        playerstatus = 0;
    }
    if (y2 == 2 && x2 == 2) {
        playerstatus = 0;
    }
    if (y2 == 5 && x2 == 1) {
        playerstatus = 0;
    }
    if (y2 == 1 && x2 == 4) {
        playerstatus = 0;
    }
    if (y2 == 6 && x2 == 3) {
        playerstatus = 0;
    }
    if(y2==3 && x2==2){
        playerstatus=0;
    }
}
    public void stairs(){
        if (firstfloor[3][4].equals("[P]")){       //changes playerstatus variable to tell the program to print different array
            playerstatus=2;
        }

    }
    public void knife(){
        if (knife == 1 && playerstatus == 0){    //if player has a knife available and dies, they can have a second try.
            playerstatus=1;
            System.out.println("You broke your knife. You are defenseless for the next attack. Remember to avoid that spot next time.");
        }
        knife = 0;
    }
    public void knife2(){
        if (knife == 1 && playerstatus == 0){    //if player has a knife available and dies, they can have a second try.
            playerstatus=2;
            System.out.println("You broke your knife. You are defenseless for the next attack. Remember to avoid that spot next time.");
        }
        knife = 0;
        reprint = 1;
    }
    public void pickupknife2(){  //allows player to pick up a knife in secondfloor
        if(y2==6 && x2 == 6){
            System.out.println("You have picked up a knife!");
            knife = 1;
        }
        if(y2==3 && x2==5){
            System.out.println("You have picked up a knife!");
            knife = 1;
        }
    }
    public void dodge(){       //Method is still a work in progress
        if (playerstatus == 0){
            System.out.println("You were attacked. Try leaning towards a direction to evade the zombie(Type w or a or s or d)");
            //allows player to try dodging the zombie if they're attacked. if they fail to dodge, they will use their knife
            Scanner dodge =new Scanner(System.in);
            String dodge1 = dodge.nextLine().toLowerCase();
            if (dodge1 == "w"){
               playerstatus=1;
                this.edit("w");
                System.out.println(toString());
            }
        }
    }

    public void dodge2(){
        if (playerstatus == 0){
            System.out.println("You were attacked. Try leaning towards a direction to evade the zombie(Type w or a or s or d)");
            String dodgekey = dodgeinput[(int)(Math.random()*4)];   //allows player to try dodging the zombie if they're attacked. if they fail to dodge, they will use their knife
            Scanner dodge =new Scanner(System.in);
            String dodge1 = dodge.nextLine().toLowerCase();
            if (dodge1 == dodgekey){
                playerstatus=2;
            }
        }
    }
    public void win(){
        if (y2 == 1 && x2==0){      //changes playerstatus variable to break the while loop in Runner.Prints a victory text if player is in the specified array coordinates.
            playerstatus = 3;
        }
    }

}
