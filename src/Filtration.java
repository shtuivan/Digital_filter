import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


public class Filtration {

    double[] output_signal = new double[Signal.dlina];
    double[] output_res_signal = new double[Formulas.dlina_frequency];



    void Digital_filter()
    {
        double[] beyond = new double[3];
        double[] koef = new double[3];
        koef[0] = 1;
        koef[1] = 3;
        koef[2] = 1;
        for (int j = 2; j < Signal.dlina; j++)
        {
            for (int g = 0; g < 3; g++)
            {
                beyond[g] = koef[g] * Signal.input_signal[j-g];
            }
            output_signal[j] = beyond [0] + beyond[1] + beyond[2];


        }
        System.out.println("Цикл фильтра успешно прошёл");
    }







    void Digital_Research_filter()
    {
        double[] beyond = new double[3];
        double[] koef = new double[3];
        koef[0] = 1;
        koef[1] = 3;
        koef[2] = 1;
        for (int j = 2; j < Formulas.dlina_frequency; j++)
        {
            for (int g = 0; g < 3; g++)
            {
                beyond[g] = koef[g] * Signal.input_res_signal[j-g];
            }
            output_res_signal[j] = beyond [0] + beyond[1] + beyond[2];


            Formulas.outp_max[j] = Arrays.stream(output_res_signal).max().getAsDouble();
            Formulas.outp_min[j] = Arrays.stream(output_res_signal).min().getAsDouble();
            Formulas.ampl_out_now[j] = (Formulas.outp_max[j] - Formulas.outp_min[j]) / 2;
            Formulas.KotF_now[j] = Formulas.ampl_out_now[j] / Formulas.ampl_in_now[j];

        }
        System.out.println("Цикл фильтра RES успешно прошёл");

    }







    void Output_Research()
    {

        try
        {
            FileOutputStream fos = new FileOutputStream("E:\\1java_prod\\Digital Filtration\\src\\output_filter\\out.csv");
            String fields_csv = "Number;Input;Output;KotF_now;Frequency;\n";
            byte[] b = fields_csv.getBytes();
            fos.write(b);

            for (int k = 0; k < Formulas.dlina_frequency; k++)
            {
                int num = k+1;
                fields_csv = num + ";" + Signal.input_res_signal[k] + ";" + output_res_signal[k] + ";" + Formulas.KotF_now[k] + ";" + Signal.frequency[k] +";\n";
                fields_csv = fields_csv.replace('.',',');
                b = fields_csv.getBytes();
                fos.write(b);
            }


            String amplituda_csv = "Input Max;Input Min;Output Max;Output Min;Inp Amplitude;Out Amplitude;KotF;\n";
            byte[] c = amplituda_csv.getBytes();
            fos.write(c);

            Formulas.out_max = Arrays.stream(output_res_signal).max().getAsDouble();
            Formulas.out_min = Arrays.stream(output_res_signal).min().getAsDouble();
            Formulas.Ampl_out = (Formulas.out_max - Formulas.out_min)/2;
            Formulas.KotF = Formulas.Ampl_out / Formulas.Ampl_in;
            System.out.println(Formulas.out_max);
            System.out.println(Formulas.out_min);

            amplituda_csv = Formulas.in_max + ";" + Formulas.in_min + ";"
                    + Formulas.out_max + ";" + Formulas.out_min + ";"
                    + Formulas.Ampl_in + ";" + Formulas.Ampl_out + ";" + Formulas.KotF + ";\n";

            c = amplituda_csv.getBytes();
            fos.write(c);
            fos.close();
            System.out.println("Сигнал отфильтрован, амплитуда выходного сигнала создана");



        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }










    void Output()
    {

        try
        {
            FileOutputStream fos = new FileOutputStream("E:\\1java_prod\\Digital Filtration\\src\\output_filter\\out.csv");
            String fields_csv = "Number;Input;Output;KotF_now;Frequency;\n";
            byte[] b = fields_csv.getBytes();
            fos.write(b);

            for (int k = 0; k < Signal.dlina; k++)
            {
                int num = k+1;
                fields_csv = num + ";" + Signal.input_signal[k] + ";" + output_signal[k] + ";" + Formulas.KotF_now[k] + ";" + Signal.frequency[k] +";\n";
                fields_csv = fields_csv.replace('.',',');
                b = fields_csv.getBytes();
                fos.write(b);
            }


            String amplituda_csv = "Input Max;Input Min;Output Max;Output Min;Inp Amplitude;Out Amplitude;KotF;\n";
            byte[] c = amplituda_csv.getBytes();
            fos.write(c);

            Formulas.out_max = Arrays.stream(output_signal).max().getAsDouble();
            Formulas.out_min = Arrays.stream(output_signal).min().getAsDouble();
            Formulas.Ampl_out = (Formulas.out_max - Formulas.out_min)/2;
            Formulas.KotF = Formulas.Ampl_out / Formulas.Ampl_in;
            System.out.println(Formulas.out_max);
            System.out.println(Formulas.out_min);

            amplituda_csv = Formulas.in_max + ";" + Formulas.in_min + ";"
                    + Formulas.out_max + ";" + Formulas.out_min + ";"
                    + Formulas.Ampl_in + ";" + Formulas.Ampl_out + ";" + Formulas.KotF + ";\n";

            c = amplituda_csv.getBytes();
            fos.write(c);
            fos.close();
            System.out.println("Сигнал отфильтрован, амплитуда выходного сигнала создана");



        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }






}
