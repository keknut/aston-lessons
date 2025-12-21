package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputStream is = Main.class.getResourceAsStream("db.txt");

        if (is == null) {
            System.err.println("Error: файл db.txt не найден в classpath");
            return;
        }

        List<Student> students = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            List<String> lines = reader.lines().toList();

            String name = null;
            List<Book> books = new ArrayList<>();

            for (String line : lines) {
                line = line.trim();
                
                if (line.isEmpty()) {
                    /* Если пустая строка разделитель
                    */
                    if (name != null) {
                        /* Если имя студента уже определено,
                        *    добавляем его в список
                        */
                        students.add(new Student(name, new ArrayList<>(books)));
                        /* Очищаем список книг
                        */
                        books.clear();
                        /* Очищаем имя студента
                        */
                        name = null;
                    }
                } else if (name == null) {
                    /* Если имя студента еще не определено,
                    *  запонминаем студента
                    */
                    name = line;
                } else {
                    /* Если строка не пустая и имя студента определено,
                    *   добавляем книгу в список
                    */

                    /* Разбиваем строку с книгами на части
                     */
                    String[] parts = line.split(":");
                    if (parts.length == 3) {
                        /* Если строка с книгой соответствует формату
                         */
                        String title = parts[0].trim();
                        int pages = Integer.parseInt(parts[1].trim());
                        int year = Integer.parseInt(parts[2].trim());
                        books.add(new Book(title, pages, year));
                    }
                }
            }

            /* После цикла добавляем последнего студента в список
             */
            if (name != null) {
                students.add(new Student(name, books));
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e.getMessage());
        }

        /* Вывод для проверки
         */
        // System.out.println("=== Студенты из файла ===");
        // students.forEach(System.out::println);
        // System.out.println();

        /* Основное задание через один стрим
         */

        System.out.println("=== Результат обработки одним стримом ===");

        students.stream()
            .peek(System.out::println)
            .flatMap(student -> student.getBooks().stream())
            .distinct()
            .filter(book -> book.getYear() > 2000)
            .sorted(Comparator.comparing(Book::getPages))
            .limit(3)
            .map(Book::getYear)
            .findFirst()
            .ifPresentOrElse(
                year -> System.out.println("Год выпуска найденной книги: " + year),
                () -> System.out.println("Такая книга отсутсвует")
            );
                
    }
}
