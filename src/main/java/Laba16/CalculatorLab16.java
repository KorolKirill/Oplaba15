package Laba16;

public class CalculatorLab16 {
    private static CalculatorLab16 instance;

    private CalculatorLab16() {
    }

    public static CalculatorLab16 getInstance() {
        if (instance==null) {
            return (instance=new CalculatorLab16());
        }
        else{
            return instance;
        }
    }

    public double calculateEquation(String aParam, String bParam, String cParam, String dParam, String typeOfEquation) {
        double result = 0;
        double a = Double.parseDouble(aParam);
        double b = Double.parseDouble(bParam);
        double c = Double.parseDouble(cParam);
        double d = Double.parseDouble(dParam);
        switch (typeOfEquation) {
            case "1":
                if (b<=0) {
                    throw new IllegalArgumentException("Wrong value for B in this formula");
                }
                result = Math.sqrt(Math.abs(Math.sin(a) - 4 * Math.log(b) / Math.pow(c, d)));
            case "2":
                if (c<0) {
                    throw new IllegalArgumentException("Wrong value for C in this formula");
                }
                result = Math.pow(2 * Math.sin(a) + Math.cos(Math.abs(b * Math.sqrt(c))), d);
            case "3":
                if (c<=0) {
                    throw new IllegalArgumentException("Wrong value for C in this formula");
                }
                result = (Math.pow(Math.E, a) + 3 * Math.log(c)) / Math.pow(b, c / 2) * Math.abs(Math.atan(d));
        }
        return result;
    }

}
