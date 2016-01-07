package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;
import jcx.util.*;
import jcx.html.*;
import jcx.jform.hproc;
import jcx.db.*;

public class FORM_STATE extends hproc{
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的預設值與按鈕的動作 
		// 傳入值 value 
		String EMPID = getUser().trim();
		setValue("EMPID",EMPID);
		talk t = getTalk();
		String sql = "select hecname,DEP_NAME,DEP_CODE from user_info_view where EMPID='"+EMPID.trim()+"'";
		String ret[][] = t.queryFromPool(sql);
		setValue("ENAME",ret[0][0].trim());
		setValue("DEPT_NAME",ret[0][1].trim());
		setValue("DEP_NAME",ret[0][2].trim());
		String today = getToday("YYYYmmdd");
		setValue("SDATE",today);
		setValue("EDATE",today);
	    return value;
	}
	public String getInformation(){
		return "---------------text3(FORM_STATE).html_action()----------------";
	}
}