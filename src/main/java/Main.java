import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Input input = new Input();
        input.main();
        Calculator calc = new Calculator();
        calc.tax(input.state, input.subtotal);
        calc.total(input.subtotal);

        if(input.state.equals("WI")){
            System.out.printf("The subtotal is $%.2f.\nThe tax is $%.2f.\n", input.subtotal, calc.orderTax);
        }
        System.out.printf("The total is $%.2f.", calc.total);
    }
}

class Input{
    double subtotal;
    String state;

    public void main(){
        System.out.print("What is the order amount? ");
        Scanner input1 = new Scanner(System.in);
        String string1 = input1.next();
        this.subtotal = Double.parseDouble(string1);

        System.out.print("What is the state? ");
        Scanner input2 = new Scanner(System.in);
        this.state = input2.next();
    }
}

class Calculator{
    double tax;
    double orderTax;
    double total;

    public void tax(String state, double subtotal){
        this.tax = 0.00;
        this.orderTax = 0.00;
        if(state.equals("WI")){
            this.tax = 0.055;
            this.orderTax = this.tax * subtotal;
        }
    }


    public void total(double subtotal){
        this.total = subtotal + this.orderTax;
    }
}