package com.dilipmaharjan.learnjava.problemsolving;

public class SwappingTwoNumbers {
    private static void swapWithTemporaryVariable(int a,int b){
        System.out.printf("swapWithTemporaryVariable : \n Before swapping %d , %d ",a,b);
        int t=a;
        a=b;
        b=t;
        System.out.printf("\nAfter swapping %d , %d \n",a,b);

    }
    private static void swapWithAdditionAndSubstraction(int a,int b){
        System.out.printf("swapWithOutTemporaryVariable : \nBefore swapping %d , %d ",a,b);
        a=a+b; //10+20=30
        b=a-b;//30-20=10
        a=a-b;//20-10=20

        System.out.printf("\nAfter swapping %d , %d \n",a,b);
    }
    private static void swapWithMultiplicationAndDivision(int a,int b){
        System.out.printf("swapWithOutTemporaryVariable : \nBefore swapping %d , %d ",a,b);
        a=a*b; //10*20=200
        b=a/b;//30/20=10
        a=a/b;//20/10=20

        System.out.printf("\nAfter swapping %d , %d \n",a,b);
    }

    private static void swapWithBitwiseOprator(int a,int b){
        System.out.printf("swapWithOutTemporaryVariable : \nBefore swapping %d , %d ",a,b);
        /**
         * Initial given inputs are converted into binary
         * XOR operator : 1 if both are same else 0
         * e.g
         * a=10=1010
         * b=20=10100
         * a^b=11110=30
         *
         */
        a=a^b;
        b=a^b;
        a=a^b;

        System.out.printf("\nAfter swapping %d , %d \n",a,b);
    }


    private static void swapWithSingleStatement(int a,int b){
        System.out.printf("swapWithOutTemporaryVariable : \nBefore swapping %d , %d ",a,b);
     b=a+b-(a=b);

        System.out.printf("\nAfter swapping %d , %d \n",a,b);
    }

    public static void main(String[] args) {
        swapWithTemporaryVariable(20,30);
        swapWithAdditionAndSubstraction(10,20);
        swapWithMultiplicationAndDivision(10,20);
        swapWithSingleStatement(10,20);
    }
}
