/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    package Modelos;

/**
 *
 * @author jose rivera
 */
public class ComboItem
{
    private String textString;
    private int value;

    public ComboItem(String textString, int value)
    {
        this.textString = textString;
        this.value = value;
    }

    @Override
    public String toString()
    {
        return textString;
    }

    public String getKey()
    {
        return textString;
    }

    public int getValue()
    {
        return value;
    }
}