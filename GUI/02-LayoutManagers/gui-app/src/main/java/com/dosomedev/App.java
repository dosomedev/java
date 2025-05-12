package com.dosomedev;

/**
 * Swing LayoutManager example.
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        FlowLayoutExample example1 = new FlowLayoutExample();
        example1.run();

        BorderLayoutExample example2 = new BorderLayoutExample();
        example2.run();

        GridLayoutExample example3 = new GridLayoutExample();
        example3.run();

        GridBagLayoutExample example4 = new GridBagLayoutExample();
        example4.run();

        CardLayoutExample example5 = new CardLayoutExample();
        example5.run();

        BoxLayoutExample example6 = new BoxLayoutExample();
        example6.run();
    }
}
