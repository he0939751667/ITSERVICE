package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import YSH.OA.P14_ITSERVICE.Init;
import setFuntion._hproc;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class flowc_state extends _hproc {
	public String action(String value) throws Throwable {
		// �i�۩wHTML�����U��쪺�w�]�ȻP���s���ʧ@
		// �ǤJ�� value
		Init init = new Init();
		talk t = getTalk();
		String state = getState().trim();
		String EMPID = getValue("EMPID");
		setValue("ENAME", getName(EMPID));

		String tot_FF[] = init.download_field();
		for (int i = 0; i < tot_FF.length; i++) {
			tot_FF[i] = getValue(tot_FF[i]);
		}
		String download[] = { "download1", "download2", "download3",
				"download4", "download5", "download6" };
		download_field(tot_FF, download);
		if (state.equals("�ݳB�z")) {
			setNewView("FLOWPROCESS");
		} else if (state.equals("�����D��")) {
			String getchief[][] = getchief(EMPID);
			String getparent_chief[][] = getparent_chief(getchief[0][1]);
			if (getchief[0][0].equals(getparent_chief[0][0])) {
				setValue("check", "1");
			} else {
				setValue("check", "0");
			}
		} else if (state.equals("��T�D��")) {
			setVisible("DEVELOP", true);
			// ���oYSH��T�����Ҧ��H�����]�t�D��
			String ysh_IT_NO[][] = getYSHIT_NO();
			String IT_CHIEF[][] = getIT_CHIEF(t, ysh_IT_NO[0][0]);
			String Reference = "DEVELOP";
			String condition = "DEP_CODE='00900' and EMPID <> '"
					+ IT_CHIEF[0][0] + "'";
			setPULL(t, condition, Reference);
		} else if (state.equals("�}�o�H��")) {
			setVisible("text6", true);
			setVisible("COMPLETE_DATE", true);
			setVisible("button1", true);
			setVisible("text5", true);
			setVisible("TEST_PERSON", true);
			setVisible("TEST_LINK", true);
			setVisible("TESTFILE", true);

			String DEVELOP = getValue("DEVELOP");
			String condition = "EMPID <> '" + DEVELOP + "'";
			String Reference = "TEST_PERSON";
			setPULL(t, condition, Reference);

			String COMPLETEDATE = getValue("COMPLETEDATE");
			String TESTPERSON = getValue("TESTPERSON");
			String TESTLINK = getValue("TESTLINK");
			setValue("COMPLETE_DATE", COMPLETEDATE);
			setValue("TEST_PERSON", TESTPERSON);
			setValue("TEST_LINK", TESTLINK);
		} else if (state.equals("���դH��")) {
			setNewView("FLOWCTEST");
			setEditable("TEST_RESULT", true);
			String TESTLINK = getValue("TESTLINK");
			if (TESTLINK.length() != 0) {
				setValue("TEST_LINK",
						"<a  Target=\"_new\" href=\"" + TESTLINK.trim() + "\">"
								+ TESTLINK.trim() + "</a>");
			}
			String TESTFILE = getValue("TESTFILE");
			if (TESTFILE.length() != 0) {
				setValue("TEST_FILE",
						"<a href=\"" + getDownloadURL(TESTFILE.trim())
								+ "\">���U��</a>");
			}
			String TESTRESULT = getValue("TESTRESULT");
			setValue("TEST_RESULT", TESTRESULT);
			download_field(tot_FF, download);
		} else if (state.equals("��T���D��") || state.equals("�W�u�H��")) {
			setNewView("FLOWCTEST");
			String TESTLINK = getValue("TESTLINK");
			setValue("TEST_LINK", "<a href=\"" + TESTLINK.trim() + "\">"
					+ TESTLINK.trim() + "</a>");
			String TESTFILE = getValue("TESTFILE");
			setValue("TEST_FILE", "<a href=\""
					+ getDownloadURL(TESTFILE.trim()) + "\">���U��</a>");
			String TESTRESULT = getValue("TESTRESULT");
			setValue("TEST_RESULT", TESTRESULT);
		}
		return value;
	}

	public String getInformation() {
		return "---------------text4(FLOWC_STATE).html_action()----------------";
	}
}
