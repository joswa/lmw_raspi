/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Git;


/**
 *
 * @author MyAdmin
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;


public class getSettings {
    
        String result = "";
	InputStream inputStream;
        public static String BASEURL;
        public String URLEMPVALIDATE;
        public static String URLGETJOBS;
        public static String RecordSep;
        public String FieldSep;
        public String USER_AGENT;
        public String URLGETJOBSITEMS;
        public String URLPRINTFLAG;
        public String URLGETJOBSITEMSDET;
        public String AppImagePath;
        public String ScalePort;
        public String ImageUrl;
        public String SoundBoardPort;
        public int StableWeightNos;
        static JFrame LoginWindow ;
        static JFrame MainWindow ;
         static String empno;
         public String PROCEDURECALL;
         public String INSERTDATA;
         public static String CHECKREMARKS;
        public static String Deviceid;
        //private getSettings objSettings;

        public String ReadingFromat;
            public getSettings() throws IOException {
        getPropValues();
        BASEURL = readFile();
    }
public static String readFile() throws IOException
{
    String content = null;
    File file = new File("serverurl.txt"); //for ex foo.txt
    FileReader reader = null;
    try {
        reader = new FileReader(file);
        char[] chars = new char[(int) file.length()];
        reader.read(chars);
        content = new String(chars);
        reader.close();
    } catch (IOException e) {
        content = "0";
    } finally {
        if(reader !=null){reader.close();}
    }
    return content;
}
        
	public String getPropValues() throws IOException {
            
            
            String serverurl = readFile();
            
             BASEURL = serverurl;
            
            
            System.out.println(BASEURL);
 
		try {
			Properties prop = new Properties();
			String propFileName = "sparesettings.properties";
 
			//inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
                        inputStream = getClass().getResourceAsStream(propFileName);
                        AppImagePath = (new File(".").getAbsolutePath().toString());
                        AppImagePath=AppImagePath.substring(0, AppImagePath.length()-1);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			Date time = new Date(System.currentTimeMillis());
 
			// get the property value and print it out
			//BASEURL = prop.getProperty("BASEURL");
                        INSERTDATA = BASEURL + prop.getProperty("PUSHDATA");
                        CHECKREMARKS = BASEURL + prop.getProperty("REMARKS");
                        URLEMPVALIDATE = BASEURL + prop.getProperty("URLEMPVALIDATE");
                        URLGETJOBS = BASEURL + prop.getProperty("URLGETJOBS");
                        URLGETJOBSITEMS = BASEURL + prop.getProperty("URLGETJOBSITEMS");
                        URLGETJOBSITEMSDET = BASEURL + prop.getProperty("URLGETJOBSITEMSDET");
                        ImageUrl = BASEURL + prop.getProperty("ImageUrl");
                        URLPRINTFLAG = BASEURL + prop.getProperty("URLUPDATEPRINTFLAG");
                        PROCEDURECALL = BASEURL + prop.getProperty("PROCEDURECALL");
                        RecordSep = prop.getProperty("RecordSep");
                        FieldSep =  prop.getProperty("FieldSep");
                        USER_AGENT =  prop.getProperty("USER_AGENT");
                        ScalePort =  prop.getProperty("ScalePort");
                        SoundBoardPort=prop.getProperty("SoundBoardPort");
                        Deviceid=prop.getProperty("Deviceid");
                        
                        ReadingFromat=prop.getProperty("ReadingFromat");
                        StableWeightNos = Integer.parseInt( prop.getProperty("StableWeightNos"));
                        
                        System.out.println("Device ID " + Deviceid);
                        System.out.println(ReadingFromat);
                        System.out.println(BASEURL);
                        System.out.println(ScalePort);
                        
                        /*String company1 = prop.getProperty("company1");
			String company2 = prop.getProperty("company2");
			String company3 = prop.getProperty("company3");
 
			result = "Company List = " + company1 + ", " + company2 + ", " + company3;
			System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
                        */
		} catch (Exception e) {
			System.out.println("Exception: " + e);
                        System.out.println(e.toString());
		} finally {
			inputStream.close();
		}
		return result;
	}
        
        public static double round(double value, int places) {
    if (places < 0) throw new IllegalArgumentException();

    long factor = (long) Math.pow(10, places);
    value = value * factor;
    long tmp = Math.round(value);
    return (double) tmp / factor;
}
        
        public static String RoundWeight1g(String LastValue) //1gram Roundoff
{
                       System.out.println("Start RoundOff");
               Double RoundOfWeight=0.0; // 1 Gram Round off 28Oct16
               Integer LastDigit=0;
               System.out.println("pos"+LastValue.indexOf(".")+"X");
               if(LastValue.indexOf(".")>0)
               {
                   LastValue=LastValue.replace(".", ":");
                   System.out.println("X"+LastValue+"X");
                   String[] Arr= LastValue.split(":");
                   System.out.println("X"+Arr[0]+"X");
                   System.out.println("X"+Arr[1]+"X");
                   
                   String DecimalDigits=Arr[1];
                   System.out.println("Len"+DecimalDigits.length()+"X");
                   if(DecimalDigits.length()>=3)
                   {
                       System.out.println(""+ DecimalDigits.substring(0,3));
                       DecimalDigits=DecimalDigits.substring(0,3);
                       System.out.println("XXX");
                       System.out.println("2,1 = "+ DecimalDigits.substring(2));
                       //System.out.println("XXX");
                       LastDigit=Integer.valueOf( DecimalDigits.substring(2));
                       System.out.println("DD" + LastDigit);
                       if(LastDigit%2==1)
                       {
                           LastDigit=LastDigit-1;
                       }
                       System.out.println(" " + LastDigit);
                       DecimalDigits=DecimalDigits.substring(0,2) + LastDigit.toString();
                   }
                   else
                       DecimalDigits=DecimalDigits;
                   
               RoundOfWeight= Double.valueOf( Arr[0] + "." +  DecimalDigits);
               LastValue=RoundOfWeight.toString();
               }
               System.out.println("LastValue"+LastValue);
               return LastValue;
}

        public boolean FillTable(JTable objTable,String[] pTableHeadData, String pTableData, Boolean ClearRowsFlat  ) 
        {
            String[] sTmp;
            int RowCount=0;
            DefaultTableModel tm1=new DefaultTableModel( pTableHeadData,10 );
            
            sTmp = pTableData.split(RecordSep);
            
            if(ClearRowsFlat==true)
            {
                ((DefaultTableModel) objTable.getModel()).setRowCount(0);
            }
            String[] sTmpArr = sTmp;
            RowCount=objTable.getRowCount();
            for(int i=0;i<sTmp.length;i++)
                {
                    
                    String[] sTmpArr1=sTmpArr[i].split(FieldSep);
                      //Mohan changed 06sep16 String[] ArrRowContent={sTmpArr1[1],sTmpArr1[2],sTmpArr1[9],sTmpArr1[24],sTmpArr1[4]};//sTmpArr1[46] for LMW Change it in prod
                      String[] ArrRowContent={sTmpArr1[0],sTmpArr1[1],sTmpArr1[2],sTmpArr1[3],sTmpArr1[4]};//sTmpArr1[46] for LMW Change it in prod
                        tm1.insertRow(RowCount++,ArrRowContent);
                    //tm1.insertRow(RowCount++,sTmp[i].split(FieldSep));
                    
                }
            tm1.setRowCount(RowCount);
            //((DefaultTableModel) objTable.getModel()).setRowCount(RowCount);
                objTable.setModel(tm1);
                return true;
        }
        
        public void resizeColumns(JTable jTable1, float[] columnWidthPercentage) {
            int tW = jTable1.getWidth();
            TableColumn column;
            TableColumnModel jTableColumnModel = jTable1.getColumnModel();
            int cantCols = jTableColumnModel.getColumnCount();
            for (int i = 0; i < cantCols; i++) {
                column = jTableColumnModel.getColumn(i);
                int pWidth = Math.round(columnWidthPercentage[i] * tW);
                column.setPreferredWidth(pWidth);
            }
        }
        
        public static String callURL(String myURL) {
		System.out.println("Requeted URL:" + myURL);
		StringBuilder sb = new StringBuilder();
		      URLConnection urlConn = null;
		InputStreamReader in = null;
		try {
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null) {
				in = new InputStreamReader(urlConn.getInputStream(),
						                                  Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
		in.close();
		} catch (Exception e) {
			//throw new RuntimeException("Exception while calling URL:"+ myURL, e);
                        System.out.println(" URL CALL Unable to connect Server");
                        JOptionPane.showMessageDialog(null, "UNABLE TO CONNECT SERVER");
		} 
 
		return sb.toString();
	}

    
}







