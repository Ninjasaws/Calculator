import java.util.*;

public class Bandwidth {


    private static final HashMap<String, Integer> indexMap = new HashMap<>();//done?
    private static final HashMap<Integer, String> typeMap = new HashMap<>();
    private static final HashMap<String, Double> timeScale = new HashMap<>();


    public static void setValues() throws Exception {

        indexMap.put("b", 0);
        indexMap.put("B", 1);
        indexMap.put("kb", 2);
        indexMap.put("KB", 3);
        indexMap.put("mb", 4);
        indexMap.put("MB", 5);
        indexMap.put("gb", 6);
        indexMap.put("GB", 7);
        indexMap.put("tb", 8);
        indexMap.put("TB", 9); // done

        typeMap.put(0, "b"); // done
        typeMap.put(1, "B");
        typeMap.put(2, "kb");
        typeMap.put(3, "KB");
        typeMap.put(4, "mb");
        typeMap.put(5, "MB");
        typeMap.put(6, "gb");
        typeMap.put(7, "GB");
        typeMap.put(8, "tb");
        typeMap.put(9, "TB");

        timeScale.put("YEAR", 3.15576e7); // done
        timeScale.put("MONTH", 2629800.0);
        timeScale.put("WEEK", 604800.0);
        timeScale.put("DAY", 86400.0);
        timeScale.put("HOUR", 3600.0);
        timeScale.put("MINUTE", 60.0);

//        System.out.println(webBandwidth(5000,"Hour",303,typeMap.get(1))[0]);
//        System.out.println(webBandwidth(5000,"Hour",303,typeMap.get(1))[1]);

        //AllConversions("3032","GB");

        //DataConverter("3032","GB","b");

        //System.out.println(HostBandConv(1000,"(GB)","(mb)"));
        //System.out.println(HostBandConvREV(3.0420564301468,"mb","GB"));

        //System.out.println("Total time: " + LoadTimeCalc("5223100", "(MB)", "5", "(mb)"));
    }

    /** This method attempts to output all equivalent conversions from different data types
     *
     * @param data String inputted value of data type
     * @param type String defines the Datatype of the variable "data"
     */
    public static void AllConversions(String data,String type){
        System.out.println(data + type + " is equivalent to the following:");
        for(int i = 0; i < 10;i++){
            double sizez = DataConverter(data, type, typeMap.get(i));
            if(!typeMap.get(i).equals(type)) {
                if(sizez > 100000) System.out.print(sizez);
                else System.out.printf("%.2f",sizez);
                System.out.println(" ("+ typeMap.get(i) +") ");
            }
        }
    }//done

    /** When given a monthly usage w/datatype, this method to convert the equivalence to it
     * with a user given (data type) in per seconds.
     *
     * @param mUsage double The number of data of a data type in one month
     * @param unitType String the data type of the variable "mUsage"
     * @param unitType2 String the data type to convert to
     * @return double The number of data of the data type per sec
     */
    public static double HostBandConv(double mUsage, String unitType,String unitType2){
        return DataConverter(mUsage+"",unitType,unitType2) / timeScale.get("MONTH");
    }

    /** When given a monthly usage w/datatype, this method to convert the equivalence to it
     * with a user given (data type) in a month.
     *
     * @param Bandwidth The number of data of a data type in one month
     * @param unitType String the data type of the variable "Bandwidth"
     * @param UnitType2 String the data type to convert to
     * @return double The number of data of the data type per month
     */
    public static double HostBandConvREV(double Bandwidth,String unitType,String UnitType2){
        return DataConverter(Bandwidth+"",unitType,UnitType2) * timeScale.get("MONTH");
    }

    /** This method estimates the necessary bandwidth needed to host a site, given views per (amountOfTime)(timeUnit), and (pageSize) (dataUnit)
     * It gives back an array which will store the requirements in Mbits/s and GB per month
     *
     * @param pageViews double input of # of views
     * @param PerUnit String input of data type of variable "pageViews"
     * @param pageSize double input of a size amount of a certain unit
     * @param PageSizeUnits String input of data type of variable "pageSize"
     * @return double[] index[0] represents megabits per sec while index[1] represents Gigabytes per month
     */
    public static double[] webBandwidth(double pageViews,String PerUnit, double pageSize,String PageSizeUnits){
        double[] Bandwidth = new double[2];
        Bandwidth[1] = (pageViews/timeScale.get(PerUnit)) * DataConverter(pageSize + "", PageSizeUnits,typeMap.get(4));
        Bandwidth[0] = (pageViews/(timeScale.get(PerUnit) / 2629800.0)) * DataConverter(pageSize + "", PageSizeUnits,typeMap.get(7));
        return Bandwidth;
    }

    // Converts one set of data unit to another
    public static double DataConverter(String data, String type, String type2) {

        double rawData = Double.parseDouble(data);
        double index = indexMap.get(type);
        double i = indexMap.get(type2);

        if (index % 2 == 0) {
            if ((i + index) % 2 == 0) {

                if (i >= index)
                    return (rawData * Math.pow(0.001, (i - index) / 2));

                else if (i < index)
                    return (rawData / Math.pow(0.001, (index - i) / 2));

            } else if (Math.abs(i - index) % 2 == 1) {

                if (i >= index)
                    return (rawData * Math.pow(0.001, (i - index - 1) / 2) * 0.125);

                else if (i < index)
                    return ((rawData / Math.pow(0.001, (index - i + 1) / 2)) * 0.125);
            }
        } else if (index % 2 == 1) {
            if ((i + index) % 2 == 0) {

                if (i >= index)
                    return (rawData * Math.pow(0.001, (i - index) / 2));

                else if (i < index)
                    return (rawData / Math.pow(0.001, (index - i) / 2));

            } else if ((i + index) % 2 == 1) {

                if (i >= index)
                    return (rawData * Math.pow(0.001, (i - index - 1) / 2) * 0.008);
                else if (i < index) {
                    return ((1.0 * rawData / Math.pow(0.001, ((index - i + 1) / 2))) * 0.008);
                }
            }
        } else {
            System.out.println("Error: i = " + i + " index = " + index + " data = " + data);
        }
    return -1;} // done

    /** Given two different separate fields (file Size) and (Bandwidth Size) with proper indication on the what data type it is,
     * this method will attempt to calculate and amount of time it will take for a (file) to upload/download
     * with the given constraint of the (Bandwidth). It returns a String that gives the time it will take in days, or and hours, or and minutes, and seconds
     * It depends on if the time it take will reach a full hour, day, etc.. for it to be shown in the output
     *
     * @param fileSize String an input, a number defining the size, data type based on variable "type"
     * @param type String an input, Used to define the data type variable "fileSize"
     * @param bandSize String an input, String a number defining the size, data type based on variable "type2"
     * @param type2 String an input,  String Used to define the data type variable "bandSize"
     * @return String returns seconds, or (minutes/hours/days) depending on how long it will take to upload/download.
     */
    public static String LoadTimeCalc(String fileSize, String type, String bandSize, String type2){



        int[] timeManager = new int[4];
        double seconds = Double.parseDouble(fileSize)/(DataConverter(bandSize, type2, type));
        timeManager[0] = (int) seconds % 60;
        timeManager[1] = (int) seconds / 60 % 60;
        timeManager[2] = (int) seconds / 60 / 60 % 24;
        timeManager[3] = (int) seconds / 60 / 60 / 24;

        String replay = "Up/download will take " + timeManager[0] + " seconds";

        if(timeManager[1] >= 1) replay += ", " + timeManager[1] + " minutes";
        if(timeManager[2] >= 1) replay += ", " + timeManager[2] + " hours";
        if(timeManager[3] >= 1) replay += ", " + timeManager[3] + " days";
        return replay +".";
    }//done

}
