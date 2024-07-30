

public class VendRunner {
    public static void main(String[] args){
            try {
                    //Snack instance
//                    Snack snack1 = new Snack("PopCorn", 3, true);
//                    System.out.println("---SNACK---");
//                    System.out.println(snack1);
//
//                    Snack snack2 = new Snack("Snack 2", 0, true);
//                    System.out.println("---SNACK---");
//                    System.out.println(snack2);
//
//                    //Beverage instance
//                    Beverage beverage1 = new Beverage("Fanta", 1.09, 16.8);
//                    System.out.println("---Beverage---");
//                    System.out.println(beverage1);
//
//                    //Create the product instance
//                    //Product product = new Product();
//                    //product.setPrice(-3);
//
//                    //Slot instance
//                    Slot<Snack> slot1 = new Slot<>(snack1, 4);
//                    System.out.println("---Slot1---");
//                    System.out.println(slot1);
//
//                    Slot<Beverage> slot2 = new Slot<>(beverage1, 3);
//                    System.out.println("---Slot2---");
//                    System.out.println(slot2);
//
//                    //Create a slot3 instance - invalid input
//                    Slot<Snack> slot3 = null;
//
//                    //Vending Machine Instance
//                    VendingMachine vendingMachine = new VendingMachine();
//
//                    //Invalid Input - slot3
//                    //vendingMachine.addProduct("ERD",slot3);
//                    //Add Products to Vending Machine
//                    vendingMachine.addProduct("PopCorn", slot1);
//                    vendingMachine.addProduct("Fanta", slot2);
//
//                    System.out.println("---Vending Machine");
//                    //Display products
//                    vendingMachine.displayProducts();
//
//                    //Dispense products
//                    //Invalid input
//                    //Product dispensedProduct = vendingMachine.dispenseProduct("");
//                    Product dispensedProduct1 = vendingMachine.dispenseProduct("Fanta");
//                    Product dispensedProduct2 = vendingMachine.dispenseProduct("PopCorn");
//                    Product dispensedProduct3 = vendingMachine.dispenseProduct("Fanta");
//                    Product dispensedProduct4 = vendingMachine.dispenseProduct("Fanta");
//                    Product dispensedProduct5 = vendingMachine.dispenseProduct("Fanta");
//
//                    System.out.println("---After Dispensing---");
//                    vendingMachine.displayProducts();

                System.out.println("**************************************************");
                VendingMachine vendingMachine2 = new VendingMachine();
                //call method for csv loadProductsFromCSV(product.csv)
                vendingMachine2.loadProductsFromCSV("product.csv");
//                vendingMachine2.addProduct();
vendingMachine2.displayProducts();

                //lets join a break out room
               // join room 10

                // DO NOT CLOSE THE FILE UNTIL WE GET BACK!
            }catch(IllegalArgumentException exception)
            {
                    System.out.println("Invalid Inputs :"+exception.getMessage());
            }
    }
}
