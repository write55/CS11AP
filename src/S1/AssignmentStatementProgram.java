package S1;
// Aaron Wu

public class AssignmentStatementProgram {

    public static void main(String[] args) {

        int A = 64;
        int B = 4;

        System.out.println("A = " + A);
        System.out.println("B = " + B);

        int C = (A + B) / 2;
        System.out.println("C = " + C);

        int D = (A * A) - (C * C);
        System.out.println("D = " + D);

        double E = (double) (C - A) / ((2 * A) - 8);
        System.out.println("E = " + E);
        // Alternatively make everything but G a double
        // That would work better if A and B were different values

        int F = (B * B * B) - (C * C);
        System.out.println("F = " + F);

        int G = (A + B) / 4;
        System.out.println("G = " + G);

        double H = (F * F) / (G - E);
        System.out.println("H = " + H);

    }

}

// A = 64
// B = 4
// C = 34
// D = 2940
// E = -0.25
// F = -1092
// G = 17
// H = 69128.34782608696
