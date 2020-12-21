import java.util.Arrays;

class Signal {
    static int dlina = 300;
    static double[] input_signal = new double[Formulas.dlina_frequency];
    static double[] input_res_signal = new double[Formulas.dlina_frequency];
    //double[] amplitude = new double[Signal.dlina];
    static double[] frequency = new double[Formulas.dlina_frequency];

    void Create_signal()
    {
        for (int i = 0; i < dlina; i++)
        {
            input_signal[i] = Formulas.Ampl_in * Math.cos(2 * Math.PI * Formulas.F * i * (1 / Formulas.Fs));
        }

        Formulas.in_max = Arrays.stream(input_signal).max().getAsDouble();
        Formulas.in_min = Arrays.stream(input_signal).min().getAsDouble();

        System.out.println("Входной сигнал и амплитуда созданы");
    }

    void Create_Research_signal() {


            for (int i = 0; i < Formulas.dlina_frequency; i++)
            {
                frequency[i] = i;
                input_res_signal[i] = Formulas.Ampl_in * Math.cos(2 * Math.PI * frequency[i] * i * (1 / Formulas.Fs));
                Formulas.inp_max[i] = Arrays.stream(input_res_signal).max().getAsDouble();
                Formulas.inp_min[i] = Arrays.stream(input_res_signal).min().getAsDouble();
                Formulas.ampl_in_now[i] = (Formulas.inp_max[i] - Formulas.inp_min[i]) / 2;
            }



        Formulas.in_max = Arrays.stream(input_res_signal).max().getAsDouble();
        Formulas.in_min = Arrays.stream(input_res_signal).min().getAsDouble();

        System.out.println("Входной сигнал и амплитуда созданы");


    }

}
