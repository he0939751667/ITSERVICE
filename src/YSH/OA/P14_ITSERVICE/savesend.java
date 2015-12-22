package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import YSH.OA.P14_ITSERVICE.Init;
import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;
import hr.common;

import com.ysp.bean.UserInfoViewBean;
import com.ysp.service.BaseService;
import com.ysp.service.MailService;
import com.ysp.util.DateTimeUtil;

public class savesend extends _hproc {
	String tablename = "ITSERVICE";
	BaseService service;
	public String action(String value) throws Throwable {
		// 可自定HTML版本各欄位的預設值與按鈕的動作
		// 傳入值 value
		talk t = getTalk();
		service = new BaseService(this);
		// 取得所有欄位資料
		Init init = new Init();
		String[] field_Init = init.field_Init();
		for (int i = 0; i < field_Init.length; i++) {
			field_Init[i] = getValue(field_Init[i]);
		}
		// 處理上傳的檔案
		String tot_UPLOADS[] = init.upload_field();
		String UPLOAD[] = UPLOAD(tot_UPLOADS);
		for (int i = 0; i < tot_UPLOADS.length; i++) {
			tot_UPLOADS[i] = UPLOAD[i];
		}
		// 新增到資料庫所需要新增的欄位(依新增上有的欄位+上表單號碼)
		String field[] = init.field();
		// 新增到資料庫所需要新增的欄位資料
		int j = 0;
		for (int i = field_Init.length - 6; i < field_Init.length; i++) {
			field_Init[i] = tot_UPLOADS[j];
			j++;
		}
		String field_data[] = field_Init;
		// 預防沒有填寫到的欄位
		String forget_field[] = init.forget_field();
		for (int i = 0; i < forget_field.length; i++) {
			forget_field[i] = getValue(forget_field[i]);
		}
		String forget_field_name[] = { "申請日期", "需求日期", "需求等級", "需求類型", "種類",
				"預期效益", "需求描述" };
		boolean send = forget_field(forget_field, forget_field_name);
		if (send == false) {
			String ret[][] = user_info_YSH(t,field_Init[1]);
			setValue("ENAME", ret[0][0]);
			setValue("DEPT_NAME", ret[0][1]);
			setValue("DEPT", ret[0][2]);

			String TYPE2 = getValue("DETYPE");
			Vector V1 = new Vector();
			Vector V2 = new Vector();
			if (TYPE2.equals("修改表單程式")) {
				V1.addElement("Emaker");
				V2.addElement("Emaker");
				V1.addElement("SAP");
				V2.addElement("SAP");
				V1.addElement("其他");
				V2.addElement("其他");
				setReference("TYPE", V1, V2);
			} else if (TYPE2.equals("開發表單")) {
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
		String ret[][] = user_info_YSH(t,field_Init[1]);
		setValue("ENAME", ret[0][0]);
		setValue("DEPT_NAME", ret[0][1]);
		setValue("DEPT", ret[0][2]);
		// 要清除欄位
		String clear_field[] = { "DEDATE", "LVL", "DETYPE", "TYPE", "EFFECTS",
				"DESCRIPT", "RULEFILE", "UPLD1", "UPLD2", "UPLD3", "UPLD4",
				"UPLD5" };
		Clear_field(t, clear_field);
		// 新增至資料庫
		add_data(t, tablename, field, field_data);

		// email內容                                   EMPID
		String name = getName(field_Init[1]);
		String title = "主旨：(" + field_Init[1] + ")" + name + "員工之資訊處理服務審核表，請進入系統簽核";

		String content = "資料：\r\n";
		content += "申請人：" + field_Init[1] + " " + name + "\r\n";
		content += "申請單位：" + field_Init[0].trim() + "\r\n";
		content += "申請日期：" + convert.FormatedDate(field_Init[2], "/") + "\r\n";
		content += "需求日期：" + convert.FormatedDate(field_Init[3], "/") + "\r\n";
		content += "需求等級：" + field_Init[4].trim() + "\r\n";
		content += "需求類型：" + field_Init[5].trim() + "\r\n";
		content += "需求種類：" + field_Init[6].trim() + "\r\n";
		content += "預期效益：" + field_Init[7].trim() + "\r\n";
		content += "需求描述：" + field_Init[8].trim() + "\r\n";
		
		sendMail(t, field_Init[1], service, title, content);
		return value;
	}

	public String getInformation() {
		return "---------------button2(\u5b58\u6a94\u9001\u51fa).html_action()----------------";
	}
}
