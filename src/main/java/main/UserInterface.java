package main;

import org.w3c.dom.ls.LSOutput;
import shop.Accessories;
import shop.PCAccessories;
import shop.Shop;
import shop.Sort;

import java.util.Scanner;

public class UserInterface {
    private Shop shop = new Shop();

    public void programRun() {
        System.out.println("ДОБРО ПОЖАЛОВАТЬ");
        char input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Введите\n1 - чтобы войти в качестве работника магазина\n" +
                    "2 - чтобы войти в качестве покупателя\n" +
                    "q - завершить работу");

            input = scanner.nextLine().trim().charAt(0);
            switch (input) {
                case '1':
                    showWorkerInterface();
                    break;
                case '2':
                    showUserInterface();
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Выберите значение из списка");
                    break;
            }

        } while (input != 'q');
    }

    private void showWorkerInterface() {
        Scanner scanner = new Scanner(System.in);
        char input;
        do {
            System.out.println("\nВведите\n1 - чтобы добовить новый ноутбук\n" +
                    "2 - чтобы сконфигурировать случайный ноутбук\n" +
                    "3 - посмотреть список всех доступных ноутбуков\n" +
                    "q - назад");
            input = scanner.nextLine().trim().charAt(0);
            switch (input) {
                case '1':
                    shop.addLaptop();
                    break;
                case '2':
                    shop.addRandomLaptop();
                    break;
                case '3':
                    System.out.println("Модели в наличии");
                    System.out.println(shop.toString());
                    break;
                case 'q':
                    break;
                default:
                    System.out.println("Выберите значение из списка");
                    break;
            }
        } while (input != 'q');
        System.out.println();
    }

    public void showUserInterface() {
        Scanner scanner = new Scanner(System.in);
        char input;
        do {
            System.out.println("\nВведите\n1 - отфильтровать по объему ОЗУ\n" +
                    "2 - отфильтровать по объему ПЗУ\n" +
                    "3 - отфильтровать по цвету\n" +
                    "4 - выбрать ОС\n" +
                    "5 - выбрать тип ЦП\n" +
                    "6 - показать все модели\n" +
                    "q - назад");
            input = scanner.nextLine().trim().charAt(0);
            switch (input) {
                case '1':
                    Sort ramSort = new Sort(1, showRamSortWindow(), shop);
                    System.out.println("Подходящие модели:");
                    ramSort.printSortedModels();
                    break;
                case '2':
                    Sort romSort = new Sort(2, showRomSortWindow(), shop);
                    System.out.println("Подходящие модели:");
                    romSort.printSortedModels();
                    break;
                case '3':
                    Sort colorSort = new Sort(3, showColorSortWindow(), shop);
                    System.out.println("Подходящие модели:");
                    colorSort.printSortedModels();
                    break;
                case '4':
                    Sort osSort = new Sort(4, showOSSortWindow(), shop);
                    System.out.println("Подходящие модели:");
                    osSort.printSortedModels();
                    break;
                case '5':
                    Sort cpuSort = new Sort(5, showCpuSortWindow(), shop);
                    System.out.println("Подходящие модели:");
                    cpuSort.printSortedModels();
                    break;
                case '6':
                    System.out.println("Подходящие модели:");
                    System.out.println(shop.toString());
                    break;

            }
        } while (input != 'q');
        System.out.println();


    }

    private String showCpuSortWindow() {
        PCAccessories accessories = new PCAccessories();
        Scanner scanner = new Scanner(System.in);
        char input;
        do {
            for (int i = 0; i < accessories.getCpu().size(); i++) {
                System.out.printf("%d - %s\n", i, accessories.getCpu().get(i));
            }
            System.out.println("q - назад");
            input = scanner.nextLine().trim().charAt(0);
            if (input != 'q') {
                try {
                    String result = accessories.getCpu().get(Character.getNumericValue(input));
                    return result;
                } catch (Exception e) {
                    System.out.println("Выберите вариант из списка");
                }
            }
        } while (input != 'q');

        return null;

    }

    private String showOSSortWindow() {
        PCAccessories accessories = new PCAccessories();
        Scanner scanner = new Scanner(System.in);
        char input;
        do {
            for (int i = 0; i < accessories.getOs().size(); i++) {
                System.out.printf("%d - %s\n", i, accessories.getOs().get(i));
            }
            System.out.println("q - назад");
            input = scanner.nextLine().trim().charAt(0);
            if (input != 'q') {
                try {
                    String result = accessories.getOs().get(Character.getNumericValue(input));
                    return result;
                } catch (Exception e) {
                    System.out.println("Выберите вариант из списка");
                }
            }
        } while (input != 'q');
        return null;
    }

    private String showColorSortWindow() {
        PCAccessories accessories = new PCAccessories();
        Scanner scanner = new Scanner(System.in);
        char input;
        do {
            for (int i = 0; i < accessories.getColor().size(); i++) {
                System.out.printf("%d - %s\n", i, accessories.getColor().get(i));
            }
            System.out.println("q - назад");
            input = scanner.nextLine().trim().charAt(0);
            if (input != 'q') {
                try {
                    String result = accessories.getColor().get(Character.getNumericValue(input));
                    return result;
                } catch (Exception e) {
                    System.out.println("Выберите вариант из списка");
                }
            }
        } while (input != 'q');
        return null;
    }

    private int showRomSortWindow() {
        PCAccessories accessories = new PCAccessories();
        Scanner scanner = new Scanner(System.in);
        char input;
        do {
            for (int i = 0; i < accessories.getRom().size(); i++) {
                System.out.printf("%d - %dГб\n", i, accessories.getRom().get(i));
            }
            System.out.println("q - назад");
            input = scanner.nextLine().trim().charAt(0);
            if (input != 'q') {
                try {
                    int result = accessories.getRom().get(Character.getNumericValue(input));
                    return result;
                } catch (Exception e) {
                    System.out.println("Выберите вариант из списка");
                }
            }
        } while (input != 'q');
        return 0;
    }

    private int showRamSortWindow() {
        PCAccessories accessories = new PCAccessories();
        Scanner scanner = new Scanner(System.in);
        char input;
        do {
            for (int i = 0; i < accessories.getRam().size(); i++) {
                System.out.printf("%d - %dГб\n", i, accessories.getRam().get(i));
            }
            System.out.println("q - назад");
            input = scanner.nextLine().trim().charAt(0);
            if (input != 'q') {
                try {
                    int result = accessories.getRam().get(Character.getNumericValue(input));
                    return result;
                } catch (Exception e) {
                    System.out.println("Выберите вариант из списка");
                }
            }
        } while (input != 'q');

        return 0;
    }

}
