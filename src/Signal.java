import javax.swing.plaf.metal.MetalIconFactory;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

class Signal {
    static int max_length_freq;
    static int step;
    static int dlina = 50;
    static int usual_length = 300;
    static double[] input_signal = new double[Formulas.dlina_frequency];
    static double[] input_res_signal = new double[Formulas.dlina_frequency];
    double[] amplitude = new double[Signal.dlina];
    static double[] frequency = new double[Formulas.dlina_frequency];

    void Create_signal()
    {
        for (int i = 0; i < usual_length; i++)
        {
            input_signal[i] = Formulas.Ampl_in * Math.cos(2 * Math.PI * Formulas.F * i * (1 / Formulas.Fs));
        }

        Formulas.in_max = Arrays.stream(input_signal).max().getAsDouble();
        Formulas.in_min = Arrays.stream(input_signal).min().getAsDouble();

        System.out.println("Обычный входной сигнал с F= " + Formulas.F + " и длиной " + usual_length + " значений создан.");
    }

    void Create_Research_signal() {
        double[] beyond = new double[3];
        double[] koef = new double[3];
        koef[0] = 1;
        koef[1] = 3;
        koef[2] = 4;
        try {
            FileOutputStream fos = new FileOutputStream("E:\\1java_prod\\Digital Filtration\\src\\output_filter\\out_cycle.csv");


            for (int i = 0; i < Formulas.dlina_frequency; i = i + step) {


                frequency[i] = i;


                for (int z = 2; z <= dlina; z++) {
                    input_res_signal[z] = Formulas.Ampl_in * Math.cos(2 * Math.PI * frequency[i] * z * (1 / Formulas.Fs));

//Фильтрация отсюда
                    for (int g = 0; g < 3; g++) {
                        beyond[g] = koef[g] * Signal.input_res_signal[z - g];
                    }
                    Filtration.output_res_signal[z] = beyond[0] + beyond[1] + beyond[2];
                    Formulas.inp_max[z] = Arrays.stream(input_res_signal).max().getAsDouble();
                    Formulas.inp_min[z] = Arrays.stream(input_res_signal).min().getAsDouble();
                    Formulas.ampl_in_now[z] = (Formulas.inp_max[z] - Formulas.inp_min[z]) / 2;

                    Formulas.outp_max[z] = Arrays.stream(Filtration.output_res_signal).max().getAsDouble();
                    Formulas.outp_min[z] = Arrays.stream(Filtration.output_res_signal).min().getAsDouble();
                    Formulas.ampl_out_now[z] = (Formulas.outp_max[z] - Formulas.outp_min[z]) / 2;
                    Formulas.KotF_now[z] = Formulas.ampl_out_now[z] / Formulas.ampl_in_now[z];
                    if (Double.isInfinite(Formulas.KotF_now[z]))
                    {
                        Formulas.KotF_now[z] = 0;
                    }
//запись в файл здесь
                    String stolbec = frequency[i] + ";" + input_res_signal[z] + ";" + Filtration.output_res_signal[z] + ";" + Formulas.KotF_now[z] + ";" + "\n";
                    stolbec = stolbec.replace('.', ',');
                    byte[] v = stolbec.getBytes();
                    fos.write(v);


                }


                System.out.println("вх ампл " + Formulas.ampl_in_now[i] + " на частоте " + i);
            }

            Formulas.in_max = Arrays.stream(input_res_signal).max().getAsDouble();
            Formulas.in_min = Arrays.stream(input_res_signal).min().getAsDouble();
            System.out.println("Входной исследовательский сигнал и амплитуда созданы");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
