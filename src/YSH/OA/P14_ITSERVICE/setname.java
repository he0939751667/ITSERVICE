package YSH.OA.P14_ITSERVICE;

import jcx.jform.hproc;

import java.io.*;
import java.util.*;

import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class setname extends hproc {
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的onChange 的動作
		// 傳入值 value
		talk t = getTalk();
		String EMPID = getValue("EMPID");
		String sql = "select HECNAME,DEP_NAME,DEP_CODE from user_info_view where EMPID='" + EMPID+ "'";
		String name[][] = t.queryFromPool(sql);
		setValue("ENAME", name[0][0]);
		setValue("DEPT_NAME", name[0][1]);
		setValue("DEP_NAME", name[0][2]);
		return value;
	}

	public String getInformation() {
		return "---------------EMPID(\u7533\u8acb\u4eba:).html_action()----------------";
	}
}