import java.lang.Math;
import java.util.Scanner;

class Pair {
    public double x, y;
    public String msg;
}

class QEquation {
    private double a, b, c;
    public double a() {return a;}
    public double b() {return b;}
    public double c() {return c;}
    
    public QEquation (double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public QEquation (Scanner s) {
        this.a = s.nextDouble();
        this.b = s.nextDouble();
        this.c = s.nextDouble();
    }
    
    private double d() {
        return b*b-4*a*c;
    }
    
    public Pair get_ans() {
        Pair p = new Pair();
        double discr = d();
        
        if (a == 0) {
            if (b == 0) p.msg = "no";
            else {
                p.x = -Double.valueOf(c)/b;
                p.msg = "single";
            }
            return p;
        }
        
        if (discr > 0) {
            p.x = (-b-Math.sqrt(discr))/2/a;
            p.y = (-b+Math.sqrt(discr))/2/a;
            p.msg = "double";
        }
        
        if (discr == 0) {
            p.x = p.y = -Double.valueOf(b)/2/a;
            p.msg = "single";
        }
        
        if (discr < 0) {
            p.msg = "no";
        }
        
        return p;
    }
}

class Solution {
    public static void main(String[] args) {
        process(new QEquation(5,4,-10));
        process(new QEquation(3,0,4));
        process(new QEquation(0,3,-4));
        process(new QEquation(0,0,-4));
        process(new QEquation(5,0,0));
        process(new QEquation(2,0.5,-5));
        
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            process(new QEquation(scan));
        }
        // 1 5 6
        // 2 1 -1
    }
    
    private static void process(QEquation qe) {
        System.out.printf("Solving equation ");
        if (qe.a() != 0) System.out.printf("%.2fx^2", qe.a());
        if (qe.b() > 0) System.out.printf("+%.2fx", qe.b());
        if (qe.b() < 0) System.out.printf("%.2fx", qe.b());
        if (qe.c() > 0) System.out.printf("+%.2f", qe.c());
        if (qe.c() < 0) System.out.printf("%.2f", qe.c());
        System.out.printf("=0 ...\n");
        
        Pair ans = qe.get_ans();
        if (ans.msg == "no") System.out.println("There is no answer (((");
        if (ans.msg == "single") System.out.printf("Answer: x=%.4f\n", ans.x);
        if (ans.msg == "double") System.out.printf("Answer: x1=%.4f, x2=%.4f\n", ans.x, ans.y);
        
        System.out.println();
    }
}
