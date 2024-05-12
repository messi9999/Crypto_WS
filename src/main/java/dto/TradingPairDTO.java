package dto;

public class TradingPairDTO {
    private float price;
    private float quantity;

    public TradingPairDTO(float newPrice, float newQuantity) {
        price = newPrice;
        quantity = newQuantity;
    }

    public TradingPairDTO(String newPrice, String newQuantity) {
        price = Float.parseFloat(newPrice);
        quantity =  Float.parseFloat(newQuantity);
    }

    public String getPrice() {
        return String.format("%.8f", price);
    }

    public String getQuantity() {
        return String.format("%.8f", quantity);
    }

    public void setPrice(float newPrice) {
        price = newPrice;
    }

    public void setQuantity(float newQuantity) {
        quantity = newQuantity;
    }

    public float totalPrice() {
        return price * quantity;
    }

    public void print() {
        System.out.printf("Price: %.8f, Quality: %.8f%n", price, quantity);
    }
}
