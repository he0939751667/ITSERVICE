package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class add extends _hproc{
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的預設值與按鈕的動作 
		// 傳入值 value 
		talk t = getTalk();
		String EMPID = getUser();
		setValue("EMPID",EMPID.trim());
		
		String ret[][] = user_info_view(t, EMPID);
		setValue("ENAME",ret[0][0].trim());
		setValue("DEPT_NAME",ret[0][1].trim());
		setValue("DEPT",ret[0][2].trim());
		
		String today = getToday("YYYYmmdd");
		setValue("APDATE",today);
		String sql = "select dep_chief from user_info_view where EMPID='"
				+ EMPID + "'";
		String chief[][] = t.queryFromPool(sql);
		setValue("CHECK_CHIEF", chief[0][0]);
     	return value;
	}
	public String getInformation(){
		return "---------------button2(\u65b0\u589e).html_action()----------------";
	}
}