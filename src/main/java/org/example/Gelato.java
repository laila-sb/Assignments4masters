package org.example;

public class Gelato extends Dessert{
    private final GelatoFlavors flavor;

    //String vessel;

    //constructor
    public Gelato(GelatoFlavors flavor, double pricePerScoop){
        this.flavor = flavor;
        this.pricePerScoop = pricePerScoop;
    }

    //method total price
    public double calculatePrice(int scoops){
        return scoops * pricePerScoop;
    }

    //method to display flavor + price
    @Override
    public void displayInfo(){
        System.out.println("Gelato flavor: " + flavor + " | Total price: " + pricePerScoop);
    }

    //another method

    public GelatoFlavors getFlavor() {
        return flavor;
    }


    public double getPricePerScoop() {
        return pricePerScoop;
    }

    private void setPricePerScoop(double pricePerScoop) {
        this.pricePerScoop = pricePerScoop;
    }

}
