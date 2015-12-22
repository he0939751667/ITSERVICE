package YSH.OA.P14_ITSERVICE;
import java.io.*;
import java.util.*;

import setFuntion._bProcFlow;
import YSH.OA.P14_ITSERVICE.Init;

import com.ysp.bean.UserInfoViewBean;
import com.ysp.service.BaseService;
import com.ysp.service.MailService;

import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class send_all_mail extends _bProcFlow{
	BaseService service;
	public boolean action(String value)throws Throwable{
		Init init = new Init();
		String PNO = getValue("PNO");
		//取得所有欄位資料
		String field_Init[] = init.field_Init();
		for(int i=0;i<field_Init.length;i++){
			field_Init[i] = getValue(field_Init[i]);
		}
		service = new BaseService(this);
		talk t = getTalk();
		//把簽核過並有重複的人篩選
		String vid[][] = getFlowHistory();
		if (vid.length == 0)
			return true;
		Vector V2 = FLOWHistory(t, vid);
		
		String name = getName(field_Init[1]);
		
		BaseService bs = new BaseService(this);
		UserInfoViewBean user = bs.getUserInfoBean(field_Init[1]);
		MailService mail = new MailService(bs);

		String HRADDR = (String) get("SYSTEM.HRADDR");
		String title = "主旨：(" + field_Init[1] + ")" + name + "資料處理服務審核表( " + PNO
				+ " )結案通知";
		String content = "";
		content += "申請人：" + field_Init[1] + " " + name + "\r\n";
		content += "申請單位：" + field_Init[0].trim() + "\r\n";
		content += "申請日期：" + convert.FormatedDate(field_Init[2], "/") + "\r\n";
		content += "需求日期：" + convert.FormatedDate(field_Init[3], "/") + "\r\n";
		content += "需求等級：" + field_Init[4].trim() + "\r\n";
		content += "需求類型：" + field_Init[5].trim() + "\r\n";
		content += "需求種類：" + field_Init[6].trim() + "\r\n";
		content += "預期效益：" + field_Init[7].trim() + "\r\n";
		content += "需求描述：" + field_Init[8].trim() + "\r\n";
		// content += "系統網址："+HRADDR.trim()+"\r\n";
		// content += "寄件給："+usr[i].trim()+"\r\n";
		sendallmail(V2, mail, title, content);
		return true;
	}
	public String getInformation(){
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}