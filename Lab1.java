import java.util.Random;
import static java.lang.Math.*;
public class Lab1 {
    public static void main(String[] args) {
        long[] s = ArrayS();    
        float[] x = ArrayX();
        double[][] e = MatrizE(s, x);
        impMatriz(e); // Declaracion de las variables 
    }
    static long[] ArrayS() {
        long[] s = new long[12];
        long valor = 3;
        for (int i = 0; i < s.length; i++) {
            s[i] = valor;
            valor = valor + 2;
        }
        return s; // Loop de la primer variable e incremento de de i 
    }
    static float[] ArrayX() {
        float[] x = new float[16];
        Random rnd = new Random();
        float min = -12.0f;
        float max = 14.0f;
        for (int j = 0; j < x.length; j++) {
            x[j] = min + rnd.nextFloat() * (max - min);
        }
        return x; // loop de la segunda variable e incemento de j
    }
    static double[][] MatrizE(long[] s, float[] x) {
        double[][] e = new double[s.length][x.length];
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < x.length; j++) {
                e[i][j] = calculator(s[i], x[j]);
            }
        }
        return e; // loop de la tercera variable (la matriz) e incremento con las variablres anteriores
    }
    static double calculator(long si, double xj) {
        if (si == 3) {
            return formulA(xj);
        } else if (perteneceA(si, 9, 1  , 15, 17, 21, 23)) {
            return formulB(xj);
        } else {
            return formulC(xj);
        }
    } // revisar si pertenece a alguna de las formulas 
    static double formulA(double x) {
        double raiz = cbrt(x);
        double exponent = pow(x, x);
        double base = pow(raiz, exponent);
        double interior = base - 0.25;
        return pow(0.5 * interior, 2);
    }   //resultado primera formula 
    static double formulB(double x) {
        double base = 2 * x;
        double exponent = pow(base, x);
        double interior = exp(exponent);
        return cos(interior);
    } // Resultado segunda formula 
    static double formulC(double x) {
        double sin = sin(x);
        double interior = 0.25 * sin;
        double tangent = tan(interior);
        return cos(tangent);   
    } // Resultado 4 formula
    static boolean perteneceA(long valor, long... conjunto) {
        for (long v : conjunto) {
            if (valor == v) {
                return true;
            }
        }
        return false;
    } // Revicion de resultados 
    static void impMatriz(double[][] e) {
        for (double[] fila : e) {
            StringBuilder sb = new StringBuilder();
            for (double valor : fila) {
                sb.append(String.format("%.4f", valor)).append("\t");
            }
            System.out.println(sb.toString().trim());
        }
    }
} // Impresion resultados

//byte 1 en
//short 2 en
//int 4 en
// long 8 en
// float 4 de
//double 8 de
//char 2 le
//boolean true or false 0