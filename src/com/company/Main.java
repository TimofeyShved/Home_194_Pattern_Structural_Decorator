package com.company;

public class Main {

    public static void main(String[] args) {
        // Данный паттерн (Декоратор), помогает не меняя код сделать надстойку возможностей
        // выбранному классу

        // обычный вид
        IFile file = new FileRead();
        file.read();

        // надстройки
        IFile file1 = new FileReadInDecorator(new FileRead());
        file1.read();
    }
}

// обычный класс
interface IFile{
    void read();
}

class  FileRead implements IFile{
    @Override
    public void read() {
        System.out.println("read file");
    }
}

// создание надстройки
abstract class FileDecorator implements IFile{
    IFile file;

    public FileDecorator(IFile file) {
        this.file = file;
    }

    @Override
    public abstract void read();
}

class FileReadInDecorator extends  FileDecorator{
    public FileReadInDecorator(IFile file) {
        super(file);
    }

    @Override
    public void read() {
        System.out.println("Decorator read file");
        file.read();
    }
}