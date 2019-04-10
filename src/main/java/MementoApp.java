//хранитель позволяет зафиксировать и сохранить внутреннее состояние объекта,так чтобы позднее восстановить
public class MementoApp {
    public static void main(String[] args) {
        Game game = new Game();
        game.set("LVL 1",3000);

        File file = new File();
        file.setSave(game.save());

        game.load(file.getSave());

    }
}

class Game {
    private String level;
    private int time;

    @Override
    public String toString() {
        return "Game{" +
                "level='" + level + '\'' +
                ", time=" + time +
                '}';
    }

    public void set(String level, int time) {
        this.time = time;
        this.level = level;
    }

    public Save save(){
        return new Save(level,time);
    }

    public void load(Save save){
        level = save.getLevel();
        time = save.getTime();
    }
}

//Хранитель
class Save {
    private final String level;
    private final int time;

    public Save(String level, int time) {
        this.level = level;
        this.time = time;
    }

    public String getLevel() {
        return level;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Save{" +
                "level='" + level + '\'' +
                ", time=" + time +
                '}';
    }
}

//Опекун
class File {
   private Save save;

    public Save getSave() {
        return save;
    }

    public void setSave(Save save) {
        this.save = save;
    }
}
