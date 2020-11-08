package Controller;

import Model.FrequencyUnit;
import Model.RateUnit;
import Model.SizeUnit;

public class InternetCalculator {

    public InternetCalculator(){}

    public String estimateTime(SizeUnit fileSize, RateUnit bandwidth) throws Exception {

        int[] timeManager = new int[4];
        double seconds =  (new SizeUnit(fileSize.getVal(), fileSize.getType()).convertTo(bandwidth.getType()).getVal()) / bandwidth.getVal();

        timeManager[0] = (int) seconds % 60;
        timeManager[1] = (int) seconds / 60 % 60;
        timeManager[2] = (int) seconds / 60 / 60 % 24;
        timeManager[3] = (int) seconds / 60 / 60 / 24;

        String replay = "Up/download will take, ";

        if (timeManager[3] >= 1) replay +=  timeManager[3] + " days, ";
        if (timeManager[2] >= 1) replay +=  timeManager[2] + " hours, ";
        if (timeManager[1] >= 1) replay +=  timeManager[1] + " minutes, ";


        return replay + timeManager[0] + " seconds.";

    }

    public String websiteBandwidth(FrequencyUnit numPerTime,SizeUnit pageSize) throws Exception {
        return websiteBandwidth(numPerTime,pageSize,1);
    }

    public String websiteBandwidth(FrequencyUnit numPerTime,SizeUnit pageSize, int redundancyF) throws Exception {

        String statement;

        if(redundancyF < 1)
            return "Error: cannot have a Redundancy Factor less than 1 ";

        double mbs = ( numPerTime.getVal()/ FrequencyUnit.getTime.get(numPerTime.getType()) ) * pageSize.convertTo("mb").getVal();
        double GB = ( numPerTime.getVal()/ (FrequencyUnit.getTime.get(numPerTime.getType()) / FrequencyUnit.getTime.get("MONTH"))) * pageSize.convertTo("GB").getVal();

        statement = "Actual bandwidth needed is " + mbs + " Mbit/s or " + GB + " GB per month";

        if(redundancyF !=1)
             statement += "\nwith a redundancy factor of " + (mbs * redundancyF) + " Mbit/s or " + (GB * redundancyF) + " GB per month";

        return statement;
    }

    public String hostingBandwidth(SizeUnit monthlyUse,String bandwidthUnit) throws Exception {
        bandwidthUnit= new SizeUnit(1,bandwidthUnit).getType();
        return monthlyUse.toString() + " per month is equivalent to " + (monthlyUse.convertTo(bandwidthUnit).getVal() / new FrequencyUnit().getTime.get("MONTH")) + " " + bandwidthUnit + "/s" ;
    }

    public String hostingBandwidth(RateUnit Bandwidth,String sizeType) throws Exception { // error
        sizeType= new SizeUnit(1,sizeType).getType();
        return Bandwidth.toString() + "/s is equivalent to "
                + ( new SizeUnit(Bandwidth.getVal(),Bandwidth.getType()).convertTo(sizeType).getVal() * new FrequencyUnit().getTime.get("MONTH")) + " " + sizeType;
    }
}
