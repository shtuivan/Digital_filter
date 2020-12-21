public class Formulas {
//    double[] V_input = new double[Signal.dlina];
//
//    double dt = 1/Fs;
//    double Fs = 1/dt;
//    double t = n * dt;
//    double f = Fs / 2;
//    double max, min;
//    double Ampl = (max-min)/2;
    //double koef_ot_F = ();

static double Fs = 600;
static int dlina_frequency = (int) Fs / 2;
static double Ampl_in = 220;
static double Ampl_out = 2;
static double F = 5;
static double KotF;
static double[] KotF_now = new double[dlina_frequency];
static double in_max, in_min, out_max, out_min;


static double[] inp_max = new double[dlina_frequency];
static double[] inp_min = new double[dlina_frequency];

static double[] outp_max = new double[dlina_frequency];
static double[] outp_min = new double[dlina_frequency];

static double[] ampl_in_now = new double[dlina_frequency];
static double[] ampl_out_now = new double[dlina_frequency];


}
