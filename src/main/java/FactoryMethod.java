import java.time.Instant;


public class FactoryMethod {
    public static void main(String[] args) {
        WatchMacker watchMacker = new DigitalWatchMaker();
        Watch watch = watchMacker.creatWach();
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {

    public void showTime() {
        System.out.println(Instant.now());
    }
}

class RomeWatch implements Watch {

    public void showTime() {
        System.out.println("VII-XII");
    }
}

/*
Создаем класс в котором опишем наш фабричный метод
 */
interface WatchMacker {
    Watch creatWach();
}

class DigitalWatchMaker implements WatchMacker{

    @Override
    public Watch creatWach() {
        return new DigitalWatch();
    }
}
class RomeWatchMaker implements WatchMacker {

    @Override
    public Watch creatWach() {
        return new RomeWatch();
    }
}