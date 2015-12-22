package YSH.OA.P14_ITSERVICE;

import jcx.jform.bProcFlow;
import java.io.*;
import java.util.*;

import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class update_develop extends bProcFlow {
	public boolean action(String value) throws Throwable {
		// 回傳值為 true 表示執行接下來的流程處理
		// 回傳值為 false 表示接下來不執行任何流程處理
		// 傳入值 value 為 "核准"
		talk t = getTalk();
		final String PNO = getValue("PNO");
		final String DEVELOP = getValue("DEVELOP");
		if (DEVELOP.length() == 0) {
			message("開發人員不得為空!");
			return false;
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("update ITSERVICE set DEVELOP='" + DEVELOP
					+ "' where PNO='" + PNO + "'");
			addToTransaction(sb.toString());
			message("更新完成");
			return true;
		}
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}