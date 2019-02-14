import java.util.*;
import java.text.DecimalFormat;

import static java.lang.Math.*;

public class main
{
    public static void main(String [] args)
    {
        boolean again =false;
        do {
            DecimalFormat format = new DecimalFormat("##.0");
            DecimalFormat currency = new DecimalFormat("$"+"##.00");
            System.out.println("Welcome to the Pool and Hot Tub calculator!");
            Scanner in = new Scanner(System.in);
            double Width;
            System.out.println("Please enter the depth of the shallow end for the pool(2-5 feet)");
            double ShallowD = in.nextDouble();
            double ShallowDD = ShallowD - .5;

            if (ShallowDD < 1.5 || ShallowDD > 5) {
                do {
                    System.out.println("Your input is not in the range! Please enter the depth of the shallow end for the pool (2-5 feet)"); //get some input
                    double ShallowDDD = in.nextDouble();
                    ShallowDD =ShallowDDD-.5;

                }
                while (ShallowDD < 1.5 || ShallowDD > 5);
            }

            System.out.println("Please enter the depth of the deep end for the pool (6-12 feet)");
            double DeepD = in.nextDouble();
            double DeepDD = DeepD - .5;
            if (DeepDD < 5.5 || DeepDD > 12) {
                do {
                    System.out.println("Your input is not in the range! Please enter the depth of the deep end for the pool (6-12 feet)"); //get some input
                    double DeepDDD = in.nextDouble();
                    DeepDD= DeepDDD-.5;
                }
                while (DeepDD < 5.5 || DeepDD > 12);
            }
            System.out.println("Please enter the width of the pool(15-30 feet)"); //get some input
            Width = in.nextDouble();
            if (Width < 14.5 || Width > 30) {
                do {
                    System.out.println("Your input is not in the range! Please enter the width of the pool (15-30 feet)"); //get some input
                    double WidthP = in.nextDouble();
                    Width = WidthP;
                }
                while (Width < 14.5 || Width > 30);
            }
            System.out.println("Please enter the length of the pool (35-60 feet)"); //get some input
            double Length = in.nextDouble();
            if (Length < 34.5 || Length > 60) {
                do {
                    System.out.println("Your input is not in the range! Please enter the length of the pool (35-60 feet)"); //get some input
                    double LengthP = in.nextDouble();
                    Length = LengthP;
                }
                while (Length < 34.5 || Length > 60);
            }

            System.out.println("Please enter the length of the walk-in for the pool (5 feet - 1/6 of the pool length)");
            double WalkL = in.nextDouble();
            if (WalkL < 4.5 || WalkL > ((1.0 / 6) * Length)) {
                do {
                    System.out.println(" Your input is not in the range!Please enter the length of the walk-in for the pool(5 feet - 1/6 of the pool length)"); //get some input
                    double WalkLL = in.nextDouble();
                    WalkL = WalkLL;
                }
                while (WalkL < 4.5 || WalkL > (1.0 / 6) * Length);
            }
            System.out.println("Please enter the length of the shallow end for the pool( 10 feet - 1/3 of the pool length)");
            double ShallowL = in.nextDouble();
            if (ShallowL < 9.5 || ShallowL > ((1.0 / 3) * Length)) {
                do {
                    System.out.println(" Your input is not in the range!Please enter the length of the shallow end for the pool( 10 feet - 1/3 of the pool length)"); //get some input
                    double ShallowLL = in.nextDouble();
                    ShallowL=ShallowLL;
                }
                while (ShallowL < 9.5 || ShallowL > (1.0 / 3) * Length);
            }
            System.out.println("Please enter the length of the deep end for the pool ( 12 feet to 1/2 of the pool length)");
            double DeepL = in.nextDouble();
            if (DeepL < 11.5 || DeepL > ((1.0 / 2) * Length)) {
                do {
                    System.out.println(" Your input is not in the range!Please enter the length of the deep end for the pool ( 12 feet to 1/2 of the pool length)"); //get some input
                    double DeepLL = in.nextDouble();
                    DeepL = DeepLL;
                }
                while (DeepL < 11.5 || DeepL > (1.0 / 2) * Length);
            }
            System.out.println("Please enter the width of the hot tub (8-14)");
            double HotW = in.nextDouble();
            if (HotW < 7.5 || HotW > 14) {
                do {
                    System.out.println("Your input is not in the range! Please enter the width of the hot tub (8-14)"); //get some input
                    double HotWW = in.nextDouble();
                    HotW=HotWW;
                }
                while (HotW < 7.5 || HotW > 14);
            }
            System.out.println("Please enter the depth of the hot tub(3-5)");
            double HotD = in.nextDouble();
            double HotDD = HotD - .5;
            if (HotDD < 2.5 || HotDD > 5) {
                do {
                    System.out.println("Your input is not in the range! Please enter the depth of the hot tub(3-5)"); //get some input
                    double HotDDD = in.nextDouble();
                    HotDD=HotDDD-.5;
                }
                while (HotDD < 2.5 || HotDD > 5);
            }


            double A = DeepL * DeepDD * Width; //volume for deep end
            double B = ShallowL * (HotDD) * Width; // volume for shallow end
            double C = ((WalkL * HotDD) / 2) * Width; // volume for walkin
            double LengthT = Length - (DeepL + ShallowL + WalkL); //length of transition from shallow to deep
            double E = LengthT * HotDD * Width; //Upper part of transition
            double D = ((DeepDD - HotDD)); //The little gap for the middle
            double F = ((LengthT * D) / 2) * Width;//Lower part of transition
            double TotalVolume = A + B + C + E + F;

            System.out.println("Your Total Pool Volume is " + format.format(TotalVolume));
            double GallonsPool = 7.481 * TotalVolume;
            System.out.println("Gallons of water to fill in pool " + format.format(GallonsPool));
            double VolumeTub = PI * pow((HotW / 2), 2) * HotDD;
            System.out.println("Total Volume of hot tub " + format.format(VolumeTub));
            double GallonsTub = 7.481 * VolumeTub;
            System.out.println("Gallons of water to fill in hot tub " + format.format(GallonsTub));
            double TotalGallons = GallonsTub + GallonsPool;
            System.out.println("Total Gallons for both " + format.format((TotalGallons)));
            double TotalCost = TotalGallons * .10;
            System.out.println("Total Cost for both " + currency.format(TotalCost));
            System.out.println("Do you want to use the calculator again?(Y/N)");
            String option=in.next().toUpperCase();
            if(option.equals("Y"))
            {
                again = true;
            }
            else if (option.equals("N"))
            {
                again = false;
            }
        }while(again==true);


    }
}