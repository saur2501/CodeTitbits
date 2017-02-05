/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 *
 * @author ic071166
 */
public class PrependWords {

    public static void main(String args[]) throws Exception{
        File dir = new File("C:\\Users\\ic071166\\Desktop\\Queries");
        File[] files = dir.listFiles();
        BufferedReader br = null;
        BufferedWriter bw = null;
        String str = "";
        String s1,s2,s3,s4;
        StringBuilder sb;
        for (File file : files){
            if(file.isDirectory())
                continue;
            sb = new StringBuilder();
            /*if(!file.getName().equalsIgnoreCase("query90.sql"))
                continue;*/
            System.out.println(file.getPath());
            br = new BufferedReader(new FileReader(file));
            bw = new BufferedWriter(new FileWriter(dir + "\\Updated\\" + file.getName()));
            while((str = br.readLine()) != null){
                sb.append(" ").append(str);
                System.out.println("SB Status = " + sb.toString());
            }
            str = sb.toString();
            s1 = str.replaceAll("\n"," ");
            s2 = s1.replaceAll("\t", " ");
            s3 = s2.replaceAll("( )+", " ");
            s4 = s3.trim();
            
            
            
            
            
            
            
            
            //System.out.println("File is written as " + s4.toString());
            s4 = s4.replaceAll("[\\s]catalog_page[^\\w\\.\\,]", " hive.tpcds_text_2.catalog_page ");
            s4 = s4.replaceAll("[\\,]catalog_page[^\\w\\.\\,]", ",hive.tpcds_text_2.catalog_page ");
            s4 = s4.replaceAll("[\\s]catalog_page[\\,]", " hive.tpcds_text_2.catalog_page,");
            s4 = s4.replaceAll("[\\,]catalog_page[\\,]", ",hive.tpcds_text_2.catalog_page,");
            
            s4 = s4.replaceAll("[\\s]catalog_returns[^\\w\\.\\,]", " hive.tpcds_text_2.catalog_returns ");
            s4 = s4.replaceAll("[\\,]catalog_returns[^\\w\\.\\,]", ",hive.tpcds_text_2.catalog_returns ");
            s4 = s4.replaceAll("[\\s]catalog_returns[\\,]", " hive.tpcds_text_2.catalog_returns,");
            s4 = s4.replaceAll("[\\,]catalog_returns[\\,]", ",hive.tpcds_text_2.catalog_returns,");
            
            s4 = s4.replaceAll("[\\s]catalog_sales[^\\w\\.\\,]", " hive.tpcds_text_2.catalog_sales ");
            s4 = s4.replaceAll("[\\,]catalog_sales[^\\w\\.\\,]", ",hive.tpcds_text_2.catalog_sales ");
            s4 = s4.replaceAll("[\\s]catalog_sales[\\,]", " hive.tpcds_text_2.catalog_sales,");
            s4 = s4.replaceAll("[\\,]catalog_sales[\\,]", ",hive.tpcds_text_2.catalog_sales,");
            
            s4 = s4.replaceAll("[\\s]customer[^\\w\\.\\,]", " hive.tpcds_text_2.customer ");
            s4 = s4.replaceAll("[\\,]customer[^\\w\\.\\,]", ",hive.tpcds_text_2.customer ");
            s4 = s4.replaceAll("[\\s]customer[\\,]", " hive.tpcds_text_2.customer,");
            s4 = s4.replaceAll("[\\,]customer[\\,]", ",hive.tpcds_text_2.customer,");
            
            s4 = s4.replaceAll("[\\s]call_center[^\\w\\.\\,]", " hive.tpcds_text_2.call_center ");
            s4 = s4.replaceAll("[\\,]call_center[^\\w\\.\\,]", ",hive.tpcds_text_2.call_center ");
            s4 = s4.replaceAll("[\\s]call_center[\\,]", " hive.tpcds_text_2.call_center,");
            s4 = s4.replaceAll("[\\,]call_center[\\,]", ",hive.tpcds_text_2.call_center,");
            
            s4 = s4.replaceAll("[\\s]customer_address[^\\w\\.\\,]", " hive.tpcds_text_2.customer_address ");
            s4 = s4.replaceAll("[\\,]customer_address[^\\w\\.\\,]", ",hive.tpcds_text_2.customer_address ");
            s4 = s4.replaceAll("[\\s]customer_address[\\,]", " hive.tpcds_text_2.customer_address,");
            s4 = s4.replaceAll("[\\,]customer_address[\\,]", ",hive.tpcds_text_2.customer_address,");
            
            s4 = s4.replaceAll("[\\s]customer_demographics[^\\w\\.\\,]", " hive.tpcds_text_2.customer_demographics ");
            s4 = s4.replaceAll("[\\,]customer_demographics[^\\w\\.\\,]", ",hive.tpcds_text_2.customer_demographics ");
            s4 = s4.replaceAll("[\\s]customer_demographics[\\,]", " hive.tpcds_text_2.customer_demographics,");
            s4 = s4.replaceAll("[\\,]customer_demographics[\\,]", ",hive.tpcds_text_2.customer_demographics,");
            
            s4 = s4.replaceAll("[\\s]date_dim[^\\w\\.\\,]", " hive.tpcds_text_2.date_dim ");
            s4 = s4.replaceAll("[\\,]date_dim[^\\w\\.\\,]", ",hive.tpcds_text_2.date_dim ");
            s4 = s4.replaceAll("[\\s]date_dim[\\,]", " hive.tpcds_text_2.date_dim,");
            s4 = s4.replaceAll("[\\,]date_dim[\\,]", ",hive.tpcds_text_2.date_dim,");
            
            s4 = s4.replaceAll("[\\s]household_demographics[^\\w\\.\\,]", " hive.tpcds_text_2.household_demographics ");
            s4 = s4.replaceAll("[\\,]household_demographics[^\\w\\.\\,]", ",hive.tpcds_text_2.household_demographics ");
            s4 = s4.replaceAll("[\\s]household_demographics[\\,]", " hive.tpcds_text_2.household_demographics,");
            s4 = s4.replaceAll("[\\,]household_demographics[\\,]", ",hive.tpcds_text_2.household_demographics,");
            
            s4 = s4.replaceAll("[\\s]income_band[^\\w\\.\\,]", " hive.tpcds_text_2.income_band ");
            s4 = s4.replaceAll("[\\,]income_band[^\\w\\.\\,]", ",hive.tpcds_text_2.income_band ");
            s4 = s4.replaceAll("[\\s]income_band[\\,]", " hive.tpcds_text_2.income_band,");
            s4 = s4.replaceAll("[\\,]income_band[\\,]", ",hive.tpcds_text_2.income_band,");
            
            s4 = s4.replaceAll("[\\s]inventory[^\\w\\.\\,]", " hive.tpcds_text_2.inventory ");
            s4 = s4.replaceAll("[\\,]inventory[^\\w\\.\\,]", ",hive.tpcds_text_2.inventory ");
            s4 = s4.replaceAll("[\\s]inventory[\\,]", " hive.tpcds_text_2.inventory,");
            s4 = s4.replaceAll("[\\,]inventory[\\,]", ",hive.tpcds_text_2.inventory,");
            
            s4 = s4.replaceAll("[\\s]item[^\\w\\.\\,]", " hive.tpcds_text_2.item ");
            s4 = s4.replaceAll("[\\,]item[^\\w\\.\\,]", ",hive.tpcds_text_2.item ");
            s4 = s4.replaceAll("[\\s]item[\\,]", " hive.tpcds_text_2.item,");
            s4 = s4.replaceAll("[\\,]item[\\,]", ",hive.tpcds_text_2.item,");
            
            s4 = s4.replaceAll("[\\s]promotion[^\\w\\.\\,]", " hive.tpcds_text_2.promotion ");
            s4 = s4.replaceAll("[\\,]promotion[^\\w\\.\\,]", ",hive.tpcds_text_2.promotion ");
            s4 = s4.replaceAll("[\\s]promotion[\\,]", " hive.tpcds_text_2.promotion,");
            s4 = s4.replaceAll("[\\,]promotion[\\,]", ",hive.tpcds_text_2.promotion,");
            
            s4 = s4.replaceAll("[\\s]reason[^\\w\\.\\,]", " hive.tpcds_text_2.reason ");
            s4 = s4.replaceAll("[\\,]reason[^\\w\\.\\,]", ",hive.tpcds_text_2.reason ");
            s4 = s4.replaceAll("[\\s]reason[\\,]", " hive.tpcds_text_2.reason,");
            s4 = s4.replaceAll("[\\,]reason[\\,]", ",hive.tpcds_text_2.reason,");
            
            s4 = s4.replaceAll("[\\s]ship_mode[^\\w\\.\\,]", " hive.tpcds_text_2.ship_mode ");
            s4 = s4.replaceAll("[\\,]ship_mode[^\\w\\.\\,]", ",hive.tpcds_text_2.ship_mode ");
            s4 = s4.replaceAll("[\\s]ship_mode[\\,]", " hive.tpcds_text_2.ship_mode,");
            s4 = s4.replaceAll("[\\,]ship_mode[\\,]", ",hive.tpcds_text_2.ship_mode,");
            
            s4 = s4.replaceAll("[\\s]store[^\\w\\.\\,]", " hive.tpcds_text_2.store ");
            s4 = s4.replaceAll("[\\,]store[^\\w\\.\\,]", ",hive.tpcds_text_2.store ");
            s4 = s4.replaceAll("[\\s]store[\\,]", " hive.tpcds_text_2.store,");
            s4 = s4.replaceAll("[\\,]store[\\,]", ",hive.tpcds_text_2.store,");
            
            s4 = s4.replaceAll("[\\s]store_returns[^\\w\\.\\,]", " hive.tpcds_text_2.store_returns ");
            s4 = s4.replaceAll("[\\,]store_returns[^\\w\\.\\,]", ",hive.tpcds_text_2.store_returns ");
            s4 = s4.replaceAll("[\\s]store_returns[\\,]", " hive.tpcds_text_2.store_returns,");
            s4 = s4.replaceAll("[\\,]store_returns[\\,]", ",hive.tpcds_text_2.store_returns,");
            
            s4 = s4.replaceAll("[\\s]store_sales[^\\w\\.\\,]", " hive.tpcds_text_2.store_sales ");
            s4 = s4.replaceAll("[\\,]store_sales[^\\w\\.\\,]", ",hive.tpcds_text_2.store_sales ");
            s4 = s4.replaceAll("[\\s]store_sales[\\,]", " hive.tpcds_text_2.store_sales,");
            s4 = s4.replaceAll("[\\,]store_sales[\\,]", ",hive.tpcds_text_2.store_sales,");
            
            s4 = s4.replaceAll("[\\s]time_dim[^\\w\\.\\,]", " hive.tpcds_text_2.time_dim ");
            s4 = s4.replaceAll("[\\,]time_dim[^\\w\\.\\,]", ",hive.tpcds_text_2.time_dim ");
            s4 = s4.replaceAll("[\\s]time_dim[\\,]", " hive.tpcds_text_2.time_dim,");
            s4 = s4.replaceAll("[\\,]time_dim[\\,]", ",hive.tpcds_text_2.time_dim,");
            
            s4 = s4.replaceAll("[\\s]warehouse[^\\w\\.\\,]", " hive.tpcds_text_2.warehouse ");
            s4 = s4.replaceAll("[\\,]warehouse[^\\w\\.\\,]", ",hive.tpcds_text_2.warehouse ");
            s4 = s4.replaceAll("[\\s]warehouse[\\,]", " hive.tpcds_text_2.warehouse,");
            s4 = s4.replaceAll("[\\,]warehouse[\\,]", ",hive.tpcds_text_2.warehouse,");
            
            s4 = s4.replaceAll("[\\s]web_page[^\\w\\.\\,]", " hive.tpcds_text_2.web_page ");
            s4 = s4.replaceAll("[\\,]web_page[^\\w\\.\\,]", ",hive.tpcds_text_2.web_page ");
            s4 = s4.replaceAll("[\\s]web_page[\\,]", " hive.tpcds_text_2.web_page,");
            s4 = s4.replaceAll("[\\,]web_page[\\,]", ",hive.tpcds_text_2.web_page,");
            
            s4 = s4.replaceAll("[\\s]web_returns[^\\w\\.\\,]", " hive.tpcds_text_2.web_returns ");
            s4 = s4.replaceAll("[\\,]web_returns[^\\w\\.\\,]", ",hive.tpcds_text_2.web_returns ");
            s4 = s4.replaceAll("[\\s]web_returns[\\,]", " hive.tpcds_text_2.web_returns,");
            s4 = s4.replaceAll("[\\,]web_returns[\\,]", ",hive.tpcds_text_2.web_returns,");
            
            s4 = s4.replaceAll("[\\s]web_sales[^\\w\\.\\,]", " hive.tpcds_text_2.web_sales ");
            s4 = s4.replaceAll("[\\,]web_sales[^\\w\\.\\,]", ",hive.tpcds_text_2.web_sales ");
            s4 = s4.replaceAll("[\\s]web_sales[\\,]", " hive.tpcds_text_2.web_sales,");
            s4 = s4.replaceAll("[\\,]web_sales[\\,]", ",hive.tpcds_text_2.web_sales,");
            
            s4 = s4.replaceAll("[\\s]web_site[^\\w\\.\\,]", " hive.tpcds_text_2.web_site ");
            s4 = s4.replaceAll("[\\,]web_site[^\\w\\.\\,]", ",hive.tpcds_text_2.web_site ");
            s4 = s4.replaceAll("[\\s]web_site[\\,]", " hive.tpcds_text_2.web_site,");
            s4 = s4.replaceAll("[\\,]web_site[\\,]", ",hive.tpcds_text_2.web_site,");
            
                     
            //s4 = s4.replaceAll("[\\s\\,]web_site[^\\w\\.]", " hive.tpcds_text_2.web_site ");
            System.out.println("String to be written: " + s4);
            bw.write(s4.toString());
            br.close();
            bw.close();
        }
    }
    
}
