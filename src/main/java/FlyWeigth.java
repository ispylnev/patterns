
//Шаблон проектирования Flyweight (Приспособленец) предназначен для
// уменьшения количества объектов в приложении путем совместного их использования.

import java.util.HashMap;
import java.util.Map;

public class FlyWeigth {
    public static void main(String[] args) {

    }
}

interface Shapes {
    void draw(int x, int y);
}

//FlyWeigth
class Circles implements Shapes {

    int r = 5;

    @Override
    public void draw(int x, int y) {
        System.out.println("координаты " + x + y+" рисуем круг радиус= "+r);
    }
}
//FlyWeigth
class Point implements Shapes {

    @Override
    public void draw(int x, int y) {
        System.out.println("координаты " + x + y+" рисуем круг точку");
    }
}

class ShapeFactory{

    private static final Map<String, Shapes> shapes = new HashMap<>();
    public Shapes getShape(String shapName){
        Shapes shape = shapes.get(shapName);
        if (shape == null){
            switch (shapName){
                case "круг":
                    shape = new Circles();
                    break;
                case "точка":
                    shape = new Point();
                    break;
            }
        }shapes.put(shapName,shape);
    return shape;
    }
}