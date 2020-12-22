import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;


public class Filtration {

    double[] output_signal = new double[Signal.usual_length];
    static double[] output_res_signal = new double[Formulas.dlina_frequency];



    void Digital_filter()
    {
        double[] beyond = new double[3];
        double[] koef = new double[3];
        koef[0] = 1;
        koef[1] = 3;
        koef[2] = 1;
        for (int j = 2; j < Signal.usual_length; j++)
        {
            for (int g = 0; g < 3; g++)
            {
                beyond[g] = koef[g] * Signal.input_signal[j-g];
            }
            output_signal[j] = beyond [0] + beyond[1] + beyond[2];


        }
        System.out.println("Цикл фильтра успешно прошёл");
    }


















    void Output()
    {

        try
        {
            FileOutputStream fos = new FileOutputStream("E:\\1java_prod\\Digital Filtration\\src\\output_filter\\out.csv");
            String fields_csv = "Number;Input;Output;\n";
            byte[] b = fields_csv.getBytes();
            fos.write(b);

            for (int k = 0; k < Signal.usual_length; k++)
            {
                int num = k+1;
                fields_csv = num + ";" + Signal.input_signal[k] + ";" + output_signal[k] +";\n";
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
            amplituda_csv = amplituda_csv.replace('.',',');
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
