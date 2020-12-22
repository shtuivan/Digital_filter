import java.util.Scanner;

public class Choice_of_setup {
    public void Asking()
    {
        Scanner scanner = new Scanner(System.in);
        while (true)
        {
            System.out.println("До какой частоты будем разгонять сигнал? Максимум = " + Formulas.dlina_frequency);
            Signal.max_length_freq = scanner.nextInt();
            if (Signal.max_length_freq <= Formulas.dlina_frequency && Signal.max_length_freq >= 1)
            {
                break;
            }
            else System.out.println("Частота не может быть больше 300, т.к. в ТЗ указана частота дискретизации 600. Нельзя выбрать отрицательную и нулевую частоту. Выберите другую");
        }

        while (true)
        {
            System.out.println("Какой шаг вы хотите использовать для исследования? Рекомендуется не ниже " + (Signal.max_length_freq/3) + " . Максимум - " + (Signal.max_length_freq-1));

            Signal.step = scanner.nextInt();
            if (Signal.step >= 1 && Signal.step < Signal.max_length_freq)
            {
                break;
            }
            else System.out.println("Нельзя выбирать шаг меньше единицы. Нельзя выбирать шаг больше " + (Signal.max_length_freq-1) + ". Выберите шаг ещё раз");
        }


        while (true)
        {
            System.out.println("Сколько значений сигнала вы хотите получить? (для наглядности не более 50)");
            Signal.dlina = scanner.nextInt();
            if (Signal.dlina >= 3 && Signal.dlina <= 300)
            {
                Signal.dlina++;
                break;
            }
            else System.out.println("Меньше 3 выбирать нельзя, а также нельзя сгенерировать значений больше, чем 300. Выберите ещё раз");
        }



    }





}
