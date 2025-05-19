package practice.lld.product;

public class ElectronicsProduct extends Product{
    private String brand;
    private int warrantyPeriod; // in months

    private ElectronicsProduct(ElectronicsProductBuilder builder) {
        super(builder);
        this.brand = builder.brand;
        this.warrantyPeriod = builder.warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public static class ElectronicsProductBuilder extends ProductBuilder<ElectronicsProductBuilder>{
        private String brand;
        private int warrantyPeriod;

        public ElectronicsProductBuilder(String sku, String name, double price, int quantity, int threshold, ProductCategory category) {
            super(sku, name, price, quantity, threshold, category);
        }

        public ElectronicsProductBuilder brand(String brand){
            this.brand = brand;
            return this;
        }
        public ElectronicsProductBuilder warrantyPeriod(int warrantyPeriod){
            this.warrantyPeriod = warrantyPeriod;
            return this;
        }
        @Override
        public ElectronicsProduct build() {
            return new ElectronicsProduct(this);
        }
        @Override
        public ElectronicsProductBuilder self() {
            return this;
        }
    }

}
