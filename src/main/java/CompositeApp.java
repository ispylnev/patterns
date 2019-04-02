import java.util.ArrayList;
import java.util.List;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square = new Square();
        Shape triangle = new Triangle();
        Shape sq = new Square();
        Shape tr = new Triangle();

        Composite composite = new Composite();
        composite.addComponent(square);
        composite.addComponent(triangle);

        Composite compositeNext = new Composite();
        compositeNext.addComponent(sq);
        compositeNext.addComponent(tr);
        composite.addComponent(compositeNext);
        composite.draw();
    }
}

interface Shape {
    void draw();
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Квадрат");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Круг");
    }
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Треугольник");
    }
}

//в композите необходимо инициализировать массив. Собственно ради прохода по нему методом draw все и затевалось
class Composite implements Shape {
    private List<Shape> components = new ArrayList<>();

    public void addComponent(Shape component) {
        this.components.add(component);
    }


    public void removeComponent(Shape component) {
        this.components.remove(component);
    }

    //данным методом мы дойдем до самого глубоко уровня будь
    // то компонент(NOde) или какой либо композит в котором есть своя нода
    @Override
    public void draw() {
        for(Shape component :components){
            component.draw();
        }
    }
}

