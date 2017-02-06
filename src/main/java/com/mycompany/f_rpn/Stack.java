/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.f_rpn;

/**
 *
 * @author Mathias
 */
public class Stack<T>
{

    public T[] data = null;
    public int top = 0;

    public Stack()
    {
        this.data = (T[]) new Object[100];
    }

    public void push(T element)
    {
        data[top] = element;
        top++;
    }

    public T pop() throws Exception
    {
        if (isEmpty())
        {
            throw new Exception("Unable to pop empty stack");
        }
        T element = data[top];
        top--;
        return element;
    }

    public boolean isEmpty()
    {
        return top == 0;
    }

    @Override
    public String toString()
    {
        if (!isEmpty())
        {
            String result = "";
            for (int i = 0; i < top; i++)
            {
                if (data[i] != null)
                {
                    result += data[i] + " ";
                }
            }
            return result;
        }
        return ("Stack is empty");
    }

    public void calculate()
    {
        if (top >= 3)
        {
            if (isMathematicalOperator(data[top - 1].toString()))
            {
                if (isNumeric(data[top - 3].toString()) && isNumeric(data[top - 2].toString()))
                {

                    if (data[top - 1].equals("+"))
                    {
                        Integer res = Integer.parseInt(data[top - 3].toString()) + Integer.parseInt(data[top - 2].toString());

                        top = top - 3;
                        push((T) res);
                    }

                    if (data[top - 1].equals("-"))
                    {
                        Integer res = Integer.parseInt(data[top - 3].toString()) - Integer.parseInt(data[top - 2].toString());

                        top = top - 3;
                        push((T) res);
                    }

                    if (data[top - 1].equals("*"))
                    {
                        Integer res = Integer.parseInt(data[top - 3].toString()) * Integer.parseInt(data[top - 2].toString());

                        top = top - 3;
                        push((T) res);
                    }

                    if (data[top - 1].equals("/"))
                    {
                        Integer res = Integer.parseInt(data[top - 3].toString()) / Integer.parseInt(data[top - 2].toString());

                        top = top - 3;
                        push((T) res);
                    }
                }
            }
        }
    }

    public boolean isMathematicalOperator(String str)
    {
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }

    public boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c))
            {
                return false;
            }
        }
        return true;
    }
}
