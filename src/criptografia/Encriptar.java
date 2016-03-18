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
public class Encriptar {   
    
    
    public int[] criptografar(int[] key, int[] text){
        //procedimento de geração da chave 1
        Encripta encripta = new Encripta();
        int[] p10 = new int[10];
        
        p10 = encripta.p10(key);
        int[] ls1 = new int[10];                
        ls1 = encripta.LS_1(p10);        
        int[] k1 = new int[8];
        k1 = encripta.p8(ls1);
        
        //procedimento de geração da chave 2
        int[] ls2 = new int[10];
        ls2 = encripta.LS_2(ls1);        
        int[] k2 = new int[8];
        k2 = encripta.p8(ls2);
        System.out.println("KEY 1 : " + Arrays.toString(k1));
        System.out.println("KEY 2 : " + Arrays.toString(k2));
        
        //procedimento de encriptação
        int[] ip = new int[8];
        ip = encripta.ip(text);
        System.out.println("IP: " + Arrays.toString(ip));
        //usando key 1
        int[] fk = new int[8];
        fk = encripta.fk(ip, k1);
        System.out.println("Fk: " + Arrays.toString(fk));
        
        int[] sw = new int[8];        
        sw = encripta.sw(fk, ip);
        System.out.println("SW: " + Arrays.toString(sw));
        
        //usando key 2
        int[] fk2 = new int[8];
        fk2 = encripta.fk(sw, k2);
        System.out.println("Fk: " + Arrays.toString(fk2));
        
        
        
        int[] ip_1 = new int[8];
        ip_1 = encripta.ip_1(fk2);
        System.out.println("IP-¹: " + Arrays.toString(ip_1));
    
        return ip_1;
    }
    
    public int[] descriptografar(int[] cipertext, int[] key){
        
        //procedimento de geração da chave 1
        Encripta encripta = new Encripta();
        int[] p10 = new int[10];
        
        p10 = encripta.p10(key);
        int[] ls1 = new int[10];                
        ls1 = encripta.LS_1(p10);        
        int[] k1 = new int[8];
        k1 = encripta.p8(ls1);
        
        //procedimento de geração da chave 2
        int[] ls2 = new int[10];
        ls2 = encripta.LS_2(ls1);        
        int[] k2 = new int[8];
        k2 = encripta.p8(ls2);
        System.out.println("KEY 1 : " + Arrays.toString(k1));
        System.out.println("KEY 2 : " + Arrays.toString(k2));
        
        //descriptografando
        int[] ip = new int[8];
        ip = encripta.ip(cipertext);
        System.out.println("IP: " + Arrays.toString(ip));
        //usando key 1
        int[] fk = new int[8];
        fk = encripta.fk(ip, k2);
        System.out.println("Fk: " + Arrays.toString(fk));
        
        int[] sw = new int[8];        
        sw = encripta.sw(fk, ip);
        System.out.println("SW: " + Arrays.toString(sw));
        
        //usando key 2
        int[] fk2 = new int[8];
        fk2 = encripta.fk(sw, k1);
        System.out.println("Fk: " + Arrays.toString(fk2));
        
        
        
        int[] ip_1 = new int[8];
        ip_1 = encripta.ip_1(fk2);
        System.out.println("IP-¹: " + Arrays.toString(ip_1));
    
        return ip_1;
        
    }
    
}
