package com.ttn.WebAutomation.utillib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.slf4j.LoggerFactory;

import com.ttn.WebAutomation.seleniumUtils.SeleniumHelper;

import org.slf4j.Logger;

public class TextFileHandler extends FileHandler {
  public static String delimiter;
	protected static Logger logger = LoggerFactory.getLogger(SeleniumHelper.class);

  
  
  Writer writer;
  public boolean writeFile(ResultSet results, String filePath) {
    boolean isFileWritten = false;

    if (FileHandler.fileCreated != null) {
      try {
        writer = new BufferedWriter(new FileWriter(filePath));

        for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
          writer.write(results.getMetaData().getColumnName(i) + "\t");
        }
        writer.write("\n");

        while (results.next()) {
          for (int i = 1; i <= results.getMetaData().getColumnCount(); i++) {
            writer.write(String.valueOf(results.getObject(i)) + "\t");
          }
          writer.write("\n");
        }

        writer.close();
        isFileWritten = true;
        return isFileWritten;
      } catch (Exception e) {
        isFileWritten = false;
        return isFileWritten;
      }
      finally {try {
		writer.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		  logger.info("IOException");
	}
      }
      }
    

    return false;
  }

  FileInputStream fstream;
  DataInputStream in;
  public ArrayList<String[]> convertToTableData(String file) {
    ArrayList<String[]> result = null;
    try {
       fstream = new FileInputStream(file);
       in = new DataInputStream(fstream);
      @SuppressWarnings("resource")
      BufferedReader br = new BufferedReader(new InputStreamReader(in));

      result = new ArrayList<String[]>();
      String strLine2 = null;
      while ((strLine2=br.readLine()) != null) {
        String strLine1 = null;
        @SuppressWarnings("null")
        String[] lines = strLine1.split("\t");
        result.add(lines);
      }
    } catch (Exception e) {
   
      result = null;
      
    }
    finally {try {
		fstream.close();
		  in.close();
		  
	} catch (IOException e) {
		// TODO Auto-generated catch block
		  logger.info("IOException");
	}
  
    }
    return result;
  }

  public boolean writeTableData(ArrayList<String[]> results, String file) {
    boolean status = false;
    try {
      writer = new BufferedWriter(new FileWriter(file));

      for (String[] result : results) {
        for (int i = 0; i < result.length; i++) {
          writer.write(result[i] + "\t");
        }
        writer.write("\n");
      }
      writer.close();
      status = true;
    } catch (Exception e) {
      status = false;
    }
    finally {try {
		writer.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		  logger.info("IOException");
	}}
    return status;
  }


  public void convertToXMLData() {
  }

  public static void WriteFile(String result , String filepath){


    FileOutputStream fop = null;
    File file;
    try {
      file = new File(filepath);
      fop = new FileOutputStream(file);
      if (!file.exists()) {
        file.createNewFile();
      }
      // get the content in bytes
      byte[] contentInBytes = result.getBytes();
      fop.write(contentInBytes);
      fop.flush();
      fop.close();
    } catch (IOException e) {
        logger.info("IOException");
    } finally {
      try {
        if (fop != null) {
          fop.close();
        }
      } catch (IOException e) {
		  logger.info("IOException");
      }
    }
  }

}
