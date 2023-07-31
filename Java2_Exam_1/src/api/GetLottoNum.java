package api;

public class GetLottoNum extends RestHelper {
	/* To treat this class as a singleton variable */
	private static GetLottoNum instance = new GetLottoNum();	
    
	public static final String baseWin = "drwtNo";
	public static final String bonus = "bnusNo";
	
	public static GetLottoNum getInstance() {
        return instance;
    }
	
	/* Inherited Functions */
		// protected String toUtfString(String rawString) => Make a UTF-8 String from Java String
		// protected static String getHTML(String urlToRead) => get HTTP response from LoL API Server
	
	/* Basic Data to use LoL API */	
	private String basUrl = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=";
	private int ep;

	/* To get Summmoner data from LoL API */
	public String getWinNum(int ep) throws Exception {
		this.ep = ep;
		return getWinNum();
	}
	
	public String getWinNum() throws Exception {
		String string_url = basUrl + ep;

		return super.getHTML(string_url);
	}
	
	
}
