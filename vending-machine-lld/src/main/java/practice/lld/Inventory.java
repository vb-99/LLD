package practice.lld;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    List<ItemShelf> itemShelves;

    public Inventory() {
       this.itemShelves = new ArrayList<>();
    }
    public void addItemToShelf(ItemType itemType, int quantity, double price){
        boolean isShelfPresent = false;
        for(ItemShelf itemShelf:itemShelves){
            if(itemShelf.getItemType()==itemType){
                boolean isItemPresent = true;
                itemShelf.addItem(quantity);
            }
        }
        if(!isShelfPresent){
            ItemShelf itemShelf = new ItemShelf(itemType,quantity,price);
            itemShelves.add(itemShelf);
        }
    }
    public void removeItemFromShelf(ItemType itemType, int quantity){
        for(ItemShelf itemShelf:itemShelves){
           if(itemShelf.getItemType()==itemType){
               itemShelf.removeItem(quantity);
               break;
           }
        }
    }
    public int getQuantity(ItemType itemType){
        for(ItemShelf itemShelf:itemShelves){
            if(itemShelf.getItemType()==itemType){
                return itemShelf.getQuantity();
            }
        }
        return 0;
    }
    public double getItemPrice(ItemType itemType){
        for(ItemShelf itemShelf:itemShelves){
            if(itemShelf.getItemType()==itemType){
                return itemShelf.getItemPrice();
            }
        }
        return 0;
    }





}
