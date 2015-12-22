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
		//���oñ�֤H��
		Vector vid = getEngagedPeople();
		if (vid.size() == 0)
			return;
		Init init = new Init();
		//���o�Ҧ������
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
		if (state.equals("�ݳB�z") || state.equals("�����D��") || state.equals("�`�g�z") || state.equals("��T�D��") || state.equals("�}�o�H��")) {
			String title = "�D���G(" + field_Init[1] + ")" + name + "��T�B�z�A�ȼf�֪�( " + PNO
					+ " )�A�жi�J�t��ñ�� " + HRADDR.trim();
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
			content += "��ܷN���G" + getMemo().trim() + "\r\n";
			content += "�t�κ��}�G" + HRADDR.trim() + "\r\n";
			// content += "�H���G"+vid+"\r\n";
			sendmail(V2, mail, title, content);
			return;
		} else if (state.equals("���դH��") || state.equals("��T���D��")) {
			String TEST_RESULT = getValue("TEST_RESULT");
			String title = "�D���G(" + field_Init[1] + ")" + name + "��T�B�z�A�ȼf�֪�( " + PNO
					+ " )�A�жi�J�t��ñ�� " + HRADDR.trim();
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
			content += "���յ��G�G" + TEST_RESULT.trim() + "\r\n";
			content += "��ܷN���G" + getMemo().trim() + "\r\n";
			content += "�t�κ��}�G" + HRADDR.trim() + "\r\n";
			// content += "�H���G"+vid+"\r\n";
			sendmail(V2, mail, title, content);
			return;
		}
	}

	public String getInformation() {
		return "---------------\u8ab2\u4e3b\u7ba1.Notify()----------------";
	}
}