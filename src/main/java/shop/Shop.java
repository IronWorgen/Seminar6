package shop;

import lombok.Data;

import java.io.IOException;
import java.util.*;

@Data
public class Shop {
    private Set<Laptop> laptopSet = new LinkedHashSet<>();

    public Shop() {
        laptopSet = new LinkedHashSet<>();
        addRandomLaptop();
        addRandomLaptop();
        addRandomLaptop();

    }

    public void addRandomLaptop() {
        if (!laptopSet.add(new Laptop())) {
            System.out.println("Не удалось добавить устройство");
        } else {
            System.out.println("Устройство добалено");
        }

    }

    public void addLaptop() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите серийный номер: ");
        int number = scanner.nextInt();
        String cpu = chooseCpu();
        int ram = chooseRam();
        int rom = chooseRom();
        String color = chooseColor();
        String os = chooseOs();
        if (!laptopSet.add(new Laptop(number, cpu, rom, ram, color, os))) {
            System.out.println("Не удалось добавить");
        } else {
            System.out.println("Устройство добалено");
        }


    }

    private String chooseOs() {
        Scanner scanner = new Scanner(System.in);
        PCAccessories pcAccessories = new PCAccessories();
        System.out.println("Выберите ОС:");
        List os = pcAccessories.getOs();
        for (int i = 0; i < os.size(); i++) {
            System.out.printf("%d - %s\n", i, os.get(i));
        }
        boolean flag = true;
        String newOs = null;
        while (flag) {
            flag = false;
            try {
                newOs = pcAccessories.getOs().get(scanner.nextInt());
            } catch (Exception e) {
                System.out.println("Выберите вариант из списка");
                flag = true;
            }
        }
        return newOs;
    }

    private String chooseColor() {
        Scanner scanner = new Scanner(System.in);
        PCAccessories pcAccessories = new PCAccessories();
        System.out.println("Выберите тип цвет корпуса:");
        List color = pcAccessories.getColor();
        for (int i = 0; i < color.size(); i++) {
            System.out.printf("%d - %s\n", i, color.get(i));
        }
        boolean flag = true;
        String newColor = null;
        while (flag) {
            flag = false;
            try {
                newColor = pcAccessories.getColor().get(scanner.nextInt());
            } catch (Exception e) {
                System.out.println("Выберите вариант из списка");
                flag = true;
            }
        }
        return newColor;

    }

    private int chooseRom() {
        Scanner scanner = new Scanner(System.in);
        PCAccessories pcAccessories = new PCAccessories();
        System.out.println("Выберите объем ПЗУ:");
        List rom = pcAccessories.getRom();
        for (int i = 0; i < rom.size(); i++) {
            System.out.printf("%d - %dГб\n", i, rom.get(i));
        }
        boolean flag = true;
        int newRam = 0;
        while (flag) {
            flag = false;
            try {
                newRam = pcAccessories.getRom().get(scanner.nextInt());
            } catch (Exception e) {
                System.out.println("Выберите вариант из списка");
                flag = true;
            }
        }
        return newRam;

    }

    private int chooseRam() {
        Scanner scanner = new Scanner(System.in);
        PCAccessories pcAccessories = new PCAccessories();
        System.out.println("Выберите объем ОЗУ:");
        List ram = pcAccessories.getRam();
        for (int i = 0; i < ram.size(); i++) {
            System.out.printf("%d - %dГб\n", i, ram.get(i));
        }
        boolean flag = true;
        int newRam = 0;
        while (flag) {
            flag = false;
            try {
                newRam = pcAccessories.getRam().get(scanner.nextInt());
            } catch (Exception e) {
                System.out.println("Выберите вариант из списка");
                flag = true;
            }
        }
        return newRam;

    }

    private String chooseCpu() {
        Scanner scanner = new Scanner(System.in);
        PCAccessories pcAccessories = new PCAccessories();
        System.out.println("Выберите тип процессора:");
        List cpu = pcAccessories.getCpu();
        for (int i = 0; i < cpu.size(); i++) {
            System.out.printf("%d - %s\n", i, cpu.get(i));
        }
        boolean flag = true;
        String newCpu = null;
        while (flag) {
            flag = false;
            try {
                newCpu = pcAccessories.getCpu().get(scanner.nextInt());
            } catch (Exception e) {
                System.out.println("Выберите вариант из списка");
                flag = true;
            }
        }
        return newCpu;
    }

    @Override
    public String toString() {
        String result = "";
        for (Laptop laptop :
                laptopSet) {
            result += laptop.toString() + "\n";
        }
        return result;
    }
}
