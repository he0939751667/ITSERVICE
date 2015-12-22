package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class send_result extends _bProcFlow {
	String tablename = "ITSERVICE";

	public boolean action(String value) throws Throwable {
		// 回傳值為 true 表示執行接下來的流程處理
		// 回傳值為 false 表示接下來不執行任何流程處理
		// 傳入值 value 為 "核准"
		talk t = getTalk();
		String PNO = getValue("PNO");
		String TESTRESULT = getValue("TEST_RESULT");
		String field[] = { "TESTRESULT" };
		String field_data[] = { TESTRESULT };
		if (TESTRESULT.length() == 0) {
			message("測試結果不得為空!");
			return false;
		} else {
			UPDATE_DATA(t,tablename, field, field_data, PNO);
			return true;
		}
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}