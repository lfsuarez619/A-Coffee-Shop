import java.util.*;
import java.io.*;
import java.text.*;

/**
 * The main driver for the Coffee Shop program
 * @author Luis Suarez and Katelin Jaque
 */
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner CafeApplication = new Scanner(System.in);
        System.out.println("Cafe Application Running...");
        Stack<String> stack = new Stack<String>();
        int input = 0;

        int[] a = new int[6];
        a = inventoryInital(a);

        boolean cond = memberAsk();
        if (cond == true) {
            System.out.println("Welcome back, and enjoy a $1 discount on your total purchase");
        } else {
            System.out.println("Unfortunately you are not a rewards member. " +
                    "Sign up online at www.java-coffee.com today!");
        }

        do {
            menu();

            switch (CafeApplication.nextLine()) {
                case "1":
                    arrayPrint(a); //complete this one
                    break;
                case "2":
                    if (a[0] != 0) {
                        stack = CreateOrder(a);
                        logWriter(stack);
                    } else {
                        System.out.println("Out of Coffee. Visit us later.");
                        System.exit(0);
                    }
                    break;
                case "3":
                    inventoryWriter(a);
                    break;
                case "4":
                    logWriter(stack);
                    break;
                case "5":
                    input = 1;
                    break;
                default:
                    System.out.println("Invalid Selection. Please Try Again");
            }

        }
        while (input != 1);
        System.out.println("Goodbye!");
        System.exit(0);
    }
    /**
     * Will be the inital reading of the inventory
     * @author Luis Suarez and Katelin Jaque
     */
    public static int[] inventoryInital(int[] a) throws FileNotFoundException {
        int i = 0;
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader("/Users/luissuarez/eclipse-workspace/CoffeeShops/src/inventory.txt"));
            //perhaps manually write the path of the file
            //File mypath = new File("/username/folder/CoffeeShop/src/inventory.txt");
            try {
                String test = "Test string !";
                File file = new File("/Users/luissuarez/eclipse-workspace/CoffeeShops/src/inventory.txt");

                String line = myBuffer.readLine();
                while (line != null) { //control iteration inside while loop
                    a[i] = Integer.valueOf(line.indexOf("=") + 2); //substring ("= " !!!) method to be used
                    line = myBuffer.readLine();

                    i++; // i increments
                }
                myBuffer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done");
        return a;
    }

    /**
     * Will ask the user is they are a rewards member
     * @author Luis Suarez and Katelin Jaque
     */
    public static boolean memberAsk() {
        Scanner scrn = new Scanner(System.in);
        char z;
        boolean cond = false;
        String x;
        System.out.println("Are you a rewards member with us?");
        System.out.println("Press 'y' for yes, or 'n' for no.");

        x = scrn.nextLine();
        z = x.charAt(0);

        if (z == 'y') {
            String user;
            String pass;
            System.out.print("Please enter your UserName: ");
            user = scrn.nextLine();
            System.out.print("Please enter your Password: ");
            pass = scrn.nextLine();

            try (BufferedReader br = new BufferedReader(new FileReader("/Users/luissuarez/eclipse-workspace/CoffeeShops/src/UsernamePassword"))) {
                String line;
                while ((line = br.readLine()) != null && cond == false) {
                    cond = (user + " | " + pass).equals(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } else if (z == 'n') {
            System.out.print("");
        } else {
            System.out.println("Please Try Again");
        }
        return cond;
    }

    /**
     * Encapsulation of the coffee menu
     * @author Luis Suarez and Katelin Jaque
     */
    public static void menu () {
        System.out.println("Press 1 : Read Inventory");
        System.out.println("Press 2 : Create Coffee Order");
        System.out.println("Press 3 : Update Inventory");
        System.out.println("Press 4 : Update log file");
        System.out.println("Press 5 : Exit the application");
    }

    /**
     * Prints out the inventory on demand
     * @author Luis Suarez and Katelin Jaque
     */
    public static void arrayPrint (int[] a){
        System.out.println("Black Coffee = " + a[0]);
        System.out.println("Milk = " + a[1]);
        System.out.println("HotWater = " + a[2]);
        System.out.println("Espresso = " + a[3]);
        System.out.println("Sugar = " + a[4]);
        System.out.println("WhippedCream = " + a[5]);
    }

    //With the inventoryReader() method, I just can't seem to understand fully how the buffer reader works.
    // And in my weak understanding of the buffer reader, I don't see how only the number values from
    // inventory.txt can be read
    /**
     * The main driver for the Coffee Shop program
     * @author Luis Suarez and Katelin Jaque
     * @return Integer array that represents the inventory quantities
     */
    public static int[] inventorReader() throws FileNotFoundException {
        int[] a = new int[6];
        int i = 0;
        try {
            BufferedReader myBuffer = new BufferedReader(new FileReader("/Users/luissuarez/eclipse-workspace/CoffeeShops/src/inventory.txt"));
            //perhaps manually write the path of the file
            //File mypath = new File("/username/folder/CoffeeShop/src/inventory.txt");
            try {
                String test = "Test string !";
                File file = new File("/Users/luissuarez/eclipse-workspace/CoffeeShops/src/inventory.txt");

                String line = myBuffer.readLine();
                while (line != null) { //control iteration inside while loop
                    a[i] = Integer.valueOf(line.indexOf("=") + 2); //substring ("= " !!!) method to be used
                    System.out.println(line);
                    line = myBuffer.readLine();

                    i++; // i increments
                }
                myBuffer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done");
        return a;
    }


    /**
     * The main driver for the Coffee Shop program
     * @author Luis Suarez and Katelin Jaque
     * @throws FileNotFoundException in the code
     */
    public static void inventoryWriter(int[] a) throws FileNotFoundException {
        //String[] s = new String[6];
        //s = menuString(s);

        int i = 0;
        try {
            FileWriter myWriter = new FileWriter("/Users/luissuarez/eclipse-workspace/CoffeeShops/src/inventory.txt");
            myWriter.write("\n\nBlack Coffee = " + a[0]);
            myWriter.write("\n\nMilk = " + a[1]);
            myWriter.write("\n\nHotWater = " + a[2]);
            myWriter.write("\n\nEspresso = " + a[3]);
            myWriter.write("\n\nSugar = " + a[4]);
            myWriter.write("\n\nWhippedCream = " + a[5]);

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //inventorReader();
    }

    /**
     * The main driver for the Coffee Shop program
     * @author Luis Suarez and Katelin Jaque
     * @param a that acts as the current inventory quantities
     * @return int[] that will return a more current inventory quantity
     */
    public static Stack<String> CreateOrder(int[] a) throws FileNotFoundException {
        Scanner userFeedback = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        //ArrayList<String> coffeeOrder = new ArrayList<String> ();
        Coffee basicCoffee = new BasicCoffee();
        int in = 0;
        int z = 0;
        // you must decrement of the original/current values so
        //the values can reach zero and can stop user from ordering more

        //[0] = black coffee
        //[1] = milk
        //[2] = sugar
        //[3] = whipped cream
        //[4] = espresso
        //[5] = hot water
        //pass an array that represents inv. and decrement in each case to show real time inv.

            if (a[0] > 0) {
                System.out.println("""
                Select Coffee Order:
                //[1] = black coffee
                //[2] = milk
                //[3] = sugar
                //[4] = whipped cream
                //[5] = espresso
                //[6] = hot water
                press 7 to quit""");
                in = userFeedback.nextInt();
                switch (in) {
                case (1):
                    basicCoffee = new BlackCoffee(basicCoffee);
                    a[0]--;
                    inventoryWriterCO(a);
                    break;
                case (2):
                    basicCoffee = new Milk(basicCoffee);
                    a[1]--;
                    break;
                case (3):
                    basicCoffee = new Sugar(basicCoffee);
                    a[2]--;
                    break;
                case (4):
                    basicCoffee = new WhippedCream(basicCoffee);
                    a[3]--;
                    break;
                case (5):
                    basicCoffee = new Espresso(basicCoffee);
                    a[4]--;
                    break;
                case (6):
                    basicCoffee = new HotWater(basicCoffee);
                    a[5]--;
                    break;
                }
            }
        stack.push(basicCoffee.toString());
        return stack;
    }

    public static void inventoryWriterCO(int[] a) throws FileNotFoundException {
        //String[] s = new String[6];
        //s = menuString(s);

        int i = 0;
        try {
            FileWriter myWriter = new FileWriter("/Users/luissuarez/eclipse-workspace/CoffeeShops/src/inventory.txt");
            myWriter.write("\n\nBlack Coffee = " + a[0]);
            myWriter.write("\n\nMilk = " + a[1]);
            myWriter.write("\n\nHotWater = " + a[2]);
            myWriter.write("\n\nEspresso = " + a[3]);
            myWriter.write("\n\nSugar = " + a[4]);
            myWriter.write("\n\nWhippedCream = " + a[5]);

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //inventorReader();
    }


    /**
     * The main driver for the Coffee Shop program
     * @author Luis Suarez and Katelin Jaque
     * @param stack is passed which contains the coffee objects
     */
    public static void logWriter (Stack<String> stack) {
            //logWriter(Stack<String> stack)
            //yo want string buffer to pass everything as a string
            try {
                FileWriter myWriter = new FileWriter("/Users/luissuarez/eclipse-workspace/CoffeeShops/src/LogFile.txt", true);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                Date date = new Date(System.currentTimeMillis());
                myWriter.write("\n\nWriting orders from stack " + formatter.format(date));
                myWriter.write("\n\nRECEIPT\n");

                if (stack.empty()) {
                    System.out.println("Nothing to log. Stack is empty");
                } else {
                    for (int i = 0; i < stack.size(); i++) {
                        myWriter.write(stack.pop());
                    }
                    myWriter.close();
                    System.out.println("successfully uploaded to the log file");
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }


}


