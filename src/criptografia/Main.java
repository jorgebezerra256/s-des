/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Main {
    
    public static void main(String[] args) {
        int[] key = new int[10];
        int[] text = new int[8];
        key[0] = 0;
        key[1] = 1;
        key[2] = 1;
        key[3] = 1;
        key[4] = 1;
        key[5] = 1;
        key[6] = 1;
        key[7] = 1;
        key[8] = 0;
        key[9] = 1;
        
        Scanner input = new Scanner(System.in);
        System.out.println("Digite dois caracteres! São validos apenas de A a P!");
        String string = input.nextLine();
        string = string.toUpperCase();
        //System.out.println("\n\n" + string);
        //convertendo caratere para bit
        CodificacaoLetras caracteres = new CodificacaoLetras();
        System.arraycopy(caracteres.charToArrayBit(string.charAt(0)), 0, text, 0, 4);
        System.arraycopy(caracteres.charToArrayBit(string.charAt(1)), 0, text, 4, 4);
        System.out.println("Texto lido: " + string);
        
        System.out.println("Texto em bits: " +Arrays.toString(text));
        
        System.out.println("\nCriptografando..");
        //Criptografar
        Encriptar encriptar = new Encriptar();
        int[] cipertext = new int[8];
        cipertext = encriptar.criptografar(key, text);
        int[] bitsleftc = new int[4];
        int[] bitsrightc = new int[4];
        System.arraycopy(cipertext, 0, bitsleftc, 0, 4);
        System.arraycopy(cipertext, 4, bitsrightc, 0, 4);
        String retorno = Character.toString(caracteres.bitsToChar(bitsleftc)) + Character.toString(caracteres.bitsToChar(bitsrightc));
        System.out.println("Texto Criptografado: " + retorno);
        System.out.println("\n");
        System.out.println("Decriptografando..");
        //Decriptografar
        int[] textdecipted = new int[8];
        textdecipted = encriptar.descriptografar(cipertext, key);
        
        System.out.println("\nConverter bits para texto");
        int[] bitsleft = new int[4];
        int[] bitsright = new int[4];
        System.arraycopy(textdecipted, 0, bitsleft, 0, 4);
        System.arraycopy(textdecipted, 4, bitsright, 0, 4);
        retorno = Character.toString(caracteres.bitsToChar(bitsleft)) + Character.toString(caracteres.bitsToChar(bitsright));
        System.out.println("Texto apos decifrado e convertido de bit para string");
        System.out.println(retorno);
    }
    
}
