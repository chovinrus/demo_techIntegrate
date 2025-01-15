package demo.zjm._07_建造者模式实现不可变对象.target;

/**
 * @program: DesignPattern
 * @ClassName: Obj
 * @description:
 * @author: AlanMa
 * @create: 2024-01-10 10:36
 */
public class Product {
    final private String component1;
    final private String component2;
    final private String component3;

    private Product(Builder builder) {
        this.component1 = builder.component1;
        this.component2 = builder.component2;
        this.component3 = builder.component3;
    }

    @Override
    public String toString() {
        return "Product{" +
                "component1='" + component1 + '\'' +
                ", component2='" + component2 + '\'' +
                ", component3='" + component3 + '\'' +
                '}';
    }

    public static class Builder {
        private String component1;
        private String component2;
        private String component3;

        public Builder setComponent1(String component1) {
            this.component1 = component1;
            return this;
        }

        public Builder setComponent2(String component2) {
            this.component2 = component2;
            return this;
        }

        public Builder setComponent3(String component3) {
            this.component3 = component3;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
