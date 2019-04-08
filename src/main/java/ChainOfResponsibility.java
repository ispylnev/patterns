public class ChainOfResponsibility {

    public static void main(String[] args) {
        Logger emailLogger = new EmailLogger(1);
        Logger sms = new SMSLogger(3);
      emailLogger.writeMessage("Написать если приоритет 2",2);
        emailLogger.setNext(sms);
        sms.writeMessage("sms если приоритет 3",3);



    }
}

class Level{

    public static final int ERROR=1;
    public static final int DEBUG=1;
    public static final int INFO=1;
}

abstract class Logger{
    int priority;
    public Logger (int priority){
        this.priority = priority;
    }

    Logger next;

    public void setNext(Logger logger){
        this.next = logger;
    }
    public void writeMessage(String message, int level){
        if(level<=priority){
            write(message);
        }
        if (next!=null){
            next.writeMessage(message,level);
        }

    }

   abstract void write(String message);

}

class EmailLogger extends Logger {

    public EmailLogger(int priority) {
        super(priority);
    }

    @Override
    void write(String message) {
        System.out.println(message);
    }
}

class SMSLogger extends Logger {

    public SMSLogger(int priority) {
        super(priority);
    }

    @Override
    void write(String message) {
        System.out.println(message);
    }
}