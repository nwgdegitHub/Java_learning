package 多态;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Person peron = new Person();

        Printer printer1 = new BlackPrinter();
        Printer printer2 = new ColorPrinter();

        peron.doPrint(printer1);
        peron.doPrint(printer2);
    }
}
