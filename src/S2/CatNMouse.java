package S2;

/*
Aaron Wu
Due: 4/25/19
Reads a maze in the format of a text file
Uses recursion to find a mouse on character "M" from a cat "C"
Cat is always in first row
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CatNMouse {

    private ArrayList<ArrayList<Character>> maze;
    private int w; // width, x
    private int h; // height, y
    private int cat = 0; // Cat's x-coordinate
    private boolean found = false;

    public CatNMouse() {
        maze = new ArrayList<ArrayList<Character>>();
    }

    // FILE READING
    public void readFile() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter relative path of file: ");
        FileReader readFile = new FileReader(in.readLine());
        BufferedReader inFile = new BufferedReader(readFile);
        System.out.println("\nReading File...\n");
        String input = inFile.readLine();
        while (input != null) {
            process(input);
            input = inFile.readLine();
        }
        inFile.close();
        w = maze.get(0).size();
        h = maze.size();
    }

    public void process(String in) {
        ArrayList<Character> temp = new ArrayList<Character>();
        for (int i = 0; i < in.length(); i++) {
            temp.add(in.charAt(i));
        }
        maze.add(temp);
    }

    // GETTER/SETTER
    public boolean getFound() {
        return found;
    }

    public int getCat() {
        return cat;
    }

    // FUNCTION METHODS
    // Cat always at y = 0, gives x location
    public void findCat() {
        while (!maze.get(0).get(cat).equals('C')) {
            cat++;
        }
        maze.get(0).set(cat, ' ');
    }

    // Builds string from maze array for output
    public String toString() {
        maze.get(0).set(cat, 'C');
        StringBuilder out = new StringBuilder();
        for (ArrayList<Character> i : maze) {
            for (Character j : i) {
                if (j == '1') {
                    out.append(' ');
                } else {
                    out.append(j);
                }
            }
            out.append("\n");
        }
        return out.toString();
    }

    // Gives dimensions, result, calls toString
    public void printResult() {
        if (found) {
            System.out.println("The cat found the mouse in this " + w + " x " + h + " maze");
        } else {
            System.out.println("The cat was unable to find the mouse in this " + w + " x " + h + " maze");
        }
        System.out.println(toString());
    }

    // Solve method - give starting coordinates
    public void solve(int x, int y) {
        if (x >= w || x < 0 || y >= h || y < 0) {
            return;
        } else if (maze.get(y).get(x).equals('#')) {
            return;
        } else if (maze.get(y).get(x).equals('M') && !found) {
            found = true;
            printResult(); // "End" the method, doesn't stop recursion
            return;
        } else if (maze.get(y).get(x).equals('0') || maze.get(y).get(x).equals('1') || maze.get(y).get(x).equals('C')) {
            return;
        }
        maze.get(y).set(x, '0');
        solve(x, y + 1);
        solve(x - 1, y);
        solve(x, y - 1);
        solve(x + 1, y);
        // If the cat hits a wall or something meaning it's trapped the recursive call will return
        // The space from the previous recurse will be set to 1 then printed as a space later
        maze.get(y).set(x, '1');
    }

    public static void main(String[] args) throws IOException {
        CatNMouse cnm;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char sentinel = 'Y';
        while (sentinel != 'N') {
            cnm = new CatNMouse();
            cnm.readFile();
            cnm.findCat();
            cnm.solve(cnm.getCat(), 0);
            if (!cnm.getFound()) {
                cnm.printResult();
            }
            System.out.println("Continue? (Y/N)");
            sentinel = in.readLine().toUpperCase().charAt(0);
        }
    }
}

/*

OUTPUT

Enter relative path of file: maze1.txt

Reading File...

The cat found the mouse in this 40 x 20 maze
##C#####################################
##0        ######## ############       #
##0         ####### #            ##### #
##0################ ################## #
##0#######00000000000000000      ##### #
##0#######0###############0######000## #
##0#######000000000M######0###0000#0 # #
##0#####  ########## #####0###0## #0## #
##0##### # ######0000#####00000## #0## #
##0##### #######00##0##############00# #
##0##### ####0000###0#########    ##0# #
##00     ####0######0######### #####0# #
###0       ##0######0######### ##0000# #
###0#########0######000  ##### ##0#### #
###0#########0########0## #### ##000000#
###00000000000  ######0## #### #######0#
######################0## #   ##0000000#
######################0#########0##### #
######################00000000000#     #
########################################

Continue? (Y/N)
Y
Enter relative path of file: maze2.txt

Reading File...

The cat found the mouse in this 7 x 7 maze
####C
####0##
###M0
00000
000 0
00000
#######

Continue? (Y/N)
Y
Enter relative path of file: maze3.txt

Reading File...

The cat found the mouse in this 10 x 10 maze
########C#
#     # 0#
 ##### 00#
#   0000##
#   0#####
#   000 ##
######000
#     00M#
      00##
###   00

Continue? (Y/N)
Y
Enter relative path of file: maze4.txt

Reading File...

The cat was unable to find the mouse in this 11 x 8 maze
#####C#####
#
#
# #### ####
  #  #    #
# # M#    #
# #  #    #
# ########

Continue? (Y/N)
Y
Enter relative path of file: maze5.txt

Reading File...

The cat found the mouse in this 8 x 8 maze
M      C
0      0
00000000
######00
00000000
00000000
00000000
######00

Continue? (Y/N)
Y
Enter relative path of file: maze6.txt

Reading File...

The cat found the mouse in this 7 x 8 maze
M     C
0     0
0000000
#######



#######

Continue? (Y/N)
Y
Enter relative path of file: maze7.txt

Reading File...

The cat found the mouse in this 10 x 8 maze
    C00
    000
    000
    000
    000
    000M
    0000
    0000

Continue? (Y/N)
Y
Enter relative path of file: maze8.txt

Reading File...

The cat found the mouse in this 10 x 6 maze
#####C0000
#########0
#########0
######0000
0000000###
M#########

Continue? (Y/N)
Y
Enter relative path of file: maze9.txt

Reading File...

The cat found the mouse in this 13 x 3 maze
####C0000M##
    000000
############

Continue? (Y/N)
Y
Enter relative path of file: maze10.txt

Reading File...

The cat found the mouse in this 4 x 10 maze
 C
 0
 0
 0
 0M
 00
 00
 00
 00
 00

Continue? (Y/N)
Y
Enter relative path of file: maze11.txt

Reading File...

The cat was unable to find the mouse in this 10 x 8 maze
###C######


  #####
  #   #
  # M #
  #   #
  #####

Continue? (Y/N)
Y
Enter relative path of file: maze12.txt

Reading File...

The cat found the mouse in this 40 x 20 maze
##C#####################################
##0        ######## ############       #
##0         ####### #            ##### #
##0################ ################## #
##0#######00000000000000000      ##### #
##0#######0###############0######000## #
##0#######000000000M######0###0000#0 # #
##0################# #####0###0## #0## #
##0##### # ######0000#####00000## #0## #
##0##### #######00##0##############00# #
##0##### ####0000###0#########    ##0# #
##00     ####0######0######### #####0# #
###0       ##0######0######### ##0000# #
###0#########0######000  ##### ##0#### #
###0#########0########0## #### ##000000#
###00000000000  ######0## #### #######0#
######################0## #   ##0000000#
######################0#########0##### #
######################00000000000#     #
########################################

Continue? (Y/N)
N

 */