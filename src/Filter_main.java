
public class Filter_main {
    public static void main(String[] args) {
        Signal signal = new Signal();
        Filtration filtration = new Filtration();
        Choice_of_setup choice = new Choice_of_setup();

        signal.Create_signal();
        filtration.Digital_filter();
        filtration.Output();
        System.out.println("Тестовый метод отработал");

        choice.Asking();

        signal.Create_Research_signal();

        System.out.println("Исследовательский метод отработал");



    }
}