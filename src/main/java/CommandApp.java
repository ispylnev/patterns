public class CommandApp {
    public static void main(String[] args) {

        Comp comp = new Comp();
        User user = new User(new StartCommand(comp),new StopCommand(comp),new ResetCommand(comp));
        user.resetComp();
        user.startComp();
    }
}

interface Command {
    void execute();
}

//Reciver
class Comp {
    public void start() {
        System.out.println("start");
    }

    public void strop() {
        System.out.println("stop");
    }

    public void reset() {
        System.out.println("reset");
    }
}

//конкретная команда
class StartCommand implements Command {
    Comp comp;

    public StartCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.start();
    }
}

//конкретная команда
class StopCommand implements Command {
    Comp comp;

    public StopCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.strop();
    }
}

//конкретная команда
class ResetCommand implements Command {
    Comp comp;

    public ResetCommand(Comp comp) {
        this.comp = comp;
    }

    @Override
    public void execute() {
        comp.reset();
    }
}

//Invoker смысл этого класса в том чтобы использвоать конкретные команды execute не в дваваясь в подробности реализации
//он вообе не знает о существовании класса Comp
class User {
   private Command start;
   private Command stop;
   private Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    public void startComp(){
        start.execute();
    }
    public void stopComp(){
        stop.execute();
    }
    public void resetComp(){
        reset.execute();
    }
}
