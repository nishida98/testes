package teste.sheets;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;

public class GoogleSheetsLiveTest {

	private static Sheets sheetsService;
	private static String SPREADSHEET_ID = "1_jxcPCVggM1ee-0yqX7FUUEScYBuJ-7mOqYv-PVQfsw";
	private static String range = "A:AH";
	
	public static void setup() throws GeneralSecurityException, IOException {
		
		sheetsService = SheetsServiceUtil.getSheetServices();
		
	}
	
	public static void readSheet() throws IOException, GeneralSecurityException {
		
		setup();
				
		ValueRange response = sheetsService.spreadsheets().values()
                .get(SPREADSHEET_ID, range)
                .execute();
        List<List<Object>> values = response.getValues();
        
        for(List<Object> lista: values) {
        	
        	for(Object obj : lista) {
        		
        		System.out.println(obj);
        		break;
        	}
        	
        }
        
	}
	
	public static void main(String[] args) throws IOException, GeneralSecurityException {
		
		readSheet();
		
	}
	
}