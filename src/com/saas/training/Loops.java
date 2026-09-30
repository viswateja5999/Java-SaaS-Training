package com.saas.training;

public class Loops {
    public static void  main(String[] args){
        int i;
        boolean isActive;
        //for loop
        System.out.println("For Loop");
              for(i=1;i<=10;i++){
                  System.out.println("Employee " + i);
              }
              for(i=1;i<=10;i++)
              {
                  isActive = (i%2 == 0);
                  if(isActive)
                  {
                      System.out.println("Employee "+i+" is Active");
                  }
              }
        // while loop
        System.out.println("While Loop");
              i = 1;
              while(i <= 10){
                  System.out.println("Employee " + i);
                  i++;
              }
              i=1;
              while(i <= 10){
                  isActive = (i%2==0);
                          if(isActive){
                              System.out.println("Employee "+i+" is Active");
                          }
                          i++;
              }
        //do-while loop
        System.out.println("Do-While Loop");
              i = 1;
              do{
                  System.out.println("Employee "+i);
                  i++;
              }while (i<=10);
              i = 1;
              do{
                  isActive = (i%2!=0);
                  if(isActive){
                      System.out.println("Employee "+i+" is Active");
                  }i++;
              }while (i<=10);
    }
}
