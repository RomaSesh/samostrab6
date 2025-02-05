import java.util.HashMap;
import java.util.Map;

// Класс, представляющий поставщика
class Supplier {
    private String name; // Название поставщика
    private Map<String, Integer> supplies; // Список поставляемых продуктов и их количество

    // Конструктор класса Supplier
    public Supplier(String name) {
        this.name = name;
        this.supplies = new HashMap<>();
    }

    // Получение имени поставщика
    public String getName() {
        return name;
    }

    // Получение списка поставок
    public Map<String, Integer> getSupplies() {
        return supplies;
    }

    // Метод для поставки продукта
    public void supplyProduct(String productId, int quantity) {
        // Добавляет количество продукта в список поставок
        supplies.put(productId, supplies.getOrDefault(productId, 0) + quantity);
    }
}