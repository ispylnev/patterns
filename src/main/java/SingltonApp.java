public class SingltonApp  {
    public static void main(String[] args) {

    }
}


class Singlton{
    private static final Object sync = new Object();

    private static volatile Singlton instance = null;
    private Singlton(){
    }

    public  static Singlton getInstance(){
        if (instance == null){
            synchronized (sync){
                if (instance == null){
                    instance = new Singlton();
                }
            }
        }return instance;
    }
}