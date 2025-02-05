public class Main {
    public static void main(String[] args) {
        SupplyManager manager = new SupplyManager(); // Создание менеджера поставок

        Supplier supplier1 = new Supplier("Supplier A"); // Создание первого поставщика
        Supplier supplier2 = new Supplier("Supplier B"); // Создание второго поставщика

        manager.addSupplier(supplier1); // Добавление первого поставщика в менеджер
        manager.addSupplier(supplier2); // Добавление второго поставщика в менеджер

        Product product1 = new Product("1", "Product 1"); // Создание первого продукта
        Product product2 = new Product("2", "Product 2"); // Создание второго продукта

        manager.addProduct(product1); // Добавление первого продукта в менеджер
        manager.addProduct(product2); // Добавление второго продукта в менеджер

        // Поставка продуктов от поставщиков
        manager.supplyProduct("Supplier A", "1", 100);
        manager.supplyProduct("Supplier A", "2", 50);
        manager.supplyProduct("Supplier B", "1", 30);

        // Вывод информации о поставках
        System.out.println("Unsupplied Products: " + manager.getUnsuppliedProducts());
        System.out.println("Most Supplied Product: " + manager.getMostSuppliedProduct());
        System.out.println("Total Supplies for Product 1: " + manager.getTotalSuppliesForProduct("1"));
        System.out.println("Suppliers for Product 1: " + manager.getSuppliersForProduct("1"));
        System.out.println("Sorted Supplies: " + manager.getSortedSupplies());
    }
}
