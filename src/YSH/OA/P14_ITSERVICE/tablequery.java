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
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		talk t = getTalk();
		String PNO = getValue("PNO");
		//���oITSERVICE�̪�����ƨó]�w���
		Init init = new Init();
		String field[] = init.query_detail();
		selectfield(tablename, field, PNO);
		//�]�w����
		String EMPID = getValue("EMPID");
		String ret[][] = user_info_YSH(t, EMPID);
		setValue("ENAME", ret[0][0]);
		setValue("DEPT_NAME", ret[0][1]);
		setValue("DEP_NAME", ret[0][2]);
		//���o�U���ɮת����
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