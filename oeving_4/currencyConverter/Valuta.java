package currencyConverter;

public class Valuta {
    private String name;
    private double exchangeRate;

    public Valuta() {
        this.name = "Unknown currency";
        this.exchangeRate = 1.0;
    }

    public Valuta(String name) {
        this.name = name;
        this.exchangeRate = 1.0;
    }

    public Valuta(String name, double exchangeRate) {
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    public String getName() {
        return name;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double toNok(double amount) {
        return amount * exchangeRate;
    }

    public double fromNok(double nokAmount) {
        return nokAmount / exchangeRate;
    }
}
