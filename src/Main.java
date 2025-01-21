public class Main {
    public static void main(String[] args) {
        SupplyManager manager = new SupplyManager();

        Supplier supplier1 = new Supplier("Supplier A");
        Supplier supplier2 = new Supplier("Supplier B");

        manager.addSupplier(supplier1);
        manager.addSupplier(supplier2);

        Product product1 = new Product("1", "Product 1");
        Product product2 = new Product("2", "Product 2");

        manager.addProduct(product1);
        manager.addProduct(product2);

        manager.supplyProduct("Supplier A", "1", 100);
        manager.supplyProduct("Supplier A", "2", 50);
        manager.supplyProduct("Supplier B", "1", 30);

        System.out.println("Unsupplied Products: " + manager.getUnsuppliedProducts());
        System.out.println("Most Supplied Product: " + manager.getMostSuppliedProduct());
        System.out.println("Total Supplies for Product 1: " + manager.getTotalSuppliesForProduct("1"));
        System.out.println("Suppliers for Product 1: " + manager.getSuppliersForProduct("1"));
        System.out.println("Sorted Supplies: " + manager.getSortedSupplies());
    }
}

