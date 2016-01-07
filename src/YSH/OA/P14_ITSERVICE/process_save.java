package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class process_save extends _bProcFlow {
	String tablename = "ITSERVICE";

	public boolean action(String value) throws Throwable {
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��y�{�B�z
		// �^�ǭȬ� false ��ܱ��U�Ӥ��������y�{�B�z
		// �ǤJ�� value �� "�T�{�ק�"
		talk t = getTalk();
		Init init = new Init();
		String PNO = getValue("PNO");
		// ���o�����
		String field[] = init.process_update();
		String field_data[] = new String[field.length];
		for (int i = 0; i < field.length; i++) {
			field_data[i] = getValue(field[i]);
		}
		// ���o�W�Ǹ��
		String UPLD[] = init.upload_field();
		String UPLOADS[] = new String[UPLD.length];
		for (int i = 0; i < UPLD.length; i++) {
			UPLOADS[i] = getValue(UPLD[i]);
		}
		boolean check = check_chief(t, tablename, UPLD, UPLOADS, field,
				field_data, PNO);
		if (check == false) {
			process_save(tablename, UPLD, UPLOADS, field, field_data, PNO);
		}
		return true;
	}

	public String getInformation() {
		return "---------------\u78ba\u8a8d\u4fee\u6539.preProcess()----------------";
	}
}
