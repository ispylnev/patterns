//Шаблон Посетитель хорошо использовать в тех случаях, когда необходимо
//        сделать какие-то операции над рядом объектов, но нужно избежать загрязнения их кода.



public class VisitorApp {
    public static void main(String[] args) {
    Element car = new CarElement();
    car.accept(new HooliganVisitor());
    }
}

interface Visitor {
    void visit(EngineElement engineElement);

    void visit(BodyElement bodyElement);

    void visit(CarElement carElement);

    void visit(WellElement wellElement);
}

interface Element {
    void accept(Visitor visitor);
}

class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

//вообще классы соержашие елементы нужны примерно когда мы хотим всю логику
//работы с элементом отдать визитеру
class EngineElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("завел двигатель");
    }

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("поцарапал кузов");
    }

    @Override
    public void visit(CarElement carElement) {

    }

    @Override
    public void visit(WellElement wellElement) {
        System.out.println("проколол" + wellElement.getName());
    }
}

class MechanicVisitor implements Visitor {

    @Override
    public void visit(EngineElement engineElement) {
        System.out.println("Заглушил двигатель");
    }

    @Override
    public void visit(BodyElement bodyElement) {
        System.out.println("Покрасил кузов");
    }

    @Override
    public void visit(CarElement carElement) {
        System.out.println("отполировал фары");
    }

    @Override
    public void visit(WellElement wellElement) {
        System.out.println("накачал" + wellElement.getName());
    }



}

class CarElement implements Element {
    Element[] elements;

    public CarElement() {
        this.elements = new Element[]{new WellElement("Правое переднее колесо"),
                new WellElement("Левое переднее колесо"), new WellElement("Правое заднее колесо"),
                new WellElement("Левое заднее колесо")
        };
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
        visitor.visit(this);

    }
}

class WellElement implements Element {
    private String name;

    public WellElement(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}