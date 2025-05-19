package practice.lld.product;

public abstract class Product {
    private String sku;
    private String name;
    private double price;
    private int quantity;
    private int threshold;
    private ProductCategory category;

    protected Product(ProductBuilder<?> builder) {
        this.sku = builder.sku;
        this.name = builder.name;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.threshold = builder.threshold;
        this.category = builder.category;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public int getThreshold() {
        return threshold;
    }

    public static abstract class ProductBuilder<T extends ProductBuilder<T>>{
        private String sku;
        private String name;
        private double price;
        private int quantity;
        private int threshold;
        private ProductCategory category;

        public ProductBuilder(String sku, String name, double price, int quantity, int threshold, ProductCategory category) {
            this.sku = sku;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.threshold = threshold;
            this.category = category;
        }
        public T sku(String sku){
            this.sku = sku;
            return self();
        }
        public T name(String name){
            this.name = name;
            return self();
        }
        public T price(double price){
            this.price = price;
            return self();
        }
        public T quantity(int quantity){
            this.quantity = quantity;
            return self();
        }

        public T threshold(int threshold){
            this.threshold = threshold;
            return self();
        }
        public T category(ProductCategory category){
            this.category = category;
            return self();
        }
        protected abstract T self();
        public abstract Product build();
    }

}
