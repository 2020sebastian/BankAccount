//********************************************************************
//  Account.java       Author: Lewis and Loftus
//
//  Represents a bank account with basic services such as deposit
//  and withdraw.
//********************************************************************

import java.text.NumberFormat;

public class BankAccount 
{
   private static long assignAccountNumber = 1000;

   private NumberFormat fmt = NumberFormat.getCurrencyInstance();

   private double penalty = 25.0;//penalty for overdrawn account
   private long acctNumber;
   private double balance;
   private String name;

   //-----------------------------------------------------------------
   //  Sets up the account by defining its owner, account number,
   //  and initial balance.
   //-----------------------------------------------------------------
   public BankAccount (String owner, double initial)
   {
      name = owner;
      acctNumber = assignAccountNumber++;
      balance = initial;
   }
   
   public BankAccount(String owner)
   {
       name = owner;
       acctNumber = assignAccountNumber++;
       balance = 0;
    }

   //-----------------------------------------------------------------
   //  Validates the transaction, then deposits the specified amount
   //  into the account. Returns the new balance.
   //-----------------------------------------------------------------
   public int deposit (double amount)
   {
      int value = 0;
      if (amount < 0)  // deposit value is negative

            value = 1;
      else
           balance = balance + amount;
   
      return value;
   }

   //-----------------------------------------------------------------
   //  Validates the transaction, then withdraws the specified amount
   //  from the account. Returns the new balance.
   //-----------------------------------------------------------------
   public int withdraw (double amount)
   {
       int value = 0;
      
     
      if (amount < 0)  // withdraw value is negative
            value = 1;
      else
         if (amount > balance)  // withdraw value exceeds balance
         {
            value = 2;
            balance -= penalty;
         }
         else
            balance = balance - amount;



      return value;
   }
    //-----------------------------------------------------------------
    // transfer amount from account to another account
    //-----------------------------------------------------------------
 
    public int transfer(BankAccount acc,double amount)
    {      
        int value = this.withdraw(amount);
        if (value == 0)
        {
            value = acc.deposit(amount);
            if (value != 0) //could not make deposit, put money back in account
                deposit(amount);
            return value;
        }
        else
            return value;
    }
  
   //-----------------------------------------------------------------
   //  Returns the name of the account.
   //-----------------------------------------------------------------
   public String getName ()
   {
      return name;
   }

    //-----------------------------------------------------------------
   //  Returns the name of the account.
   //-----------------------------------------------------------------
   public void setName (String newName)
   {
      name = newName;
   }


   //-----------------------------------------------------------------
   //  Returns the current balance of the account.
   //-----------------------------------------------------------------
   public double getBalance ()
   {
      return balance;
   }


   //-----------------------------------------------------------------
   //  Returns the account number.
   //-----------------------------------------------------------------
   public long getAccountNumber ()
   {
      return acctNumber;
   }
   
   public void setPenalty(double newPenalty)
   {
       penalty = newPenalty;
    }
    
    public double getPenalty()
    {
        return penalty;
    }

   //-----------------------------------------------------------------
   //  Returns a one-line description of the account as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
   }

  
}
