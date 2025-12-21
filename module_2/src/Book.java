package src;

public class Book {
    private String title;
    private int pages;
    private int year;

    public Book(String title, int pages, int year) {
        this.title = title;
        this.pages = pages;
        this.year = year;
    }

    /* Getters
     */
    public String getTitle() { return title; }
    public int getPages() { return pages; }
    public int getYear() { return year; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return pages == book.pages && year == book.year && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return title.hashCode() + pages + year;
    }

    @Override
    public String toString() {
        return String.format("'%s' (%d стр., %d г.)", title, pages, year);
    }
}
