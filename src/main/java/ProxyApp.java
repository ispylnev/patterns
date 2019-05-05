
//Шаблон проектирования Прокси, он же Заместитель, он же Суррогат,
// предназначен для косвенного обращения к объекту.
// То есть обращение к методам реального объекта п
// роисходит через объект-заместитель (прокси).
public class ProxyApp {
    public static void main(String[] args) {
        Image image = new ProxyImage("D://кино");
        image.display();
    }
}

interface Image {

    void display();
}

class RealImage implements Image {

    private String file;

    //чтобы уйти от загрузки сделаем виртуальный прокси
    public RealImage(String file) {
        this.file = file;
        load();
    }

    private void load() {
        System.out.println("Загрузка " + file);
    }

    @Override
    public void display() {
        System.out.println("просмотр" + file);
    }
}


//виртуальный прокси
class ProxyImage implements Image {
    RealImage image;

    String file;

    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if (image == null) {
            image = new RealImage(file);
        }
        image.display();
    }

}