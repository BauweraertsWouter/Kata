package com.wouter.kata.karatechop;

/**
 * Hello world!
 *
 */
public class KarateChop
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int search(int element, int[] list) {
        if (list.length == 0){return -1;}
        else if (list.length == 1){
            if (list[0]== element){
                return 0;
            }else {
                return -1;
            }
        }
        return 0;
    }
}
