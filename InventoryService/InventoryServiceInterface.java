package InventoryService;

import org.json.simple.JSONArray;

public interface InventoryServiceInterface {
    void writeFile(JSONArray array);
    JSONArray readFile();
    JSONArray addItems(JSONArray array);
    JSONArray editItems(JSONArray array,String name);
    JSONArray removeItems(JSONArray array,String name);
    void displayItems(JSONArray array);
    void totalValueOfInventory(JSONArray array);
    void totalWeightOfInventory(JSONArray array);
    void totalPriceOfInventory(JSONArray array);
}
