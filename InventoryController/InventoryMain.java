package InventoryController;

import InventoryService.InventoryService;
import InventoryService.InventoryServiceInterface;
import Util.UserInputOutput;
import org.json.simple.JSONArray;

import java.util.Scanner;

public class InventoryMain {
    static Scanner input = new Scanner(System.in);
    static InventoryService service = new InventoryService();

        public static void main(String[] args) {
            JSONArray jsonArray = new JSONArray();
            boolean flag = true;
            while (flag) {
                int choice = UserInputOutput.getUserChoice();
                switch (choice) {
                    case 1:
                        System.out.println("\n" + "Add Inventory");
                        service.addItems(jsonArray);
                        flag = true;
                        break;
                    case 2:
                        System.out.println("\n" + "Edit Inventory");
                        jsonArray = service.readFile();
                        System.out.print("Enter the item name you want to edit: ");
                        String editedName = input.next();
                        jsonArray = service.editItems(jsonArray, editedName);
                        service.writeFile(jsonArray);
                        break;
                    case 3:
                        System.out.println("\n" + "Delete Inventory");
                        jsonArray = service.readFile();
                        System.out.print("Enter the item name you want to delete: ");
                        String deletedName = input.next();
                        jsonArray = service.removeItems(jsonArray, deletedName);
                        service.writeFile(jsonArray);
                        break;
                    case 4:
                        System.out.print("\n" + "View Inventory" + "\n");
                        jsonArray = service.readFile();
                        service.displayItems(jsonArray);
                        flag = true;
                        break;
                    case 5:
                        System.out.println("\n" + "Total value of Inventory");
                        jsonArray = service.readFile();
                        service.totalValueOfInventory(jsonArray);
                        break;
                    case 6:
                        System.out.println("\n" + "Total weight of Inventory");
                        jsonArray = service.readFile();
                        service.totalWeightOfInventory(jsonArray);
                        break;
                    case 7:
                        System.out.println("\n" + "Total price of Inventory");
                        jsonArray = service.readFile();
                        service.totalPriceOfInventory(jsonArray);
                        break;
                    case 8:
                        flag = false;
                        break;
                }
            }
        }

    }
