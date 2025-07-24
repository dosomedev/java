package com.dosomedev;

/**
 * Swing ActionListener example.
 *
 */
public class App
{
    public static void main( String[] args )
    {
        MouseEventExample example1 = new MouseEventExample();
        example1.run();

        KeyEventExample example2 = new KeyEventExample();
        example2.run();

        FocusEventExample example3 = new FocusEventExample();
        example3.run();

        ItemEventExample example4 = new ItemEventExample();
        example4.run();
    }
}
