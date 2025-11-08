import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

interface Shipping {
    double getCost(Order order);
    String getDate(Order order);
}

class Ground implements Shipping {
    @Override
    public double getCost(Order order) {
        if (order.getTotal() > 100) {
            return 0;
        }
        return Math.max(10, order.getTotalWeight() * 1.5);
    }

    @Override
    public String getDate(Order order) {
        return LocalDate.now().plusDays(5).toString();
    }
}

class Air implements Shipping {
    @Override
    public double getCost(Order order) {
        return order.getTotalWeight() * 3;
    }

    @Override
    public String getDate(Order order) {
        return LocalDate.now().plusDays(2).toString();
    }
}

class Order {
    private List<Double> lineItems;
    private Shipping shipping;

    public Order(List<Double> lineItems) {
        this.lineItems = lineItems;
    }

    public double getTotalWeight() {
        return lineItems.stream().mapToDouble(Double::doubleValue).sum() / 10;
    }

    public double getTotal() {
        return lineItems.stream().mapToDouble(Double::doubleValue).sum();
    }

    public void setShippingType(Shipping shipping) {
        this.shipping = shipping;
    }

    public double getCost() {
        return shipping.getCost(this);
    }

    public String getShippingDate() {
        return shipping.getDate(this);
    }
}

public class ShippingSysteme {
    public static void main(String[] args) {
        Order order = new Order(Arrays.asList(50.0, 30.0, 20.0));

        order.setShippingType(new Ground());
        System.out.println("Ground Shipping Cost: $" + order.getCost());
        System.out.println("Delivery Date: " + order.getShippingDate());

        order.setShippingType(new Air());
        System.out.println("\nAir Shipping Cost: $" + order.getCost());
        System.out.println("Delivery Date: " + order.getShippingDate());
    }
}
