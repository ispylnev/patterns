//это метод ,внтуренние
// блоки которого могут переопределятсья подклассами для изммебажния повторного копирования
public class TemparyMetodApp {
    public static void main(String[] args) {
        B b = new B();
        b.templateMethod();
    }
}

abstract class A{
    //общая логика
   void templateMethod(){
       System.out.println(1);
       System.out.println(2);
       diff();
   }
   abstract void diff();
}

class B extends A{

    @Override
    void diff() {
        System.out.println("Отличительная черта класса B");
    }
}

class C extends A{

    @Override
    void diff() {
        System.out.println("Отличительная черта класса А");
    }
}