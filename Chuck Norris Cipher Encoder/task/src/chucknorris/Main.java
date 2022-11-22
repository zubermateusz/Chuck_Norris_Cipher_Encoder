package chucknorris;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Input string:");
        // wczytanie tekstu od uzytkownika
        StringBuilder mainText = new StringBuilder(new Scanner(System.in).nextLine());
        StringBuilder tempText = new StringBuilder();
        // sprawdzenie czy cos zostalo wpisane
        //if (text.length() > 0) { //usuniete dla Stage 2/5
            //wyswietlenie tekstu w formie binarnej STAGE 2/5
            //System.out.println(" ");
        tempText = changeTextTToBinary(mainText); // przerabia tekst zwykly na binarny
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

    private static StringBuilder changeTextTToBinary(StringBuilder text) {
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
    }
}