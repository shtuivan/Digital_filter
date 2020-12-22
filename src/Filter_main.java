
public class Filter_main {
    public static void main(String[] args) {
        Signal signal = new Signal(); //создаём объект класса Signal
        Filtration filtration = new Filtration(); //создаём объект класса Filtration
        Choice_of_setup choice = new Choice_of_setup(); //создаём объект класса Choice_of_setup

        signal.Create_signal(); //вызываем метод создания сигнала
        filtration.Digital_filter(); //вызов фильтрации сигнала
        filtration.Output(); //вызов вывода данных в таблицу
        System.out.println("Тестовый метод отработал");

        choice.Asking(); //вызываем метод для опроса пользователя

        signal.Create_Research_signal(); //после опроса начинает свою работу исследовательский режим

        System.out.println("Исследовательский метод отработал");



    }
}