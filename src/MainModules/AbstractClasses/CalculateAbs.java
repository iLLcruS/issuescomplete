package MainModules.AbstractClasses;

import DataPackage.Variable;

public abstract class CalculateAbs extends Variable {
   public abstract double sum(double x, double y);

   public abstract void sumComplete();
   public abstract double minus(double x, double y);
   public abstract void minusComplete();

   public abstract double multiplication(double x, double y);

   public abstract void multiplicationComplete();

   public abstract double division(double x, double y);

   public abstract void divisionComplete();

   public abstract double interest(double x, double y);

   public abstract void interestComplete();

   public abstract double sqrt(double x);
   public abstract void sqrtComplete();
   public abstract double pow(double x, double y);
   public abstract void powComplete();

   public abstract double sin(double x);
   public abstract void sinComplete();

   public abstract double cos(double x);
   public abstract void cosComplete();


}









