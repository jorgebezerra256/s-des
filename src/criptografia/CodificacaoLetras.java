/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package criptografia;

import java.util.Arrays;

/**
 *
 * @author jorge
 */
public class CodificacaoLetras {
    private final int[] A = {0,0,0,0};
    private final int[] B = {0,0,0,1};
    private final int[] C = {0,0,1,0};
    private final int[] D = {0,0,1,1};
    private final int[] E = {0,1,0,0};
    private final int[] F = {0,1,0,1};
    private final int[] G = {0,1,1,0};
    private final int[] H = {0,1,1,1};
    private final int[] I = {1,0,0,0};
    private final int[] J = {1,0,0,1};
    private final int[] K = {1,0,1,0};
    private final int[] L = {1,0,1,1};
    private final int[] M = {1,1,0,0};
    private final int[] N = {1,1,0,1};
    private final int[] O = {1,1,1,0};
    private final int[] P = {1,1,1,1};
    
    private final char a = 'A';
    private final char b = 'B';
    private final char c = 'C';
    private final char d = 'D';
    private final char e = 'E';
    private final char f = 'F';
    private final char g = 'G';
    private final char h = 'H';
    private final char i = 'I';
    private final char j = 'J';
    private final char k = 'K';
    private final char l = 'L';
    private final char m = 'M';
    private final char n = 'N';
    private final char o = 'O';
    private final char p = 'P';
    
    public char bitsToChar(int[] bits){
        if(Arrays.equals(bits, A))
            return 'A';        
        if(Arrays.equals(bits, B))
            return 'B';        
        if(Arrays.equals(bits, C))
            return 'C';        
        if(Arrays.equals(bits, D))
            return 'D';        
        if(Arrays.equals(bits, E))
            return 'E';        
        if(Arrays.equals(bits, F))
            return 'F';
        if(Arrays.equals(bits, G))
            return 'G';        
        if(Arrays.equals(bits, H))
            return 'H';
        if(Arrays.equals(bits, I))
            return 'I';
        if(Arrays.equals(bits, J))
            return 'J';
        if(Arrays.equals(bits, K))
            return 'K';
        if(Arrays.equals(bits, L))
            return 'L';
        if(Arrays.equals(bits, M))
            return 'M';
        if(Arrays.equals(bits, N))
            return 'N';
        if(Arrays.equals(bits, O))
            return 'O';
        if(Arrays.equals(bits, P))
            return 'P';
        return '0';
        
    }
    
    
    public int[] charToArrayBit(char caractere){
        if(caractere == a)
            return A;
        if(caractere == b)
            return B;
        if(caractere == c)
            return C;
        if(caractere == d)
            return D;
        if(caractere == e)
            return E;
        if(caractere == f)
            return F;
        if(caractere == g)
            return G;
        if(caractere == h)
            return H;
        if(caractere == k)
            return K;
        if(caractere == i)
            return I;
        if(caractere == j)
            return J;
        if(caractere == l)
            return L;
        if(caractere == m)
            return M;
        if(caractere == n)
            return N;
        if(caractere == o)
            return O;
        if(caractere == p)
            return P;
        return null;
    }
    
    
}
