//public static void DataConverter(String data, String type){
//
//        double rawData = Double.parseDouble(data);
//        double index = indexMap.get(type);
//
//        for(int i = 0; i < 10; i++){
//        if(index % 2 == 0){
//        if(        (i + index) % 2 == 0      ) {
//
//        if (i >= index)
//        System.out.print(rawData * Math.pow(0.001, (i - index) / 2));
//
//        else if (i < index)
//        System.out.print(rawData / Math.pow(0.001, (index - i) / 2));
//
//        }
//
//        else if( Math.abs(i - index) % 2 == 1){
//
//        if (i >= index)
//        System.out.print(rawData * Math.pow(0.001, (i - index - 1) / 2) * 0.125 );
//
//        else if (i < index)
//        System.out.print(    (rawData / Math.pow(0.001, (index - i + 1) / 2)) * 0.125  );
//        }
//        }
//        else if (index % 2 == 1) {
//        if ((i + index) % 2 == 0) {
//
//        if (i >= index)
//        System.out.print(rawData * Math.pow(0.001, (i - index) / 2));
//
//        else if (i < index)
//        System.out.print(rawData / Math.pow(0.001, (index - i) / 2));
//
//        }
//        else if ( (i + index) % 2 == 1) {
//
//        if (i >= index)
//        System.out.print(rawData * Math.pow(0.001, (i - index - 1) / 2) * 0.008);
//        else if (i < index) {
//        System.out.print((1.0*rawData / Math.pow(0.001,( (index - i + 1) / 2))) * 0.008);
//        }
//        }
//        }
//        else{
//        System.out.println("Error: i = " + i + " index = " + index + " data = " + data);
//        }
//        System.out.println(typeMap.get(i));
//        }
//        }