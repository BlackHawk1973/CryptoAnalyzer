package com.javarush.burykh.cryptoanalyzer.caesar;

import java.util.Arrays;

public class Cipher {
    private final char[] alphabet = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й',
            'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
            'х', 'ц', 'ч', 'ш', 'щ', 'ь', 'ы', 'ъ', 'э', 'ю', 'я',
            '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', ' ',
            ',', '.', '«', '»', '"', '\'', '/', ':', ';', '!', '?',
            '(', ')', '<', '>', '@', '$', '%', '&', '-', '+', '*'
    };


    public String encript(String text, int shift) {
        text = text.toLowerCase();
        char[] chars = text.toCharArray();

        if (shift > alphabet.length) {
            shift = shift % alphabet.length;
        }
        if (shift == 0) {
            return  text;
        }

        for (int i = 0; i < chars.length; i++) {
            //char c = chars[i];
            int index = 0;
            for (int j = 0; j < alphabet.length; j++) {
                if (alphabet[j] == chars[i]) {
                    index = j;
                    break;
                }
            }

            if (index + shift >= alphabet.length) {
                index = index + shift - alphabet.length;
            } else if (index + shift < 0) {
                index = index + shift + alphabet.length;
            } else {
                index = index + shift;
            }

            chars[i] = alphabet[index];
        }
        
        return String.valueOf(chars);
    }

    public String decript(String text, int shift)
    {
        return encript(text, -shift);
    }
}
