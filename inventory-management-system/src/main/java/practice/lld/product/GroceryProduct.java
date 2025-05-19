package practice.lld.product;

import java.time.LocalDate;

public class GroceryProduct extends Product{

    private LocalDate expiryDate;

    private GroceryProduct(GroceryProductBuilder builder) {
        super(builder);
        this.expiryDate = builder.expiryDate;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public static class GroceryProductBuilder extends ProductBuilder<GroceryProductBuilder>{
        private LocalDate expiryDate;

        public GroceryProductBuilder(String sku, String name, double price, int quantity, int threshold, ProductCategory category) {
            super(sku, name, price, quantity, threshold, category);
        }
        public GroceryProductBuilder expiryDate(LocalDate expiryDate){
            this.expiryDate = expiryDate;
            return this;
        }
        @Override
        public GroceryProduct build() {
            return new GroceryProduct(this);
        }
        @Override
        public GroceryProductBuilder self() {
            return this;
        }
    }

}
