package chucknorris;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        // wczytanie tekstu od uzytkownika
        //StringBuilder mainText = new StringBuilder(new Scanner(System.in).nextLine());
        StringBuilder tempText = new StringBuilder();
        // sprawdzenie czy cos zostalo wpisane
        //if (text.length() > 0) { //usuniete dla Stage 2/5
            //wyswietlenie tekstu w formie binarnej STAGE 2/5
            //System.out.println(" ");
        // zakomentowany do stage 4/5
    //    tempText = changeTextToBinary(mainText); // przerabia tekst zwykly na binarny
        //System.out.println(tempText);
        // zakomentowany do stage 4/5
    //    tempText = encryptBinaryTextToZeros(tempText); // szyfruje tekst binarny na format 0 00 0000 00
        for(;;) {
            System.out.println("Please input operation (encode/decode/exit):");
            String menuFromUser = new Scanner(System.in).nextLine();
            switch (menuFromUser) {
                case "encode": {
                    System.out.println("Input string:");
                    tempText = new StringBuilder(new Scanner(System.in).nextLine());
                    tempText = changeTextToBinary(tempText);
                    tempText = encryptBinaryTextToZeros(tempText);
                    System.out.println("Encoded string:");
                    printResult(tempText);
                    break;
                }
                case "decode": {
                    System.out.println("Input encoded string:");
                    tempText = new StringBuilder(new Scanner(System.in).nextLine());
                    tempText = decodeEncodedText(tempText);
                    tempText = changeBinaryToText(tempText);
                    System.out.println("Decoded string:");
                    printResult(tempText);
                    break;
                }
                case "exit": {
                    System.out.println("Bye");
                    System.exit(0);
                }
                default: {
                    System.out.printf("There is no %s operation", menuFromUser);
                }
            }
        }
        //tempText = encryptBinaryTextToZeros(tempText);
         // wyswietla tekst zaszyfrowany
/*            // wstawienie spacji po kazdym znaku STAGE 1/5
            for (int i = 0; i < text.length(); i++) {
                textOutput.append(text.charAt(i)).append(' ');
            }
            // usuniecie spacji na koncu napisu
            textOutput.deleteCharAt(textOutput.length() - 1);
            // wyswietlenie tekstu
            //System.out.println(textOutput);

 */
        //}
    }

    private static StringBuilder changeBinaryToText(StringBuilder inputText) {
        StringBuilder resultText = new StringBuilder(); // binary text

        for (int i = 0; i < inputText.length() / 7; i++) {
            resultText.append((char)Byte.parseByte(inputText.substring(i * 7, (i+1) * 7) , 2));
        }

        return resultText;
    }

    private static StringBuilder decodeEncodedText(StringBuilder mainText) {
        StringBuilder resultText = new StringBuilder();
        int counter0 = 0;
        int counter1 = 0;
        boolean flag0 = false;
        boolean flag1 = false;
        for (int i = 0; i < mainText.length(); i++) {
            if (mainText.charAt(i) == '0') { // '0'
                if (flag0) counter0++;
                if (flag1) counter1++;
                if (!flag0 && !flag1) {
                    if (mainText.charAt(i + 1) == '0') { //znacznik '0'
                        flag0 = true;
                        i++;
                    } else {
                        flag1 = true;
                    }
                }
            } else { // ' '
                if (counter0 > 0) {
                    for (int j = 0; j < counter0; j++) {
                        resultText.append("0");
                    }
                    counter0 = 0;
                    flag0 = false;
                }
                if (counter1 > 0) {
                    for (int j = 0; j < counter1; j++) {
                        resultText.append("1");
                    }
                    counter1 = 0;
                    flag1 = false;
                }
            }
        }
        if (counter0 > 0) {
            for (int j = 0; j < counter0; j++) {
                resultText.append("0");
            }
        }
        if (counter1 > 0) {
            for (int j = 0; j < counter1; j++) {
                resultText.append("1");
            }
        }
        return resultText;
    }

    private static StringBuilder encryptBinaryTextToZeros(StringBuilder textToEncrypted) {
        StringBuilder encryptedText = new StringBuilder();
        boolean flag0 = false;
        boolean flag1 = false;

        int counter0 = 0;
        int counter1 = 0;

        for (int i = 0; i < textToEncrypted.length(); i++) {
            if (textToEncrypted.charAt(i) == '0') { // dla binarnego 0
                flag0 = true;
                counter0++;
                if (flag1) {
                    flag1 = false;

                    encryptedText.append("0 "); // 0 oznacza 1 binarnie
                    for (int j = 0; j < counter1; j++) {  // dodaje ilosc znakow 1 w postaci 0
                        encryptedText.append("0");
                    }
                    encryptedText.append(" "); // dodaje spacje do nastepnego znaku
                    counter1 = 0;
                }
            }

            if (textToEncrypted.charAt(i) == '1') { // dla binarnego 1
                flag1 = true;
                counter1++;
                if (flag0) {
                    flag0 = false;

                    encryptedText.append("00 "); // 00 oznacza 0 binarnie
                    for (int j = 0; j < counter0; j++) {  // dodaje ilosc znakow 1 w postaci 0
                        encryptedText.append("0");
                    }
                    encryptedText.append(" "); // dodaje spacje do nastepnego znaku
                    counter0 = 0;
                }
            }
        }
        //dodanie znakow na koncu tekstu, poniewaz for konczy sie z dlugoscia tekstu
        // i nie zapisuje pozostalych policzonych znakow
        if (counter0 > 0) { // dla 0
            encryptedText.append("00 "); // 00 oznacza 0 binarnie
            for (int j = 0; j < counter0; j++) {  // dodaje ilosc znakow 1 w postaci 0
                encryptedText.append("0");
            }
            encryptedText.append(" "); // dodaje spacje do nastepnego znaku
            counter0 = 0;
        }
        if (counter1 > 0) { // dla 1
            encryptedText.append("0 "); // 0 oznacza 1 binarnie
            for (int j = 0; j < counter1; j++) {  // dodaje ilosc znakow 1 w postaci 0
                encryptedText.append("0");
            }
            encryptedText.append(" "); // dodaje spacje do nastepnego znaku
            counter1 = 0;
        }


        return encryptedText;
    }

    private static StringBuilder changeTextToBinary(StringBuilder text) {
        StringBuilder tempText = new StringBuilder(); // binary text
        for (int i = 0; i < text.length(); i++) {
            // pobiera char, rzutuje na int, przerabia na binary i parsuje na int, dodaje zera przez liczba do 7 cyfr
            tempText.append(String.format("%07d",Integer.parseInt(Integer.toBinaryString(text.charAt(i)))));
        }
        return tempText;
    }

    private static void printResult(StringBuilder resultText) {
        //StringBuilder textOutput = new StringBuilder();
        //textOutput.append("The result:\n");
        //textOutput.append(resultText);
        System.out.println(resultText);
    }
}