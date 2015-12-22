package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import YSH.OA.P14_ITSERVICE.Init;
import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class save_develop extends _hproc{
	String tablename = "ITSERVICE";
	public String action(String value)throws Throwable{
		// 可自定HTML版本各欄位的預設值與按鈕的動作 
		// 傳入值 value
		Init init = new Init();
		talk t = getTalk();
		//更新測試人員相關資料
		String PNO = getValue("PNO");
		String COMPLETEDATE = getValue("COMPLETE_DATE");
		String TESTPERSON = getValue("TEST_PERSON");
		String TESTLINK = getValue("TEST_LINK");
		
		String field[] = {"COMPLETEDATE","TESTPERSON","TESTLINK","TESTFILE"};
		String UPLOADS[] = UPLOAD(field);
		String field_data[] = {COMPLETEDATE,TESTPERSON,TESTLINK,UPLOADS[3]};
		
		String field2[] = {"COMPLETEDATE","TESTPERSON","TESTLINK"};
		String field_data2[] = {COMPLETEDATE,TESTPERSON,TESTLINK};
		if(UPLOADS[3].length()!=0){
			update_data(t,tablename, field, field_data, PNO);
		}else{
			update_data(t,tablename, field2, field_data2, PNO);
		}
		
		String EMPID = getValue("EMPID");
		String[][] ret = user_info_YSH(t, EMPID);
		setValue("ENAME",ret[0][0]);
		
		String tot_FF[] = init.download_field();
		for(int i=0;i<tot_FF.length;i++){
			tot_FF[i] = getValue(tot_FF[i]);
		}
		String download[] = {"download1","download2","download3","download4","download5","download6"};
		download_field(tot_FF, download);
		
		setVisible("text6",true);
		setVisible("COMPLETE_DATE",true);
		setVisible("button1",true);
		setVisible("text5",true);
		setVisible("TEST_PERSON",true);
		setVisible("TEST_LINK",true);
		setVisible("TESTFILE",true);
		String DEVELOP = getValue("DEVELOP");
		String condition = "EMPID <> '"+DEVELOP+"'";
		String Reference = "TEST_PERSON";
		setPULL(t, condition, Reference);
		 return value;
	}
	public String getInformation(){
		return "---------------button1(\u5b58\u6a94).html_action()----------------";
	}
}