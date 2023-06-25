package MainModules.AbstractClasses;

import DataPackage.Variable;
import org.json.simple.parser.ParseException;

public abstract class CalculateAbs extends Variable {
   public abstract double sum(double x, double y);

   public abstract void sumComplete() throws ParseException;

   public abstract double minus(double x, double y);

   public abstract void minusComplete() throws ParseException;

   public abstract double multiplication(double x, double y);

   public abstract void multiplicationComplete() throws ParseException;

   public abstract double division(double x, double y);

   public abstract void divisionComplete() throws ParseException;

   public abstract double interest(double x, double y);

   public abstract void interestComplete() throws ParseException;

   public abstract double sqrt(double x);

   public abstract void sqrtComplete() throws ParseException;

   public abstract double pow(double x, double y);

   public abstract void powComplete() throws ParseException;

   public abstract double sin(double x);

   public abstract void sinComplete() throws ParseException;

   public abstract double cos(double x);

   public abstract void cosComplete() throws ParseException;

   public abstract double x2(double dis, double a, double b);

   public abstract double x(double b, double a);

   public abstract void disc() throws ParseException;

   public abstract double discriminant(double b, double a, double c);

   public abstract double x1(double dis, double a, double b);

   public abstract double tan(double x);
   public abstract void tanComplete() throws ParseException;

   public abstract double[] average();
   public abstract void averageComplete();

   public abstract double asin(double x);

   public abstract void asinComplete() throws ParseException;

   public abstract double acos(double x);

   public abstract void acosComplete() throws ParseException;

   public abstract double atan(double x);

   public abstract void atanComplete() throws ParseException;

   public abstract double cbrt(double x);

   public abstract void cbrtComplete() throws ParseException;

   public abstract double log(double x);

   public abstract void logComplete() throws ParseException;

   public abstract double log10(double x);

   public abstract void log10Complete() throws ParseException;

   public abstract double sinh(double x);

   public abstract void sinhComplete() throws ParseException;

   public abstract double cosh(double x);

   public abstract void coshComplete() throws ParseException;

   public abstract double tanh(double x);

   public abstract void tanhComplete() throws ParseException;

}







