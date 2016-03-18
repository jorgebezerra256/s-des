/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;


/**
 *
 * @author jorge
 */
public class Encripta {

    //calcula a permutação do vetor inicial
    public int[] ip(int[] plaintext) {
        int[] ip = new int[8];

        ip[0] = plaintext[1];
        ip[1] = plaintext[5];
        ip[2] = plaintext[2];
        ip[3] = plaintext[0];
        ip[4] = plaintext[3];
        ip[5] = plaintext[7];
        ip[6] = plaintext[4];
        ip[7] = plaintext[6];

        return ip;
    }

    //calcula a permutação do vetor final
    public int[] ip_1(int[] text) {
        int[] ip = new int[8];

        ip[0] = text[3];
        ip[1] = text[0];
        ip[2] = text[2];
        ip[3] = text[4];
        ip[4] = text[6];
        ip[5] = text[1];
        ip[6] = text[7];
        ip[7] = text[5];

        return ip;
    }

    //combinação da função de permutação com a chave 1
    public int[] fk(int[] iptext, int[] key1) {
        int[][] s0 = new int[4][4];
        s0[0][0] = 1;
        s0[0][1] = 0;
        s0[0][2] = 3;
        s0[0][3] = 2;
        s0[1][0] = 3;
        s0[1][1] = 2;
        s0[1][2] = 1;
        s0[1][3] = 0;
        s0[2][0] = 0;
        s0[2][1] = 2;
        s0[2][2] = 1;
        s0[2][3] = 3;
        s0[3][0] = 3;
        s0[3][1] = 1;
        s0[3][2] = 3;
        s0[3][3] = 2;

        int[][] s1 = new int[4][4];
        s1[0][0] = 0;
        s1[0][1] = 1;
        s1[0][2] = 2;
        s1[0][3] = 3;
        s1[1][0] = 2;
        s1[1][1] = 0;
        s1[1][2] = 1;
        s1[1][3] = 3;
        s1[2][0] = 3;
        s1[2][1] = 0;
        s1[2][2] = 1;
        s1[2][3] = 0;
        s1[3][0] = 2;
        s1[3][1] = 1;
        s1[3][2] = 0;
        s1[3][3] = 3;

        //copia dos 4 bits iniciais do iptext        
        int[] leftIPtext = new int[4];
        System.arraycopy(iptext, 0, leftIPtext, 0, 4);

        //copia dos 4 bits finais do iptext        
        int[] rightIPtext = new int[4];
        System.arraycopy(iptext, 4, rightIPtext, 0, 4);
        
        //permutação extendida do lado direito
        int[] permutacaoextendida = new int[8];
        permutacaoextendida[0] = rightIPtext[3];
        permutacaoextendida[1] = rightIPtext[0];
        permutacaoextendida[2] = rightIPtext[1];
        permutacaoextendida[3] = rightIPtext[2];
        permutacaoextendida[4] = rightIPtext[1];
        permutacaoextendida[5] = rightIPtext[2];
        permutacaoextendida[6] = rightIPtext[3];
        permutacaoextendida[7] = rightIPtext[0];
        
        //xor do lado direito com a key 1
        int[] xor = new int[8];
        xor[0] = permutacaoextendida[0] ^ key1[0];
        xor[1] = permutacaoextendida[1] ^ key1[1];
        xor[2] = permutacaoextendida[2] ^ key1[2];
        xor[3] = permutacaoextendida[3] ^ key1[3];
        xor[4] = permutacaoextendida[4] ^ key1[4];
        xor[5] = permutacaoextendida[5] ^ key1[5];
        xor[6] = permutacaoextendida[6] ^ key1[6];
        xor[7] = permutacaoextendida[7] ^ key1[7];
                    
        int rowS0 = xor[0] * 2 + xor[3];
        int collumnS0 = xor[1] * 2 + xor[2];
        int rowS1 = xor[4] * 2 + xor[7];
        int collumnS1 = xor[5] * 2 + xor[6];

        //pega o valor na matriz S0 e S1 faz a conversão para bit
        int[] p4 = new int[4];        
        p4[0] = s0[rowS0][collumnS0] / 2;
        p4[1] = s0[rowS0][collumnS0] % 2;
        p4[2] = s1[rowS1][collumnS1] / 2;
        p4[3] = s1[rowS1][collumnS1] % 2;
        
        //permutação no resultado de S0 e S1
        int[] permutacao4 = new int[4];
        permutacao4[0] = p4[1];
        permutacao4[1] = p4[3];
        permutacao4[2] = p4[2];
        permutacao4[3] = p4[0];
        
        //xor da permutação4 com o lado esquerdo do iptext
        int[] result = new int[4];
        result[0] = permutacao4[0] ^ leftIPtext[0];
        result[1] = permutacao4[1] ^ leftIPtext[1];
        result[2] = permutacao4[2] ^ leftIPtext[2];
        result[3] = permutacao4[3] ^ leftIPtext[3];
                
        int[] retornar = new int[8];
        System.arraycopy(result, 0, retornar, 0, 4);
        System.arraycopy(iptext, 4, retornar, 4, 4);

        return retornar;
    }

    public int[] sw(int[] fk, int[] iptext) {
        int[] result = new int[8];
        for (int i = 0; i < 4; i++) {
            result[i] = iptext[i+4];
            result[i + 4] = fk[i];
        }
        return result;
    }

    public int[] p10(int[] key) {
        int[] result = new int[10];
        result[0] = key[2];
        result[1] = key[4];
        result[2] = key[1];
        result[3] = key[6];
        result[4] = key[3];
        result[5] = key[9];
        result[6] = key[0];
        result[7] = key[8];
        result[8] = key[7];
        result[9] = key[5];

        return result;
    }
    
    public int[] LS_1(int[] key) {
        int[] result = new int[10];

        result[0] = key[1];
        result[1] = key[2];
        result[2] = key[3];
        result[3] = key[4];
        result[4] = key[0];
        result[5] = key[6];
        result[6] = key[7];
        result[7] = key[8];
        result[8] = key[9];
        result[9] = key[5];

        return result;
    }

    public int[] p8(int[] result){
        int[] result1 = new int[8];
        result1[0] = result[5];
        result1[1] = result[2];
        result1[2] = result[6];
        result1[3] = result[3];
        result1[4] = result[7];
        result1[5] = result[4];
        result1[6] = result[9];
        result1[7] = result[8];
        
        return result1;
    }
    
    public int[] LS_2(int[] key){
        int[] result = new int[10];
        
        result[0] = key[2];
        result[1] = key[3];
        result[2] = key[4];
        result[3] = key[0];
        result[4] = key[1];        
        result[5] = key[7];
        result[6] = key[8];
        result[7] = key[9];
        result[8] = key[5];
        result[9] = key[6];
        
        return result;
    }
}
