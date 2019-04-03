//задача шаблона пересылать клиента к методу класса ,который имеет нужынй функционал
//например при использовании старого интерфейса мы просто преобразуем наш метод на нвоый
public class AdapterApp {
    public static void main(String[] args) {
        //1 способ через наследование
        VectorGraphicsInt g = new VectorAdapter();
        g.drawSquare();


        //2 способ через композицию
        VectorGraphicsInt g2 = new VectorAdapter2();
        g.drawSquare();
    }


}

interface VectorGraphicsInt {
    void drawLine();

    void drawSquare();
}

class RasterGraphics {
    void drawRasterLine() {
        System.out.println("Рисуем линию");
    }

    void drawRasterSquare() {
        System.out.println("Рисуем квадрат");
    }
}

class VectorAdapter extends RasterGraphics implements VectorGraphicsInt {

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}


class VectorAdapter2 implements VectorGraphicsInt {
    RasterGraphics rasterGraphics = new RasterGraphics();

    @Override
    public void drawLine() {
       rasterGraphics.drawRasterLine();
    }

    @Override
    public void drawSquare() {
       rasterGraphics.drawRasterSquare();
    }
}