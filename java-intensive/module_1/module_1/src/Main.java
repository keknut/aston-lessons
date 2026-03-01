import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Пример использования собственной реализации HashMap
        MyHashMap<String, Integer> map = new MyHashMap<>();

        // Добавление элементов
        map.put("один", 1);
        map.put("два", 2);
        map.put("три", 3);

        // Получение значений
        System.out.println("Значение по ключу 'два': " + map.get("два")); // 2

        // Обновление значения
        map.put("два", 22);
        System.out.println("Обновлённое значение по ключу 'два': " + map.get("два")); // 22

        // Удаление элемента
        map.remove("три");
        System.out.println("После удаления 'три', значение по ключу 'три': " + map.get("три")); // null

        // Попытка получить несуществующий ключ
        System.out.println("Значение по ключу 'четыре': " + map.get("четыре")); // null
    }
}