import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

//паттерн наблюдатель
public class MeteoApp {
    public static void main(String[] args) {

        MeteoStation station  = new MeteoStation();
        station.addObserver(new ConsolObserver());
        station.addObserver(new FileObserver());
        station.setTempAndPressure(1,2);

    }
}

//интерфейс для объекта за которым будут наблюдать подписчики
interface Observed {
    void addObserver(Observer o);

    void removeObserver(Observer o);

    void notifyObservers();
}

//интерфейс нужен для подписчиков на события изменения нашего объекта
interface Observer {
    void handlerEvent(int temp, int presser);
}

class MeteoStation implements Observed {

    int temp;
    int pressure;

    public void setTempAndPressure(int t, int p) {
        temp = t;
        pressure = p;
        notifyObservers();
    }

    List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.handlerEvent(temp, pressure);
        }
    }
}

//Конкретный наблюдатель
class ConsolObserver implements Observer {

    @Override
    public void handlerEvent(int temp, int presser) {
        System.out.println("Температура изменилась. Температура = " + temp + "Давление= " + presser);
    }
}

//другой наблюдатель со своей логикой
class FileObserver implements Observer{
    @Override
    public void handlerEvent(int temp, int presser) {
        File f;
        try{
            f = File.createTempFile("Temp","_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Погода изменилась. Температура = " + temp + "Давление= " + presser);
            pw.println();
            pw.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}