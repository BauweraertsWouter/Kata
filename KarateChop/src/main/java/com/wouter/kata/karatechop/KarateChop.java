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

    public int search(int element, int[] list){//method overloading, because initial call has no index yet.
        return search(element, list, 0);
    }

    public int search(int element, int[] list, int index) {
        if (list.length == 0){return -1;}
        else if (list.length == 1){
            if (list[0]== element){
                index += 0;
            }else {
                return  -1;
            }
        }else{
            int length = (list.length/2);

            int[] newList = new int[length];
            if (element == list[length]){index += length;}
            else if (element < list[length]){
                for (int i = 0; i < length; i++) {
                    newList[i] = list[i];
                }
                index = this.search(element, newList, index);
            }else {
                int j = 0;
                index += length;
                for (int i = length; i < list.length; i++) {
                    newList[j++] = list[i];
                }
                index = this.search(element, newList, index);
            }

        }
        return index;
    }
}
