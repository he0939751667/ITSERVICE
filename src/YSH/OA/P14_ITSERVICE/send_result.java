package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class send_result extends _bProcFlow {
	String tablename = "ITSERVICE";

	public boolean action(String value) throws Throwable {
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��y�{�B�z
		// �^�ǭȬ� false ��ܱ��U�Ӥ��������y�{�B�z
		// �ǤJ�� value �� "�֭�"
		talk t = getTalk();
		String PNO = getValue("PNO");
		String TESTRESULT = getValue("TEST_RESULT");
		String field[] = { "TESTRESULT" };
		String field_data[] = { TESTRESULT };
		if (TESTRESULT.length() == 0) {
			message("���յ��G���o����!");
			return false;
		} else {
			UPDATE_DATA(t,tablename, field, field_data, PNO);
			return true;
		}
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}