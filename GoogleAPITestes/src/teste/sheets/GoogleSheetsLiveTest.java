package teste.sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;

public class GoogleSheetsLiveTest {

	private static Sheets sheetsService;
	private static String SPREADSHEET_ID = "1_jxcPCVggM1ee-0yqX7FUUEScYBuJ-7mOqYv-PVQfsw";
	
	public static void setup() throws GeneralSecurityException, IOException {
		
		sheetsService = SheetsServiceUtil.getSheetServices();
		
	}
	
	public static void readSheet() throws IOException, GeneralSecurityException {
		
		List<String> ranges = Arrays.asList("E1", "E4");
		
		setup();
		
		BatchGetValuesResponse readResult = sheetsService.spreadsheets().values().batchGet(SPREADSHEET_ID).setRanges(ranges).execute();
		
		System.out.println(readResult);
		
	}
	
	public static void main(String[] args) throws IOException, GeneralSecurityException {
		
		readSheet();
		
	}
	
}
