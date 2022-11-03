import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        Scanner sc = new Scanner(System.in);

        int sizeOfList;

        while (true) {
            System.out.println("Введите размер списка");
            if (!sc.hasNextInt()) {
                logger.log("Введено некорректное значение");
                logger.log("Повторная попытка");
                sc.next();
            } else {
                if ((sizeOfList = sc.nextInt()) < 1) {
                    logger.log("Введен отрицательный или нулевой размер списка");
                    logger.log("Повторная попытка");
                    continue;
                }
                break;
            }
        }

        int maxValue;
        while (true) {
            System.out.println("Введите верхнюю границу для значений");
            if (!sc.hasNextInt()) {
                logger.log("Введено некорректное значение");
                logger.log("Повторная попытка");
                sc.next();
            } else {
                if ((maxValue = sc.nextInt()) < 0) {
                    logger.log("Введена отрицательная верхняя граница");
                    logger.log("Повторная попытка");
                    continue;
                }
                break;
            }
        }


        logger.log("Создаем и наполняем список");
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < sizeOfList; i++) {
            list.add(random.nextInt(maxValue));
        }
        System.out.println("Вот случайный список: " + list);
        logger.log("Просим пользователя ввести входные данные для фильтрации");

        int filterInt;
        while (true) {
            System.out.println("Введите порог для фильтрации");
            if (!sc.hasNextInt()) {
                logger.log("Введено некорректное значение");
                logger.log("Повторная попытка");
                sc.next();
            } else {
                if ((filterInt = sc.nextInt()) < 0) {
                    logger.log("Введено отрицательное число для фильтрации");
                    logger.log("Повторная попытка");
                    continue;
                }
                break;
            }
        }

        Filter filter = new Filter(filterInt);
        List<Integer> filterList = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + filterList);
        sc.close();
        logger.log("Завершаем программу");
    }
}
