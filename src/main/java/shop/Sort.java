package shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Sort {
    List<Laptop> list;
    Set<Laptop> shop;

    public Sort(int num, int value, Shop shop) {
        this.shop = shop.getLaptopSet();
        list = new ArrayList<>();
        switch (num) {
            case 1:
                ramSort(value);
                break;
            case 2:
                romSort(value);
                break;

            default:
                break;
        }
    }

    public Sort(int num, String value, Shop shop) {
        this.shop = shop.getLaptopSet();
        list = new ArrayList<>();
        switch (num) {
            case 3:
                colorSort(value);
                break;
            case 4:
                osSort(value);
                break;
            case 5:
                cpuSort(value);
                break;
            default:
                break;
        }
    }

    private void cpuSort(String value) {
        for (Laptop laptop :
                shop) {
            if (laptop.getCpu().equals(value)) {
                list.add(laptop);
            }
        }
    }

    private void osSort(String value) {
        for (Laptop laptop :
                shop) {
            if (laptop.getOs().equals(value)) {
                list.add(laptop);
            }
        }
    }

    private void colorSort(String value) {
        for (Laptop laptop :
                shop) {
            if (laptop.getColor().equals(value)) {
                list.add(laptop);
            }
        }
    }


    private void ramSort(int value) {
        for (Laptop laptop :
                shop) {
            if (laptop.getRam() >= value) {
                list.add(laptop);
            }
        }
    }

    private void romSort(int value) {
        for (Laptop laptop :
                shop) {
            if (laptop.getRom() >= value) {
                list.add(laptop);
            }
        }
    }


    public void printSortedModels() {
        for (Laptop laptop :
                list) {
            System.out.println(laptop.toString());
        }
    }
}
