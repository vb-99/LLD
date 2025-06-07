package practice.lld;


public class ItemShelf {
    private ItemType itemType;
    private int quantity;
    private double itemPrice;

    public ItemShelf(ItemType itemType,int quantity, double itemPrice) {
        this.itemType = itemType;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }

    public void addItem(int quantity){
        this.quantity += quantity;
    }
    public void removeItem(int quantity){
        this.quantity -= quantity;
        if(this.quantity<0){
            this.quantity = 0;
        }
    }
    public boolean isEmpty(){
        return quantity==0;
    }
    public ItemType getItemType() {
        return itemType;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }


}
