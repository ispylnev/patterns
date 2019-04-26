
//Шаблон проектирования "Стратегия" предназначен для
// определения группы классов, которые представляют собой
// набор возможных вариантов поведения. Это дает возможность
// гибко подключать те или
//иные наборы вариантов поведения во время работы приложения,
// меняя его функциональность "на ходу".

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        int []arr = {1,6,4,2,8};
        StrategyClient strategyClient = new StrategyClient();
        strategyClient.setSorting(new BubleSort());
        strategyClient.getSorting(arr);
    }


}

//Context
class StrategyClient {
    Sorting sorting;

    public void getSorting(int arr[]) {
        sorting.sort(arr);
    }

    public void setSorting(Sorting sorting) {
        this.sorting = sorting;
    }
}

interface Sorting {
    void sort(int arr[]);
}

//сортировка выбором
class SortChoise implements Sorting {
    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // предпологаем, что начальный элемент рассматриваемого фрагмента и будет минимальным

            System.out.println(Arrays.toString(arr));
            int min = arr[i]; // предполагаемый минимальный элемент
            int imin = i;   // индекс минимального жлемента

            // Просматриваем оставшийся фрагмент массива и ищем там элемент, меньший предположенного минимума.

            for (int j = i + 1; j < arr.length; j++) {
                //Если находим новый минимум, то запоминаем его индекс
                //И обновляем значение минимума
                if (arr[j] < min) {
                    min = arr[j];
                    imin = j;
                }
            }

            //Проверяем, нашелся ли элемент меньше, чем стоит на текущей позиции.
            // Если нашелся, то меняем элементы местами

            if (i != imin) {
                int temp = arr[i];
                arr[i] = arr[imin];
                arr[imin] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

class BubleSort implements Sorting {

    @Override
    public void sort(int[] arr) {

        boolean isSorted = false;
        int buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;

                    buf = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buf;
                }
            }
        }
    }
}