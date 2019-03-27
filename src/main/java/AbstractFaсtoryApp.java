public class AbstractFaсtoryApp {
    public static void main(String[] args) {

        DeviceFactory deviceFactory = new EnDeviceFactory();
        Mouse mouse = deviceFactory.getMouse();
        mouse.click();
    }

}

interface Mouse{
    void click();
    void dbclicj();
    void scroll(int direction);
}

interface Keyboard{
    void print();
    void println();
}

interface Touchpad{
    void track(int deltaX, int deltaY);
}

/*
интерфейс для абстрактной фабрики
 */
interface DeviceFactory{
    Mouse getMouse();
    Keyboard getKeyboard();
    Touchpad getTouchpad();
}

/*
реализация абстрактной фабрики
 */

class RuDeviceFactory implements DeviceFactory{

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return null;
    }

    @Override
    public Touchpad getTouchpad() {
        return null;
    }
}

/*
реализация абстрактной фабрики
 */
class EnDeviceFactory implements DeviceFactory{

    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public Keyboard getKeyboard() {
        return null;
    }

    @Override
    public Touchpad getTouchpad() {
        return null;
    }
}


class RuMouse implements Mouse{

    @Override
    public void click() {
        System.out.println("Клик");
    }

    @Override
    public void dbclicj() {
        System.out.println("Дабл Клик");
    }

    @Override
    public void scroll(int direction) {
        System.out.println("скрол Клик на "+ direction);
    }
}
class EnMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Click");
    }

    @Override
    public void dbclicj() {
        System.out.println("Double Click");
    }

    @Override
    public void scroll(int direction) {
        System.out.println("scroll" + direction);
    }
}



