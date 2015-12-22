package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class check_user extends _hproc{
	public String action(String value)throws Throwable{
		// �i�۩wHTML�����U��쪺onChange ���ʧ@ 
		// �ǤJ�� value 
		talk t = getTalk();
		String EMPID = getValue("EMPID");
		if(EMPID.length()==0){
			message("���u�s�����o����!");
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
		if(TYPE.equals("�ק���{��")){
			V1.addElement("Emaker");
			V2.addElement("Emaker");
			V1.addElement("SAP");
			V2.addElement("SAP");
			V1.addElement("��L");
			V2.addElement("��L");
			setReference("TYPE", V1, V2);
		}else if(TYPE.equals("�}�o���")){
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
	public String getInformation(){
		return "---------------EMPID(\u7533\u8acb\u4eba).html_action()----------------";
	}
}