/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexandre
 */
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Warehouse {

    private Map<String, Integer> storage;
    private Map<String, Integer> stocks;

    public Warehouse() {
        this.storage = new HashMap<>();
        this.stocks = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        this.stocks.put(product, stock);
        this.storage.put(product, price);
    }

    public int price(String product) {
        return this.storage.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return this.stocks.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (this.stocks.containsKey(product)) {
            int stock = this.stocks.get(product);
            if (stock > 0) {
                stock--;
                this.stocks.replace(product, stock);
                return true;
            }
        }
        return false;

    }
    
    public Set<String> products(){
        return this.stocks.keySet();
    }
}
