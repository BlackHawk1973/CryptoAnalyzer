package com.javarush.burykh.cryptoanalyzer.consoleui;

public enum MenuCommand {
    ENCRIPTION(1, "Зашифровать файл"),
    DECRIPTION(2, "Расшифровать файл"),
    EXIT(0, "Выход");

    private final int number;
    private final String description;

    MenuCommand(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {return number;}
    public String getDescription() {return description;}

    public static MenuCommand command(int number) {
        for (MenuCommand command : MenuCommand.values()) {
            if (command.getNumber() == number) {
                return command;
            }
        }
        throw new IllegalArgumentException("Выбрана несуществующая операция!");
    }
}

