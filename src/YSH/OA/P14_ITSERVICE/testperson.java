package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class testperson extends _bProcFlow {
	String tablename = "ITSERVICE";

	public boolean action(String value) throws Throwable {
		// 回傳值為 true 表示執行接下來的流程處理
		// 回傳值為 false 表示接下來不執行任何流程處理
		// 傳入值 value 為 "核准"
		talk t = getTalk();
		String PNO = getValue("PNO");
		String COMPLETEDATE = getValue("COMPLETE_DATE");
		String TESTPERSON = getValue("TEST_PERSON");
		String TESTLINK = getValue("TEST_LINK");
		String TESTFILE = getValue("TESTFILE");
		boolean file_sure = false;
		if (TESTFILE.length() != 0) {
			file_sure = true;
		}
		if (file_sure == true) {
			String field[] = { "COMPLETEDATE", "TESTPERSON", "TESTLINK",
					"TESTFILE" };
			String field_name[] = { "預計完成日期", "測試人員", "測試網址" };
			String field_data[] = { COMPLETEDATE, TESTPERSON, TESTLINK,
					TESTFILE };
			for (int i = 0; i < field_data.length - 1; i++) {
				if (field_data[i].length() == 0) {
					message(field_name[i] + "不得為空!");
					return false;
				}
			}
			String[] file = { "TESTFILE" };
			String[] UPLOAD = UPLOAD(file);
			field_data[field.length - 1] = UPLOAD[0];
			UPDATE_DATA(t, tablename, field, field_data, PNO);
			return true;
		} else {
			String field[] = { "COMPLETEDATE", "TESTPERSON", "TESTLINK"};
			String field_name[] = { "預計完成日期", "測試人員", "測試網址" };
			String field_data[] = { COMPLETEDATE, TESTPERSON, TESTLINK};
			for (int i = 0; i < field_data.length - 1; i++) {
				if (field_data[i].length() == 0) {
					message(field_name[i] + "不得為空!");
					return false;
				}
			}
			UPDATE_DATA(t, tablename, field, field_data, PNO);
			return true;
		}
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}