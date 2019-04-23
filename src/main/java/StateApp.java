//
//Паттерн Состояние (State) позволяет объекту изменять свое
//        поведение в зависимости от внутреннего состояния
//        , т.е.  шаблон обеспечивает изменение поведения объекта во время выполнения программы
public class StateApp {
    public static void main(String[] args) {
        Station radio7 = new Radio7();
        Radio stationContext = new Radio();
        stationContext.setStation(radio7);
        stationContext.play();
        stationContext.nextStation();
        stationContext.play();

    }


}

//State состояние нашего объекта
interface Station {
    void play();
}

class Radio7 implements Station {

    @Override
    public void play() {
        System.out.println("Радио 7");
    }
}

class RuRadio implements Station {

    @Override
    public void play() {
        System.out.println("RuRadio");
    }
}

class EnRadio implements Station {

    @Override
    public void play() {
        System.out.println("EnRadio 7");
    }
}

//Context
//в данном примере переключение между состояними производит сам контекст
class Radio {
    Station station;

    void setStation(Station st) {
        station = st;
    }

    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RuRadio());
        } else if (station instanceof RuRadio) {
            setStation(new EnRadio());
        } else if (station instanceof RuRadio) {
            setStation(new Radio7());
        }
    }

    void play() {
        station.play();
    }
}

//Теперь переключением состоянием управляет сам объект.

//State
interface Activity {
    void doSomething(Robot context);
}

class Robot{
    Activity state;
    public void setState(Activity state){
        this.state = state;
    }

    public void doSomething(){
        state.doSomething(this);
    }
}

//state
class Work implements Activity {

    @Override
    public void doSomething(Robot context) {
        System.out.println("Работаю");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity {
    private int count = 0;

    @Override
    public void doSomething(Robot context) {
        if (count < 3) {
            System.out.println("Отдыхаем " + count + "...");
            count++;
        }else context.setState(new Work());
    }
}

