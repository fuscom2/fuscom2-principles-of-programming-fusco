public class Salesman {
    String name;
    String city;
    double commision;
    double totalSales;

    public Salesman (String name, String city, double commision, double totalSales) {
        this.name = name;
        this.city = city;
        this.commision = commision;
        this.totalSales = totalSales;
    }

    public String toString() {
        return "Name: " + name + ", City: " + city + ", commission: " + commision + ", Total Sales: " + totalSales;
    }

    public String getName() {
        return name;
    }

    public Double getSales() {
        return totalSales;
    }

    public Double getSalesCommission() {
        return totalSales * commision;
    }
}
