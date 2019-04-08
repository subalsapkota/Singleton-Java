//Subal Sapkota - W0673339

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
	private final String LOG_TXT = "log.txt";
	private static Logger writerConnection;
	private BufferedWriter writer;

	private Logger() {
		try {
			writer = new BufferedWriter(new FileWriter(LOG_TXT, true));
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm").format(new Date());
			writer.append(timeStamp);
			writer.append(System.lineSeparator());
			
        } catch (IOException e) {}
	}

	public static Logger getInstance() {

		if (writerConnection == null) {
			writerConnection = new Logger();
		}
		return writerConnection;
	}

	public void log(String message){
		try {
			writer.append(message);
			writer.append(System.lineSeparator());
		} catch (IOException e) {}
		
	};

	public void close() {
		try {
			writer.close();
		} catch (IOException e) {}
	}
}
