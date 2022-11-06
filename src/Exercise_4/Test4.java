package Exercise_4;

public class Test4 {
    public static void testExercise4() {
        System.out.println("---------------------\n" +
                "| Решение задания 4 |\n" +
                "---------------------");
        SortedIntegerList repeatedList = new SortedIntegerList(true);
        // метод add всегда добавляет элемент в конец списка
        //Заполним repeatedList числами с повторами
        for (int i = 0; i < 10; i++){
            repeatedList.add(i % 2);
        }
        System.out.println("Содержимое repeatedList с повторами");
        for (int i = 0; i < repeatedList.getSize(); i++){
            System.out.print(repeatedList.getElement(i) + " ");
        }
        SortedIntegerList notRepeatedList = new SortedIntegerList(false);
        //Заполним notRepeatedList числами без повторов
        for (int i = 0; i < 10; i++){
            notRepeatedList.add(i % 2);
        }
        System.out.println("\nСодержимое notRepeatedList без повторов");
        for (int i = 0; i < notRepeatedList.getSize(); i++){
            System.out.print(notRepeatedList.getElement(i) + " ");
        }
        System.out.println("\nСравнение repeatedList и notRepeatedList с разной размерностью. Итог: " + repeatedList.equals(notRepeatedList));
        SortedIntegerList repeatedList2 = new SortedIntegerList(true);
        //Заполним repeatedList2 числами с повторами
        for (int i = 0; i < 10; i++){
            repeatedList2.add(i % 2);
        }
        System.out.println("Содержимое repeatedList2 с повторами");
        for (int i = 0; i < repeatedList2.getSize(); i++){
            System.out.print(repeatedList2.getElement(i) + " ");
        }
        System.out.println("\nСравнение repeatedList и repeatedList2 с одинаковой размерностью и одинаковыми элементами." +
                " Итог: " + repeatedList.equals(repeatedList2));
        SortedIntegerList repeatedList3 = new SortedIntegerList(true);
        //Заполним repeatedList3 числами с повторами отличных от листа №1
        for (int i = 0; i < 10; i++){
            repeatedList3.add(i % 2 + 1);
        }
        System.out.println("Содержимое repeatedList3 с повторами");
        for (int i = 0; i < repeatedList3.getSize(); i++){
            System.out.print(repeatedList3.getElement(i) + " ");
        }
        System.out.println("\nСравнение repeatedList и repeatedList3 с одинаковой размерностью, но разными элементами." +
                " Итог: " + repeatedList.equals(repeatedList3));
        SortedIntegerList list = new SortedIntegerList(false);
        // Заполняем list по убыванию
        for (int i = 10; i != 0; i--){
            list.add(i);
        }
        System.out.println("Содержимое list без повторов");
        for (int i = 0; i < list.getSize(); i++){
            System.out.print(list.getElement(i) + " ");
        }
        System.out.println();
    }
}
