public class Prototype {
    public static void main(String[] args) {
        Human human = new Human(12, "Alex");
        Human copy = (Human) human.copy();

        HumanFactory humanFactory = new HumanFactory(copy);
        Human h1 = humanFactory.makeCopy();
        humanFactory.setPrototype(new Human(33,"new"));
        Human h2 = humanFactory.makeCopy();

    }
}

//интерфейс с методом для клонирования объекта
interface Copyable {
    Object copy();
}

class Human implements Copyable {

    int age;
    String name;

    public Human(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public Object copy() {
        return new Human(age, name);
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//создадим фабрику для людей
class HumanFactory{
    Human human;

    public HumanFactory(Human human){
        this.human = human;
    }
    public void setPrototype(Human human){
        this.human = human;
    }
   public Human makeCopy(){
        return (Human) human.copy();
   }
}