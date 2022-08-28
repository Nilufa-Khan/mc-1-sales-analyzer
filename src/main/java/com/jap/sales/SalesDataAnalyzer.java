package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SalesDataAnalyzer {


    // This method reads a file and adds each line of the file into the corresponding SalesRecord object
    public SalesRecord[] readFile(String fileName) {
        FileReader fileReader = null;
        int countlines = 0;
        SalesRecord[] salesRecord =null;
        try{
            fileReader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fileReader);
            String lines = br.readLine();
            while((lines = br.readLine() )!= null){
                countlines ++;
            }
            salesRecord = new SalesRecord[countlines];
            fileReader = new FileReader(fileName);
            br = new BufferedReader(fileReader);
            lines = br.readLine();
            int index = 0;
            while ((lines = br.readLine()) != null){
                String[] split = lines.split(",");
                String date = split[0];
                int customerId = Integer.parseInt(split[1]);
                int product_category = Integer.parseInt(split[2]);
                String payment_method = split[3];
                double amount = Double.parseDouble(split[4]);
                double time_on_site = Double.parseDouble(split[5]);
                int clicks_in_site = Integer.parseInt(split[6]);
                salesRecord[index] = new SalesRecord(date,customerId,product_category,payment_method,amount,time_on_site,clicks_in_site);
                index++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return salesRecord;
    }



}
