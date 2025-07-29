package com.dosomedev;

/**
 * Swing table example.
 *
 */
public class App
{
    public static void main( String[] args )
    {
        SimpleTableExample example1 = new SimpleTableExample();
        example1.run();

        TableFilterSortExample example2 = new TableFilterSortExample();
        example2.run();

        TableAddDeleteExample example3 = new TableAddDeleteExample();
        example3.run();
    }
}
