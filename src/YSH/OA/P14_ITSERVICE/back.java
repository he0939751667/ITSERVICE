package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class back extends _hproc {
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		String EMPID = getUser().trim();
		talk t = getTalk();
		String[][] ret = user_info_view(t, EMPID);
		setValue("EMPID",EMPID);
		setValue("ENAME", ret[0][0].trim());
		setValue("DEPT_NAME", ret[0][1].trim());
		setValue("DEP_NAME", ret[0][2].trim());
		String today = getToday("YYYYmmdd");
		setValue("SDATE",today);
		setValue("EDATE",today);
		return value;
	}

	public String getInformation() {
		return "---------------button1(\u8fd4\u56de).html_action()----------------";
	}
}