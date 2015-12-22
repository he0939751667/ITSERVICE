package YSH.OA.P14_ITSERVICE;

public class Init {
	// �s�W����
	String PNO = "PNO";
	String DEPT_NAME = "DEPT_NAME";
	String EMPID = "EMPID";
	String APDATE = "APDATE";
	String DEDATE = "DEDATE";
	String LVL = "LVL";
	String DETYPE = "DETYPE";
	String TYPE = "TYPE";
	String EFFECTS = "EFFECTS";
	String DESCRIPT = "DESCRIPT";
	String RULEFILE = "RULEFILE";
	String UPLD1 = "UPLD1";
	String UPLD2 = "UPLD2";
	String UPLD3 = "UPLD3";
	String UPLD4 = "UPLD4";
	String UPLD5 = "UPLD5";
	// �d�ߤ���
	String SDATE = "SDATE";
	String EDATE = "EDATE";
	// �d��table
	String COMPLETEDATE = "COMPLETEDATE";

	/**
	 * ���i���s�W�����W�������
	 * 
	 * @return DEPT_NAME [0],EMPID [1],APDATE [2],DEDATE [3],LVL [4],DETYPE
	 *         [5],TYPE [6],EFFECTS [7],DESCRIPT [8],RULEFILE [9],UPLD1
	 *         [10],UPLD2 [11],UPLD3 [12],UPLD4 [13],UPLD5 [14]
	 */
	public String[] field_Init() {
		String[] Init = { DEPT_NAME, EMPID, APDATE, DEDATE, LVL, DETYPE, TYPE,
				EFFECTS, DESCRIPT, RULEFILE, UPLD1, UPLD2, UPLD3, UPLD4, UPLD5 };
		return Init;
	}

	/**
	 * �s�W���Ʈw�һݭn�s�W�����(�̷s�W�W�������+�W��渹�X)
	 * 
	 * @return 
	 *         PNO,DEPT_NAME,EMPID,APDATE,DEDATE,LVL,DETYPE,TYPE,EFFECTS,DESCRIPT
	 *         ,RULEFILE,UPLD1,UPLD2,UPLD3,UPLD4,UPLD5
	 */
	public String[] field() {
		String[] field = { PNO, DEPT_NAME, EMPID, APDATE, DEDATE, LVL, DETYPE,
				TYPE, EFFECTS, DESCRIPT, RULEFILE, UPLD1, UPLD2, UPLD3, UPLD4,
				UPLD5 };
		return field;
	}

	/**
	 * �s�W���Ʈw���Ҧ��W���ɮ�
	 * 
	 * @return RULEFILE,UPLD1,UPLD2,UPLD3,UPLD4,UPLD5
	 */
	public String[] upload_field() {
		String[] upload_field = { RULEFILE, UPLD1, UPLD2, UPLD3, UPLD4, UPLD5 };
		return upload_field;
	}

	/**
	 * �w���S����Ū����
	 * 
	 * @return APDATE,DEDATE,LVL,DETYPE,TYPE,EFFECTS,DESCRIPT
	 */
	public String[] forget_field() {
		String[] forget_field = { APDATE, DEDATE, LVL, DETYPE, TYPE, EFFECTS,
				DESCRIPT };
		return forget_field;
	}

	/**
	 * �d�ߥΪ����
	 * 
	 * @return PNO,APDATE
	 */
	public String[] query_field() {
		String[] query_field = { PNO, APDATE };
		return query_field;

	}

	/**
	 * �d�ߤ��������
	 * 
	 * @return PNO,SDATE,EDATE
	 */
	public String[] query_field_data() {
		String[] query_field_data = { PNO, SDATE, EDATE };
		return query_field_data;

	}

	/**
	 * �d�ߤ�����table���
	 * 
	 * @return PNO,DEPT_NAME,APDATE,EMPID,LVL,COMPLETEDATE,DETYPE,TYPE
	 */
	public String[] query_table() {
		String[] query_table = { PNO, DEPT_NAME, APDATE, EMPID, LVL,
				COMPLETEDATE, DETYPE, TYPE };
		return query_table;
	}

	/**
	 * �d��detail
	 * 
	 * @return PNO, LVL, EMPID, DEPT_NAME, APDATE, DEDATE, DETYPE, TYPE,
	 *         COMPLETEDATE, RULEFILE, UPLD1, UPLD2, UPLD3, UPLD4, UPLD5,
	 *         EFFECTS, DESCRIPT
	 */
	public String[] query_detail() {
		String[] query_detail = { PNO, LVL, EMPID, DEPT_NAME, APDATE, DEDATE,
				DETYPE, TYPE, COMPLETEDATE, RULEFILE, UPLD1, UPLD2, UPLD3,
				UPLD4, UPLD5, EFFECTS, DESCRIPT };
		return query_detail;
	}
	
	/**
	 * �U���ɮת����
	 * @return RULEFILE, UPLD1, UPLD2, UPLD3, UPLD4, UPLD5
	 */
	public String[] download_field(){
		String[] download_field = { RULEFILE, UPLD1, UPLD2, UPLD3, UPLD4, UPLD5 };
		return download_field;
	}
	
	/**
	 * �ݳB�z�n��s�����
	 * @return LVL, APDATE, DEDATE,
				DETYPE, TYPE, EFFECTS, DESCRIPT
	 */
	public String[] process_update(){
		String[] process_update = {LVL, APDATE, DEDATE,
				DETYPE, TYPE, EFFECTS, DESCRIPT};
		return process_update;
	}
}
