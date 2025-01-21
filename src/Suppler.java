import java.util.HashMap;
import java.util.Map;

class Supplier {
    private String name;
    private Map<String, Integer> supplies;

    public Supplier(String name) {
        this.name = name;
        this.supplies = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getSupplies() {
        return supplies;
    }

    public void supplyProduct(String productId, int quantity) {
        // Проверяем, есть ли продукт в списке поставок. Если есть, то добавляем к текущему количеству указанное количество.
        // Если продукта нет, то добавляем его в
        supplies.put(productId, supplies.getOrDefault(productId, 0) + quantity);
    }
}
