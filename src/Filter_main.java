public class Filter_main {
    public static void main(String[] args) {
        Signal signal = new Signal();
        signal.Create_Research_signal();

        Filtration filtration = new Filtration();
        filtration.Digital_Research_filter();
        filtration.Output_Research();


    }
}