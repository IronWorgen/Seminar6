package shop;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Data
public class PCAccessories implements Accessories {

    private List<Integer> ram;
    private List<Integer> rom;
    private List<String> cpu;
    private List<String> color;
    private List<String> os;
    Random random;

    public PCAccessories() {
        ram = new ArrayList<>(Arrays.asList(4, 8, 16, 32));
        rom = new ArrayList<>(Arrays.asList(128, 240, 256, 512, 1000, 1024));
        cpu = new ArrayList<>(Arrays.asList("Intel Core i3", "Intel Core i5", "Intel Core i7", "Intel Core i9",
                "AMD Ryzen 3", "AMD Ryzen 5", "AMD Ryzen 7", "AMD Ryzen 9"));
        color = new ArrayList<>(Arrays.asList("Белый", "Чёрный", "Золотой", "Синий"));
        os = new ArrayList<>(Arrays.asList("Windows 7", "Windows 8", "Windows 10", "Linux"));

        random = new Random();

    }

    public int getRandomRam() {

        return ram.get(random.nextInt(0, ram.size()));
    }

    public int getRandomRom() {

        return rom.get(random.nextInt(0, rom.size()));
    }

    public String getRandomCpu() {


        return cpu.get(random.nextInt(0, cpu.size()));
    }

    public String getRandomColor() {
        return color.get(random.nextInt(0, color.size()));
    }

    public String getRandomOs() {
        return os.get(random.nextInt(0, os.size()));
    }
}
