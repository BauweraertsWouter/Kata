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
        }else{
            int lengtgh = (list.length/2);
            int[] newList = new int[lengtgh];
            if (element == list[lengtgh]){return 0;}
            else if (element < list[lengtgh]){
                for (int i = 0; i < lengtgh; i++) {
                    newList[i] = list[i];
                }
            }else {
                int j = 0;
                for (int i = lengtgh; i < list.length; i++) {
                    newList[j++] = list[i];
                }
            }
            return this.search(element, newList);
        }
    }
}
