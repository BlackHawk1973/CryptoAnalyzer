package com.javarush.burykh.cryptoanalyzer.consoleui;

import com.javarush.burykh.cryptoanalyzer.caesar.Coder;
import com.javarush.burykh.cryptoanalyzer.caesar.exception.CoderException;
import com.javarush.burykh.cryptoanalyzer.consoleui.exception.InvalidUserInputException;
import com.javarush.burykh.cryptoanalyzer.file.exception.FileManagerException;

import java.util.Scanner;

public class MainMenu {
    private final String WELCOME_MESSAGE = "Добро пожаловать в Криптоанализатор!";
    private final String OPERATION_PATTERN = "%d - %s \n";
    private final String TRY_AGAIN_COMMAND = "да";
    private final Scanner scan;
    private final Coder coder;
    public MainMenu() {
        scan = new Scanner(System.in);
        coder = new Coder();
    }

    public void start() {
        showMenu();
        MenuCommand command = readCommand();
        doCommand(command);
        

    }

    private void showMenu() {
        System.out.println(WELCOME_MESSAGE);
        System.out.println("Выберите действие");
        for (MenuCommand command : MenuCommand.values()) {
            System.out.printf(OPERATION_PATTERN, command.getNumber(), command.getDescription());
        }
    }

    private MenuCommand readCommand() {
        boolean isTryAgain = false;
        do {
            try {
                int choice = readInt();
                return MenuCommand.command(choice);
            } catch (IllegalArgumentException | InvalidUserInputException e ) {
                System.out.println("Неверная операция!");
                System.out.println("Причина: " + e.getMessage());
                System.out.println("Введите 'да' для подолжения или другой символ для выхода");

                String input = readString();
                if (TRY_AGAIN_COMMAND.equalsIgnoreCase(input)) {
                    isTryAgain = true;
                }
            }
        } while (isTryAgain);
        return MenuCommand.EXIT;
    }



    private void doCommand(MenuCommand command) {
        switch (command) {
            case EXIT -> commandExit();
            case ENCRIPTION -> commandEncription();
            case DECRIPTION -> commandDecription();
        }
    }



    private void commandEncription() {
        System.out.println("Введите имя исходного файла: ");
        String inputFileName = readString();
        System.out.println("Введите имя файла для шифрования: ");
        String outputFileName = readString();
        System.out.println("Введите ключ шифрования: ");
        int shiftKey = readInt();

        try {
            coder.encrypt(inputFileName, outputFileName, shiftKey);
            System.out.println("Выполнено.");
        } catch (FileManagerException | CoderException e) {
            System.err.println("Что-то пошло не так: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void commandDecription() {
        System.out.println("Введите имя зашифрованного файла: ");
        String inputFileName = readString();
        System.out.println("Введите имя файла для расшифровки: ");
        String outputFileName = readString();
        System.out.println("Введите ключ расшифровки: ");
        int shiftKey = readInt();

        try {
            coder.decrypt(inputFileName, outputFileName, shiftKey);
            System.out.println("Выполнено");
        } catch (FileManagerException | CoderException e) {
            System.err.println("Что-то пошло не так: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private void commandExit() {
        System.out.println("До свидания.");
    }

    private int readInt() {
        String input = scan.nextLine();
        try {
            return Integer.parseInt(input);
        }  catch (NumberFormatException e) {
            throw new InvalidUserInputException("Неправильный ввод.", e);
        }
    }

    private String readString() {
        return scan.nextLine();
    }

}
