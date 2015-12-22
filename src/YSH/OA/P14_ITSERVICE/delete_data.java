package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;
import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class delete_data extends _bProcFlow{
	String tablename = "ITSERVICE";
	public boolean action(String value)throws Throwable{
		// 回傳值為 true 表示執行接下來的流程處理
		// 回傳值為 false 表示接下來不執行任何流程處理
		// 傳入值 value 為 "刪除"
			String PNO = getValue("PNO");
			deleteData(tablename, PNO);
			return true;
	}
	public String getInformation(){
		return "---------------\u522a\u9664.preProcess()----------------";
	}
}