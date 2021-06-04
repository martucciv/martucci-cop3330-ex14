package ex14;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Veronica Martucci
 */
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    double tax;
    double orderTax;
    double total;

    public static void main(String[] args){
        Main app = new Main();
        double subtotal = app.inputAmount();
        String state = app.inputState();
        app.tax(state, subtotal);
        app.total(subtotal);
        app.printOutput(state, subtotal);
    }

    public double inputAmount(){
        System.out.print("What is the order amount? ");
        String string = input.next();
        return Double.parseDouble(string);
    }

    public String inputState(){
        System.out.print("What is the state? ");
        return input.next();
    }

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

    public void printOutput(String state, double subtotal){
        if(state.equals("WI")){
            System.out.printf("The subtotal is $%.2f.\nThe tax is $%.2f.\n", subtotal, orderTax);
        }
        System.out.printf("The total is $%.2f.", total);
    }
}