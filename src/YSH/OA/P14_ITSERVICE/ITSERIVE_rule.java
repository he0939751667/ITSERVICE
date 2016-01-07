package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;

import setFuntion._bRule;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;
import hr.common;

public class ITSERIVE_rule extends _bRule {
	public Vector getIDs(String value) throws Throwable {
		// 回傳值為 Vector contails 符合這條規格的帳號
		// value 為 "資料處理服務審核表"
		talk t = getTalk();
		String state = getState().trim();
		Vector id = new Vector();
		String EMPID = getData("EMPID");
		String[][] chief = getchief(t, EMPID);
		String parent_no = chief[0][1];
		String[][] parent_chief = getparent_chief(t, parent_no);
		if (state.equals("待處理")) {
			id.addElement(EMPID);
		} else if (state.equals("部門主管") || state.equals("董事長")) {
			for (int i = 0; i < chief.length; i++) {
				if (chief[i][0].length() != 0) {
					String DEP_CHIEF = chief[i][0];
					id.addElement(DEP_CHIEF);
				} else {
					id.addElement("admin");
				}
			}
		} else if (state.equals("總經理")) {
			if (chief[0][0].equals("u35572")) {
				String parent_no2 = "423";
				String[][] parent_chief2 = getparent_chief(t, parent_no2);
				for (int i = 0; i < parent_chief2.length; i++) {
					if (parent_chief[i][0].length() != 0) {
						String DEP_CHIEF = parent_chief2[i][0];
						id.addElement(DEP_CHIEF);
					} else {
						id.addElement("admin");
					}
				}			
			} else {
				for (int i = 0; i < parent_chief.length; i++) {
					if (parent_chief[i][0].length() != 0) {
						String DEP_CHIEF = parent_chief[i][0];
						id.addElement(DEP_CHIEF);
					} else {
						id.addElement("admin");
					}
				}
			}
		} else if (state.equals("資訊主管") || (state.equals("資訊部主管"))) {
			String[][] IT_DEPT = getYSHIT_NO();
			String[][] IT_CHIEF = getIT_CHIEF(t, IT_DEPT[0][0]);
			for (int i = 0; i < IT_CHIEF.length; i++) {
				if (IT_CHIEF[i][0].length() != 0) {
					String DEP_CHIEF = IT_CHIEF[i][0];
					id.addElement(DEP_CHIEF);
				} else {
					id.addElement("admin");
				}
			}
		} else if (state.equals("開發人員") || state.equals("上線人員")
				|| state.equals("開發人員(填寫系統文件)")) {
			String PNO = getData("PNO");
			String sql = "select DEVELOP from ITSERVICE where PNO='" + PNO
					+ "'";
			String develop_person[][] = t.queryFromPool(sql);
			for (int i = 0; i < develop_person.length; i++) {
				if (develop_person[i][0].length() != 0) {
					String DEP_CHIEF = develop_person[i][0];
					id.addElement(DEP_CHIEF);
				} else {
					id.addElement("admin");
				}
			}
		} else if (state.equals("測試人員")) {
			String PNO = getData("PNO");
			String sql = "select TESTPERSON from ITSERVICE where PNO='" + PNO
					+ "'";
			String develop_person[][] = t.queryFromPool(sql);
			for (int i = 0; i < develop_person.length; i++) {
				if (develop_person[i][0].length() != 0) {
					String DEP_CHIEF = develop_person[i][0];
					id.addElement(DEP_CHIEF);
				} else {
					id.addElement("admin");
				}
			}
		}
		return id;
	}

	public String getInformation() {
		return "---------------\u8cc7\u6599\u8655\u7406\u670d\u52d9\u5be9\u6838\u8868.Rule()----------------";
	}
}