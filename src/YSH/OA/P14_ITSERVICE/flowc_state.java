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
		// ﹚HTMLセ逆箇砞籔秙笆
		// 肚 value
		Init init = new Init();
		talk t = getTalk();
		String CHECK_CHIEF = getValue("CHECK_CHIEF");
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
		if (state.equals("矪瞶")) {
			setNewView("FLOWPROCESS");
			if(CHECK_CHIEF.equals("u35572")){
				setValue("CHECK","1");
			}else if (CHECK_CHIEF.equals("00400")){
				setValue("CHECK","2");
			}
		} else if (state.equals("戈癟恨")) {
			setVisible("DEVELOP", true);
			// 眔YSH戈癟场┮Τぃ恨
			String ysh_IT_NO[][] = getYSHIT_NO();
			String IT_CHIEF[][] = getIT_CHIEF(t, ysh_IT_NO[0][0]);
			String Reference = "DEVELOP";
			String condition = "DEP_CODE='00900' and EMPID <> '"
					+ IT_CHIEF[0][0] + "'";
			setPULL(t, condition, Reference);
		} else if (state.equals("秨祇")) {
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
		} else if (state.equals("代刚")) {
			setNewView("FLOWCTEST");
			setEditable("TEST_RESULT", true);
			String TESTLINK = getValue("TESTLINK");
			setValue("TEST_LINK", "<a href=\"" + TESTLINK.trim() + "\" target=\"_new\">"
					+ TESTLINK.trim() + "</a>");
			String TESTFILE = getValue("TESTFILE");
			if (TESTFILE.length() != 0) {
				setValue("TEST_FILE",
						"<a href=\"" + getDownloadURL(TESTFILE.trim())
								+ "\">ゅン更</a>");
			}
			String TESTRESULT = getValue("TESTRESULT");
			setValue("TEST_RESULT", TESTRESULT);
			download_field(tot_FF, download);
		}else if(state.equals("秨祇(恶糶╰参ゅン)")){
			setNewView("FLOWCTEST");
			String TESTLINK = getValue("TESTLINK");
			setValue("TEST_LINK", "<a href=\"" + TESTLINK.trim() + "\" target=\"_new\">"
					+ TESTLINK.trim() + "</a>");
			String TESTFILE = getValue("TESTFILE");
			setValue("TEST_FILE", "<a href=\""
					+ getDownloadURL(TESTFILE.trim()) + "\">ゅン更</a>");
			String TESTRESULT = getValue("TESTRESULT");
			setValue("TEST_RESULT", TESTRESULT);
			
			String field[] = {"UPLOADSYS","UP_SYS","UPLOAD","SYS_FILE","SYS_REMIND"};
			for(int i=0;i<field.length;i++){
				setVisible(field[i], true);
			}
			setEditable("UP_SYS", true);
			String SYSFILE = getValue("SYSFILE");
			if(SYSFILE.length()!=0){
			setValue("SYS_FILE", "<a href=\""
					+ getDownloadURL(SYSFILE.trim()) + "\">╰参ゅン更</a>");
			}
		} else if (state.equals("戈癟场恨") || state.equals("絬")) {
			setNewView("FLOWCTEST");
			String TESTLINK = getValue("TESTLINK");
			setValue("TEST_LINK", "<a href=\"" + TESTLINK.trim() + "\" target=\"_new\">"
					+ TESTLINK.trim() + "</a>");
			String TESTFILE = getValue("TESTFILE");
			setValue("TEST_FILE", "<a href=\""
					+ getDownloadURL(TESTFILE.trim()) + "\">ゅン更</a>");
			String TESTRESULT = getValue("TESTRESULT");
			setValue("TEST_RESULT", TESTRESULT);
			
			String field[] = {"UPLOADSYS","UP_SYS","UPLOAD","SYS_FILE"};
			for(int i=0;i<field.length;i++){
				setVisible(field[i], true);
			}
			
			String SYSFILE = getValue("SYSFILE");
			setValue("SYS_FILE", "<a href=\""
					+ getDownloadURL(SYSFILE.trim()) + "\">╰参ゅン更</a>");
		}
		return value;
	}

	public String getInformation() {
		return "---------------text4(FLOWC_STATE).html_action()----------------";
	}
}
