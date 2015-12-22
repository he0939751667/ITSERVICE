package YSH.OA.P14_ITSERVICE;


import java.io.*;
import java.util.*;
import YSH.OA.P14_ITSERVICE.Init;
import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class tablequery extends _hproc {
	String tablename = "ITSERVICE";
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		talk t = getTalk();
		String PNO = getValue("PNO");
		//取得ITSERVICE裡的欄位資料並設定欄位
		Init init = new Init();
		String field[] = init.query_detail();
		selectfield(tablename, field, PNO);
		//設定部門
		String EMPID = getValue("EMPID");
		String ret[][] = user_info_YSH(t, EMPID);
		setValue("ENAME", ret[0][0]);
		setValue("DEPT_NAME", ret[0][1]);
		setValue("DEP_NAME", ret[0][2]);
		//取得下載檔案的欄位
		String tot_FF[] = init.download_field();
		for(int i=0;i<tot_FF.length;i++){
			tot_FF[i] = getValue(tot_FF[i]);
		}

		String download[] = { "download1", "download2", "download3",
				"download4", "download5", "download6" };
		download_field(tot_FF,download);
		return value;

	}

	public String getInformation() {
		return "---------------null(null).html_action()----------------";
	}
}