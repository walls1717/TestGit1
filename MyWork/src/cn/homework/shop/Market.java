package cn.homework.shop;

public class Market {
    private Product[] products; //商品仓库
    private final String NAME= "CJ超市";

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public String getNAME() {
        return NAME;
    }

    public Product sell(String name) {
        for(int i = 0; i < products.length; i++) {
            if(name == products[i].getProName()) {
                return products[i];
            }
        }
        return null;
    }
}
