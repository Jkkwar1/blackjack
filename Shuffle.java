/**
* Author: Joseph-Richard Kwarteng
* 
* Purpose of the class
*/
import java.util.ArrayList;
import java.util.Random;

public class Shuffle{
    public static void main(String[] args){

        ArrayList<Integer> arr0 = new ArrayList<>();
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = arr0;
        Random rand = new Random();
        for(int i = 0;i<10;i++){
            arr0.add(i,rand.nextInt(0,10));
            arr1.add(arr0.get(i));
            

        }
        System.out.println(arr0);
        for(int i =0;i<10;i++){
            int r = rand.nextInt(0,arr0.size());
            System.out.println("Removed: "+ arr0.get(r)+ " List: "+arr0);
            arr0.remove(r);
            
            
        }
        // System.out.println(arr0);
        // System.out.println(arr1);
        // System.out.println(arr2);

        // System.out.println("arr0.equals(arr1): " + (arr0.equals(arr1)) + "\narr1.equals(arr2): " + (arr1.equals(arr2)) + "\narr2.equals(arr0): " + (arr2.equals(arr0)));



    }






}