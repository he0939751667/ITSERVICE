package YSH.OA.P14_ITSERVICE;

import jcx.jform.bProcFlow;
import java.io.*;
import java.util.*;

import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class update_develop extends bProcFlow {
	public boolean action(String value) throws Throwable {
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��y�{�B�z
		// �^�ǭȬ� false ��ܱ��U�Ӥ��������y�{�B�z
		// �ǤJ�� value �� "�֭�"
		talk t = getTalk();
		final String PNO = getValue("PNO");
		final String DEVELOP = getValue("DEVELOP");
		if (DEVELOP.length() == 0) {
			message("�}�o�H�����o����!");
			return false;
		} else {
			StringBuffer sb = new StringBuffer();
			sb.append("update ITSERVICE set DEVELOP='" + DEVELOP
					+ "' where PNO='" + PNO + "'");
			addToTransaction(sb.toString());
			message("��s����");
			return true;
		}
	}

	public String getInformation() {
		return "---------------\u6838\u51c6.preProcess()----------------";
	}
}