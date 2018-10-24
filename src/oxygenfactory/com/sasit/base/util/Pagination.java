package oxygenfactory.com.sasit.base.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class Pagination extends JdbcDaoSupport {

	public static final int NUMBERS_PER_PAGE = 10;
	// 涓�椤垫樉绀虹殑璁板綍鏁�
	private int numPerPage;
	// 璁板綍鎬绘暟
	private int totalRows;
	// 鎬婚〉鏁�
	private int totalPages;
	// 褰撳墠椤电爜
	private int currentPage;
	// 璧峰琛屾暟
	private int startIndex;
	// 缁撴潫琛屾暟
	private int lastIndex;
	// 缁撴灉闆嗗瓨鏀綥ist
	private List<Map<String,Object>> resultList;
	// 缁撴灉闆�
	private  T entity;  
	// JdbcTemplate jTemplate
	private JdbcTemplate jTemplate;

	/**
	 * 姣忛〉鏄剧ず10鏉¤褰曠殑鏋勯�犲嚱鏁�,浣跨敤璇ュ嚱鏁板繀椤诲厛缁橮agination璁剧疆currentPage锛宩Template鍒濆��
	 * 
	 * @param sql
	 *            oracle璇彞
	 */
	public Pagination(String sql) {
		if (jTemplate == null) {
			throw new IllegalArgumentException(
					"com.deity.ranking.util.Pagination.jTemplate is null,please initial it first. ");
		} else if (sql.equals("")) {
			throw new IllegalArgumentException(
					"com.deity.ranking.util.Pagination.sql is empty,please initial it first. ");
		}
		new Pagination(sql, currentPage, NUMBERS_PER_PAGE, jTemplate);
	}

	/**
	 * 鍒嗛〉鏋勯�犲嚱鏁�
	 * 
	 * @param sql
	 *            鏍规嵁浼犲叆鐨剆ql璇彞寰楀埌涓�浜涘熀鏈垎椤典俊鎭�
	 * @param currentPage
	 *            褰撳墠椤�
	 * @param numPerPage
	 *            姣忛〉璁板綍鏁�
	 * @param jTemplate
	 *            JdbcTemplate瀹炰緥
	 */
	public Pagination(String sql, int currentPage, int numPerPage,JdbcTemplate jTemplate) {
		if (jTemplate == null) {
			throw new IllegalArgumentException(
					"com.deity.ranking.util.Pagination.jTemplate is null,please initial it first. ");
		} else if (sql == null || sql.equals("")) {
			throw new IllegalArgumentException(
					"com.deity.ranking.util.Pagination.sql is empty,please initial it first. ");
		}
		// 璁剧疆姣忛〉鏄剧ず璁板綍鏁�
		setNumPerPage(numPerPage);
		// 璁剧疆瑕佹樉绀虹殑椤垫暟
		setCurrentPage(currentPage);
		// 璁＄畻鎬昏褰曟暟
		StringBuffer totalSQL = new StringBuffer(" SELECT count(*) FROM ( ");
		totalSQL.append(sql);
		totalSQL.append(" ) totalTable ");
		// 缁橨dbcTemplate璧嬪��
		setJdbcTemplate(jTemplate);
		// 鎬昏褰曟暟
		setTotalRows(getJdbcTemplate().queryForInt(totalSQL.toString()));
		// 璁＄畻鎬婚〉鏁�
		setTotalPages();
		// 璁＄畻璧峰琛屾暟
		setStartIndex();
		// 璁＄畻缁撴潫琛屾暟
		setLastIndex();
//		System.out.println("lastIndex=" + lastIndex);//

		// 鏋勯�爋racle鏁版嵁搴撶殑鍒嗛〉璇彞
		/**
		 * StringBuffer paginationSQL = new StringBuffer(" SELECT * FROM ( ");
		 * paginationSQL.append(" SELECT temp.* ,ROWNUM num FROM ( ");
		 * paginationSQL.append(sql);
		 * paginationSQL.append(" ) temp where ROWNUM <= " + lastIndex);
		 * paginationSQL.append(" ) WHERE num > " + startIndex);
		 */
		String sqlTemp = getMySQLPageSQL(sql, startIndex, numPerPage);
		// 瑁呭叆缁撴灉闆�
		setResultList(getJdbcTemplate().queryForList(sqlTemp));
		closeConnection(jTemplate);
	}
	
	public static void closeConnection(JdbcTemplate jTemplate) {
		try 
		{
			Connection con = jTemplate.getDataSource().getConnection();
			if ( ! con.isClosed()) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 鏋勯�燤ySQL鏁版嵁鍒嗛〉SQL
	 * 
	 * @param queryString
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	public String getMySQLPageSQL(String queryString, Integer startIndex,Integer pageSize) {
		String result = "";
		if (null != startIndex && null != pageSize) {
			result = queryString + " limit " + startIndex + "," + pageSize;
		} else if (null != startIndex && null == pageSize) {
			result = queryString + " limit " + startIndex;
		} else {
			result = queryString;
		}
		return result;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}

	public List<Map<String,Object>> getResultList() {
		return resultList;
	}

	public void setResultList(List<Map<String,Object>> resultList) {
		this.resultList = resultList;
	}

	public int getTotalPages() {
		return totalPages;
	}

	// 璁＄畻鎬婚〉鏁�
	public void setTotalPages() {
		if (totalRows % numPerPage == 0) {
			this.totalPages = totalRows / numPerPage;
		} else {
			this.totalPages = (totalRows / numPerPage) + 1;
		}
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex() {
		this.startIndex = (currentPage - 1) * numPerPage;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public JdbcTemplate getJTemplate() {
		return jTemplate;
	}

	public void setJTemplate(JdbcTemplate template) {
		jTemplate = template;
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	// 璁＄畻缁撴潫鏃跺�欑殑绱㈠紩
	public void setLastIndex() {
//		System.out.println("totalRows=" + totalRows);// /////////
//		System.out.println("numPerPage=" + numPerPage);// /////////
		if (totalRows < numPerPage) {
			this.lastIndex = totalRows;
		} else if ((totalRows % numPerPage == 0)
				|| (totalRows % numPerPage != 0 && currentPage < totalPages)) {
			this.lastIndex = currentPage * numPerPage;
		} else if (totalRows % numPerPage != 0 && currentPage == totalPages) {// 鏈�鍚庝竴椤�
			this.lastIndex = totalRows;
		}
	}

}