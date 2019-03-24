package finalproject;

/**
 * CSE 231 - Final Project
 * Kelly Kurkowski & Wendy Yang
 */

import java.text.DecimalFormat;

public class Transaction
{
    String date, description, category;
    double amount;
    
    DecimalFormat formatter = new DecimalFormat("$#0.00");
            
    public Transaction()
    {
        date = "";
        description = "";
        category ="";
        amount = 0;
    }
    
    public Transaction(String d, String dsc, String cat, double amt)
    {
        date = d;
        description = dsc;
        category = cat;
        amount = amt;
    }
    
    public String getDate()
    {
        return date;
    }
    
    public String getDsc()
    {
        return description;
    }
    
    public String getCat()
    {
        return category;
    }
    
    public double getAmt()
    {
        return amount;
    }
    
    public void setDate(String d)
    {
        date = d;
    }
    
    public void setDsc(String desc)
    {
        description = desc;
    }
    
    public void setCat(String cat)
    {
        category = cat;
    }
    
    public void setAmt(double amt)
    {
        amount = amt;
    }
    
    @Override
    public String toString()
    {
        String str = date + "\t" + description + "\t"
                + category + "\t" + formatter.format(amount);
        
        return str;
   }    
}