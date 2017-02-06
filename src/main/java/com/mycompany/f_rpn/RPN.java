/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.f_rpn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Mathias
 */
public class RPN
{

    public static String inputs;

    public static void main(String[] args) throws IOException
    {
        System.out.println("Welcome to the RPN calculator - type arguments to begin");
        run();
    }

    public static void run() throws IOException
    {
        Stack stack = new Stack();
        while (true)
        {
            System.out.print(">");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            inputs = br.readLine();

            if (!inputs.isEmpty())
            {

                String[] inputList = inputs.split(" ");

                for (String input : inputList)
                {
                    if (stack.isMathematicalOperator(input) || stack.isNumeric(input))
                    {
                        if (stack.isMathematicalOperator(input))
                        {
                            stack.push(input);
                        } else
                        {
                            stack.push(Integer.parseInt(input));
                        }
                    }
                stack.calculate();
                }
            }

            System.out.println(stack.toString() + " ");
        }
    }
}
