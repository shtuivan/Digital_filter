import java.util.Scanner;

public class Choice_of_setup {
    public void Asking()
    {
        System.out.println("Какой шаг вы хотите использовать для исследования? (рекомендуется не ниже 100. Максимум - 299)");
        Scanner scanner = new Scanner(System.in);
        Signal.step = scanner.nextInt();
        if (Signal.step < 1)
        {
            System.out.println("Нельзя выбирать шаг меньше единицы");
            Signal.step = 1;
        }
        else if (Signal.step > 299)
        {
            System.out.println("Нельзя выбирать шаг больше 299.");
            Signal.step = 299;
        }
        System.out.println("Какую длину для сигналов вы хотите использовать? (для наглядности не более 50)");
        Signal.dlina = scanner.nextInt();
        if (Signal.dlina < 3)
        {
            System.out.println("Слишком маленькая длина для сигнала");
            Signal.dlina = 3;
        }
    }





}
