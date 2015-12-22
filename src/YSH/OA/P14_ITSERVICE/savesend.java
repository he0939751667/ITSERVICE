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
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		talk t = getTalk();
		service = new BaseService(this);
		// ���o�Ҧ������
		Init init = new Init();
		String[] field_Init = init.field_Init();
		for (int i = 0; i < field_Init.length; i++) {
			field_Init[i] = getValue(field_Init[i]);
		}
		// �B�z�W�Ǫ��ɮ�
		String tot_UPLOADS[] = init.upload_field();
		String UPLOAD[] = UPLOAD(tot_UPLOADS);
		for (int i = 0; i < tot_UPLOADS.length; i++) {
			tot_UPLOADS[i] = UPLOAD[i];
		}
		// �s�W���Ʈw�һݭn�s�W�����(�̷s�W�W�������+�W��渹�X)
		String field[] = init.field();
		// �s�W���Ʈw�һݭn�s�W�������
		int j = 0;
		for (int i = field_Init.length - 6; i < field_Init.length; i++) {
			field_Init[i] = tot_UPLOADS[j];
			j++;
		}
		String field_data[] = field_Init;
		// �w���S����g�쪺���
		String forget_field[] = init.forget_field();
		for (int i = 0; i < forget_field.length; i++) {
			forget_field[i] = getValue(forget_field[i]);
		}
		String forget_field_name[] = { "�ӽФ��", "�ݨD���", "�ݨD����", "�ݨD����", "����",
				"�w���įq", "�ݨD�y�z" };
		boolean send = forget_field(forget_field, forget_field_name);
		if (send == false) {
			String ret[][] = user_info_YSH(t,field_Init[1]);
			setValue("ENAME", ret[0][0]);
			setValue("DEPT_NAME", ret[0][1]);
			setValue("DEPT", ret[0][2]);

			String TYPE2 = getValue("DETYPE");
			Vector V1 = new Vector();
			Vector V2 = new Vector();
			if (TYPE2.equals("�ק���{��")) {
				V1.addElement("Emaker");
				V2.addElement("Emaker");
				V1.addElement("SAP");
				V2.addElement("SAP");
				V1.addElement("��L");
				V2.addElement("��L");
				setReference("TYPE", V1, V2);
			} else if (TYPE2.equals("�}�o���")) {
				V1.addElement("Emaker");
				V2.addElement("Emaker");
				V1.addElement("SAP");
				V2.addElement("SAP");
				V1.addElement("��L");
				V2.addElement("��L");
				setReference("TYPE", V1, V2);
			}
			return value;
		}
		String ret[][] = user_info_YSH(t,field_Init[1]);
		setValue("ENAME", ret[0][0]);
		setValue("DEPT_NAME", ret[0][1]);
		setValue("DEPT", ret[0][2]);
		// �n�M�����
		String clear_field[] = { "DEDATE", "LVL", "DETYPE", "TYPE", "EFFECTS",
				"DESCRIPT", "RULEFILE", "UPLD1", "UPLD2", "UPLD3", "UPLD4",
				"UPLD5" };
		Clear_field(t, clear_field);
		// �s�W�ܸ�Ʈw
		add_data(t, tablename, field, field_data);

		// email���e                                   EMPID
		String name = getName(field_Init[1]);
		String title = "�D���G(" + field_Init[1] + ")" + name + "���u����T�B�z�A�ȼf�֪�A�жi�J�t��ñ��";

		String content = "��ơG\r\n";
		content += "�ӽФH�G" + field_Init[1] + " " + name + "\r\n";
		content += "�ӽг��G" + field_Init[0].trim() + "\r\n";
		content += "�ӽФ���G" + convert.FormatedDate(field_Init[2], "/") + "\r\n";
		content += "�ݨD����G" + convert.FormatedDate(field_Init[3], "/") + "\r\n";
		content += "�ݨD���šG" + field_Init[4].trim() + "\r\n";
		content += "�ݨD�����G" + field_Init[5].trim() + "\r\n";
		content += "�ݨD�����G" + field_Init[6].trim() + "\r\n";
		content += "�w���įq�G" + field_Init[7].trim() + "\r\n";
		content += "�ݨD�y�z�G" + field_Init[8].trim() + "\r\n";
		
		sendMail(t, field_Init[1], service, title, content);
		return value;
	}

	public String getInformation() {
		return "---------------button2(\u5b58\u6a94\u9001\u51fa).html_action()----------------";
	}
}
