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
		//���o�Ҧ������
		String field_Init[] = init.field_Init();
		for(int i=0;i<field_Init.length;i++){
			field_Init[i] = getValue(field_Init[i]);
		}
		service = new BaseService(this);
		talk t = getTalk();
		//��ñ�ֹL�æ����ƪ��H�z��
		String vid[][] = getFlowHistory();
		if (vid.length == 0)
			return true;
		Vector V2 = FLOWHistory(t, vid);
		
		String name = getName(field_Init[1]);
		
		BaseService bs = new BaseService(this);
		UserInfoViewBean user = bs.getUserInfoBean(field_Init[1]);
		MailService mail = new MailService(bs);

		String HRADDR = (String) get("SYSTEM.HRADDR");
		String title = "�D���G(" + field_Init[1] + ")" + name + "��ƳB�z�A�ȼf�֪�( " + PNO
				+ " )���׳q��";
		String content = "";
		content += "�ӽФH�G" + field_Init[1] + " " + name + "\r\n";
		content += "�ӽг��G" + field_Init[0].trim() + "\r\n";
		content += "�ӽФ���G" + convert.FormatedDate(field_Init[2], "/") + "\r\n";
		content += "�ݨD����G" + convert.FormatedDate(field_Init[3], "/") + "\r\n";
		content += "�ݨD���šG" + field_Init[4].trim() + "\r\n";
		content += "�ݨD�����G" + field_Init[5].trim() + "\r\n";
		content += "�ݨD�����G" + field_Init[6].trim() + "\r\n";
		content += "�w���įq�G" + field_Init[7].trim() + "\r\n";
		content += "�ݨD�y�z�G" + field_Init[8].trim() + "\r\n";
		// content += "�t�κ��}�G"+HRADDR.trim()+"\r\n";
		// content += "�H�󵹡G"+usr[i].trim()+"\r\n";
		sendallmail(V2, mail, title, content);
		return true;
	}
	public String getInformation(){
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}