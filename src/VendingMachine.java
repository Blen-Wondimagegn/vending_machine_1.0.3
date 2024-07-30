import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine {

    private Map<String,Slot<? extends Product>> slots;

    public VendingMachine(){
        this.slots = new HashMap<String,Slot<? extends Product>>();
    }

    //To add a Product
    public void addProduct(String code, Slot<?> slot)
    {
        if(code == null || code.isEmpty())
        {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        if(slot == null)
        {
            throw new IllegalArgumentException("Slot cannot be null");
        }
        slots.put(code, slot);
    }

    //To dispense product
    public Product dispenseProduct(String code) {
        //Validate Code
        if(code == null || code.isEmpty())
        {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        //Check if the code exists
        if(slots.containsKey(code))
        {
            if(slots.get(code).getQuantity() >0){
                slots.get(code).setQuantity(slots.get(code).getQuantity() - 1);
                String name = slots.get(code).getProduct().getName();
                double price = slots.get(code).getProduct().getPrice();
                printReceipt(name, price);
                return slots.get(code).getProduct();
            }else if(slots.get(code).getQuantity() ==0){
                String name = slots.get(code).getProduct().getName();
                sendVendorNotification(name);
            }
            else{
                System.out.println("Product Not Available");
            }
        }

        return null;
    }

    //To display product
    public void displayProducts() {
        for (Map.Entry<String, Slot<? extends Product>> entry : slots.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


    public void printReceipt(String name, double price)  {
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter("receipt.txt", true))) {
//
//            LocalDateTime now = LocalDateTime.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//            String timestamp = now.format(formatter);
//
//            writer.write("Product Name: " + name);
//            writer.newLine();
//            writer.write("Price: $" + price);
//            writer.newLine();
//            writer.write("Timestamp: " + timestamp);
//            writer.newLine();
//            writer.write("-----------------------------");
//            writer.newLine();
//
//        } catch (IOException e) {
//            System.err.println("Error writing to receipt file: " + e.getMessage());
//        }
        BufferedWriter writer = null;
        try {
            writer= new  BufferedWriter(new FileWriter("receipt.txt", true));
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = now.format(formatter);

            writer.write("Product Name: " + name);
            writer.newLine();
            writer.write("Price: $" + price);
            writer.newLine();
            writer.write("Timestamp: " + timestamp);
            writer.newLine();
            writer.write("-----------------------------");
            writer.newLine();
        }catch (IOException e){
            System.err.println("Error writing to receipt file: " + e.getMessage());
        }
        finally {
            try{
            writer.close();
            }catch (IOException e){
                System.err.println("Error writing to receipt file: " + e.getMessage());
            }

        }

    }

    private void sendVendorNotification(String name){
            String fileName = "notification_" + name.replaceAll("\\s", "_") + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write("Notification - " + LocalDateTime.now());
                writer.newLine();
                writer.write("Product Name: " + name);
                writer.newLine();
                writer.write("The product is out of stock.");
                writer.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void loadProductsFromCSV(String fileName){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("products.csv"));
            String line;
            while((line = reader.readLine()) != null){
                String [] parts = line.split(",");
                if(parts.length ==5){
                    String code =   parts[0];
                    String type = parts[1];
                    String name = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    int quantity = Integer.parseInt(parts[4]);

                    if(type.equalsIgnoreCase("snack")){
                        Snack snack = new Snack(name, quantity);
                        Slot<Snack> slot = new Slot<>(snack,quantity);
                        addProduct(code,slot);
                    }
                    if(type.equalsIgnoreCase("beverage")){
                        Beverage beverage = new Beverage(name,price);
                        Slot<Beverage> slot = new Slot<>(beverage,quantity);
                        addProduct(code,slot);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                reader.close();
            }catch (IOException e){
                System.err.println("Error writing to receipt file: " + e.getMessage());
            }
        }
    }
    @Override
    public String toString() {
        return "VendingMachine{" +
                "slots=" + slots +
                '}';
    }
}
