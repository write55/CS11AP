package S1;
// Aaron Wu
// 9/14/18
// Program to randomly generate two (x,y) points with values ranging from -10 to 10, then calculate the distance between them
// Uses Math methods to generate random numbers and do exponents

public class DistanceProgram {

    public static void main(String[] args) {

        // GENERATE RANDOM NUMBERS
        int x1, y1, x2, y2;
        x1 = (int) (Math.random() * 21) - 10;
        y1 = (int) (Math.random() * 21) - 10;
        x2 = (int) (Math.random() * 21) - 10;
        y2 = (int) (Math.random() * 21) - 10;

        double distance = Math.pow(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2), .5);
        distance = (int) (100.0 * distance + .5) / 100.0;
        System.out.println("The distance between (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ") is " + distance);

    }

}