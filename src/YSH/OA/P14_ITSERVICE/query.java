package YSH.OA.P14_ITSERVICE;


import java.io.*;
import java.util.*;
import YSH.OA.P14_ITSERVICE.Init;
import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class query extends _hproc {
	String tablename = "ITSERVICE";
	String projectname = "資料處理服務審核表";
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		Init init = new Init();
		String EMPID = getValue("EMPID");
		String[] query = init.query_table();
		String[] field = init.query_field();
		String[] field_data = init.query_field_data();
		for(int i=0;i<field_data.length;i++){
			field_data[i] = getValue(field_data[i]);
		}
		talk t = getTalk();
		query(t, tablename, projectname,query, field, field_data,EMPID);
		String ret[][] = user_info_YSH(t, EMPID);
		setValue("ENAME",ret[0][0]);
		setValue("DEPT_NAME",ret[0][1]);
		setValue("DEP_NAME",ret[0][2]);
		return value;
	}

	public String getInformation() {
		return "---------------button1(\u67e5\u8a62).html_action()----------------";
	}
}