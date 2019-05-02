//Шаблон проектирования Итератор предоставляет универсальный
// последовательный доступ к элементам коллекции.
// Хорош в тех случаях, когда необходимо реализовать единый механизм
// перебора элементов коллекций, не зависящий от способа реализации ни одной из этих коллекций.
public class IteratorApp {
    public static void main(String[] args) {
        ConcrreteAgrigate concrreteAgrigate = new ConcrreteAgrigate();
        Iterator it = concrreteAgrigate.getIterator();
        while (it.hasNext()) {
            System.out.println((String) it.next());
        }
    }
}


//для таких классов и создается обвязка в виде iterator_a
class ConcrreteAgrigate implements Aggregate {
    String[] tasks = {"понедельник", "вторник"};

    //нам нужен какой-то конкретный итератор поэтому создадим внутринний класс
    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator {
        int count = 0;

        @Override
        public boolean hasNext() {
            return count < tasks.length ? true : false;
        }

        @Override
        public Object next() {
            return tasks[count++];
        }
    }

}

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Aggregate {
    Iterator getIterator();
}


