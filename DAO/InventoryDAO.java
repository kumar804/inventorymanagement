package DAO;

import InventoryModel.Inventory;
import InventoryService.InventoryServiceInterface;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InventoryDAO implements InventoryServiceInterface {
    Scanner input = new Scanner(System.in);
    String filepath = "C:\\Users\\Manish Kumar Singh\\IdeaProjects\\Inventory\\src\\InventoryController\\inventory.json";

    @Override
    public void writeFile(JSONArray array) {
        try {
            FileWriter fw = new FileWriter(filepath);
            fw.write(array.toString());
            fw.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        readFile();
    }

    @Override
    public JSONArray readFile() {
        JSONParser jsonParser = new JSONParser();
        JSONArray inventory = null;
        try {
            FileReader reader = new FileReader(filepath);
            inventory = (JSONArray) jsonParser.parse(reader);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        return inventory;
    }


    @Override
    public JSONArray addItems(JSONArray array) {

        Inventory inventory=new Inventory();
        System.out.println("Enter the name of the item");
        inventory.setName(input.next());
        System.out.println("Enter the price of the item");
        inventory.setPrice(input.nextDouble());
        System.out.println("Enter the weight of the item");
        inventory.setWeight(input.nextDouble());

        JSONObject jsonObject=new JSONObject();
        jsonObject.put("Name", inventory.getName());
        jsonObject.put("Price", inventory.getPrice());
        jsonObject.put("Weight", inventory.getWeight());
        array.add(jsonObject);

        writeFile(array);
        return array;
    }
    @Override
    public JSONArray editItems(JSONArray array, String name) {
        JSONObject jsonObject=null;
        for (int i = 0; i < array.size(); i++) {
            String existingName=(String) jsonObject.get("Name");
            if(existingName.equalsIgnoreCase(name)){
                System.out.println("Enter 1. Price Change 2. Weight Change");
                int option = input.nextInt();
                switch(option) {
                    case 1:
                        System.out.print("Enter the updated price: ");
                        jsonObject.replace("Price", input.nextDouble());
                        //jsonObject.put("Price", input.nextDouble());
                        break;
                    case 2:
                        System.out.print("Enter the updated weight: ");
                        jsonObject.replace("Weight", input.nextDouble());
                        // jsonObject.put("Weight", input.nextDouble());
                        break;
                }
            }
        }
        return array;
    }
    @Override
    public void displayItems(JSONArray array) {
        System.out.println(array + "\n");
    }
    @Override
    public void totalValueOfInventory(JSONArray array){
        JSONObject obj = null;
        double totalValue = 0;
        for (int i = 0; i < array.size(); i++) {
            obj=(JSONObject) array.get(i);
            double price=(double) obj.get("Price");
            double weight=(double) obj.get("Weight");
            totalValue = totalValue + price * weight;
        }
        System.out.println("The total value of the Inventory is: " +totalValue);
    }
    @Override
    public void totalWeightOfInventory(JSONArray array) {
        JSONObject obj = null;
        double totalWeight = 0;
        for (int i = 0; i < array.size(); i++){
            obj=(JSONObject) array.get(i);
            double weight=(double) obj.get("Weight");
            totalWeight = totalWeight + weight;

        }
        System.out.println("The total weight of the Inventory is: " +totalWeight);
    }
    @Override
    public void totalPriceOfInventory(JSONArray array) {
        JSONObject obj = null;
        double totalPrice = 0;
        for (int i = 0; i < array.size(); i++) {
            obj=(JSONObject) array.get(i);
            double price=(double) obj.get("Price");
            totalPrice = totalPrice + price;
        }
        System.out.println("The total weight of the Inventory is: " +totalPrice);
    }
    @Override
    public JSONArray removeItems(JSONArray array, String name) {
        JSONObject jsonObject=null;
        for (int i = 0; i < array.size(); i++) {
            jsonObject=(JSONObject) array.get(i);
            String nameFound=(String) jsonObject.get("Name");
            if(nameFound.equalsIgnoreCase(name)) {
                array.remove(jsonObject);
            }
        }
        return array;
    }
}
