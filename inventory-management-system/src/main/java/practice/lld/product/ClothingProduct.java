package practice.lld.product;

public class ClothingProduct extends Product {
    private String size;
    private String color;

    private ClothingProduct(ClothingProductBuilder builder) {
       super(builder);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public static class ClothingProductBuilder extends ProductBuilder<ClothingProductBuilder>{
        private String size;
        private String color;
        public ClothingProductBuilder(String sku, String name, double price, int quantity, int threshold, ProductCategory category) {
            super(sku, name, price, quantity, threshold, category);
        }
        public ClothingProductBuilder size(String size){
            this.size = size;
            return this;
        }
        public ClothingProductBuilder color(String color){
            this.color = color;
            return this;
        }
        @Override
        public ClothingProduct build() {
            return new ClothingProduct(this);
        }
        @Override
        public ClothingProductBuilder self() {
            return this;
        }
    }
}
