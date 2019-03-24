package finalproject;

/**
 * CSE 231 - Final Project
 * Kelly Kurkowski & Wendy Yang
 */

import static java.lang.Math.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

public class Checkbook
{ 
    ArrayList<Transaction> chbk;
    Transaction trans;
    
    int n = 0;
    
    private boolean found;
    
    DecimalFormat formatter = new DecimalFormat("$#0.00");
    
    public Checkbook()
    {
        chbk = new ArrayList<>();
    }
    
    public void add(Transaction t)
    {
        chbk.add(t);
    }
    
    public void remove()
    {
        n = chbk.size()-1;
        chbk.remove(n);
    }
    
    private void find(String e)
    {
        n = 0;
        found = false;
        
        while (n < chbk.size())
        {
            if (chbk.get(n).getDate().equals(e)
                    || chbk.get(n).getDsc().equals(e)
                    || chbk.get(n).getCat().equals(e))
            {
                found = true;
                return;
            }
            else
                n++;
        }
    }
    
    public boolean contains(String e) 
    {
        find(e);
        return found;
    }
    
    public String toString()
    {
        String result = "";
        for(Transaction temp : chbk)
        {
            result += temp.toString() + "\n";
        }
        return result;
    }
    
    public String calculateSpending(String e)
    {
        double sum = 0;
        n=0;
        
        while (n < chbk.size())
        {
            if (chbk.get(n).getCat().equals(e))
            {
                found = true;
                sum += chbk.get(n).getAmt();
            }
            n++;
        }
        
        return formatter.format(abs(sum));
        
    }
    
    public String getBalance()
    {
        double sum = 0;
        
        for (Transaction chbk1 : chbk)
        {
            sum += chbk1.getAmt();
        }
        
        return formatter.format(sum);
    }
    
    public boolean isEmpty()
    {
        return chbk.isEmpty();
    }
     
   
//    public void quickSort()
//    {
//        recQuickSort(0, chbk.size()-1);
//    }
//    
//    public void recQuickSort(int left, int right)
//    {
//        if(right-left <= 0)
//            return;
//        else
//        {
//            Transaction pivot = chbk.get(right);
//            
//            int partition = partitionIt(left, right, pivot);
//            recQuickSort(left, partition-1);
//            recQuickSort(partition+1, right);
//        }
//    }
//    
//    public int partitionIt(int left, int right, Transaction pivot)
//    {
//        int leftPtr = left-1;
//        int rightPtr = right;
//        
//        while(true)
//        {
//            while(chbk.get(++leftPtr) < pivot)
//                ;
//            
//            while(rightPtr > 0 && chbk.get(--rightPtr) > pivot)
//                ;
//            
//            if(leftPtr >= rightPtr)
//                break;
//            else 
//                swap(leftPtr, rightPtr);
//        }
//        
//        swap(leftPtr, right);
//        return leftPtr;
//    }
//    
//    public void swap(int a, int b)
//    {
//        Transaction temp = chbk.get(a);
//        chbk.get(a) = chbk.get(b);
//        chbk.get(b) = temp;
//    }
}