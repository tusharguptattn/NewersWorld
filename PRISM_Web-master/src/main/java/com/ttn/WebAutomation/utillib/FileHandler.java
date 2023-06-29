package com.ttn.WebAutomation.utillib;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class FileHandler {
	public static File fileCreated = null;

	/**
	 * @param paramResultSet
	 * @param paramString
	 * @return
	 */
	public abstract boolean writeFile(ResultSet paramResultSet, String paramString);

	/**
	 * @param paramString
	 * @return
	 * @throws IOException 
	 */
	public abstract ArrayList<String[]> convertToTableData(String paramString) throws IOException;

	/**
	 *
	 */
	public abstract void convertToXMLData();

	/**
	 * @param paramArrayList
	 * @param paramString
	 * @return
	 */
	public abstract boolean writeTableData(ArrayList<String[]> paramArrayList, String paramString);

	/**
	 * @param fileName
	 * @return
	 */
	public static boolean isFileExist(String fileName) {
		File file = new File(fileName);
		//System.out.println("Is file " + fileName + ".java" + " exists : " + file.exists());
		return file.exists();
	}

	/**
	 * @param filePath
	 * @return
	 */
	public static boolean createFile(String filePath) {
		boolean isFileCreated = false;
		try {
			File file = new File(filePath);
			if (!file.exists()) {
				File file1 = new File(file.getParent());

				if (!file1.exists()) {
					if (file1.mkdirs()) {
						file.createNewFile();
						isFileCreated = true;
					}
				} else {
					file.createNewFile();
					isFileCreated = true;
				}
			} else {
				file.delete();
				file = new File(filePath);
				file.createNewFile();
				isFileCreated = true;
			}

			fileCreated = file;

			return isFileCreated;
		} catch (Exception e) {
			isFileCreated = false;
			fileCreated = null;
		}
		return isFileCreated;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static String getFileType(String fileName) {
		String result = "";
		File file = new File(fileName);

		if (file.getName().lastIndexOf('.') == -1) {
			return result;
		}

		int position = file.getName().lastIndexOf('.');

		result = file.getName().substring(position + 1);

		return result;
	}

	/**
	 * @param fileName
	 * @return
	 */
	public static FileHandler createFileHandler(String fileName) {
		FileHandler fileHandler = null;
		String extension = getFileType(fileName);

		if ((extension.equalsIgnoreCase("text")) || (extension.equalsIgnoreCase("txt"))
				|| (extension.equalsIgnoreCase(".txt"))) {
			fileHandler = new TextFileHandler();
		} else {
			fileHandler = null;
		}

		return fileHandler;
	}

	/**
	 * @param fileFolder
	 * @return
	 */
	public static boolean createFolder(String fileFolder) {
		boolean isFileCreated = false;
		try {

			File file = new File(fileFolder);
			if (!file.exists()) {
				if (file.mkdirs()) {
					isFileCreated = true;
				} else {
					file.createNewFile();
					isFileCreated = true;
				}
			}
		} catch (Exception e) {
			isFileCreated = false;
			fileCreated = null;
		}
		return isFileCreated;
	}
}
