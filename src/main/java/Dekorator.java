public class Dekorator {

    public static void main(String[] args) {
//    Printer printer = new Printer("Печать");

        PrinterInt printerInt = new DekoratorForPrinter(new Printer("Печать"));
        printerInt.print();
    }
}

interface PrinterInt {
    void print();
}

class Printer implements PrinterInt {
    String value;

   public Printer(String value) {
        this.value = value;
    }

    public void print() {
        System.out.println(value);
    }
}

class DekoratorForPrinter implements PrinterInt {
    PrinterInt component;

    public DekoratorForPrinter(PrinterInt component) {
        this.component = component;
    }
    public void print () {
        System.out.println("декоратор вступил в работу");
        component.print();
    }
}


