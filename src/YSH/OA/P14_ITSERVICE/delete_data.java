package YSH.OA.P14_ITSERVICE;

import java.io.*;
import java.util.*;
import setFuntion._bProcFlow;
import jcx.util.*;
import jcx.html.*;
import jcx.db.*;

public class delete_data extends _bProcFlow{
	String tablename = "ITSERVICE";
	public boolean action(String value)throws Throwable{
		// �^�ǭȬ� true ��ܰ��汵�U�Ӫ��y�{�B�z
		// �^�ǭȬ� false ��ܱ��U�Ӥ��������y�{�B�z
		// �ǤJ�� value �� "�R��"
			String PNO = getValue("PNO");
			deleteData(tablename, PNO);
			return true;
	}
	public String getInformation(){
		return "---------------\u522a\u9664.preProcess()----------------";
	}
}