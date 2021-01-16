package com.intercom;


public class Main {

    public static void main(String[] args) {

        Handler handler = null;
        //No commandline arguments
        if (args.length == 0) {
            System.out.println("Usage: java Main <path of customers.txt> [distance]");
            System.exit(1);
        }
        //Both File Path and Distance is provided
        else if (args.length == 2) {
            try {
                if (Double.parseDouble(args[1]) < 0) //Validating distance
                    throw new NumberFormatException("Negative number");
                handler = new Handler(args[0], Double.parseDouble(args[1]));
            } catch (NumberFormatException e) {
                System.out.println("Distance has to be a number");
                System.exit(1);
            }
        }
        //Default case when only File Path is provided
        else {
            handler = new Handler(args[0]);
        }
        handler.runApplication();

    }

}
