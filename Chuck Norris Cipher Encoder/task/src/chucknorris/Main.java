package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input string:");
        // wczytanie tekstu od uzytkownika
        StringBuilder mainText = new StringBuilder(new Scanner(System.in).nextLine());
        StringBuilder tempText;
        // sprawdzenie czy cos zostalo wpisane
        //if (text.length() > 0) { //usuniete dla Stage 2/5
            //wyswietlenie tekstu w formie binarnej STAGE 2/5
            //System.out.println(" ");
        tempText = changeTextToBinary(mainText); // przerabia tekst zwykly na binarny
        //System.out.println(tempText);
        tempText = encryptBinaryTextToZeros(tempText); // szyfruje tekst binarny na format 0 00 0000 00

        printResult(tempText); // wyswietla tekst zaszyfrowany
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
        StringBuilder textOutput = new StringBuilder();
        textOutput.append("The result:\n");
        textOutput.append(resultText);
        System.out.println(textOutput);
    }
}