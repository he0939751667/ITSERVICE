package YSH.OA.P14_ITSERVICE;


import java.io.*;
import java.util.*;

import setFuntion._bNotify;

import com.ysp.bean.UserInfoViewBean;
import com.ysp.service.BaseService;
import com.ysp.service.MailService;

import YSH.OA.P14_ITSERVICE.Init;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class send_mail extends _bNotify {
	public void actionPerformed(String value) throws Throwable {
		String state = getSourceState().trim();
		//取得簽核人員
		Vector vid = getEngagedPeople();
		if (vid.size() == 0)
			return;
		Init init = new Init();
		//取得所有欄位資料
		String PNO = getValue("PNO");
		String field_Init[] = init.field_Init();
		for(int i=0;i<field_Init.length;i++){
			field_Init[i] = getValue(field_Init[i]);
		}
		String name = getName(field_Init[1]);
		talk t = getTalk();
		
		Vector V2 = getmail(t, vid);
		BaseService bs = new BaseService(this);
		UserInfoViewBean user = bs.getUserInfoBean(field_Init[1]);
		MailService mail = new MailService(bs);
		
		String HRADDR = (String) get("SYSTEM.HRADDR");
		if (state.equals("待處理") || state.equals("部門主管") || state.equals("總經理") || state.equals("資訊主管") || state.equals("開發人員")) {
			String title = "主旨：(" + field_Init[1] + ")" + name + "資訊處理服務審核表( " + PNO
					+ " )，請進入系統簽核 " + HRADDR.trim();
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
			content += "批示意見：" + getMemo().trim() + "\r\n";
			content += "系統網址：" + HRADDR.trim() + "\r\n";
			// content += "寄給："+vid+"\r\n";
			sendmail(V2, mail, title, content);
			return;
		} else if (state.equals("測試人員") || state.equals("資訊部主管")) {
			String TEST_RESULT = getValue("TEST_RESULT");
			String title = "主旨：(" + field_Init[1] + ")" + name + "資訊處理服務審核表( " + PNO
					+ " )，請進入系統簽核 " + HRADDR.trim();
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
			content += "測試結果：" + TEST_RESULT.trim() + "\r\n";
			content += "批示意見：" + getMemo().trim() + "\r\n";
			content += "系統網址：" + HRADDR.trim() + "\r\n";
			// content += "寄給："+vid+"\r\n";
			sendmail(V2, mail, title, content);
			return;
		}
	}

	public String getInformation() {
		return "---------------\u8ab2\u4e3b\u7ba1.Notify()----------------";
	}
}