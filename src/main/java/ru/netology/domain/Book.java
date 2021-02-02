package ru.netology.domain;

public class Book extends Product{
    private String author;

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    @Override
    public boolean matches(String search){
        boolean searchByName = super.matches(search);
        if (searchByName){
            return true;
        }
        return this.getAuthor().equalsIgnoreCase(search);
    }
}
