package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class check_user extends _hproc{
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的onChange 的動作 
		// 傳入值 value 
		talk t = getTalk();
		String EMPID = getValue("EMPID");
		if(EMPID.length()==0){
			message("員工編號不得為空!");
			setValue("DEPT","");
			return value;
		}
		String ret[][] = user_info_YSH(t, EMPID);
		setValue("ENAME",ret[0][0]);
		setValue("DEPT_NAME",ret[0][1]);
		setValue("DEPT",ret[0][2]);
		
		String TYPE = getValue("DETYPE");
		Vector V1 = new Vector();
		Vector V2 = new Vector();
		if(TYPE.equals("修改表單程式")){
			V1.addElement("Emaker");
			V2.addElement("Emaker");
			V1.addElement("SAP");
			V2.addElement("SAP");
			V1.addElement("其他");
			V2.addElement("其他");
			setReference("TYPE", V1, V2);
		}else if(TYPE.equals("開發表單")){
			V1.addElement("Emaker");
			V2.addElement("Emaker");
			V1.addElement("SAP");
			V2.addElement("SAP");
			V1.addElement("其他");
			V2.addElement("其他");
			setReference("TYPE", V1, V2);
		}
		return value;
	}
	public String getInformation(){
		return "---------------EMPID(\u7533\u8acb\u4eba).html_action()----------------";
	}
}