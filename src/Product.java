// Класс, представляющий продукт
class Product {
    private String id; // Идентификатор продукта
    private String name; // Название продукта

    // Конструктор класса Product
    public Product(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Получение идентификатора продукта
    public String getId() {
        return id;
    }

    // Получение названия продукта
    public String getName() {
        return name;
    }
}