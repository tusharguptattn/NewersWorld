	package com.ttn.WebAutomation.utillib;

	import com.google.common.io.BaseEncoding;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import java.io.File;

	/**
	 * Useful for binary data (e.g. sending files to ReportPortal)
	 *
	 * @author Vaibhav Shukla
	 */
	public class SendScreenshot {

	    private static final Logger LOGGER = LoggerFactory.getLogger("binary_data_logger");

	    private SendScreenshot() {
	        //statics only
	    }

	    public static void log(File file, String message) {
	LOGGER.info("RP_MESSAGE#FILE#{}#{}", file.getAbsolutePath(), message);
	    }

	    public static void log(byte[] bytes, String message) {
	        LOGGER.info("RP_MESSAGE#BASE64#{}#{}", BaseEncoding.base64().encode(bytes), message);
	    }

	    public static void logBase64(String base64, String message) {
	        LOGGER.info("RP_MESSAGE#BASE64#{}#{}", base64, message);
	    }
	}

