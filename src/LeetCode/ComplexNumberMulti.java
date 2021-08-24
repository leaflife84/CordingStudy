package LeetCode;

public class ComplexNumberMulti {
    public static void main(String[] args) {
        ComplexNumberMulti c = new ComplexNumberMulti();
        String num1 = "1+1i";
        String num2 = "1+1i";
        System.out.println(c.complexNumberMultiply(num1,num2));
    }

    public String complexNumberMultiply(String num1, String num2) {
        int real1 = Integer.parseInt(num1.split("\\+")[0]);
        int real2 = Integer.parseInt(num2.split("\\+")[0]);
        String imaginary1 = num1.split("\\+")[1];
        String imaginary2 = num2.split("\\+")[1];
        int real = (real1*real2)+((Integer.parseInt(imaginary1.split("i")[0])*Integer.parseInt(imaginary2.split("i")[0]))*-1);
        int img = (real1*(Integer.parseInt(imaginary2.split("i")[0])))+(real2*(Integer.parseInt(imaginary1.split("i")[0])));
        return real+"+"+img+"i";
    }
}
