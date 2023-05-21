package shop;

import lombok.Data;

import java.util.Random;

@Data
public class Laptop {
    private int number;
    private int ram;
    private int rom;
    private String cpu;
    private String color;
    private String os;

    public Laptop() {
        Accessories accessories = new PCAccessories();
        ram = accessories.getRandomRam();
        rom = accessories.getRandomRom();
        cpu = accessories.getRandomCpu();
        color = accessories.getRandomColor();
        os = accessories.getRandomOs();
        Random random = new Random();
        number = random.nextInt(10000, 100000);
    }


    public Laptop(int number, String cpu, int rom, int ram, String color, String os) {

        this.ram = ram;
        this.rom = rom;
        this.cpu = cpu;
        this.color = color;
        this.os = os;

        this.number = number;

    }

    @Override
    public String toString() {
        return "id=" + number +
                ", cpu='" + cpu + '\'' +
                ", ram=" + ram + "Гб" +
                ", rom=" + rom + "Гб" +
                ", color='" + color + '\'' +
                ", os='" + os + '\'' +
                "}\n";
    }
}
