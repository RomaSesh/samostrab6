import java.util.*;

class SupplyManager {
    private List<Supplier> suppliers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();

    // Добавляет поставщика в список поставщиков
    public void addSupplier(Supplier supplier) {
        suppliers.add(supplier);
    }

    // Добавляет продукт в список продуктов
    public void addProduct(Product product) {
        products.add(product);
    }

    // Поставляет продукт от поставщика
    public void supplyProduct(String supplierName, String productId, int quantity) {
        for (Supplier supplier : suppliers) {
            if (supplier.getName().equals(supplierName)) {
                supplier.supplyProduct(productId, quantity);
                break;
            }
        }
    }

    // Возвращает список непоставленных продуктов
    public List<String> getUnsuppliedProducts() {
        List<String> unsupplied = new ArrayList<>();
        for (Product product : products) {
            boolean isSupplied = suppliers.stream()
                    .anyMatch(supplier -> supplier.getSupplies().containsKey(product.getId()));
            if (!isSupplied) {
                unsupplied.add(product.getName());
            }
        }
        return unsupplied;
    }

    // Возвращает продукт, который был поставлен наибольшее количество раз
    public String getMostSuppliedProduct() {
        HashMap<String, Integer> totalSupplies = new HashMap<>();
        for (Supplier supplier : suppliers) {
            for (HashMap.Entry<String, Integer> entry : supplier.getSupplies().entrySet()) {
                totalSupplies.put(entry.getKey(), totalSupplies.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        return totalSupplies.entrySet().stream()
                .max(HashMap.Entry.comparingByValue())
                .map(entry -> "Product ID: " + entry.getKey() + ", Total Quantity: " + entry.getValue())
                .orElse("No supplies available");
    }

    // Возвращает общее количество поставок для продукта
    public HashMap<Object, Object> getTotalSuppliesForProduct(String productId) {
        HashMap<Object, Object> totalSupplies = new HashMap<>();
        for (Supplier supplier : suppliers) {
            int quantity = supplier.getSupplies().getOrDefault(productId, 0);
            if (quantity > 0) {
                totalSupplies.put(supplier.getName(), quantity);
            }
        }
        return totalSupplies;
    }

    // Возвращает список поставщиков для продукта
    public List<String> getSuppliersForProduct(String productId) {
        List<String> supplierNames = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            if (supplier.getSupplies().containsKey(productId)) {
                supplierNames.add(supplier.getName());
            }
        }
        return supplierNames;
    }

    // Возвращает отсортированный список поставок
    public List<HashMap.Entry<String, Integer>> getSortedSupplies() {
        HashMap<String, Integer> totalSupplies = new HashMap<>();
        for (Supplier supplier : suppliers) {
            for (HashMap.Entry<String, Integer> entry : supplier.getSupplies().entrySet()) {
                totalSupplies.put(entry.getKey(), totalSupplies.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
        }
        List<HashMap.Entry<String, Integer>> sortedSupplies = new ArrayList<>(totalSupplies.entrySet());
        sortedSupplies.sort((Comparator<? super HashMap.Entry<String, Integer>>) HashMap.Entry.comparingByValue().reversed());
        return sortedSupplies;
    }
}